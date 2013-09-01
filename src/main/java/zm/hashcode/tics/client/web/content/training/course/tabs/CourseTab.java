/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.course.tabs;

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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import zm.hashcode.tics.app.facade.training.competencies.CompetencyFacade;
import zm.hashcode.tics.app.facade.training.course.CategoryFacade;
import zm.hashcode.tics.app.facade.training.course.CourseFacade;
import zm.hashcode.tics.app.facade.training.course.CourseTypeFacade;
import zm.hashcode.tics.app.facade.training.course.CriteriaFacade;
import zm.hashcode.tics.app.facade.training.course.TargetGroupFacade;
import zm.hashcode.tics.app.facade.training.institutions.TrainingInstitutionFacade;
import zm.hashcode.tics.app.facade.ui.util.StatusFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.training.course.CourseMenu;
import zm.hashcode.tics.client.web.content.training.institutions.InstitutionMenu;
import zm.hashcode.tics.client.web.content.training.course.forms.CourseForm;
import zm.hashcode.tics.client.web.content.training.course.model.CourseBean;
import zm.hashcode.tics.client.web.content.training.course.tables.CourseTable;
import zm.hashcode.tics.client.web.content.training.course.util.CourseUtil;
import zm.hashcode.tics.domain.training.competencies.Competency;
import zm.hashcode.tics.domain.training.course.Category;
import zm.hashcode.tics.domain.training.course.Course;
import zm.hashcode.tics.domain.training.course.CourseType;
import zm.hashcode.tics.domain.training.course.Criteria;
import zm.hashcode.tics.domain.training.course.TargetGroup;
import zm.hashcode.tics.domain.training.institutions.TrainingInstitution;
import zm.hashcode.tics.domain.ui.util.Status;

/**
 *
 * @author geek
 */
public class CourseTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final CourseForm form;
    private final CourseTable table;
    //
    private Collection<String> courseCompetenciesIds = new HashSet<>(); // for ListSelect
    private Collection<String> courseTargetGroupIds = new HashSet<>(); // for ListSelect
    //
    private String courseCategoryId; // for and ENTITY
    private String institutionNameId; // for and ENTITY
    private String courseStatusId; // for and ENTITY
    private String courseTypeId; // for and ENTITY
    private String courseCriteriaId; // for and ENTITY

    public CourseTab(TicsMain app) {
        main = app;
        form = new CourseForm();
        table = new CourseTable(main);
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
            final Course course = CourseFacade.getCourseService().find(table.getValue().toString());
            final CourseBean bean = new CourseUtil().getBean(course);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        } else if (property == form.courseCategoryCombo) {
            courseCategoryId = property.getValue().toString();
        } else if (property == form.courseCriteriaCombo) {
            courseCriteriaId = property.getValue().toString();
        } else if (property == form.courseStatusCombo) {
            courseStatusId = property.getValue().toString();
        } else if (property == form.courseTypeCombo) {
            courseTypeId = property.getValue().toString();
        } else if (property == form.trainingInstitutionCombo) {
            institutionNameId = property.getValue().toString();
        } else if (property == form.courseCompetenciesList) {
            courseCompetenciesIds = (Collection<String>) property.getValue();
        } else if (property == form.courseTargetGroupList) {
            courseTargetGroupIds = (Collection<String>) property.getValue();
        }

    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            CourseFacade.getCourseService().persist(getNewEntity(binder));
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
            CourseFacade.getCourseService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        CourseFacade.getCourseService().remove(getUpdateEntity(binder));
        getHome();
    }

    private Course getNewEntity(FieldGroup binder) {
        final CourseBean bean = ((BeanItem<CourseBean>) binder.getItemDataSource()).getBean();
//
        List<Competency> competencies = new ArrayList<>();
        for (String id : courseCompetenciesIds) {
            Competency compentency = CompetencyFacade.getCompetencyService().find(id);
            competencies.add(compentency);
        }
        //
        List<TargetGroup> targetGroups = new ArrayList<>();
        for (String id : courseTargetGroupIds) {
            TargetGroup targetGroup = TargetGroupFacade.getTargetGroupService().find(id);
            targetGroups.add(targetGroup);
        }
        //
        Category category = CategoryFacade.getCategoryService().find(courseCategoryId);
        TrainingInstitution trainingInstitution = TrainingInstitutionFacade.getTrainingInstitutionService().find(institutionNameId);
        Status status = StatusFacade.getStatusService().find(courseStatusId);
        Criteria criteria = CriteriaFacade.getCriteriaService().find(courseCriteriaId);
        CourseType courseType = CourseTypeFacade.getCourseTypeService().find(courseTypeId);

        final Course course = new Course.Builder(bean.getName())
                .courseCategory(category)
                .courseCompetencies(competencies)
                .courseCriteria(criteria)
                .courseObjective(bean.getCourseObjective())
                .courseStatus(status)
                .courseTargetGroup(targetGroups)
                .courseTopic(bean.getCourseTopic())
                .courseType(courseType)
                .institutionName(trainingInstitution)
                .notes(bean.getNotes())
                .build();
        return course;
    }

    private Course getUpdateEntity(FieldGroup binder) {
        final CourseBean bean = ((BeanItem<CourseBean>) binder.getItemDataSource()).getBean();
//
        List<Competency> competencies = new ArrayList<>();
        for (String id : courseCompetenciesIds) {
            Competency compentency = CompetencyFacade.getCompetencyService().find(id);
            competencies.add(compentency);
        }
        //
        List<TargetGroup> targetGroups = new ArrayList<>();
        for (String id : courseTargetGroupIds) {
            TargetGroup targetGroup = TargetGroupFacade.getTargetGroupService().find(id);
            targetGroups.add(targetGroup);
        }
        //
        Category category = CategoryFacade.getCategoryService().find(courseCategoryId);
        TrainingInstitution trainingInstitution = TrainingInstitutionFacade.getTrainingInstitutionService().find(institutionNameId);
        Status status = StatusFacade.getStatusService().find(courseStatusId);
        Criteria criteria = CriteriaFacade.getCriteriaService().find(courseCriteriaId);
        CourseType courseType = CourseTypeFacade.getCourseTypeService().find(courseTypeId);

        final Course course = new Course.Builder(bean.getName())
                .courseCategory(category)
                .courseCompetencies(competencies)
                .courseCriteria(criteria)
                .courseObjective(bean.getCourseObjective())
                .courseStatus(status)
                .courseTargetGroup(targetGroups)
                .courseTopic(bean.getCourseTopic())
                .courseType(courseType)
                .institutionName(trainingInstitution)
                .notes(bean.getNotes())
                .id(bean.getId())
                .build();
        return course;
    }

    private void getHome() {
        main.content.setSecondComponent(new CourseMenu(main, "COURSES"));
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
        form.courseCategoryCombo.addValueChangeListener((ValueChangeListener) this);
        form.courseCompetenciesList.addValueChangeListener((ValueChangeListener) this);
        form.courseCriteriaCombo.addValueChangeListener((ValueChangeListener) this);
        form.courseStatusCombo.addValueChangeListener((ValueChangeListener) this);
        form.courseTargetGroupList.addValueChangeListener((ValueChangeListener) this);
        form.courseTypeCombo.addValueChangeListener((ValueChangeListener) this);
        form.trainingInstitutionCombo.addValueChangeListener((ValueChangeListener) this);
    }
}
