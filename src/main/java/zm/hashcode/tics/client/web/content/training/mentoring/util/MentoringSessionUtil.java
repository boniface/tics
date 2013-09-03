/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.mentoring.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import zm.hashcode.tics.client.web.content.training.mentoring.model.MentoringSessionBean;
import zm.hashcode.tics.domain.training.mentoring.MentoringCompetencies;
import zm.hashcode.tics.domain.training.mentoring.MentoringFunders;
import zm.hashcode.tics.domain.training.mentoring.MentoringObjective;
import zm.hashcode.tics.domain.training.mentoring.MentoringSession;
import zm.hashcode.tics.domain.training.mentoring.MentoringSessionType;
import zm.hashcode.tics.domain.training.mentoring.MentoringTheme;
import zm.hashcode.tics.domain.training.mentoring.MentoringToolsMethods;
import zm.hashcode.tics.domain.training.mentoring.Mentors;
import zm.hashcode.tics.domain.training.mentoring.SessionAreasOfStrengthening;

/**
 *
 * @author geek
 */
public class MentoringSessionUtil {

    public MentoringSessionBean getBean(MentoringSession mentoringSession) {
        MentoringSessionBean bean = new MentoringSessionBean();
        bean.setId(mentoringSession.getId());
        bean.setEndDate(mentoringSession.getEndDate());
        bean.setStartDate(mentoringSession.getStartDate());
        bean.setSessionName(mentoringSession.getSessionName());
        bean.setMentoringNotes(mentoringSession.getMentoringNotes());
        // for Entities
        bean.setInstitutionNameId(mentoringSession.getInstitutionName().getId());
        bean.setMentoringSubjectAreaId(mentoringSession.getMentoringSubjectArea().getId());
        bean.setMentoringVenueId(mentoringSession.getMentoringVenue().getId());
        bean.setSessionStatusId(mentoringSession.getSessionStatus().getId());
        // for List or Set
        bean.setMentoringCompetenciesIds(getMentoringCompetenciesIds(mentoringSession.getMentoringCompetencies()));
        bean.setMentoringFundersIds(getMentoringFundersIds(mentoringSession.getMentoringFunders()));
        bean.setMentoringMentorsIds(getMentoringMentorsIds(mentoringSession.getMentoringMentors()));
        bean.setMentoringObjectivesIds(getMentoringObjectivesIds(mentoringSession.getMentoringObjective()));
        bean.setMentoringSessionTypesIds(getMentoringSessionTypesIds(mentoringSession.getMentoringSessionType()));
        bean.setMentoringThemesIds(getMentoringThemesIds(mentoringSession.getMentoringTheme()));
        bean.setMentoringToolsMethodsIds(getMentoringToolsMethodsIds(mentoringSession.getMentoringToolsMethods()));
        bean.setSessionAreasOfStrengtheningIds(getSessionAreasOfStrengtheningIds(mentoringSession.getSessionAreasOfStrengthening()));
//
//        // FOR EMBEDDABLES
//        bean.setContactNumber(funder.getContact().getContactNumber());
//        bean.setEmailAddress(funder.getContact().getEmailAddress());
//        bean.setPhysicalAddress(funder.getContact().getPostalAddress());
//        bean.setPostalAddress(funder.getContact().getPostalAddress());
//        bean.setPostalCode(funder.getContact().getPostalCode());

        return bean;
    }

    public Set<String> getMentoringCompetenciesIds(List<MentoringCompetencies> entity) {
        Set<String> ids = new HashSet<>();
        for (MentoringCompetencies mentoringCompetency : entity) {
            ids.add(mentoringCompetency.getId());
        }
        return ids;
    }

    public Set<String> getMentoringFundersIds(List<MentoringFunders> entity) {
        Set<String> ids = new HashSet<>();
        for (MentoringFunders mentoringFunders : entity) {
            ids.add(mentoringFunders.getId());
        }
        return ids;
    }

    public Set<String> getMentoringMentorsIds(List<Mentors> entity) {
        Set<String> ids = new HashSet<>();
        for (Mentors mentoringMentor : entity) {
            ids.add(mentoringMentor.getId());
        }
        return ids;
    }

    public Set<String> getMentoringObjectivesIds(List<MentoringObjective> entity) {
        Set<String> ids = new HashSet<>();
        for (MentoringObjective mentoringObjectives : entity) {
            ids.add(mentoringObjectives.getId());
        }
        return ids;
    }

    public Set<String> getMentoringSessionTypesIds(List<MentoringSessionType> entity) {
        Set<String> ids = new HashSet<>();
        for (MentoringSessionType mentoringSessionTypes : entity) {
            ids.add(mentoringSessionTypes.getId());
        }
        return ids;
    }

    public Set<String> getMentoringThemesIds(List<MentoringTheme> entity) {
        Set<String> ids = new HashSet<>();
        for (MentoringTheme mentoringTheme : entity) {
            ids.add(mentoringTheme.getId());
        }
        return ids;
    }

    public Set<String> getMentoringToolsMethodsIds(List<MentoringToolsMethods> entity) {
        Set<String> ids = new HashSet<>();
        for (MentoringToolsMethods mentoringObjectives : entity) {
            ids.add(mentoringObjectives.getId());
        }
        return ids;
    }

    public Set<String> getSessionAreasOfStrengtheningIds(List<SessionAreasOfStrengthening> entity) {
        Set<String> ids = new HashSet<>();
        for (SessionAreasOfStrengthening sessionAreasOfStrengthening : entity) {
            ids.add(sessionAreasOfStrengthening.getId());
        }
        return ids;
    }
}
