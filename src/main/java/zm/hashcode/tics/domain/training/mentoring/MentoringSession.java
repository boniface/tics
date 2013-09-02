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
    private List<MentoringTheme> mentoringSessionTheme = new ArrayList<>();
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
    List<MentoringToolsMethods> mentoringToolsMethodses = new ArrayList<>();

    private MentoringSession() {
    }
}
