/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.mentoring.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author geek
 */
public class MentoringSessionBean implements Serializable {

    private String id;
    private String sessionName;
    private Date startDate;
    private Date endDate;
    private String mentoringNotes;
    private String institutionNameId; // TrainingInstitution
    private String sessionStatusId; // Status
    private String mentoringSubjectAreaId; // MentoringSubjectArea
    private String mentoringVenueId;// Facility
    private Set<String> mentoringMentorsIds; // Mentors
    private Set<String> mentoringSessionTypesIds; // MentoringSessionType
    private Set<String> mentoringThemesIds; // MentoringTheme
    private Set<String> mentoringFundersIds; // MentoringFunders
    private Set<String> mentoringCompetenciesIds; // MentoringCompetencies
    private Set<String> mentoringObjectivesIds; // MentoringObjective
    private Set<String> sessionAreasOfStrengtheningIds; // SessionAreasOfStrengthening
    private Set<String> mentoringToolsMethodsIds; // MentoringToolsMethods

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the sessionName
     */
    public String getSessionName() {
        return sessionName;
    }

    /**
     * @param sessionName the sessionName to set
     */
    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the mentoringNotes
     */
    public String getMentoringNotes() {
        return mentoringNotes;
    }

    /**
     * @param mentoringNotes the mentoringNotes to set
     */
    public void setMentoringNotes(String mentoringNotes) {
        this.mentoringNotes = mentoringNotes;
    }

    /**
     * @return the institutionNameId
     */
    public String getInstitutionNameId() {
        return institutionNameId;
    }

    /**
     * @param institutionNameId the institutionNameId to set
     */
    public void setInstitutionNameId(String institutionNameId) {
        this.institutionNameId = institutionNameId;
    }

    /**
     * @return the sessionStatusId
     */
    public String getSessionStatusId() {
        return sessionStatusId;
    }

    /**
     * @param sessionStatusId the sessionStatusId to set
     */
    public void setSessionStatusId(String sessionStatusId) {
        this.sessionStatusId = sessionStatusId;
    }

    /**
     * @return the mentoringSubjectAreaId
     */
    public String getMentoringSubjectAreaId() {
        return mentoringSubjectAreaId;
    }

    /**
     * @param mentoringSubjectAreaId the mentoringSubjectAreaId to set
     */
    public void setMentoringSubjectAreaId(String mentoringSubjectAreaId) {
        this.mentoringSubjectAreaId = mentoringSubjectAreaId;
    }

    /**
     * @return the mentoringVenueId
     */
    public String getMentoringVenueId() {
        return mentoringVenueId;
    }

    /**
     * @param mentoringVenueId the mentoringVenueId to set
     */
    public void setMentoringVenueId(String mentoringVenueId) {
        this.mentoringVenueId = mentoringVenueId;
    }

    /**
     * @return the mentoringMentorsIds
     */
    public Set<String> getMentoringMentorsIds() {
        return mentoringMentorsIds;
    }

    /**
     * @param mentoringMentorsIds the mentoringMentorsIds to set
     */
    public void setMentoringMentorsIds(Set<String> mentoringMentorsIds) {
        this.mentoringMentorsIds = mentoringMentorsIds;
    }

    /**
     * @return the mentoringSessionTypesIds
     */
    public Set<String> getMentoringSessionTypesIds() {
        return mentoringSessionTypesIds;
    }

    /**
     * @param mentoringSessionTypesIds the mentoringSessionTypesIds to set
     */
    public void setMentoringSessionTypesIds(Set<String> mentoringSessionTypesIds) {
        this.mentoringSessionTypesIds = mentoringSessionTypesIds;
    }

    /**
     * @return the mentoringThemesIds
     */
    public Set<String> getMentoringThemesIds() {
        return mentoringThemesIds;
    }

    /**
     * @param mentoringThemesIds the mentoringThemesIds to set
     */
    public void setMentoringThemesIds(Set<String> mentoringThemesIds) {
        this.mentoringThemesIds = mentoringThemesIds;
    }

    /**
     * @return the mentoringFundersIds
     */
    public Set<String> getMentoringFundersIds() {
        return mentoringFundersIds;
    }

    /**
     * @param mentoringFundersIds the mentoringFundersIds to set
     */
    public void setMentoringFundersIds(Set<String> mentoringFundersIds) {
        this.mentoringFundersIds = mentoringFundersIds;
    }

    /**
     * @return the mentoringCompetenciesIds
     */
    public Set<String> getMentoringCompetenciesIds() {
        return mentoringCompetenciesIds;
    }

    /**
     * @param mentoringCompetenciesIds the mentoringCompetenciesIds to set
     */
    public void setMentoringCompetenciesIds(Set<String> mentoringCompetenciesIds) {
        this.mentoringCompetenciesIds = mentoringCompetenciesIds;
    }

    /**
     * @return the mentoringObjectivesIds
     */
    public Set<String> getMentoringObjectivesIds() {
        return mentoringObjectivesIds;
    }

    /**
     * @param mentoringObjectivesIds the mentoringObjectivesIds to set
     */
    public void setMentoringObjectivesIds(Set<String> mentoringObjectivesIds) {
        this.mentoringObjectivesIds = mentoringObjectivesIds;
    }

    /**
     * @return the sessionAreasOfStrengtheningIds
     */
    public Set<String> getSessionAreasOfStrengtheningIds() {
        return sessionAreasOfStrengtheningIds;
    }

    /**
     * @param sessionAreasOfStrengtheningIds the sessionAreasOfStrengtheningIds to set
     */
    public void setSessionAreasOfStrengtheningIds(Set<String> sessionAreasOfStrengtheningIds) {
        this.sessionAreasOfStrengtheningIds = sessionAreasOfStrengtheningIds;
    }

    /**
     * @return the mentoringToolsMethodsIds
     */
    public Set<String> getMentoringToolsMethodsIds() {
        return mentoringToolsMethodsIds;
    }

    /**
     * @param mentoringToolsMethodsIds the mentoringToolsMethodsIds to set
     */
    public void setMentoringToolsMethodsIds(Set<String> mentoringToolsMethodsIds) {
        this.mentoringToolsMethodsIds = mentoringToolsMethodsIds;
    }
}
