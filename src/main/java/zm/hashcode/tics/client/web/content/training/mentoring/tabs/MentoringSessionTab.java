/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.mentoring.tabs;

import zm.hashcode.tics.client.web.content.system.mentoring.tabs.*;
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
import java.util.Set;
import zm.hashcode.tics.app.facade.offices.FacilityFacade;
import zm.hashcode.tics.app.facade.training.institutions.TrainingInstitutionFacade;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringCompetenciesFacade;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringFundersFacade;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringObjectiveFacade;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringSessionFacade;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringSessionTypeFacade;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringSubjectAreaFacade;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringThemeFacade;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringToolsMethodsFacade;
import zm.hashcode.tics.app.facade.training.mentoring.MentorsFacade;
import zm.hashcode.tics.app.facade.training.mentoring.SessionAreasOfStrengtheningFacade;
import zm.hashcode.tics.app.facade.ui.util.StatusFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.training.mentoring.MentoringMenu;
import zm.hashcode.tics.client.web.content.training.mentoring.forms.MentoringSessionForm;
import zm.hashcode.tics.client.web.content.training.mentoring.model.MentoringSessionBean;
import zm.hashcode.tics.client.web.content.training.mentoring.tables.MentoringSessionTable;
import zm.hashcode.tics.client.web.content.training.mentoring.util.MentoringSessionUtil;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.training.institutions.TrainingInstitution;
import zm.hashcode.tics.domain.training.mentoring.MentoringCompetencies;
import zm.hashcode.tics.domain.training.mentoring.MentoringFunders;
import zm.hashcode.tics.domain.training.mentoring.MentoringObjective;
import zm.hashcode.tics.domain.training.mentoring.MentoringSession;
import zm.hashcode.tics.domain.training.mentoring.MentoringSessionType;
import zm.hashcode.tics.domain.training.mentoring.MentoringSubjectArea;
import zm.hashcode.tics.domain.training.mentoring.MentoringTheme;
import zm.hashcode.tics.domain.training.mentoring.MentoringToolsMethods;
import zm.hashcode.tics.domain.training.mentoring.Mentors;
import zm.hashcode.tics.domain.training.mentoring.SessionAreasOfStrengthening;
import zm.hashcode.tics.domain.ui.util.Status;

/**
 *
 * @author Ferox
 */
public final class MentoringSessionTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final MentoringSessionForm form;
    private final MentoringSessionTable table;
    //
    private Collection<String> mentoringMentorsIds = new HashSet<>(); // for ListSelect
    private Collection<String> mentoringSessionTypesIds = new HashSet<>(); // for ListSelect
    private Collection<String> mentoringThemesIds = new HashSet<>(); // for ListSelect
    private Collection<String> mentoringFundersIds = new HashSet<>(); // for ListSelect
    private Collection<String> mentoringCompetenciesIds = new HashSet<>(); // for ListSelect
    private Collection<String> mentoringObjectivesIds = new HashSet<>(); // for ListSelect
    private Collection<String> sessionAreasOfStrengtheningIds = new HashSet<>(); // for ListSelect
    private Collection<String> mentoringToolsMethodsIds = new HashSet<>(); // for ListSelect
    //
    private String institutionNameId; // for and ENTITY
    private String sessionStatusId; // for and ENTITY
    private String mentoringSubjectAreaId; // for and ENTITY
    private String mentoringVenueId; // for and ENTITY

    public MentoringSessionTab(TicsMain app) {
        main = app;
        form = new MentoringSessionForm();
        table = new MentoringSessionTable(main);
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
            final MentoringSession mentoringSession = MentoringSessionFacade.getMentoringSessionService().find(table.getValue().toString());
            final MentoringSessionBean bean = new MentoringSessionUtil().getBean(mentoringSession);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        } else if (property == form.institutionNameCombo) {
            institutionNameId = property.getValue().toString();
        } else if (property == form.mentoringSubjectAreaCombo) {
            mentoringSubjectAreaId = property.getValue().toString();
        } else if (property == form.mentoringVenueCombo) {
            mentoringVenueId = property.getValue().toString();
        } else if (property == form.sessionStatusCombo) {
            sessionStatusId = property.getValue().toString();
        } else if (property == form.mentoringMentorsList) {
            mentoringMentorsIds = (Collection<String>) property.getValue();
        } else if (property == form.mentoringSessionTypeList) {
            mentoringSessionTypesIds = (Collection<String>) property.getValue();
        } else if (property == form.mentoringThemeList) {
            mentoringThemesIds = (Collection<String>) property.getValue();
        } else if (property == form.mentoringFundersList) {
            mentoringFundersIds = (Collection<String>) property.getValue();
        } else if (property == form.mentoringCompetenciesList) {
            mentoringCompetenciesIds = (Collection<String>) property.getValue();
        } else if (property == form.mentoringObjectiveList) {
            mentoringObjectivesIds = (Collection<String>) property.getValue();
        } else if (property == form.sessionAreasOfStrengtheningList) {
            sessionAreasOfStrengtheningIds = (Collection<String>) property.getValue();
        } else if (property == form.mentoringToolsMethodsList) {
            mentoringToolsMethodsIds = (Collection<String>) property.getValue();
        }

    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            MentoringSessionFacade.getMentoringSessionService().persist(getNewEntity(binder));
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
            MentoringSessionFacade.getMentoringSessionService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        MentoringSessionFacade.getMentoringSessionService().remove(getUpdateEntity(binder));
        getHome();
    }

    private MentoringSession getNewEntity(FieldGroup binder) {
        final MentoringSessionBean bean = ((BeanItem<MentoringSessionBean>) binder.getItemDataSource()).getBean();
        //
        TrainingInstitution trainingInstitution = TrainingInstitutionFacade.getTrainingInstitutionService().find(institutionNameId);
        Status status = StatusFacade.getStatusService().find(sessionStatusId);
        MentoringSubjectArea mentoringSubjectArea = MentoringSubjectAreaFacade.getMentoringSubjectAreaService().find(mentoringSubjectAreaId);
        Facility facility = FacilityFacade.getFacilityService().find(mentoringVenueId);
        //
        List<Mentors> mentors = new ArrayList<>();
        for (String id : mentoringMentorsIds) {
            Mentors mentor = MentorsFacade.getMentorsService().find(id);
            mentors.add(mentor);
        }
        //
        List<MentoringSessionType> mentoringSessionTypes = new ArrayList<>();
        for (String id : mentoringSessionTypesIds) {
            MentoringSessionType mentoringSessionType = MentoringSessionTypeFacade.getMentoringSessionTypeService().find(id);
            mentoringSessionTypes.add(mentoringSessionType);
        }
        //
        List<MentoringTheme> mentoringThemes = new ArrayList<>();
        for (String id : mentoringThemesIds) {
            MentoringTheme mentoringTheme = MentoringThemeFacade.getMentoringThemeService().find(id);
            mentoringThemes.add(mentoringTheme);
        }
        //
        List<MentoringFunders> mentoringFunders = new ArrayList<>();
        for (String id : mentoringFundersIds) {
            MentoringFunders mentoringFunder = MentoringFundersFacade.getMentoringFundersService().find(id);
            mentoringFunders.add(mentoringFunder);
        }
        //
        List<MentoringCompetencies> mentoringCompetencies = new ArrayList<>();
        for (String id : mentoringCompetenciesIds) {
            MentoringCompetencies mentoringCompetency = MentoringCompetenciesFacade.getMentoringCompetenciesService().find(id);
            mentoringCompetencies.add(mentoringCompetency);
        }
        //
        List<MentoringObjective> mentoringObjectives = new ArrayList<>();
        for (String id : mentoringObjectivesIds) {
            MentoringObjective mentoringObjective = MentoringObjectiveFacade.getMentoringObjectiveService().find(id);
            mentoringObjectives.add(mentoringObjective);
        }
        //
        List<SessionAreasOfStrengthening> sessionAreasOfStrengthenings = new ArrayList<>();
        for (String id : sessionAreasOfStrengtheningIds) {
            SessionAreasOfStrengthening sessionAreasOfStrengthening = SessionAreasOfStrengtheningFacade.getSessionAreasOfStrengtheningService().find(id);
            sessionAreasOfStrengthenings.add(sessionAreasOfStrengthening);
        }
        //
        List<MentoringToolsMethods> mentoringToolsMethods = new ArrayList<>();
        for (String id : mentoringToolsMethodsIds) {
            MentoringToolsMethods mentoringToolsMethod = MentoringToolsMethodsFacade.getMentoringToolsMethodsService().find(id);
            mentoringToolsMethods.add(mentoringToolsMethod);
        }

        final MentoringSession mentoringSession = new MentoringSession.Builder(bean.getSessionName())
                .startDate(bean.getStartDate())
                .endDate(bean.getEndDate())
                .mentoringNotes(bean.getMentoringNotes())
                .mentoringMentors(mentors)
                .mentoringSessionType(mentoringSessionTypes)
                .mentoringTheme(mentoringThemes)
                .institutionName(trainingInstitution)
                .sessionStatus(status)
                .mentoringFunders(mentoringFunders)
                .mentoringCompetencies(mentoringCompetencies)
                .mentoringVenue(facility)
                .mentoringObjective(mentoringObjectives)
                .mentoringSubjectArea(mentoringSubjectArea)
                .sessionAreasOfStrengthening(sessionAreasOfStrengthenings)
                .mentoringToolsMethods(mentoringToolsMethods)
                .build();
        return mentoringSession;
    }

    private MentoringSession getUpdateEntity(FieldGroup binder) {
        final MentoringSessionBean bean = ((BeanItem<MentoringSessionBean>) binder.getItemDataSource()).getBean();
        //
        TrainingInstitution trainingInstitution = TrainingInstitutionFacade.getTrainingInstitutionService().find(institutionNameId);
        Status status = StatusFacade.getStatusService().find(sessionStatusId);
        MentoringSubjectArea mentoringSubjectArea = MentoringSubjectAreaFacade.getMentoringSubjectAreaService().find(mentoringSubjectAreaId);
        Facility facility = FacilityFacade.getFacilityService().find(mentoringVenueId);
        //
        List<Mentors> mentors = new ArrayList<>();
        for (String id : mentoringMentorsIds) {
            Mentors mentor = MentorsFacade.getMentorsService().find(id);
            mentors.add(mentor);
        }
        //
        List<MentoringSessionType> mentoringSessionTypes = new ArrayList<>();
        for (String id : mentoringSessionTypesIds) {
            MentoringSessionType mentoringSessionType = MentoringSessionTypeFacade.getMentoringSessionTypeService().find(id);
            mentoringSessionTypes.add(mentoringSessionType);
        }
        //
        List<MentoringTheme> mentoringThemes = new ArrayList<>();
        for (String id : mentoringThemesIds) {
            MentoringTheme mentoringTheme = MentoringThemeFacade.getMentoringThemeService().find(id);
            mentoringThemes.add(mentoringTheme);
        }
        //
        List<MentoringFunders> mentoringFunders = new ArrayList<>();
        for (String id : mentoringFundersIds) {
            MentoringFunders mentoringFunder = MentoringFundersFacade.getMentoringFundersService().find(id);
            mentoringFunders.add(mentoringFunder);
        }
        //
        List<MentoringCompetencies> mentoringCompetencies = new ArrayList<>();
        for (String id : mentoringCompetenciesIds) {
            MentoringCompetencies mentoringCompetency = MentoringCompetenciesFacade.getMentoringCompetenciesService().find(id);
            mentoringCompetencies.add(mentoringCompetency);
        }
        //
        List<MentoringObjective> mentoringObjectives = new ArrayList<>();
        for (String id : mentoringObjectivesIds) {
            MentoringObjective mentoringObjective = MentoringObjectiveFacade.getMentoringObjectiveService().find(id);
            mentoringObjectives.add(mentoringObjective);
        }
        //
        List<SessionAreasOfStrengthening> sessionAreasOfStrengthenings = new ArrayList<>();
        for (String id : sessionAreasOfStrengtheningIds) {
            SessionAreasOfStrengthening sessionAreasOfStrengthening = SessionAreasOfStrengtheningFacade.getSessionAreasOfStrengtheningService().find(id);
            sessionAreasOfStrengthenings.add(sessionAreasOfStrengthening);
        }
        //
        List<MentoringToolsMethods> mentoringToolsMethods = new ArrayList<>();
        for (String id : mentoringToolsMethodsIds) {
            MentoringToolsMethods mentoringToolsMethod = MentoringToolsMethodsFacade.getMentoringToolsMethodsService().find(id);
            mentoringToolsMethods.add(mentoringToolsMethod);
        }

        final MentoringSession mentoringSession = new MentoringSession.Builder(bean.getSessionName())
                .startDate(bean.getStartDate())
                .endDate(bean.getEndDate())
                .mentoringNotes(bean.getMentoringNotes())
                .mentoringMentors(mentors)
                .mentoringSessionType(mentoringSessionTypes)
                .mentoringTheme(mentoringThemes)
                .institutionName(trainingInstitution)
                .sessionStatus(status)
                .mentoringFunders(mentoringFunders)
                .mentoringCompetencies(mentoringCompetencies)
                .mentoringVenue(facility)
                .mentoringObjective(mentoringObjectives)
                .mentoringSubjectArea(mentoringSubjectArea)
                .sessionAreasOfStrengthening(sessionAreasOfStrengthenings)
                .mentoringToolsMethods(mentoringToolsMethods)
                .id(bean.getId())
                .build();
        return mentoringSession;
    }

    private void getHome() {
        main.content.setSecondComponent(new MentoringMenu(main, "LANDING"));
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
        //
        form.institutionNameCombo.addValueChangeListener((ValueChangeListener) this);
        form.mentoringSubjectAreaCombo.addValueChangeListener((ValueChangeListener) this);
        form.mentoringVenueCombo.addValueChangeListener((ValueChangeListener) this);
        form.sessionStatusCombo.addValueChangeListener((ValueChangeListener) this);
        //
        form.mentoringCompetenciesList.addValueChangeListener((ValueChangeListener) this);
        form.mentoringFundersList.addValueChangeListener((ValueChangeListener) this);
        form.mentoringMentorsList.addValueChangeListener((ValueChangeListener) this);
        form.mentoringObjectiveList.addValueChangeListener((ValueChangeListener) this);
        form.mentoringSessionTypeList.addValueChangeListener((ValueChangeListener) this);
        form.mentoringThemeList.addValueChangeListener((ValueChangeListener) this);
        form.mentoringToolsMethodsList.addValueChangeListener((ValueChangeListener) this);
        form.sessionAreasOfStrengtheningList.addValueChangeListener((ValueChangeListener) this);
    }
}
