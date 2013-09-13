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
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.app.facade.ui.position.PositionFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.model.EmployeePositionBean;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.tables.EmployeePositionTable;
import zm.hashcode.tics.domain.people.EmployeePosition;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.ui.position.Position;

/**
 *
 * @author geek
 */
public class EmployeePositionForm extends FormLayout implements Button.ClickListener, Property.ValueChangeListener {

    private final EmployeePositionBean bean;
    public final BeanItem<EmployeePositionBean> item;
    public final FieldGroup binder;
    public ComboBox positionCombo = new ComboBox();
    // Define Buttons
    public Button save = new Button("Save");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
    private final Person person;
    private final TicsMain main;
    private final VerticalLayout content;
    private EmployeePositionTable table;

    public EmployeePositionForm(TicsMain main, Person person, VerticalLayout contentLayout) {
        setSizeFull();
        this.person = person;
        this.main = main;
        this.content = contentLayout;

        addListeners();
        bean = new EmployeePositionBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

        ComboBox positionComboBox = getLocationComboBox("Position", "positionId");
        TextField statusTextField = getTextField("Status", "status");
        PopupDateField startDatePopupDateField = getPopupDateField("Start Date", "startDate");
        PopupDateField endDatePopupDateField = getPopupDateField("End Date", "enddate");

        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(positionComboBox, 0, 0);
        grid.addComponent(statusTextField, 1, 0);
        grid.addComponent(startDatePopupDateField, 2, 0);
        grid.addComponent(endDatePopupDateField, 3, 0);

        grid.addComponent(buttons, 0, 1, 2, 1);
        addComponent(grid);

    }

    private ComboBox getLocationComboBox(String label, String field) {
        ComboBox comboBox = new ComboBox(label);
        List<Position> positions = PositionFacade.getPositionService().findAll();
////        List<Location> sortedCopy = Ordering.from(byLastName).compound(byFirstName).reverse().sortedCopy(locations);
////        List<Location> sortedList = Ordering.natural().reverse().sortedCopy(this);
//        Collection<Location> cities = Collections2.filter(locations, new CityPredicate());
        for (Position position : positions) {
            comboBox.addItem(position.getId());
            comboBox.setItemCaption(position.getId(), position.getPositionTitle());
        }
        comboBox.addValidator(new BeanValidator(EmployeePositionBean.class, field));
        comboBox.setImmediate(true);
        comboBox.setWidth(250, Unit.PIXELS);
        binder.bind(comboBox, field);
        return comboBox;
    }

    private PopupDateField getPopupDateField(String label, String field) {
        PopupDateField popupDateField = new PopupDateField(label);
        popupDateField.setWidth(250, Unit.PIXELS);
        popupDateField.addValidator(new BeanValidator(EmployeePositionBean.class, field));
        popupDateField.setImmediate(true);
        binder.bind(popupDateField, field);
        return popupDateField;
    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(EmployeePositionBean.class, field));
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
            EmployeePosition employeePosition = getNewEntity(binder);
            List<EmployeePosition> employeePositionss = new ArrayList<>();

            // Exclude current edited record from previous persisted records
            List<EmployeePosition> employeePositions = person.getPositions();
            for (EmployeePosition employeePositionv : employeePositions) {
                if (!employeePositionv.getPosition().getPositionTitle().equals(employeePosition.getPosition().getPositionTitle())) {
                    employeePositionss.add(employeePositionv);
                } else {
                    Notification.show("Change Position before SAVING!", Notification.Type.TRAY_NOTIFICATION);
                    matchFound = true;
                    break;
                }
            }

            if (!matchFound) {
                employeePositionss.add(employeePosition);
                Person updatePerson = new Person.Builder(person.getFirstname(), person.getSurname())
                        .person(person)
                        .positions(employeePositionss)
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
        boolean matchFound = false;
        try {
            binder.commit();
            EmployeePosition employeePosition = getEditedEntity(binder);
            List<EmployeePosition> employeePositions = person.getPositions();
            List<EmployeePosition> updatedEmployeePositions = new ArrayList<>();
            updatedEmployeePositions.add(employeePosition);

            // Exclude current edited record from previous persisted records
            for (EmployeePosition employeePositionv : employeePositions) {
                if (!employeePositionv.getPosition().getPositionTitle().equals(employeePosition.getPosition().getPositionTitle())) {
                    updatedEmployeePositions.add(employeePositionv);
                }
            }

            // Compare with previous persisted records
            for (EmployeePosition personRoles : employeePositions) {
                if (personRoles.getPosition().getPositionTitle().equals(employeePosition.getPosition().getPositionTitle())) {
                    Notification.show("Similar Record exist for Position Title!", Notification.Type.TRAY_NOTIFICATION);
                    matchFound = true;
                    break;
                }
            }
            if (!matchFound) {
                Person updatePerson = new Person.Builder(person.getFirstname(), person.getSurname())
                        .person(person)
                        .positions(updatedEmployeePositions)
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
        table = new EmployeePositionTable(main, personn, content);
        content.addComponent(table);
        table.addValueChangeListener((Property.ValueChangeListener) this);
    }

    private EmployeePosition getNewEntity(FieldGroup binder) {
        final EmployeePositionBean entityBean = ((BeanItem<EmployeePositionBean>) binder.getItemDataSource()).getBean();
        Position position = PositionFacade.getPositionService().find(entityBean.getPositionId()); // id stored in Bean
        final EmployeePosition employeePosition = new EmployeePosition.Builder(position)
                .enddate(entityBean.getEnddate())
                .startDate(entityBean.getStartDate())
                .status(entityBean.getStatus())
                .build();
        return employeePosition;
    }

    private EmployeePosition getEditedEntity(FieldGroup binder) {
        final EmployeePositionBean entityBean = ((BeanItem<EmployeePositionBean>) binder.getItemDataSource()).getBean();
        Position position = PositionFacade.getPositionService().find(entityBean.getPositionId()); // id stored in Bean
        final EmployeePosition employeePosition = new EmployeePosition.Builder(position)
                .enddate(entityBean.getEnddate())
                .startDate(entityBean.getStartDate())
                .status(entityBean.getStatus())
                .build();
        return employeePosition;
    }

    @Override
    public void valueChange(Property.ValueChangeEvent event) {
        final Property property = event.getProperty();
        System.out.println(" The value is " + property.getValue());
    }

    public void setBean(EmployeePosition employeePosition) {
        item.getBean().setEnddate(employeePosition.getEnddate());
        item.getBean().setPositionId(employeePosition.getPosition().getId());
        item.getBean().setStartDate(employeePosition.getStartDate());
        item.getBean().setStatus(employeePosition.getStatus());
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
