/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.positions.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.FormLayout;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import java.util.List;
import zm.hashcode.tics.app.facade.offices.DepartmentFacade;
import zm.hashcode.tics.app.facade.offices.FacilityFacade;
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.app.facade.ui.job.JobFacade;
import zm.hashcode.tics.app.facade.ui.position.PositionFacade;
import zm.hashcode.tics.app.facade.ui.position.PositionTypeFacade;
import zm.hashcode.tics.app.facade.ui.util.StatusFacade;
import zm.hashcode.tics.client.web.content.system.positions.model.PositionBean;
import zm.hashcode.tics.domain.offices.Department;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.ui.job.Job;
import zm.hashcode.tics.domain.ui.position.Position;
import zm.hashcode.tics.domain.ui.position.PositionType;
import zm.hashcode.tics.domain.ui.util.Status;

/**
 *
 * @author geek
 */
public class PositionForm extends FormLayout {

    private final PositionBean bean;
    public final BeanItem<PositionBean> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
    //
    public ListSelect subodinateList = new ListSelect();
//    public ComboBox currentOccupantCombo = new ComboBox();
    public ComboBox positionTypeCombo = new ComboBox();
    public ComboBox positionStatusCombo = new ComboBox();
//    public ComboBox facilityCombo = new ComboBox();
    public ComboBox supervisorCombo = new ComboBox();
//    public ComboBox departmentCombo = new ComboBox();
    public ComboBox jobCombo = new ComboBox();

    public PositionForm() {
        bean = new PositionBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

//        private String id;
//    private String positionCode;
//    //Make it from Job and Position Title Nurse-Code
//    private String positionTitle;
//    private String description;
//    private String positionComments;
//    private Date postionEntryDate;
//    private Date positionEndDate;
//    @DBRef
//    private Person currentOccupant; // personId
//    @DBRef
//    private PositionType positionType; // positionTypeId
//    @DBRef
//    private Status positionStatus; // statusId

//    @DBRef
//    private Facility facility; // facilityId
//    private List<String> subodinateIds; // subodinateIds
//    @DBRef
//    private Position supervisor; // positionId
//    @DBRef
//    private Department department; // departmentId
//    @DBRef
//    private Job job; // jobId

        TextField positionCode = getTextField("Position Code", "positionCode");
        TextField positionTitle = getTextField("Position Title", "positionTitle");
        TextField description = getTextField("Description", "description");
        TextField positionComments = getTextField("Position Comments", "positionComments");

        PopupDateField postionEntryDate = getPopupDateField("Postion Entry Date", "positionEntryDate");
//        PopupDateField positionEndDate = getPopupDateField("Postion End Date", "positionEndDate");

//        ComboBox currentOccupant = getCurrentOccupantComboBox("Current Occupant", "personId");
        ComboBox positionType = getPositionTypeComboBox("Position Type", "positionTypeId");
        ComboBox positionStatus = getPositionStatusComboBox("Position Status", "statusId");
//        ComboBox facility = getFacilityComboBox("Facility", "facilityId");

        final ListSelect subodinateIds = getSubordinatesListSelect("Select Subordinate", "subodinateIds");

        ComboBox supervisor = getSupervisorComboBox("Supervisor", "positionId");
//        ComboBox department = getDepartmentComboBox("Department", "departmentId");
        ComboBox job = getJobComboBox("Job", "jobId");

        GridLayout grid = new GridLayout(4, 10);  // ADJUSTS if neccesary Col, Row
        grid.setSizeFull();

        grid.addComponent(positionCode, 0, 0);
        grid.addComponent(positionTitle, 1, 0);
        grid.addComponent(description, 2, 0);
        grid.addComponent(positionComments, 0, 1);
        grid.addComponent(postionEntryDate, 1, 1);
//        grid.addComponent(positionEndDate, 1, 1);
//        grid.addComponent(currentOccupant, 1, 2);
        grid.addComponent(positionType, 2, 1);
        grid.addComponent(positionStatus, 0, 2);
//        grid.addComponent(facility, 2, 1);
        grid.addComponent(supervisor, 1, 2);
//        grid.addComponent(department, 2, 3);
        grid.addComponent(job, 2, 2);
        grid.addComponent(subodinateIds, 0, 3);

        grid.addComponent(buttons, 0, 4, 2, 4);

        addComponent(grid);

    }

    private ListSelect getSubordinatesListSelect(String label, String field) {
        subodinateList.setCaption(label);

//        QUESTION: Who are Subordinates

//        List<Subordinate> roles = UserFacade.getRoleService().findAll();
//        for (Role role : roles) {
//            subodinateList.setItemCaption(role.getId(), role.getRolename() + " " + role.getDescription());
//            subodinateList.setNullSelectionAllowed(false);
//            subodinateList.setMultiSelect(true);
//            subodinateList.addItem(role.getId());
//        }
        subodinateList.setWidth("250px");
        binder.bind(subodinateList, field);

        return subodinateList;
    }

    private PopupDateField getPopupDateField(String label, String field) {
        PopupDateField popupDateField = new PopupDateField(label);
        popupDateField.setWidth(250, Unit.PIXELS);
        popupDateField.addValidator(new BeanValidator(PositionBean.class, field));
        popupDateField.setImmediate(true);
        binder.bind(popupDateField, field);
        return popupDateField;
    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(PositionBean.class, field));
        textField.setImmediate(true);
        binder.bind(textField, field);
        return textField;
    }

//    private ComboBox getCurrentOccupantComboBox(String label, String field) {
////        ComboBox comboBox = new ComboBox(label);
//        currentOccupantCombo.setCaption(label);
//        List<Person> allPersons = PersonFacade.getPersonService().findAll();
//        for (Person iPerson : allPersons) {
//            currentOccupantCombo.addItem(iPerson.getId());
//            currentOccupantCombo.setItemCaption(iPerson.getId(), iPerson.getFirstname() + " " + iPerson.getSurname());
//        }
//
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
//        currentOccupantCombo.addValidator(new BeanValidator(PositionBean.class, field));
//        currentOccupantCombo.setImmediate(true);
//        currentOccupantCombo.setWidth(250, Unit.PIXELS);
//        binder.bind(currentOccupantCombo, field);
//        return currentOccupantCombo;
//    }
    private ComboBox getPositionTypeComboBox(String label, String field) {
//        ComboBox comboBox = new ComboBox(label);
        positionTypeCombo.setCaption(label);
        List<PositionType> allPositionTypes = PositionTypeFacade.getPositionTypeService().findAll();
        for (PositionType iPositionType : allPositionTypes) {
            positionTypeCombo.addItem(iPositionType.getId());
            positionTypeCombo.setItemCaption(iPositionType.getId(), iPositionType.getName());
        }

        positionTypeCombo.addValidator(new BeanValidator(PositionBean.class, field));
        positionTypeCombo.setImmediate(true);
        positionTypeCombo.setWidth(250, Unit.PIXELS);
        binder.bind(positionTypeCombo, field);
        return positionTypeCombo;
    }

    private ComboBox getPositionStatusComboBox(String label, String field) {
//        ComboBox comboBox = new ComboBox(label);
        positionStatusCombo.setCaption(label);
        List<Status> allStatuses = StatusFacade.getStatusService().findAll();
        for (Status iStatus : allStatuses) {
            positionStatusCombo.addItem(iStatus.getId());
            positionStatusCombo.setItemCaption(iStatus.getId(), iStatus.getStatusType() + " - " + iStatus.getStatusValue());
        }

        positionStatusCombo.addValidator(new BeanValidator(PositionBean.class, field));
        positionStatusCombo.setImmediate(true);
        positionStatusCombo.setWidth(250, Unit.PIXELS);
        binder.bind(positionStatusCombo, field);
        return positionStatusCombo;
    }
//
//    private ComboBox getFacilityComboBox(String label, String field) {
////        ComboBox comboBox = new ComboBox(label);
//        facilityCombo.setCaption(label);
//        List<Facility> allFacilities = FacilityFacade.getFacilityService().findAll();
//        for (Facility iFacility : allFacilities) {
//            facilityCombo.addItem(iFacility.getId());
//            facilityCombo.setItemCaption(iFacility.getId(), iFacility.getFacilityName());
//        }
//
//        facilityCombo.addValidator(new BeanValidator(PositionBean.class, field));
//        facilityCombo.setImmediate(true);
//        facilityCombo.setWidth(250, Unit.PIXELS);
//        binder.bind(facilityCombo, field);
//        return facilityCombo;
//    }

    private ComboBox getSupervisorComboBox(String label, String field) {
//        ComboBox comboBox = new ComboBox(label);
        supervisorCombo.setCaption(label);
        List<Position> allPositions = PositionFacade.getPositionService().findAll();
        for (Position iPosition : allPositions) {
            supervisorCombo.addItem(iPosition.getId());
            supervisorCombo.setItemCaption(iPosition.getId(), iPosition.getPositionTitle()); // IS Title Correct ?????????
        }

        supervisorCombo.addValidator(new BeanValidator(PositionBean.class, field));
        supervisorCombo.setImmediate(true);
        supervisorCombo.setWidth(250, Unit.PIXELS);
        binder.bind(supervisorCombo, field);
        return supervisorCombo;
    }
//
//    private ComboBox getDepartmentComboBox(String label, String field) {
////        ComboBox comboBox = new ComboBox(label);
//        departmentCombo.setCaption(label);
//        List<Department> allDepartments = DepartmentFacade.getDepartmentService().findAll();
//        for (Department iDepartment : allDepartments) {
//            departmentCombo.addItem(iDepartment.getId());
//            departmentCombo.setItemCaption(iDepartment.getId(), iDepartment.getName());
//        }
//
//        departmentCombo.addValidator(new BeanValidator(PositionBean.class, field));
//        departmentCombo.setImmediate(true);
//        departmentCombo.setWidth(250, Unit.PIXELS);
//        binder.bind(departmentCombo, field);
//        return departmentCombo;
//    }

    private ComboBox getJobComboBox(String label, String field) {
//        ComboBox comboBox = new ComboBox(label);
        jobCombo.setCaption(label);
        List<Job> allJobs = JobFacade.getJobService().findAll();
        for (Job iJob : allJobs) {
            jobCombo.addItem(iJob.getId());
            jobCombo.setItemCaption(iJob.getId(), iJob.getTitle());
        }

        jobCombo.addValidator(new BeanValidator(PositionBean.class, field));
        jobCombo.setImmediate(true);
        jobCombo.setWidth(250, Unit.PIXELS);
        binder.bind(jobCombo, field);
        return jobCombo;
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
