/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import java.util.List;
import zm.hashcode.tics.app.facade.offices.FacilityFacade;
import zm.hashcode.tics.app.facade.ui.demographics.GenderFacade;
import zm.hashcode.tics.app.facade.ui.demographics.IdentificationTypeFacade;
import zm.hashcode.tics.app.facade.ui.demographics.RaceFacade;
import zm.hashcode.tics.app.facade.ui.demographics.TitleFacade;
import zm.hashcode.tics.client.web.content.people.admin.model.PersonBean;

import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.ui.demographics.Gender;
import zm.hashcode.tics.domain.ui.demographics.IdentificationType;
import zm.hashcode.tics.domain.ui.demographics.Race;
import zm.hashcode.tics.domain.ui.demographics.Title;

/**
 *
 * @author boniface
 */
public final class NewPersonForm extends FormLayout {

    private final PersonBean bean;
    public final BeanItem<PersonBean> item;
    public final FieldGroup binder;
    // Define Buttons
    public final Button save = new Button("Save");
    public final Button cancel = new Button("Cancel");

    public NewPersonForm() {
        bean = new PersonBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final HorizontalLayout buttons = getButtons();
        // Determines which properties are shown


        final TextField firstname = getTextField("First Name", "firstname");
        final TextField surname = getTextField("Last Name", "surname");
        final TextField othername = getTextField("Other Name", "othername");

        final ComboBox identitiesId = getIdentitiesComboBox("ID Type", "identitiesId");
        final TextField idValue = getTextField("ID Value", "idValue");
        final ComboBox facilityId = getFacilitiesComboBox("Facility", "facilityId");

        final ComboBox titleId = getTitleComboBox("Title", "titleId");
        final ComboBox genderId = getGenderComboBox("Gender", "genderId");
        final ComboBox raceId = getRaceComboBox("Race", "raceId");


        final GridLayout grid = new GridLayout(3, 10);
        grid.setSizeFull();

        grid.addComponent(firstname, 0, 0);
        grid.addComponent(othername, 1, 0);
        grid.addComponent(surname, 2, 0);

        grid.addComponent(identitiesId, 0, 1);
        grid.addComponent(idValue, 1, 1);
        grid.addComponent(facilityId, 2, 1);

        grid.addComponent(titleId, 0, 2);
        grid.addComponent(genderId, 1, 2);
        grid.addComponent(raceId, 2, 2);

        grid.addComponent(buttons, 0, 3, 2, 3);

        addComponent(grid);
    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(PersonBean.class, field));
        textField.setImmediate(true);
        binder.bind(textField, field);
        return textField;
    }

    private ComboBox getIdentitiesComboBox(String label, String field) {
        ComboBox comboBox = new ComboBox(label);
        List<IdentificationType> identitiesType = IdentificationTypeFacade.getIdentificationTypeService().findAll();

        for (IdentificationType location : identitiesType) {
            comboBox.addItem(location.getId());
            comboBox.setItemCaption(location.getId(), location.getIdvalue());
        }
        comboBox.addValidator(new BeanValidator(PersonBean.class, field));
        comboBox.setImmediate(true);
        comboBox.setWidth(250, Unit.PIXELS);
        binder.bind(comboBox, field);
        return comboBox;
    }

    private ComboBox getFacilitiesComboBox(String label, String field) {
        ComboBox comboBox = new ComboBox(label);
        List<Facility> facilities = FacilityFacade.getFacilityService().findAll();

        for (Facility facility : facilities) {
            comboBox.addItem(facility.getId());
            comboBox.setItemCaption(facility.getId(), facility.getFacilityName());
        }
        comboBox.addValidator(new BeanValidator(PersonBean.class, field));
        comboBox.setImmediate(true);
        comboBox.setWidth(250, Unit.PIXELS);
        binder.bind(comboBox, field);
        return comboBox;
    }

    private ComboBox getTitleComboBox(String label, String field) {
        ComboBox comboBox = new ComboBox(label);
        List<Title> titles = TitleFacade.getTitleService().findAll();
        for (Title title : titles) {
            comboBox.addItem(title.getId());
            comboBox.setItemCaption(title.getId(), title.getTitle());
        }
        comboBox.addValidator(new BeanValidator(PersonBean.class, field));
        comboBox.setImmediate(true);
        comboBox.setWidth(250, Unit.PIXELS);
        binder.bind(comboBox, field);
        return comboBox;
    }

    private ComboBox getGenderComboBox(String label, String field) {
        ComboBox comboBox = new ComboBox(label);
        List<Gender> genders = GenderFacade.getGenderService().findAll();

        for (Gender gender : genders) {
            comboBox.addItem(gender.getId());
            comboBox.setItemCaption(gender.getId(), gender.getGender());
        }
        comboBox.addValidator(new BeanValidator(PersonBean.class, field));
        comboBox.setImmediate(true);
        comboBox.setWidth(250, Unit.PIXELS);
        binder.bind(comboBox, field);
        return comboBox;
    }

    private ComboBox getRaceComboBox(String label, String field) {
        ComboBox comboBox = new ComboBox(label);
        List<Race> races = RaceFacade.getRaceService().findAll();

        for (Race race : races) {
            comboBox.addItem(race.getId());
            comboBox.setItemCaption(race.getId(), race.getRaceName());
        }
        comboBox.addValidator(new BeanValidator(PersonBean.class, field));
        comboBox.setImmediate(true);
        comboBox.setWidth(250, Unit.PIXELS);
        binder.bind(comboBox, field);
        return comboBox;
    }

    private HorizontalLayout getButtons() {
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.addComponent(save);
        buttons.addComponent(cancel);

        return buttons;
    }
}
