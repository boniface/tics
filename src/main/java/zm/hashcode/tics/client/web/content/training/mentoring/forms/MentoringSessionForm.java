/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.mentoring.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import java.util.List;
import zm.hashcode.tics.app.facade.offices.FacilityFacade;
import zm.hashcode.tics.app.facade.training.institutions.TrainingInstitutionFacade;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringCompetenciesFacade;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringFundersFacade;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringObjectiveFacade;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringSessionTypeFacade;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringSubjectAreaFacade;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringThemeFacade;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringToolsMethodsFacade;
import zm.hashcode.tics.app.facade.training.mentoring.MentorsFacade;
import zm.hashcode.tics.app.facade.training.mentoring.SessionAreasOfStrengtheningFacade;
import zm.hashcode.tics.app.facade.ui.util.StatusFacade;
import zm.hashcode.tics.client.web.content.training.mentoring.model.MentoringSessionBean;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.training.institutions.TrainingInstitution;
import zm.hashcode.tics.domain.training.mentoring.MentoringCompetencies;
import zm.hashcode.tics.domain.training.mentoring.MentoringFunders;
import zm.hashcode.tics.domain.training.mentoring.MentoringObjective;
import zm.hashcode.tics.domain.training.mentoring.MentoringSessionType;
import zm.hashcode.tics.domain.training.mentoring.MentoringSubjectArea;
import zm.hashcode.tics.domain.training.mentoring.MentoringTheme;
import zm.hashcode.tics.domain.training.mentoring.MentoringToolsMethods;
import zm.hashcode.tics.domain.training.mentoring.Mentors;
import zm.hashcode.tics.domain.training.mentoring.SessionAreasOfStrengthening;
import zm.hashcode.tics.domain.ui.util.Status;

/**
 *
 * @author geek
 */
public class MentoringSessionForm extends FormLayout {

    private final MentoringSessionBean bean;
    public final BeanItem<MentoringSessionBean> item;
    public final FieldGroup binder;
    //
    public ComboBox institutionNameCombo = new ComboBox();
    public ComboBox sessionStatusCombo = new ComboBox();
    public ComboBox mentoringVenueCombo = new ComboBox();
    public ComboBox mentoringSubjectAreaCombo = new ComboBox();
    //
    public ListSelect mentoringMentorsList = new ListSelect();
    public ListSelect mentoringSessionTypeList = new ListSelect();
    public ListSelect mentoringThemeList = new ListSelect();
    public ListSelect mentoringFundersList = new ListSelect();
    public ListSelect mentoringCompetenciesList = new ListSelect();
    public ListSelect mentoringObjectiveList = new ListSelect();
    public ListSelect sessionAreasOfStrengtheningList = new ListSelect();
    public ListSelect mentoringToolsMethodsList = new ListSelect();
    //
//    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public MentoringSessionForm() {
        bean = new MentoringSessionBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

        //
        final TextField sessionNameTextField = getTextField("Session Name", "sessionName");
        final PopupDateField startDatePopupDateField = getPopupDateField("Start Date", "startDate");
        final PopupDateField endDatePopupDateField = getPopupDateField("End Date", "endDate");
        //
        final ComboBox institutionNameComboBox = getInstitutionNameComboBox("Institution Name", "institutionNameId");
        final ComboBox sessionStatusComboBox = getSessionStatusComboBox("Session Status", "sessionStatusId");
        final ComboBox mentoringSubjectAreaComboBox = getMentoringSubjectAreaComboBox("Mentoring Subject Area", "mentoringSubjectAreaId");
        final ComboBox mentoringVenueComboBox = getMentoringVenueComboBox("Mentoring Venue", "mentoringVenueId");

        //
        final TextArea mentoringNotesField = getMentoringNotesTextArea("Mentoring Notes", "mentoringNotes");
        //
        final ListSelect mentoringMentorsListSelect = getMentoringMentorsListSelect("Mentoring Mentors", "mentoringMentorsIds");
        final ListSelect mentoringSessionTypeListSelect = getMentoringSessionTypeListSelect("Mentoring Session Type", "mentoringSessionTypesIds");
        final ListSelect mentoringThemesListSelect = getMentoringThemesListSelect("Mentoring Themes", "mentoringThemesIds");
        final ListSelect mentoringFundersListSelect = getMentoringFundersListSelect("Mentoring Funders", "mentoringFundersIds");
        final ListSelect mentoringCompetenciesListSelect = getMentoringCompetenciesListSelect("Mentoring Competencies", "mentoringCompetenciesIds");
        final ListSelect mentoringObjectiveListSelect = getMentoringObjectiveListSelect("Mentoring Objectives", "mentoringObjectivesIds");
        final ListSelect sessionAreasOfStrengtheningListSelect = getSessionAreasOfStrengtheningListSelect("Session Areas Of Strengthening", "sessionAreasOfStrengtheningIds");
        final ListSelect mentoringToolsMethodsListSelect = getMentoringToolsMethodsListSelect("Mentoring Tools Methods", "mentoringToolsMethodsIds");
        //
        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(sessionNameTextField, 0, 0);
        grid.addComponent(startDatePopupDateField, 1, 0);
        grid.addComponent(endDatePopupDateField, 2, 0);
        grid.addComponent(institutionNameComboBox, 3, 0);
        grid.addComponent(sessionStatusComboBox, 0, 1);
        grid.addComponent(mentoringSubjectAreaComboBox, 1, 1);
        grid.addComponent(mentoringVenueComboBox, 2, 1);
        grid.addComponent(mentoringNotesField, 3, 1);
        grid.addComponent(mentoringMentorsListSelect, 0, 2);
        grid.addComponent(mentoringSessionTypeListSelect, 1, 2);
        grid.addComponent(mentoringThemesListSelect, 2, 2);
        grid.addComponent(mentoringFundersListSelect, 3, 2);
        grid.addComponent(mentoringCompetenciesListSelect, 0, 3);
        grid.addComponent(mentoringObjectiveListSelect, 1, 3);
        grid.addComponent(sessionAreasOfStrengtheningListSelect, 2, 3);
        grid.addComponent(mentoringToolsMethodsListSelect, 3, 3);

        grid.addComponent(buttons, 0, 6, 2, 6);

        addComponent(grid);
    }

    private TextArea getMentoringNotesTextArea(String label, String field) {
        TextArea textArea = new TextArea(label);
        textArea.setWidth(250, Unit.PIXELS);
        textArea.setHeight(50, Unit.PIXELS);
        textArea.setNullRepresentation("");
        textArea.addValidator(new BeanValidator(MentoringSessionBean.class, field));
        textArea.setImmediate(true);
        binder.bind(textArea, field);
        return textArea;
    }

    private PopupDateField getPopupDateField(String label, String field) {
        PopupDateField popupDateField = new PopupDateField(label);
        popupDateField.setWidth(250, Unit.PIXELS);
        popupDateField.addValidator(new BeanValidator(MentoringSessionBean.class, field));
        popupDateField.setImmediate(true);
        binder.bind(popupDateField, field);
        return popupDateField;
    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(MentoringSessionBean.class, field));
        textField.setImmediate(true);
        binder.bind(textField, field);
        return textField;
    }

    private ComboBox getInstitutionNameComboBox(String label, String field) {
        institutionNameCombo.setCaption(label);
        List<TrainingInstitution> trainingInstitutions = TrainingInstitutionFacade.getTrainingInstitutionService().findAll();
//        Collection<TrainingInstitution> institutionCourses = Collections2.filter(trainingInstitutions, new TrainingInstitutionPredicate());

        for (TrainingInstitution trainingInstitution : trainingInstitutions) {
            institutionNameCombo.addItem(trainingInstitution.getId());
            institutionNameCombo.setItemCaption(trainingInstitution.getId(), trainingInstitution.getName());
        }
        institutionNameCombo.addValidator(new BeanValidator(MentoringSessionBean.class, field));
        institutionNameCombo.setImmediate(true);
        institutionNameCombo.setWidth(250, Unit.PIXELS);
        binder.bind(institutionNameCombo, field);
        return institutionNameCombo;
    }

    private ComboBox getSessionStatusComboBox(String label, String field) {
        sessionStatusCombo.setCaption(label);
        List<Status> statuses = StatusFacade.getStatusService().findAll();
//        Collection<Location> cities = Collections2.filter(locations, new CityPredicate());
        for (Status status : statuses) {
            sessionStatusCombo.addItem(status.getId());
            sessionStatusCombo.setItemCaption(status.getId(), status.getStatusType() + " - " + status.getStatusValue());
        }
        sessionStatusCombo.addValidator(new BeanValidator(MentoringSessionBean.class, field));
        sessionStatusCombo.setImmediate(true);
        sessionStatusCombo.setWidth(250, Unit.PIXELS);
        binder.bind(sessionStatusCombo, field);
        return sessionStatusCombo;
    }

    private ComboBox getMentoringVenueComboBox(String label, String field) {
        mentoringVenueCombo.setCaption(label);
        List<Facility> facilities = FacilityFacade.getFacilityService().findAll();
//        Collection<Location> cities = Collections2.filter(locations, new CityPredicate());
        for (Facility facility : facilities) {
            mentoringVenueCombo.addItem(facility.getId());
            mentoringVenueCombo.setItemCaption(facility.getId(), facility.getFacilityName());
        }
        mentoringVenueCombo.addValidator(new BeanValidator(MentoringSessionBean.class, field));
        mentoringVenueCombo.setImmediate(true);
        mentoringVenueCombo.setWidth(250, Unit.PIXELS);
        binder.bind(mentoringVenueCombo, field);
        return mentoringVenueCombo;
    }

    private ComboBox getMentoringSubjectAreaComboBox(String label, String field) {
        mentoringSubjectAreaCombo.setCaption(label);
        List<MentoringSubjectArea> mentoringSubjectAreas = MentoringSubjectAreaFacade.getMentoringSubjectAreaService().findAll();
//        Collection<Location> cities = Collections2.filter(locations, new CityPredicate());
        for (MentoringSubjectArea mentoringSubjectArea : mentoringSubjectAreas) {
            mentoringSubjectAreaCombo.addItem(mentoringSubjectArea.getId());
            mentoringSubjectAreaCombo.setItemCaption(mentoringSubjectArea.getId(), mentoringSubjectArea.getSubjectArea());
        }
        mentoringSubjectAreaCombo.addValidator(new BeanValidator(MentoringSessionBean.class, field));
        mentoringSubjectAreaCombo.setImmediate(true);
        mentoringSubjectAreaCombo.setWidth(250, Unit.PIXELS);
        binder.bind(mentoringSubjectAreaCombo, field);
        return mentoringSubjectAreaCombo;
    }

    private ListSelect getMentoringMentorsListSelect(String label, String field) {
        mentoringMentorsList.setCaption(label);
        List<Mentors> mentors = MentorsFacade.getMentorsService().findAll();
        for (Mentors mentor : mentors) {
            mentoringMentorsList.setItemCaption(mentor.getId(), mentor.getFirstName() + " " + mentor.getLastName());
            mentoringMentorsList.setNullSelectionAllowed(false);
            mentoringMentorsList.setMultiSelect(true);
            mentoringMentorsList.addItem(mentor.getId());
        }
        mentoringMentorsList.setWidth("250px");
        binder.bind(mentoringMentorsList, field);

        return mentoringMentorsList;
    }

    private ListSelect getMentoringSessionTypeListSelect(String label, String field) {
        mentoringSessionTypeList.setCaption(label);
        List<MentoringSessionType> mentoringSessionTypes = MentoringSessionTypeFacade.getMentoringSessionTypeService().findAll();
        for (MentoringSessionType mentoringSessionType : mentoringSessionTypes) {
            mentoringSessionTypeList.setItemCaption(mentoringSessionType.getId(), mentoringSessionType.getMentoringSessionType());
            mentoringSessionTypeList.setNullSelectionAllowed(false);
            mentoringSessionTypeList.setMultiSelect(true);
            mentoringSessionTypeList.addItem(mentoringSessionType.getId());
        }
        mentoringSessionTypeList.setWidth("250px");
        binder.bind(mentoringSessionTypeList, field);

        return mentoringSessionTypeList;
    }

    private ListSelect getMentoringThemesListSelect(String label, String field) {
        mentoringThemeList.setCaption(label);
        List<MentoringTheme> mentoringThemes = MentoringThemeFacade.getMentoringThemeService().findAll();
        for (MentoringTheme mentoringTheme : mentoringThemes) {
            mentoringThemeList.setItemCaption(mentoringTheme.getId(), mentoringTheme.getMentoringTheme() + " - " + mentoringTheme.getMentoringField());
            mentoringThemeList.setNullSelectionAllowed(false);
            mentoringThemeList.setMultiSelect(true);
            mentoringThemeList.addItem(mentoringTheme.getId());
        }
        mentoringThemeList.setWidth("250px");
        binder.bind(mentoringThemeList, field);

        return mentoringThemeList;
    }

    private ListSelect getMentoringFundersListSelect(String label, String field) {
        mentoringFundersList.setCaption(label);
        List<MentoringFunders> mentoringFunders = MentoringFundersFacade.getMentoringFundersService().findAll();
        for (MentoringFunders mentoringFunder : mentoringFunders) {
            mentoringFundersList.setItemCaption(mentoringFunder.getId(), mentoringFunder.getFundersName());
            mentoringFundersList.setNullSelectionAllowed(false);
            mentoringFundersList.setMultiSelect(true);
            mentoringFundersList.addItem(mentoringFunder.getId());
        }
        mentoringFundersList.setWidth("250px");
        binder.bind(mentoringFundersList, field);

        return mentoringFundersList;
    }

    private ListSelect getMentoringCompetenciesListSelect(String label, String field) {
        mentoringCompetenciesList.setCaption(label);
        List<MentoringCompetencies> mentoringCompetencies = MentoringCompetenciesFacade.getMentoringCompetenciesService().findAll();
        for (MentoringCompetencies mentoringCompetency : mentoringCompetencies) {
            mentoringCompetenciesList.setItemCaption(mentoringCompetency.getId(), mentoringCompetency.getCompetencyName());
            mentoringCompetenciesList.setNullSelectionAllowed(false);
            mentoringCompetenciesList.setMultiSelect(true);
            mentoringCompetenciesList.addItem(mentoringCompetency.getId());
        }
        mentoringCompetenciesList.setWidth("250px");
        binder.bind(mentoringCompetenciesList, field);

        return mentoringCompetenciesList;
    }

    private ListSelect getMentoringObjectiveListSelect(String label, String field) {
        mentoringObjectiveList.setCaption(label);
        List<MentoringObjective> mentoringObjectives = MentoringObjectiveFacade.getMentoringObjectiveService().findAll();
        for (MentoringObjective mentoringObjective : mentoringObjectives) {
            mentoringObjectiveList.setItemCaption(mentoringObjective.getId(), mentoringObjective.getMentoringObjective());
            mentoringObjectiveList.setNullSelectionAllowed(false);
            mentoringObjectiveList.setMultiSelect(true);
            mentoringObjectiveList.addItem(mentoringObjective.getId());
        }
        mentoringObjectiveList.setWidth("250px");
        binder.bind(mentoringObjectiveList, field);

        return mentoringObjectiveList;
    }

    private ListSelect getSessionAreasOfStrengtheningListSelect(String label, String field) {
        sessionAreasOfStrengtheningList.setCaption(label);
        List<SessionAreasOfStrengthening> sessionAreasOfStrengthenings = SessionAreasOfStrengtheningFacade.getSessionAreasOfStrengtheningService().findAll();
        for (SessionAreasOfStrengthening sessionAreasOfStrengthening : sessionAreasOfStrengthenings) {
            sessionAreasOfStrengtheningList.setItemCaption(sessionAreasOfStrengthening.getId(), sessionAreasOfStrengthening.getAreasOfStrengthening());
            sessionAreasOfStrengtheningList.setNullSelectionAllowed(false);
            sessionAreasOfStrengtheningList.setMultiSelect(true);
            sessionAreasOfStrengtheningList.addItem(sessionAreasOfStrengthening.getId());
        }
        sessionAreasOfStrengtheningList.setWidth("250px");
        binder.bind(sessionAreasOfStrengtheningList, field);

        return sessionAreasOfStrengtheningList;
    }

    private ListSelect getMentoringToolsMethodsListSelect(String label, String field) {
        mentoringToolsMethodsList.setCaption(label);
        List<MentoringToolsMethods> mentoringToolsMethods = MentoringToolsMethodsFacade.getMentoringToolsMethodsService().findAll();
        for (MentoringToolsMethods mentoringToolsMethod : mentoringToolsMethods) {
            mentoringToolsMethodsList.setItemCaption(mentoringToolsMethod.getId(), mentoringToolsMethod.getToolsMethod());
            mentoringToolsMethodsList.setNullSelectionAllowed(false);
            mentoringToolsMethodsList.setMultiSelect(true);
            mentoringToolsMethodsList.addItem(mentoringToolsMethod.getId());
        }
        mentoringToolsMethodsList.setWidth("250px");
        binder.bind(mentoringToolsMethodsList, field);

        return mentoringToolsMethodsList;
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
