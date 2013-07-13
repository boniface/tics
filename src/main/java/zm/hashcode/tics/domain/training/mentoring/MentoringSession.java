/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training.mentoring;

import zm.hashcode.tics.domain.training.institutions.TrainingInstitution;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.ui.util.Status;

/**
 *
 * @author boniface
 */

public class MentoringSession implements Serializable {

    private static final long serialVersionUID = 1L;
 
    private Long id;
    private String sessionName;
  
    private Date startDate;
  
    private Date endDate;

    private List<MentoringMentors> mentoringMentors = new ArrayList<MentoringMentors>();

    private List<MentoringSessionType> mentoringSessionType = new ArrayList<MentoringSessionType>();

    private List<MentoringSessionTheme> mentoringSessionTheme = new ArrayList<MentoringSessionTheme>();
  
    private TrainingInstitution institutionName;
   
    private Status sessionStatus;
    private String mentoringNotes;
  
    private List<MentoringFunders> mentoringFunders = new ArrayList<MentoringFunders>();

    private List<MentoringCompetencies> mentoringCompetencies = new ArrayList<MentoringCompetencies>();
  
    private Facility mentoringVenue;

    private List<MentoringSessionObjective> mentoringObjective = new ArrayList<MentoringSessionObjective>();
    private Long MentoringSubjectArea_CompetencyType;

    private List<SessionAreasOfStrengthening> sessionAreasOfStrengthening = new ArrayList<SessionAreasOfStrengthening>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MentoringSession)) {
            return false;
        }
        MentoringSession other = (MentoringSession) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashthrims.domain.traininglist.MentoringSession[id=" + id + "]";
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
     * @return the institutionName
     */
    public TrainingInstitution getInstitutionName() {
        return institutionName;
    }

    /**
     * @param institutionName the institutionName to set
     */
    public void setInstitutionName(TrainingInstitution institutionName) {
        this.institutionName = institutionName;
    }

    /**
     * @return the sessionStatus
     */
    public Status getSessionStatus() {
        return sessionStatus;
    }

    /**
     * @param sessionStatus the sessionStatus to set
     */
    public void setSessionStatus(Status sessionStatus) {
        this.sessionStatus = sessionStatus;
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
     * @return the mentoringFunders
     */
    public List<MentoringFunders> getMentoringFunders() {
        return mentoringFunders;
    }

    /**
     * @param mentoringFunders the mentoringFunders to set
     */
    public void setMentoringFunders(List<MentoringFunders> mentoringFunders) {
        this.mentoringFunders = mentoringFunders;
    }

    /**
     * @return the mentoringCompetencies
     */
    public List<MentoringCompetencies> getMentoringCompetencies() {
        return mentoringCompetencies;
    }

    /**
     * @param mentoringCompetencies the mentoringCompetencies to set
     */
    public void setMentoringCompetencies(List<MentoringCompetencies> mentoringCompetencies) {
        this.mentoringCompetencies = mentoringCompetencies;
    }

    /**
     * @return the mentoringMentors
     */
    public List<MentoringMentors> getMentoringMentors() {
        return mentoringMentors;
    }

    /**
     * @param mentoringMentors the mentoringMentors to set
     */
    public void setMentoringMentors(List<MentoringMentors> mentoringMentors) {
        this.mentoringMentors = mentoringMentors;
    }

    /**
     * @return the sessionDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param sessionDate the sessionDate to set
     */
    public void setStartDate(Date sessionDate) {
        this.startDate = sessionDate;
    }

    /**
     * @return the mentoringVenue
     */
    public Facility getMentoringVenue() {
        return mentoringVenue;
    }

    /**
     * @param mentoringVenue the mentoringVenue to set
     */
    public void setMentoringVenue(Facility mentoringVenue) {
        this.mentoringVenue = mentoringVenue;
    }

    /**
     * @return the mentoringSessionType
     */
    public List<MentoringSessionType> getMentoringSessionType() {
        return mentoringSessionType;
    }

    /**
     * @param mentoringSessionType the mentoringSessionType to set
     */
    public void setMentoringSessionType(List<MentoringSessionType> mentoringSessionType) {
        this.mentoringSessionType = mentoringSessionType;
    }

    /**
     * @return the MentoringSubjectArea_CompetencyType
     */
    public Long getMentoringSubjectArea_CompetencyType() {
        return MentoringSubjectArea_CompetencyType;
    }

    /**
     * @param MentoringSubjectArea_CompetencyType the MentoringSubjectArea_CompetencyType to set
     */
    public void setMentoringSubjectArea_CompetencyType(Long MentoringSubjectArea_CompetencyType) {
        this.MentoringSubjectArea_CompetencyType = MentoringSubjectArea_CompetencyType;
    }

    /**
     * @return the mentoringObjective
     */
    public List<MentoringSessionObjective> getMentoringObjective() {
        return mentoringObjective;
    }

    /**
     * @param mentoringObjective the mentoringObjective to set
     */
    public void setMentoringObjective(List<MentoringSessionObjective> mentoringObjective) {
        this.mentoringObjective = mentoringObjective;
    }

    /**
     * @return the mentoringSessionTheme
     */
    public List<MentoringSessionTheme> getMentoringSessionTheme() {
        return mentoringSessionTheme;
    }

    /**
     * @param mentoringSessionTheme the mentoringSessionTheme to set
     */
    public void setMentoringSessionTheme(List<MentoringSessionTheme> mentoringSessionTheme) {
        this.mentoringSessionTheme = mentoringSessionTheme;
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
     * @return the sessionAreasOfStrengthening
     */
    public List<SessionAreasOfStrengthening> getSessionAreasOfStrengthening() {
        return sessionAreasOfStrengthening;
    }

    /**
     * @param sessionAreasOfStrengthening the sessionAreasOfStrengthening to set
     */
    public void setSessionAreasOfStrengthening(List<SessionAreasOfStrengthening> sessionAreasOfStrengthening) {
        this.sessionAreasOfStrengthening = sessionAreasOfStrengthening;
    }
}
