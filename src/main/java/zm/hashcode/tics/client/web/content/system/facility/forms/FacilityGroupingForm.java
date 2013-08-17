/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextField;
import java.util.List;
import zm.hashcode.tics.app.facade.offices.ClusterFacade;
import zm.hashcode.tics.app.facade.offices.NodeFacade;
import zm.hashcode.tics.client.web.content.system.facility.model.FacilityGroupingBean;
import zm.hashcode.tics.domain.offices.Cluster;
import zm.hashcode.tics.domain.offices.Node;

/**
 *
 * @author ColinWa
 */
public class FacilityGroupingForm extends FormLayout {

    private final FacilityGroupingBean bean;
    public final BeanItem<FacilityGroupingBean> item;
    public final FieldGroup binder;
    public ListSelect clusterList = new ListSelect();
    public ListSelect nodeList = new ListSelect();
    // Define Buttons
    public final Button save = new Button("Save");
    public final Button edit = new Button("Edit");
    public final Button cancel = new Button("Cancel");
    public final Button update = new Button("Update");
    public final Button delete = new Button("Delete");

    public FacilityGroupingForm() {
        bean = new FacilityGroupingBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);


//            private String id;
//    private String email;
//    private String passwd;
//    private String firstname;
//    private String lastname;
//    private String middlename;
//    private boolean enabled;
//    private List<String> roles;
//    private List<String> jusridication;

//        final TextField firstname = getTextField("First Name", "firstname");
//        final TextField lastname = getTextField("Last Name", "lastname");
//        final TextField middlename = getTextField("Middle Name", "middlename");
//        final TextField email = getTextField("Email Address", "email");
//        final CheckBox enable = getCheckBoxField("Activate Account", "enabled");
//        TextArea postalAddress = getTextArea("Postal Address", "postalAddress");
//        TextArea physicalAddress = getTextArea("Physical  Address", "physicalAddress");
//        ComboBox city = getComboBox("City", "city");

        final ListSelect clusters = getClusters("Select Cluster", "clusterId");
        final ListSelect nodes = getNodes("Select Node", "nodeId");


        final GridLayout grid = new GridLayout(2, 10);
        grid.setSizeFull();

        grid.addComponent(clusters, 0, 0);
        grid.addComponent(nodes, 1, 0);
//        grid.addComponent(lastname, 2, 0);
//
//        grid.addComponent(email, 0, 1);
//        grid.addComponent(enable, 0, 2);
//
//        grid.addComponent(roles, 1, 1, 1, 2);
//
//        grid.addComponent(jurisdictions, 2, 1, 2, 2);
//
//        grid.addComponent(buttons, 0, 3, 2, 3);
        grid.addComponent(buttons, 0, 1);

        addComponent(grid);
    }

//    private TextArea getTextArea(String label, String field) {
//        TextArea textArea = new TextArea(label);
//        textArea.setWidth(250, Unit.PIXELS);
//        textArea.setNullRepresentation("");
//        textArea.addValidator(new BeanValidator(FacilityGroupingBean.class, field));
//        textArea.setImmediate(true);
//        binder.bind(textArea, field);
//        return textArea;
//
//    }
//
//    private TextField getTextField(String label, String field) {
//        TextField textField = new TextField(label);
//        textField.setWidth(250, Unit.PIXELS);
//        textField.setNullRepresentation("");
//        textField.addValidator(new BeanValidator(FacilityGroupingBean.class, field));
//        textField.setImmediate(true);
//        binder.bind(textField, field);
//        return textField;
//    }
//
//    private CheckBox getCheckBoxField(String label, String field) {
//        CheckBox checkBox = new CheckBox(label);
//        checkBox.setWidth(250, Unit.PIXELS);
//        checkBox.addValidator(new BeanValidator(FacilityGroupingBean.class, field));
//        checkBox.setImmediate(true);
//        binder.bind(checkBox, field);
//        return checkBox;
//    }
//
//    private ComboBox getComboBox(String label, String field) {
//        ComboBox comboBox = new ComboBox(label);
////        List<Location> locations = LocationFacade.getLocationModelService().findAll();
////
//////        List<Location> sortedCopy = Ordering.from(byLastName).compound(byFirstName).reverse().sortedCopy(locations);
//////        List<Location> sortedList = Ordering.natural().reverse().sortedCopy(this);
////
////        Collection<Location> cities = Collections2.filter(locations, new CityPredicate());
////        for (Location location : cities) {
////            comboBox.addItem(location.getId());
////            comboBox.setItemCaption(location.getId(), location.getName());
////        }
////        comboBox.addValidator(new BeanValidator(FacilityGroupingBean.class, field));
////        comboBox.setImmediate(true);
////        comboBox.setWidth(250, Unit.PIXELS);
//        binder.bind(comboBox, field);
//        return comboBox;
//    }
    private ListSelect getNodes(String label, String field) {
        nodeList.setCaption(label);
        List<Node> nodes = NodeFacade.getNodeService().findAll();
        for (Node iNode : nodes) {
            nodeList.setItemCaption(iNode.getId(), iNode.getNodeName());
            nodeList.setNullSelectionAllowed(false);
//            nodeList.setMultiSelect(true);
            nodeList.addItem(iNode.getId());
        }
        nodeList.setWidth("250px");
        binder.bind(nodeList, field);

        return nodeList;
    }

    private ListSelect getClusters(String label, String field) {
        clusterList.setCaption(label);
        List<Cluster> clusters = ClusterFacade.getClusterService().findAll();
        for (Cluster iClusters : clusters) {
            clusterList.setItemCaption(iClusters.getId(), iClusters.getClusterName());
            clusterList.setNullSelectionAllowed(false);
//            clusterList.setMultiSelect(true);
            clusterList.addItem(iClusters.getId());
        }
        clusterList.setWidth("250px");
        binder.bind(clusterList, field);
        return clusterList;
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
}
