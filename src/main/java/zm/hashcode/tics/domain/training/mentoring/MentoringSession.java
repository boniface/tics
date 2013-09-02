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
import org.springframework.data.mongodb.core.mapping.DBRef;
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
    @DBRef
    private List<Mentors> mentoringMentors = new ArrayList<>();
    @DBRef
    private List<MentoringSessionType> mentoringSessionType = new ArrayList<>();
    @DBRef
    private List<MentoringTheme> mentoringTheme = new ArrayList<>();
    @DBRef
    private TrainingInstitution institutionName;
    @DBRef
    private Status sessionStatus;
    private String mentoringNotes;
    @DBRef
    private List<MentoringFunders> mentoringFunders = new ArrayList<>();
    @DBRef
    private List<MentoringCompetencies> mentoringCompetencies = new ArrayList<>();
    @DBRef
    private Facility mentoringVenue;
    @DBRef
    private List<MentoringObjective> mentoringObjective = new ArrayList<>();
    @DBRef
    private MentoringSubjectArea mentoringSubjectArea;
    @DBRef
    private List<SessionAreasOfStrengthening> sessionAreasOfStrengthening = new ArrayList<>();
    @DBRef
    private List<MentoringToolsMethods> mentoringToolsMethods = new ArrayList<>();

    private MentoringSession() {
    }

    private MentoringSession(Builder builder) {
        id = builder.id;
        sessionName = builder.sessionName;
        startDate = builder.startDate;
        endDate = builder.endDate;
        mentoringMentors = builder.mentoringMentors;
        mentoringSessionType = builder.mentoringSessionType;
        mentoringTheme = builder.mentoringTheme;
        institutionName = builder.institutionName;
        sessionStatus = builder.sessionStatus;
        mentoringNotes = builder.mentoringNotes;
        mentoringFunders = builder.mentoringFunders;
        mentoringCompetencies = builder.mentoringCompetencies;
        mentoringVenue = builder.mentoringVenue;
        mentoringObjective = builder.mentoringObjective;
        mentoringSubjectArea = builder.mentoringSubjectArea;
        sessionAreasOfStrengthening = builder.sessionAreasOfStrengthening;
        mentoringToolsMethods = builder.mentoringToolsMethods;

    }

    public static class Builder {

        private String id;
        private String sessionName;
        private Date startDate;
        private Date endDate;
        private List<Mentors> mentoringMentors = new ArrayList<>();
        private List<MentoringSessionType> mentoringSessionType = new ArrayList<>();
        private List<MentoringTheme> mentoringTheme = new ArrayList<>();
        private TrainingInstitution institutionName;
        private Status sessionStatus;
        private String mentoringNotes;
        private List<MentoringFunders> mentoringFunders = new ArrayList<>();
        private List<MentoringCompetencies> mentoringCompetencies = new ArrayList<>();
        private Facility mentoringVenue;
        private List<MentoringObjective> mentoringObjective = new ArrayList<>();
        private MentoringSubjectArea mentoringSubjectArea;
        private List<SessionAreasOfStrengthening> sessionAreasOfStrengthening = new ArrayList<>();
        private List<MentoringToolsMethods> mentoringToolsMethods = new ArrayList<>();

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

        public Builder mentoringMentors(List<Mentors> value) {
            mentoringMentors = value;
            return this;
        }

        public Builder mentoringSessionType(List<MentoringSessionType> value) {
            mentoringSessionType = value;
            return this;
        }

        public Builder mentoringTheme(List<MentoringTheme> value) {
            mentoringTheme = value;
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

        public Builder mentoringObjective(List<MentoringObjective> value) {
            mentoringObjective = value;
            return this;
        }

        public Builder mentoringSubjectArea(MentoringSubjectArea value) {
            mentoringSubjectArea = value;
            return this;
        }

        public Builder sessionAreasOfStrengthening(List<SessionAreasOfStrengthening> value) {
            sessionAreasOfStrengthening = value;
            return this;
        }

        public Builder mentoringToolsMethods(List<MentoringToolsMethods> value) {
            mentoringToolsMethods = value;
            return this;
        }

        public MentoringSession build() {
            return new MentoringSession(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        return "MentoringSession{" + "sessionName=" + sessionName + "}";
    }

    /**
     * @return the id
     */
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
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @return the mentoringMentors
     */
    public List<Mentors> getMentoringMentors() {
        return mentoringMentors;
    }

    /**
     * @return the mentoringSessionType
     */
    public List<MentoringSessionType> getMentoringSessionType() {
        return mentoringSessionType;
    }

    /**
     * @return the mentoringTheme
     */
    public List<MentoringTheme> getMentoringTheme() {
        return mentoringTheme;
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
     * @return the mentoringVenue
     */
    public Facility getMentoringVenue() {
        return mentoringVenue;
    }

    /**
     * @return the mentoringObjective
     */
    public List<MentoringObjective> getMentoringObjective() {
        return mentoringObjective;
    }

    /**
     * @return the mentoringSubjectArea
     */
    public MentoringSubjectArea getMentoringSubjectArea() {
        return mentoringSubjectArea;
    }

    /**
     * @return the sessionAreasOfStrengthening
     */
    public List<SessionAreasOfStrengthening> getSessionAreasOfStrengthening() {
        return sessionAreasOfStrengthening;
    }

    /**
     * @return the mentoringToolsMethods
     */
    public List<MentoringToolsMethods> getMentoringToolsMethods() {
        return mentoringToolsMethods;
    }
}
