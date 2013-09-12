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
import java.util.List;
import zm.hashcode.tics.app.facade.offices.RegistrationBodyFacade;
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.app.util.DateUtil;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.model.ProfessionalRegistrationBean;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.tables.ProfessionalRegistrationTable;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.people.ProfessionalRegistration;
import zm.hashcode.tics.domain.people.RegistrationBody;

/**
 *
 * @author geek
 */
public class ProfessionalRegistrationForm extends FormLayout implements Button.ClickListener, Property.ValueChangeListener {

    private final ProfessionalRegistrationBean bean;
    public final BeanItem<ProfessionalRegistrationBean> item;
    public final FieldGroup binder;
    public ComboBox registrationBodyCombo = new ComboBox();
    // Define Buttons
    public Button save = new Button("Save");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
    private final Person person;
    private final TicsMain main;
    private final VerticalLayout content;
    private ProfessionalRegistrationTable table;
    private static String registrationNumber;

    public ProfessionalRegistrationForm(TicsMain main, Person person, VerticalLayout contentLayout) {
        setSizeFull();
        this.person = person;
        this.main = main;
        this.content = contentLayout;

        addListeners();
        bean = new ProfessionalRegistrationBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

        ComboBox registrationBodyIdComboBox = getRegistrationBodyComboBox("Registration Body", "registrationBodyId");
        TextField registrationNumberTextField = getTextField("Registration Number", "registrationNumber");
        PopupDateField registrationDatePopupDateField = getPopupDateField("Registration Date", "registrationDate");
        PopupDateField expirationDatePopupDateField = getPopupDateField("Expiration Date", "expirationDate");
        TextField licenceNumberTextField = getTextField("Licence Number", "licenceNumber");


        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(registrationBodyIdComboBox, 0, 0);
        grid.addComponent(registrationNumberTextField, 1, 0);
        grid.addComponent(registrationDatePopupDateField, 2, 0);
        grid.addComponent(expirationDatePopupDateField, 3, 0);
        grid.addComponent(licenceNumberTextField, 0, 1);


        grid.addComponent(buttons, 0, 2, 2, 2);

        addComponent(grid);

    }

    private ComboBox getRegistrationBodyComboBox(String label, String field) {
        ComboBox comboBox = new ComboBox(label);
        List<RegistrationBody> registrationBodyS = RegistrationBodyFacade.getRegistrationBodyService().findAll();
////        List<Location> sortedCopy = Ordering.from(byLastName).compound(byFirstName).reverse().sortedCopy(locations);
////        List<Location> sortedList = Ordering.natural().reverse().sortedCopy(this);
//        Collection<Location> cities = Collections2.filter(locations, new CityPredicate());
        for (RegistrationBody registrationBody : registrationBodyS) {
            comboBox.addItem(registrationBody.getId());
            comboBox.setItemCaption(registrationBody.getId(), registrationBody.getName());
        }
        comboBox.addValidator(new BeanValidator(ProfessionalRegistrationBean.class, field));
        comboBox.setImmediate(true);
        comboBox.setWidth(250, Unit.PIXELS);
        binder.bind(comboBox, field);
        return comboBox;
    }

    private PopupDateField getPopupDateField(String label, String field) {
        PopupDateField popupDateField = new PopupDateField(label);
        popupDateField.setWidth(250, Unit.PIXELS);
        popupDateField.addValidator(new BeanValidator(ProfessionalRegistrationBean.class, field));
        popupDateField.setImmediate(true);
        binder.bind(popupDateField, field);
        return popupDateField;
    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(ProfessionalRegistrationBean.class, field));
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
        try {
            binder.commit();
            ProfessionalRegistration professionalRegistration = getNewEntity(binder);
            List<ProfessionalRegistration> professionalRegistrationns = new ArrayList<>();

            List<ProfessionalRegistration> professionalRegistrations = person.getProfessionalRegistration();
            for (ProfessionalRegistration professionalRegist : professionalRegistrations) {
                if (!professionalRegist.getRegistrationNumber().equals(professionalRegistration.getRegistrationNumber()) /*   || professionalRegist.getLicenceNumber().equals(professionalRegistration.getLicenceNumber()) */) {
                    professionalRegistrationns.add(professionalRegist);
                } else {
                    Notification.show("Similar Record exist for Registration Number!", Notification.Type.TRAY_NOTIFICATION);
                    matchFound = true;
                    break;
                }
            }

            if (!matchFound) {
                professionalRegistrationns.add(professionalRegistration);
                Person updatePerson = new Person.Builder(person.getFirstname(), person.getSurname())
                        .person(person)
                        .professionalRegistration(professionalRegistrationns)
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
            ProfessionalRegistration professionalRegistration = getEditedEntity(binder);
            List<ProfessionalRegistration> professionalRegistrations = person.getProfessionalRegistration();
            List<ProfessionalRegistration> professionalRegist = new ArrayList<>();
            professionalRegist.add(professionalRegistration);

            // Exclude current edited record from previous persited records
            for (ProfessionalRegistration professionalRegistrationn : professionalRegistrations) {
                if (!professionalRegistrationn.getRegistrationNumber().equals(registrationNumber)) {
                    professionalRegist.add(professionalRegistrationn);
                }
            }

            // Compare with previous persisted records
            for (ProfessionalRegistration professionalRegistr : professionalRegistrations) {
                if (professionalRegistr.getRegistrationNumber().equals(professionalRegistration.getRegistrationNumber()) /*   || professionalRegist.getLicenceNumber().equals(professionalRegistration.getLicenceNumber()) */) {
                    Notification.show("Similar Record exist for Registration Number!", Notification.Type.TRAY_NOTIFICATION);
                    matchFound = true;
                    break;
                }
            }
            if (!matchFound) {
                Person updatePerson = new Person.Builder(person.getFirstname(), person.getSurname())
                        .person(person)
                        .professionalRegistration(professionalRegist)
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
        table = new ProfessionalRegistrationTable(main, personn, content);
        content.addComponent(table);
        table.addValueChangeListener((Property.ValueChangeListener) this);
    }

    private ProfessionalRegistration getNewEntity(FieldGroup binder) {
        final ProfessionalRegistrationBean entityBean = ((BeanItem<ProfessionalRegistrationBean>) binder.getItemDataSource()).getBean();
        RegistrationBody registrationBody = RegistrationBodyFacade.getRegistrationBodyService().find(entityBean.getRegistrationBodyId());
        final ProfessionalRegistration professionalRegistration = new ProfessionalRegistration.Builder(registrationBody)
                .expirationDate(entityBean.getExpirationDate())
                .licenceNumber(entityBean.getLicenceNumber())
                .registrationDate(entityBean.getRegistrationDate())
                .registrationNumber(entityBean.getRegistrationNumber())
                .build();
        return professionalRegistration;
    }

    private ProfessionalRegistration getEditedEntity(FieldGroup binder) {
        final ProfessionalRegistrationBean entityBean = ((BeanItem<ProfessionalRegistrationBean>) binder.getItemDataSource()).getBean();
        RegistrationBody registrationBody = RegistrationBodyFacade.getRegistrationBodyService().find(entityBean.getRegistrationBodyId());
        final ProfessionalRegistration professionalRegistration = new ProfessionalRegistration.Builder(registrationBody)
                .expirationDate(entityBean.getExpirationDate())
                .licenceNumber(entityBean.getLicenceNumber())
                .registrationDate(entityBean.getRegistrationDate())
                .registrationNumber(entityBean.getRegistrationNumber())
                .build();
        return professionalRegistration;
    }

    @Override
    public void valueChange(Property.ValueChangeEvent event) {
        final Property property = event.getProperty();
        System.out.println(" The value is " + property.getValue());
    }

    public void setBean(ProfessionalRegistration professionalRegistration) {
        item.getBean().setExpirationDate(professionalRegistration.getExpirationDate());
        item.getBean().setLicenceNumber(professionalRegistration.getLicenceNumber());
        item.getBean().setRegistrationBodyId(professionalRegistration.getRegistrationBody().getId());
        item.getBean().setRegistrationDate(professionalRegistration.getRegistrationDate());
        item.getBean().setRegistrationNumber(professionalRegistration.getRegistrationNumber());
        registrationNumber = professionalRegistration.getRegistrationNumber();
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
