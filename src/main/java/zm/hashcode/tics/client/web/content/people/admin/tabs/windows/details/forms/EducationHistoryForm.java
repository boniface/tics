/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.forms;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.app.facade.ui.location.LocationFacade;
import zm.hashcode.tics.app.util.DateUtil;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.model.EducationHistoryBean;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.tables.EducationHistoryTable;
import zm.hashcode.tics.domain.people.EducationHistory;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.ui.location.Location;

/**
 *
 * @author geek
 */
public class EducationHistoryForm extends FormLayout implements Button.ClickListener, Property.ValueChangeListener {

    private final EducationHistoryBean bean;
    public final BeanItem<EducationHistoryBean> item;
    public final FieldGroup binder;
    public ComboBox locationCombo = new ComboBox();
    // Define Buttons
    public Button save = new Button("Save");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
    private final Person person;
    private final TicsMain main;
    private final VerticalLayout content;
    private EducationHistoryTable table;
    private static Date graduationDate;

    public EducationHistoryForm(TicsMain main, Person person, VerticalLayout contentLayout) {
        setSizeFull();
        this.person = person;
        this.main = main;
        this.content = contentLayout;

        addListeners();
        bean = new EducationHistoryBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

        TextField instituteNameTextField = getTextField("Institute Name", "instituteName");
        PopupDateField graduationDatePopupDateField = getPopupDateField("Graduation Date", "graduationDate");
        TextField majorTextField = getTextField("Major", "major");
        ComboBox locationComboBox = getLocationComboBox("Location", "locationId");

        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(instituteNameTextField, 0, 0);
        grid.addComponent(graduationDatePopupDateField, 1, 0);
        grid.addComponent(majorTextField, 2, 0);

        grid.addComponent(locationComboBox, 0, 1);


        grid.addComponent(buttons, 0, 2, 2, 2);

        addComponent(grid);

    }

    private ComboBox getLocationComboBox(String label, String field) {
        ComboBox comboBox = new ComboBox(label);
        List<Location> locations = LocationFacade.getLocationService().findAll();
////        List<Location> sortedCopy = Ordering.from(byLastName).compound(byFirstName).reverse().sortedCopy(locations);
////        List<Location> sortedList = Ordering.natural().reverse().sortedCopy(this);
//        Collection<Location> cities = Collections2.filter(locations, new CityPredicate());
        for (Location location : locations) {
            comboBox.addItem(location.getId());
            comboBox.setItemCaption(location.getId(), location.getName());
        }
        comboBox.addValidator(new BeanValidator(EducationHistoryBean.class, field));
        comboBox.setImmediate(true);
        comboBox.setWidth(250, Unit.PIXELS);
        binder.bind(comboBox, field);
        return comboBox;
    }

    private PopupDateField getPopupDateField(String label, String field) {
        PopupDateField popupDateField = new PopupDateField(label);
        popupDateField.setWidth(250, Unit.PIXELS);
        popupDateField.addValidator(new BeanValidator(EducationHistoryBean.class, field));
        popupDateField.setImmediate(true);
        binder.bind(popupDateField, field);
        return popupDateField;
    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(EducationHistoryBean.class, field));
        textField.setImmediate(true);
        binder.bind(textField, field);
        return textField;
    }

    private HorizontalLayout getButtons() {
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.addComponent(save);
        buttons.addComponent(cancel);
        buttons.addComponent(update);
        buttons.addComponent(delete);
        return buttons;
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        final Button source = event.getButton();
        if (source == save) {
            saveForm(binder);
        } else if (source == cancel) {
            getHome();
        } else if (source == update) {
            saveEditedForm(binder);
        } else if (source == delete) {
            deleteForm(binder);
        }
    }

    private void addListeners() {
        //Register Button Listeners
        save.addClickListener((Button.ClickListener) this);
        cancel.addClickListener((Button.ClickListener) this);
        update.addClickListener((Button.ClickListener) this);
        delete.addClickListener((Button.ClickListener) this);
//        table.addValueChangeListener((Property.ValueChangeListener) this); // add later in getHome()
//        cityCombo.addValueChangeListener((Property.ValueChangeListener) this);
    }

    private void saveForm(FieldGroup binder) {
        boolean matchFound = false;
        DateUtil dateUtil = new DateUtil();
        try {
            binder.commit();
            EducationHistory educationHistory = getNewEntity(binder);
            List<EducationHistory> educationHistorys = new ArrayList<>();

            // Exclude current edited record from previous persited records
            List<EducationHistory> educationHistoryss = person.getEducationHistory();
            for (EducationHistory educationHistry : educationHistoryss) {
                if (!(dateUtil.resetTimeOfDate(educationHistry.getGraduationDate()).equals(dateUtil.resetTimeOfDate(educationHistory.getGraduationDate())))) {
                    educationHistorys.add(educationHistry);
                } else {
                    Notification.show("Similar Record exist. Change Institution Name and/or Graduation Date before SAVING!", Notification.Type.TRAY_NOTIFICATION);
                    matchFound = true;
                    break;
                }
            }

            if (!matchFound) {
                educationHistorys.add(educationHistory);
                Person updatePerson = new Person.Builder(person.getFirstname(), person.getSurname())
                        .person(person)
                        .educationHistory(educationHistorys)
                        .id(person.getId())
                        .build();
                PersonFacade.getPersonService().merge(updatePerson);
                getHome();
                Notification.show("Record ADDED!", Notification.Type.TRAY_NOTIFICATION);
            }
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }

    }

    private void saveEditedForm(FieldGroup binder) {
        DateUtil dateUtil = new DateUtil();
        boolean matchFound = false;
        try {
            binder.commit();
            EducationHistory educationHistory = getEditedEntity(binder);
            List<EducationHistory> educationHistorys = person.getEducationHistory();
            List<EducationHistory> updatedEducationHistorys = new ArrayList<>();
            updatedEducationHistorys.add(educationHistory);

            // Exclude current edited record from previous persited records
            for (EducationHistory educationHistoryy : educationHistorys) {
                if (!dateUtil.resetTimeOfDate(educationHistoryy.getGraduationDate()).equals(dateUtil.resetTimeOfDate(graduationDate))) {
                    updatedEducationHistorys.add(educationHistoryy);
                }
            }

            // Compare with previous persisted records
            for (EducationHistory professionalRegistr : educationHistorys) {
                if (dateUtil.resetTimeOfDate(professionalRegistr.getGraduationDate()).equals(dateUtil.resetTimeOfDate(educationHistory.getGraduationDate()))) {
                    Notification.show("Similar Record exist for Graduation Date", Notification.Type.TRAY_NOTIFICATION);
                    matchFound = true;
                    break;
                }
            }
            if (!matchFound) {
                Person updatePerson = new Person.Builder(person.getFirstname(), person.getSurname())
                        .person(person)
                        .educationHistory(updatedEducationHistorys)
                        .id(person.getId())
                        .build();
                PersonFacade.getPersonService().merge(updatePerson);
                getHome();
                Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
            }
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }

    }

    private void deleteForm(FieldGroup binder) {
        getHome();
    }

    private void getHome() {
        content.removeAllComponents();
        Person personn = PersonFacade.getPersonService().find(person.getId()); // Get Person with current changes // refresh
        table = new EducationHistoryTable(main, personn, content);
        content.addComponent(table);
        table.addValueChangeListener((Property.ValueChangeListener) this);
    }

    private EducationHistory getNewEntity(FieldGroup binder) {
        final EducationHistoryBean entityBean = ((BeanItem<EducationHistoryBean>) binder.getItemDataSource()).getBean();
        Location location = LocationFacade.getLocationService().find(entityBean.getLocationId()); // id stored in Bean
        final EducationHistory educationHistory = new EducationHistory.Builder(entityBean.getInstituteName())
                .graduationDate(entityBean.getGraduationDate())
                .location(location)
                .major(entityBean.getMajor())
                .build();
        return educationHistory;
    }

    private EducationHistory getEditedEntity(FieldGroup binder) {
        final EducationHistoryBean entityBean = ((BeanItem<EducationHistoryBean>) binder.getItemDataSource()).getBean();
        Location location = LocationFacade.getLocationService().find(entityBean.getLocationId()); // id stored in Bean
        final EducationHistory educationHistory = new EducationHistory.Builder(entityBean.getInstituteName())
                .graduationDate(entityBean.getGraduationDate())
                .location(location)
                .major(entityBean.getMajor())
                .build();
        return educationHistory;
    }

    @Override
    public void valueChange(Property.ValueChangeEvent event) {
        final Property property = event.getProperty();
        System.out.println(" The value is " + property.getValue());
    }

    public void setBean(EducationHistory educationHistory) {
        item.getBean().setGraduationDate(educationHistory.getGraduationDate());
        item.getBean().setInstituteName(educationHistory.getInstituteName());
        item.getBean().setLocationId(educationHistory.getLocation().getId());
        item.getBean().setMajor(educationHistory.getMajor());
        graduationDate = educationHistory.getGraduationDate();
    }

    /**
     * @return the update
     */
    public Button getUpdate() {
        return update;
    }

    /**
     * @return the save
     */
    public Button getSave() {
        return save;
    }
}
