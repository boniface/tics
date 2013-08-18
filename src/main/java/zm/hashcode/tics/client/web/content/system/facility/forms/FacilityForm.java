/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextField;
import java.util.List;
import zm.hashcode.tics.app.facade.offices.FacilityFacade;
import zm.hashcode.tics.domain.offices.Facility;

/**
 *
 * @author geek
 */
public class FacilityForm extends FormLayout {
//    private final FacilityBean bean;
//    public final BeanItem<FacilityBean> item;
//    public final FieldGroup binder;
//    public ListSelect positionList = new ListSelect();
//    public ListSelect facilityMentorsList = new ListSelect();
//    // Define Buttons
//    public final Button save = new Button("Save");
//    public final Button edit = new Button("Edit");
//    public final Button cancel = new Button("Cancel");
//    public final Button update = new Button("Update");
//    public final Button delete = new Button("Delete");
//
//    public FacilityForm() {
//        bean = new FacilityBean();
//        item = new BeanItem<>(bean);
//        binder = new FieldGroup(item);
//        final HorizontalLayout buttons = getButtons();
//        // Determines which properties are shown
//        update.setVisible(false);
//        delete.setVisible(false);
//
////        private String id;
////    private String facilityName;
////    @DBRef
////    private FacilityType facilityType;
////    @DBRef
////    private Location city;
////    private Contact contact;
////    @DBRef
////    private FacilityGrouping facilityGrouping;
////    @DBRef
////    private List<Position> positions ;
////    private List<FacilityMentors> facilityMentors;
//
//        TextField facilityName = getTextField("Facility Name", "facilityName");
//
//        final ListSelect positions = getPositions("Select Cluster", "positions");
//        final ListSelect facilityMentors = getFacilityMentors("Select Node", "facilityMentors");
//
//        final GridLayout grid = new GridLayout(2, 10);
//        grid.setSizeFull();
//
//        grid.addComponent(positions, 0, 0);
//        grid.addComponent(facilityMentors, 1, 0);
////        grid.addComponent(lastname, 2, 0);
////
////        grid.addComponent(email, 0, 1);
////        grid.addComponent(enable, 0, 2);
////
////        grid.addComponent(roles, 1, 1, 1, 2);
////
////        grid.addComponent(jurisdictions, 2, 1, 2, 2);
////
////        grid.addComponent(buttons, 0, 3, 2, 3);
//        grid.addComponent(buttons, 0, 1);
//
//        addComponent(grid);
//    }
//
//    private TextField getTextField(String label, String field) {
//        TextField textField = new TextField(label);
//        textField.setWidth(250, Unit.PIXELS);
//        textField.setNullRepresentation("");
//        textField.addValidator(new BeanValidator(FacilityBean.class, field));
//        textField.setImmediate(true);
//        binder.bind(textField, field);
//        return textField;
//    }
//
//    private ListSelect getFacilityMentors(String label, String field) {
//        facilityMentorsList.setCaption(label);
//        List<Facility> facilities = FacilityFacade.getFacilityService().findAll();
//
//        for (Facility iFacility : facilities) {
//            facilityMentorsList.setItemCaption(iFacility.getId(), iFacility());
//            facilityMentorsList.setNullSelectionAllowed(false);
////            facilityMentorsList.setMultiSelect(true);
//            facilityMentorsList.addItem(iFacility.getId());
//        }
//        facilityMentorsList.setWidth("250px");
//        binder.bind(facilityMentorsList, field);
//
//        return facilityMentorsList;
//    }
//
//    private ListSelect getPositions(String label, String field) {
//        positionList.setCaption(label);
//        List<Cluster> clusters = ClusterFacade.getClusterService().findAll();
//        for (Cluster iClusters : clusters) {
//            positionList.setItemCaption(iClusters.getId(), iClusters.getClusterName());
//            positionList.setNullSelectionAllowed(false);
////            positionList.setMultiSelect(true);
//            positionList.addItem(iClusters.getId());
//        }
//        positionList.setWidth("250px");
//        binder.bind(positionList, field);
//        return positionList;
//    }
//
//    private HorizontalLayout getButtons() {
//        HorizontalLayout buttons = new HorizontalLayout();
//        buttons.addComponent(save);
//        buttons.addComponent(edit);
//        buttons.addComponent(cancel);
//        buttons.addComponent(update);
//        buttons.addComponent(delete);
//        return buttons;
//    }
}
