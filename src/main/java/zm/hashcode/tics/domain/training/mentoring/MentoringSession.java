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
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.ui.util.Status;

/**
 *
 * @author boniface
 */
@Document
public class MentoringSession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
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
    private Long mentoringSubjectArea_CompetencyType;
    private List<SessionAreasOfStrengthening> sessionAreasOfStrengthening = new ArrayList<SessionAreasOfStrengthening>();

    private MentoringSession() {
    }

    private MentoringSession(Builder builder) {
        id = builder.id;
        sessionName = builder.sessionName;
        startDate = builder.startDate;
        endDate = builder.endDate;
        mentoringMentors = builder.mentoringMentors;
        mentoringSessionType = builder.mentoringSessionType;
        mentoringSessionTheme = builder.mentoringSessionTheme;
        institutionName = builder.institutionName;
        sessionStatus = builder.sessionStatus;
        mentoringNotes = builder.mentoringNotes;
        mentoringFunders = builder.mentoringFunders;
        mentoringCompetencies = builder.mentoringCompetencies;
        mentoringVenue = builder.mentoringVenue;
        mentoringObjective = builder.mentoringObjective;
        mentoringSubjectArea_CompetencyType = builder.mentoringSubjectArea_CompetencyType;
        sessionAreasOfStrengthening = builder.sessionAreasOfStrengthening;
    }

    public static class Builder {

        private String id;
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
        private Long mentoringSubjectArea_CompetencyType;
        private List<SessionAreasOfStrengthening> sessionAreasOfStrengthening = new ArrayList<SessionAreasOfStrengthening>();

        public Builder(String val) {
            this.sessionName = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder startDate(Date value) {
            startDate = value;
            return this;
        }

        public Builder endDate(Date value) {
            endDate = value;
            return this;
        }

        public Builder mentoringMentors(List<MentoringMentors> value) {
            mentoringMentors = value;
            return this;
        }

        public Builder mentoringSessionType(List<MentoringSessionType> value) {
            mentoringSessionType = value;
            return this;
        }

        public Builder mentoringSessionTheme(List<MentoringSessionTheme> value) {
            mentoringSessionTheme = value;
            return this;
        }

        public Builder institutionName(TrainingInstitution value) {
            institutionName = value;
            return this;
        }

        public Builder sessionStatus(Status value) {
            sessionStatus = value;
            return this;
        }

        public Builder mentoringNotes(String value) {
            mentoringNotes = value;
            return this;
        }

        public Builder mentoringFunders(List<MentoringFunders> value) {
            mentoringFunders = value;
            return this;
        }

        public Builder mentoringCompetencies(List<MentoringCompetencies> value) {
            mentoringCompetencies = value;
            return this;
        }

        public Builder mentoringVenue(Facility value) {
            mentoringVenue = value;
            return this;
        }

        public Builder mentoringObjective(List<MentoringSessionObjective> value) {
            mentoringObjective = value;
            return this;
        }

        public Builder mentoringSubjectArea_CompetencyType(Long value) {
            mentoringSubjectArea_CompetencyType = value;
            return this;
        }

        public Builder sessionAreasOfStrengthening(List<SessionAreasOfStrengthening> value) {
            sessionAreasOfStrengthening = value;
            return this;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MentoringSession other = (MentoringSession) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MentoringSession{" + "id=" + id + ", sessionName=" + sessionName + '}';
    }

    public String getId() {
        return id;
    }

    /**
     * @return the sessionName
     */
    public String getSessionName() {
        return sessionName;
    }

    /**
     * @return the institutionName
     */
    public TrainingInstitution getInstitutionName() {
        return institutionName;
    }

    /**
     * @return the sessionStatus
     */
    public Status getSessionStatus() {
        return sessionStatus;
    }

    /**
     * @return the mentoringNotes
     */
    public String getMentoringNotes() {
        return mentoringNotes;
    }

    /**
     * @return the mentoringFunders
     */
    public List<MentoringFunders> getMentoringFunders() {
        return mentoringFunders;
    }

    /**
     * @return the mentoringCompetencies
     */
    public List<MentoringCompetencies> getMentoringCompetencies() {
        return mentoringCompetencies;
    }

    /**
     * @return the mentoringMentors
     */
    public List<MentoringMentors> getMentoringMentors() {
        return mentoringMentors;
    }

    /**
     * @return the sessionDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @return the mentoringVenue
     */
    public Facility getMentoringVenue() {
        return mentoringVenue;
    }

    /**
     * @return the mentoringSessionType
     */
    public List<MentoringSessionType> getMentoringSessionType() {
        return mentoringSessionType;
    }

    /**
     * @return the mentoringSubjectArea_CompetencyType
     */
    public Long getMentoringSubjectArea_CompetencyType() {
        return mentoringSubjectArea_CompetencyType;
    }

    /**
     * @return the mentoringObjective
     */
    public List<MentoringSessionObjective> getMentoringObjective() {
        return mentoringObjective;
    }

    /**
     * @return the mentoringSessionTheme
     */
    public List<MentoringSessionTheme> getMentoringSessionTheme() {
        return mentoringSessionTheme;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @return the sessionAreasOfStrengthening
     */
    public List<SessionAreasOfStrengthening> getSessionAreasOfStrengthening() {
        return sessionAreasOfStrengthening;
    }
}
