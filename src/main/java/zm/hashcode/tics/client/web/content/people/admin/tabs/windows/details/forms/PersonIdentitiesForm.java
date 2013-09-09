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
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.List;
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.app.facade.people.PersonIdentitiesFacade;
import zm.hashcode.tics.app.facade.ui.demographics.IdentificationTypeFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.model.PersonIdentitiesBean;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.tables.PersonIdentitiesTable;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.people.PersonIdentities;
import zm.hashcode.tics.domain.ui.demographics.IdentificationType;

/**
 *
 * @author geek
 */
public class PersonIdentitiesForm extends FormLayout implements Button.ClickListener, Property.ValueChangeListener {

    private final PersonIdentitiesBean bean;
    public final BeanItem<PersonIdentitiesBean> item;
    public final FieldGroup binder;
    //
    public ComboBox identificationTypeCombo = new ComboBox();
//    private String identificationTypeId;
    // Define Buttons
    public Button save = new Button("Save");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
    private final Person person;
    private final TicsMain main;
    private final VerticalLayout content;
    private PersonIdentitiesTable table;

    public PersonIdentitiesForm(TicsMain main, Person person, VerticalLayout contentLayout) {
        setSizeFull();
        this.person = person;
        this.main = main;
        this.content = contentLayout;


        bean = new PersonIdentitiesBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

//    private String id;
//    private String identificationTypeId; // IdentificationType ***
//    private String idValue;

        final ComboBox identificationTypeIdComboBox = getIdentificationTypeIdComboBox("Identification Type", "identificationTypeId");
        final TextField idValueTextField = getTextField("Id Value", "idValue");

        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(identificationTypeIdComboBox, 0, 0);
        grid.addComponent(idValueTextField, 1, 0);

        grid.addComponent(buttons, 0, 1, 2, 1);

        addComponent(grid);
        addListeners();
    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(PersonIdentitiesBean.class, field));
        textField.setImmediate(true);
        binder.bind(textField, field);
        return textField;
    }

    private ComboBox getIdentificationTypeIdComboBox(String label, String field) {
        identificationTypeCombo.setCaption(label);
        List<IdentificationType> identificationTypes = IdentificationTypeFacade.getIdentificationTypeService().findAll();
//        Collection<TrainingInstitution> institutionCourses = Collections2.filter(trainingInstitutions, new TrainingInstitutionPredicate());
        for (IdentificationType identificationType : identificationTypes) {
            identificationTypeCombo.addItem(identificationType.getId());
            identificationTypeCombo.setItemCaption(identificationType.getId(), identificationType.getIdvalue());
        }
        identificationTypeCombo.addValidator(new BeanValidator(PersonIdentitiesBean.class, field));
        identificationTypeCombo.setImmediate(true);
        identificationTypeCombo.setWidth(250, Unit.PIXELS);
        binder.bind(identificationTypeCombo, field);
        return identificationTypeCombo;
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
//        table.addValueChangeListener((Property.ValueChangeListener) this); // add later in getHome();
        /*
         identificationTypeCombo.addValueChangeListener((Property.ValueChangeListener) this);
         */
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            PersonIdentities personIdentity = getNewEntity(binder);
            PersonIdentitiesFacade.getPersonIdentitiesService().persist(personIdentity);
            List<PersonIdentities> personIdenties = new ArrayList<>();
            personIdenties.add(personIdentity);
            personIdenties.addAll(person.getIdentities());
            Person updatePerson = new Person.Builder(person.getFirstname(), person.getSurname())
                    .person(person)
                    .identities(personIdenties)
                    .id(person.getId())
                    .build();
            PersonFacade.getPersonService().merge(updatePerson);
            getHome();
            Notification.show("Record ADDED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }


    }

    private void saveEditedForm(FieldGroup binder) {
//        try {
//            binder.commit();
//            PersonIdentities personIdentity = getUpdateEntity(binder);
//            PersonIdentitiesFacade.getPersonIdentitiesService().merge(personIdentity);
//            List<PersonIdentities> personIdentities = new ArrayList<>();
//            personIdentities.add(personIdentity);
//            personIdentities.addAll(person.getIdentities());
//            Person updatePerson = new Person.Builder(person.getFirstname(), person.getSurname())
//                    .person(person)
//                    .identities(personIdentities)
//                    .id(person.getId())
//                    .build();
//            PersonFacade.getPersonService().merge(updatePerson);
//            getHome();
//            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
//        } catch (FieldGroup.CommitException e) {
//            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
//            getHome();
//        }
        getHome();
    }

    private void deleteForm(FieldGroup binder) {
//        try {
//            binder.commit();
//            PersonIdentities personIdentity = getUpdateEntity(binder);
//            List<PersonIdentities> personIdentities = new ArrayList<>();
//
//            personIdentities.addAll(person.getIdentities());
//            personIdentities.remove(personIdentity);
//            Person updatePerson = new Person.Builder(person.getFirstname(), person.getSurname())
//                    .person(person)
//                    .identities(personIdentities)
//                    .build();
//            PersonFacade.getPersonService().merge(updatePerson);
//            PersonIdentitiesFacade.getPersonIdentitiesService().remove(personIdentity);// NOTE
//            getHome();
//            Notification.show("Record DELETED!", Notification.Type.TRAY_NOTIFICATION);
//        } catch (FieldGroup.CommitException e) {
//            Notification.show("Record NOT DELETED!", Notification.Type.TRAY_NOTIFICATION);
//            getHome();
//        }
        getHome();
    }

    private void getHome() {
        content.removeAllComponents();
        Person personn = PersonFacade.getPersonService().find(person.getId()); // Get Person with current changes // refresh
        table = new PersonIdentitiesTable(main, personn, content);
        content.addComponent(table);
        table.addValueChangeListener((Property.ValueChangeListener) this);
    }

    private PersonIdentities getNewEntity(FieldGroup binder) {
        final PersonIdentitiesBean entityBean = ((BeanItem<PersonIdentitiesBean>) binder.getItemDataSource()).getBean();
        IdentificationType identificationType = IdentificationTypeFacade.getIdentificationTypeService().find(entityBean.getIdentificationTypeId());
        final PersonIdentities personIdentity = new PersonIdentities.Builder(identificationType)
                .idValue(entityBean.getIdValue())
                .build();
        return personIdentity;
    }

//    private PersonIdentities getUpdateEntity(FieldGroup binder) {
//        final PersonIdentitiesBean entityBean = ((BeanItem<PersonIdentitiesBean>) binder.getItemDataSource()).getBean();
//        IdentificationType identificationType = IdentificationTypeFacade.getIdentificationTypeService().find(entityBean.getIdentificationTypeId());
//        final PersonIdentities personIdentity = new PersonIdentities.Builder(identificationType)
//                .idValue(entityBean.getIdValue())
//                .id(entityBean.getId())
//                .build();
//        return personIdentity;
//    }
    @Override
    public void valueChange(Property.ValueChangeEvent event) {
        final Property property = event.getProperty();
        System.out.println(" The value is " + property.getValue());
        /*
         if (property == this.identificationTypeCombo) {
         identificationTypeId = property.getValue().toString();
         }
         */
    }
}
