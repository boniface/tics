/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.positions.tabs;

import zm.hashcode.tics.client.web.content.users.tabs.*;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import zm.hashcode.tics.app.facade.offices.DepartmentFacade;
import zm.hashcode.tics.app.facade.offices.FacilityFacade;
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.app.facade.ui.job.JobFacade;
import zm.hashcode.tics.app.facade.ui.position.PositionFacade;
import zm.hashcode.tics.app.facade.ui.position.PositionTypeFacade;
import zm.hashcode.tics.app.facade.ui.util.StatusFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.positions.PositionsMenu;
import zm.hashcode.tics.client.web.content.system.positions.forms.PositionForm;
import zm.hashcode.tics.client.web.content.system.positions.model.PositionBean;
import zm.hashcode.tics.client.web.content.system.positions.tables.PositionTable;
import zm.hashcode.tics.client.web.content.system.positions.util.PositionUtil;
import zm.hashcode.tics.domain.offices.Department;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.ui.job.Job;
import zm.hashcode.tics.domain.ui.position.Position;
import zm.hashcode.tics.domain.ui.position.PositionType;
import zm.hashcode.tics.domain.ui.util.Status;

/**
 *
 * @author Ferox
 */
public final class PositionTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final PositionForm form;
    private final PositionTable table;
    private Collection<String> subodinateIds = new HashSet<>();
//    private Collection<String> jusrisdicationIds = new HashSet<>();
    private String currentOccupantId;
    private String departmentId;
    private String facilityId;
    private String jobId;
    private String positionStatusId;
    private String positionTypeId;
    private String supervisorId;

    public PositionTab(TicsMain app) {
        main = app;
        form = new PositionForm();
        table = new PositionTable(main);
        setSizeFull();
        addComponent(form);
        addComponent(table);
        addListeners();
    }

    @Override
    public void buttonClick(ClickEvent event) {
        final Button source = event.getButton();
        if (source == form.save) {
            saveForm(form.binder);
        } else if (source == form.edit) {
            setEditFormProperties();
        } else if (source == form.cancel) {
            getHome();
        } else if (source == form.update) {
            saveEditedForm(form.binder);
        } else if (source == form.delete) {
            deleteForm(form.binder);
        }
    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        final Property property = event.getProperty();
        if (property == table) {
            final Position user = PositionFacade.getPositionService().find(table.getValue().toString());
            final PositionBean bean = new PositionUtil().getBean(user);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        } else if (property == form.currentOccupantCombo) {
            currentOccupantId = property.getValue().toString();
        } else if (property == form.departmentCombo) {
            departmentId = property.getValue().toString();
        } else if (property == form.facilityCombo) {
            facilityId = property.getValue().toString();
        } else if (property == form.jobCombo) {
            jobId = property.getValue().toString();
        } else if (property == form.positionStatusCombo) {
            positionStatusId = property.getValue().toString();
        } else if (property == form.positionTypeCombo) {
            positionTypeId = property.getValue().toString();
        } else if (property == form.supervisorCombo) {
            supervisorId = property.getValue().toString();
        } else if (property == form.subodinateList) {
            subodinateIds = (Collection<String>) property.getValue();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            PositionFacade.getPositionService().persist(getNewEntity(binder));
            getHome();
            Notification.show("Record ADDED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void saveEditedForm(FieldGroup binder) {
        try {
            binder.commit();
            PositionFacade.getPositionService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        PositionFacade.getPositionService().remove(getUpdateEntity(binder));
        getHome();
    }

    private Position getNewEntity(FieldGroup binder) {

        final PositionBean bean = ((BeanItem<PositionBean>) binder.getItemDataSource()).getBean();

        Person currentOccupant = PersonFacade.getPersonService().find(currentOccupantId);
        Department department = DepartmentFacade.getDepartmentService().find(departmentId);
        Facility facility = FacilityFacade.getFacilityService().find(facilityId);
        Job job = JobFacade.getJobService().find(jobId);
        Status status = StatusFacade.getStatusService().find(positionStatusId);
        PositionType postionType = PositionTypeFacade.getPositionTypeService().find(positionTypeId);
        Position position = PositionFacade.getPositionService().find(supervisorId);

        final Position iPosition = new Position.Builder(bean.getPositionTitle())
                .currentOccupant(currentOccupant)
                .department(department)
                .description(bean.getDescription())
                .facility(facility)
                .job(job)
                .positionCode(bean.getPositionCode())
                .positionComments(bean.getPositionComments())
                .positionEndDate(bean.getPositionEndDate())
                .positionStatus(status)
                .positionType(postionType)
                .postionEntryDate(bean.getPositionEndDate())
                //. suburdinateIds
                .supervisor(position)
                .build();
        return iPosition;
    }

    private Position getUpdateEntity(FieldGroup binder) {

        final PositionBean bean = ((BeanItem<PositionBean>) binder.getItemDataSource()).getBean();

        Person currentOccupant = PersonFacade.getPersonService().find(currentOccupantId);
        Department department = DepartmentFacade.getDepartmentService().find(departmentId);
        Facility facility = FacilityFacade.getFacilityService().find(facilityId);
        Job job = JobFacade.getJobService().find(jobId);
        Status status = StatusFacade.getStatusService().find(positionStatusId);
        PositionType postionType = PositionTypeFacade.getPositionTypeService().find(positionTypeId);
        Position position = PositionFacade.getPositionService().find(supervisorId);

        final Position iPosition = new Position.Builder(bean.getPositionTitle())
                .currentOccupant(currentOccupant)
                .department(department)
                .description(bean.getDescription())
                .facility(facility)
                .job(job)
                .positionCode(bean.getPositionCode())
                .positionComments(bean.getPositionComments())
                .positionEndDate(bean.getPositionEndDate())
                .positionStatus(status)
                .positionType(postionType)
                .postionEntryDate(bean.getPositionEndDate())
                //. suburdinateIds
                .supervisor(position)
                .id(bean.getId())
                .build();
        return iPosition;
    }

    private void getHome() {
        main.content.setSecondComponent(new PositionsMenu(main, "POSITION"));
    }

    private void setEditFormProperties() {
        form.binder.setReadOnly(false);
        form.save.setVisible(false);
        form.edit.setVisible(false);
        form.cancel.setVisible(true);
        form.delete.setVisible(false);
        form.update.setVisible(true);
    }

    private void setReadFormProperties() {
        form.binder.setReadOnly(true);
        //Buttons Behaviou
        form.save.setVisible(false);
        form.edit.setVisible(true);
        form.cancel.setVisible(true);
        form.delete.setVisible(true);
        form.update.setVisible(false);
    }

    private void addListeners() {
        //Register Button Listeners
        form.save.addClickListener((ClickListener) this);
        form.edit.addClickListener((ClickListener) this);
        form.cancel.addClickListener((ClickListener) this);
        form.update.addClickListener((ClickListener) this);
        form.delete.addClickListener((ClickListener) this);
        //Register Table Listerners
        table.addValueChangeListener((ValueChangeListener) this);
        form.currentOccupantCombo.addValueChangeListener((ValueChangeListener) this);
        form.departmentCombo.addValueChangeListener((ValueChangeListener) this);
        form.facilityCombo.addValueChangeListener((ValueChangeListener) this);
        form.jobCombo.addValueChangeListener((ValueChangeListener) this);
        form.positionStatusCombo.addValueChangeListener((ValueChangeListener) this);
        form.positionTypeCombo.addValueChangeListener((ValueChangeListener) this);
        form.supervisorCombo.addValueChangeListener((ValueChangeListener) this);
        form.subodinateList.addValueChangeListener((ValueChangeListener) this);
    }
}
