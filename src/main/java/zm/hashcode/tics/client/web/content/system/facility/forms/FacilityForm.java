/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.forms;

import com.google.common.collect.Collections2;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import java.util.Collection;
import java.util.List;
import zm.hashcode.tics.app.facade.offices.FacilityGroupingFacade;
import zm.hashcode.tics.app.facade.offices.FacilityTypeFacade;
import zm.hashcode.tics.app.facade.ui.location.LocationFacade;
import zm.hashcode.tics.client.web.content.system.facility.model.FacilityBean;
import zm.hashcode.tics.domain.offices.FacilityGrouping;
import zm.hashcode.tics.domain.offices.FacilityType;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.services.ui.location.predicates.CityPredicate;

/**
 *
 * @author geek
 */
public class FacilityForm extends FormLayout {

    private final FacilityBean bean;
    public final BeanItem<FacilityBean> item;
    public final FieldGroup binder;
    // Define Buttons
    public final Button save = new Button("Save");
    public final Button edit = new Button("Edit");
    public final Button cancel = new Button("Cancel");
    public final Button update = new Button("Update");
    public final Button delete = new Button("Delete");

    public FacilityForm() {
        bean = new FacilityBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

///    private String id;
//    private String facilityName;
//    private String facilityTypeId;
//    //Address
//    private String postalAddress;
//    private String physicalAddress;
//    private String contactNumber;
//    private String postalCode;
//    private String emailAddress;
//    private String cityId;
//    private String facilityGroupingId;

        final TextField facilityName = getTextField("Facility Name", "facilityName");
        final TextField contactNumber = getTextField("Contact Number", "contactNumber");
        final TextField postalCode = getTextField("Postal Code ", "postalCode");
        final TextField emailAddress = getTextField("Email  Address", "emailAddress");
        final ComboBox cityId = getCityComboBox("City", "cityId");
        final ComboBox facilityTypeId = getFacilityTypeComboBox("Facility Type", "facilityTypeId");
        final ComboBox facilityGroupingId = getFacilityGroupingComboBox("Facility Grouping", "facilityGroupingId");
        final TextArea physicalAddress = getTextAreaField("Physical  Address", "physicalAddress");
        final TextArea postalAddress = getTextAreaField("Postal   Address", "postalAddress");





        final GridLayout grid = new GridLayout(3, 10);
        grid.setSizeFull();

        grid.addComponent(facilityName, 0, 0);
        grid.addComponent(facilityTypeId, 0, 1);

        grid.addComponent(physicalAddress, 1, 0, 1, 1);
        grid.addComponent(postalAddress, 2, 0, 2, 1);

        grid.addComponent(postalCode, 0, 3);
        grid.addComponent(emailAddress, 1, 3);
        grid.addComponent(contactNumber, 2, 3);

        grid.addComponent(cityId, 0, 4);
        grid.addComponent(facilityGroupingId, 1, 4);

        grid.addComponent(buttons, 0, 5, 2, 5);
        addComponent(grid);
    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(FacilityBean.class, field));
        textField.setImmediate(true);
        binder.bind(textField, field);
        return textField;
    }

    private TextArea getTextAreaField(String label, String field) {
        TextArea textField = new TextArea(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(FacilityBean.class, field));
        textField.setImmediate(true);
        binder.bind(textField, field);
        return textField;
    }

    private ComboBox getCityComboBox(String label, String field) {
        ComboBox comboBox = new ComboBox(label);
        List<Location> locations = LocationFacade.getLocationService().findAll();
        Collection<Location> cities = Collections2.filter(locations, new CityPredicate());
        for (Location city : locations) {
            comboBox.addItem(city.getId());
            comboBox.setItemCaption(city.getId(), city.getName());
        }
        comboBox.addValidator(new BeanValidator(FacilityBean.class, field));
        comboBox.setImmediate(true);
        comboBox.setWidth(250, Unit.PIXELS);
        binder.bind(comboBox, field);
        return comboBox;
    }

    private ComboBox getFacilityGroupingComboBox(String label, String field) {
        ComboBox comboBox = new ComboBox(label);
        List<FacilityGrouping> facilityGroupings = FacilityGroupingFacade.getFacilityGroupingService().findAll();
        for (FacilityGrouping facilityGrouping : facilityGroupings) {
            comboBox.addItem(facilityGrouping.getId());
            comboBox.setItemCaption(facilityGrouping.getId(), getGropuping(facilityGrouping));
        }
        comboBox.addValidator(new BeanValidator(FacilityBean.class, field));
        comboBox.setImmediate(true);
        comboBox.setWidth(250, Unit.PIXELS);
        binder.bind(comboBox, field);
        return comboBox;
    }

    private ComboBox getFacilityTypeComboBox(String label, String field) {
        ComboBox comboBox = new ComboBox(label);
        List<FacilityType> facilityTypes = FacilityTypeFacade.getFacilityTypeService().findAll();
        for (FacilityType facilityType : facilityTypes) {
            comboBox.addItem(facilityType.getId());
            comboBox.setItemCaption(facilityType.getId(), facilityType.getFacilityName());
        }
        comboBox.addValidator(new BeanValidator(FacilityBean.class, field));
        comboBox.setImmediate(true);
        comboBox.setWidth(250, Unit.PIXELS);
        binder.bind(comboBox, field);
        return comboBox;
    }

    private HorizontalLayout getButtons() {
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.addComponent(save);
        buttons.addComponent(edit);
        buttons.addComponent(cancel);
        buttons.addComponent(update);
        buttons.addComponent(delete);
        return buttons;
    }

    private String getGropuping(FacilityGrouping facilityGrouping) {
        if (facilityGrouping != null) {
            return "Cluster: " + facilityGrouping.getCluster().getClusterName() + " Node: " + facilityGrouping.getNode().getNodeName();
        }
        return null;
    }
}
