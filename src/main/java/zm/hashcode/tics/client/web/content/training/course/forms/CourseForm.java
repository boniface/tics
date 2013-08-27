/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.course.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import java.util.List;
import zm.hashcode.tics.app.facade.training.competencies.CompetencyFacade;
import zm.hashcode.tics.app.facade.training.course.CategoryFacade;
import zm.hashcode.tics.app.facade.training.course.CourseTypeFacade;
import zm.hashcode.tics.app.facade.training.course.CriteriaFacade;
import zm.hashcode.tics.app.facade.training.course.TargetGroupFacade;
import zm.hashcode.tics.app.facade.training.institutions.TrainingInstitutionFacade;
import zm.hashcode.tics.app.facade.ui.util.StatusFacade;
import zm.hashcode.tics.client.web.content.training.course.model.CourseBean;
import zm.hashcode.tics.domain.training.competencies.Competency;
import zm.hashcode.tics.domain.training.course.Category;
import zm.hashcode.tics.domain.training.course.CourseType;
import zm.hashcode.tics.domain.training.course.Criteria;
import zm.hashcode.tics.domain.training.course.TargetGroup;
import zm.hashcode.tics.domain.training.institutions.TrainingInstitution;
import zm.hashcode.tics.domain.ui.util.Status;

/**
 *
 * @author geek
 */
public class CourseForm extends FormLayout {

    private final CourseBean bean;
    public final BeanItem<CourseBean> item;
    public final FieldGroup binder;
    //
    public ComboBox courseCategoryCombo = new ComboBox();
    public ComboBox trainingInstitutionCombo = new ComboBox();
    public ComboBox courseStatusCombo = new ComboBox();
    public ComboBox courseTypeCombo = new ComboBox();
    public ListSelect courseCompetenciesList = new ListSelect();
    public ListSelect courseTargetGroupList = new ListSelect();
    public ComboBox courseCriteriaCombo = new ComboBox();
    //
//    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
//

    public CourseForm() {
        bean = new CourseBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

        final TextField name = getTextField("Name", "name");
        final ComboBox courseCategory = getCourseCategoryComboBox("Course Category", "courseCategoryId");
        final TextField courseTopic = getTextField("Course Topic", "courseTopic");
        final ComboBox institutionName = getTrainingInstitutionComboBox("Training Institution", "institutionNameId");
        final ComboBox courseStatus = getCourseStatusComboBox("Course Status", "courseStatusId");
        final TextField courseObjective = getTextField("Course Objective", "courseObjective");
        final ComboBox courseType = getCourseTypeComboBox("Course Type", "courseTypeId");
        final ListSelect courseCompetenciesListSelect = getCourseCompetenciesListSelect("Select Course Competencies", "courseCompetenciesIds");
        final ListSelect courseTargetGroupListSelect = getCourseTargetGroupListSelect("Select Course Target Group", "courseTargetGroupIds");
        final ComboBox courseCriteria = getCourseCriteriaComboBox("Course Criteria", "courseCriteriaId");
        final TextArea notes = getTextArea("Notes", "notes");

        //
        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(name, 0, 0);
        grid.addComponent(courseCategory, 1, 0);
        grid.addComponent(courseTopic, 2, 0);
        grid.addComponent(institutionName, 3, 0);
        grid.addComponent(courseStatus, 0, 1);
        grid.addComponent(courseObjective, 1, 1);
        grid.addComponent(courseType, 2, 1);
        grid.addComponent(courseCriteria, 3, 1);
        grid.addComponent(courseCompetenciesListSelect, 0, 2);
        grid.addComponent(courseTargetGroupListSelect, 1, 2);
        grid.addComponent(notes, 2, 2);


        grid.addComponent(buttons, 0, 3, 2, 3);

        addComponent(grid);
    }

    private TextArea getTextArea(String label, String field) {
        TextArea textArea = new TextArea(label);
        textArea.setWidth(250, Unit.PIXELS);
        textArea.setNullRepresentation("");
        textArea.addValidator(new BeanValidator(CourseBean.class, field));
        textArea.setImmediate(true);
        binder.bind(textArea, field);
        return textArea;
    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(CourseBean.class, field));
        textField.setImmediate(true);
        binder.bind(textField, field);
        return textField;
    }

    private ComboBox getCourseCategoryComboBox(String label, String field) {
        courseCategoryCombo.setCaption(label);
        List<Category> categorys = CategoryFacade.getCategoryService().findAll();
        for (Category iCategory : categorys) {
            courseCategoryCombo.addItem(iCategory.getId());
            courseCategoryCombo.setItemCaption(iCategory.getId(), iCategory.getName());
        }
        courseCategoryCombo.addValidator(new BeanValidator(CourseBean.class, field));
        courseCategoryCombo.setImmediate(true);
        courseCategoryCombo.setWidth(250, Unit.PIXELS);
        binder.bind(courseCategoryCombo, field);
        return courseCategoryCombo;
    }

    private ComboBox getTrainingInstitutionComboBox(String label, String field) {
        trainingInstitutionCombo.setCaption(label);
        List<TrainingInstitution> trainingInstitutions = TrainingInstitutionFacade.getTrainingInstitutionService().findAll();
        for (TrainingInstitution iTrainingInstitution : trainingInstitutions) {
            trainingInstitutionCombo.addItem(iTrainingInstitution.getId());
            trainingInstitutionCombo.setItemCaption(iTrainingInstitution.getId(), iTrainingInstitution.getName());
        }
        trainingInstitutionCombo.addValidator(new BeanValidator(CourseBean.class, field));
        trainingInstitutionCombo.setImmediate(true);
        trainingInstitutionCombo.setWidth(250, Unit.PIXELS);
        binder.bind(trainingInstitutionCombo, field);
        return trainingInstitutionCombo;
    }

    private ComboBox getCourseStatusComboBox(String label, String field) {
        courseStatusCombo.setCaption(label);
        List<Status> statuses = StatusFacade.getStatusService().findAll();
        for (Status iStatus : statuses) {
            courseStatusCombo.addItem(iStatus.getId());
            courseStatusCombo.setItemCaption(iStatus.getId(), iStatus.getStatusType() + " - " + iStatus.getStatusValue());
        }
        courseStatusCombo.addValidator(new BeanValidator(CourseBean.class, field));
        courseStatusCombo.setImmediate(true);
        courseStatusCombo.setWidth(250, Unit.PIXELS);
        binder.bind(courseStatusCombo, field);
        return courseStatusCombo;
    }

    private ComboBox getCourseTypeComboBox(String label, String field) {
        courseTypeCombo.setCaption(label);
        List<CourseType> courseTypes = CourseTypeFacade.getCourseTypeService().findAll();
        for (CourseType iCourseType : courseTypes) {
            courseTypeCombo.addItem(iCourseType.getId());
            courseTypeCombo.setItemCaption(iCourseType.getId(), iCourseType.getName());
        }
        courseTypeCombo.addValidator(new BeanValidator(CourseBean.class, field));
        courseTypeCombo.setImmediate(true);
        courseTypeCombo.setWidth(250, Unit.PIXELS);
        binder.bind(courseTypeCombo, field);
        return courseTypeCombo;
    }

    private ComboBox getCourseCriteriaComboBox(String label, String field) {
        courseCriteriaCombo.setCaption(label);
        List<Criteria> criterias = CriteriaFacade.getCriteriaService().findAll();
        for (Criteria iCriteria : criterias) {
            courseCriteriaCombo.addItem(iCriteria.getId());
            courseCriteriaCombo.setItemCaption(iCriteria.getId(), iCriteria.getName());
        }
        courseCriteriaCombo.addValidator(new BeanValidator(CourseBean.class, field));
        courseCriteriaCombo.setImmediate(true);
        courseCriteriaCombo.setWidth(250, Unit.PIXELS);
        binder.bind(courseCriteriaCombo, field);
        return courseCriteriaCombo;
    }

    private ListSelect getCourseCompetenciesListSelect(String label, String field) {
        courseCompetenciesList.setCaption(label);
        List<Competency> competencys = CompetencyFacade.getCompetencyService().findAll();
        for (Competency iCompetency : competencys) {
            courseCompetenciesList.setItemCaption(iCompetency.getId(), iCompetency.getName());
            courseCompetenciesList.setNullSelectionAllowed(false);
            courseCompetenciesList.setMultiSelect(true);
            courseCompetenciesList.addItem(iCompetency.getId());
        }
        courseCompetenciesList.setWidth("250px");
        binder.bind(courseCompetenciesList, field);

        return courseCompetenciesList;
    }

    private ListSelect getCourseTargetGroupListSelect(String label, String field) {
        courseTargetGroupList.setCaption(label);
        List<TargetGroup> targetGroups = TargetGroupFacade.getTargetGroupService().findAll();
        for (TargetGroup iTargetGroup : targetGroups) {
            courseTargetGroupList.setItemCaption(iTargetGroup.getId(), iTargetGroup.getName());
            courseTargetGroupList.setNullSelectionAllowed(false);
            courseTargetGroupList.setMultiSelect(true);
            courseTargetGroupList.addItem(iTargetGroup.getId());
        }
        courseTargetGroupList.setWidth("250px");
        binder.bind(courseTargetGroupList, field);

        return courseTargetGroupList;
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
