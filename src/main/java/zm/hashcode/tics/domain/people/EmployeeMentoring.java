/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.people;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.training.mentoring.MentoringSession;

/**
 *
 * @author boniface
 */
@Document
public final class EmployeeMentoring implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private Date mentoringDate;
    private int patientsInitiated;
    private int hoursSpent;
    @DBRef
    private MentoringSession mentoringSession;
    @DBRef
    private Facility venue;

    private EmployeeMentoring() {
    }

    private EmployeeMentoring(Builder builder) {
        id = builder.id;
        mentoringDate = builder.mentoringDate;
        patientsInitiated = builder.patientsInitiated;
        hoursSpent= builder.hoursSpent;
        mentoringSession=builder.mentoringSession;
        venue=builder.venue;

    }

    public static class Builder {

        private String id;
        private Date mentoringDate;
        private int patientsInitiated;
        private int hoursSpent;
        private final MentoringSession mentoringSession;
        private Facility venue;

        public Builder(MentoringSession val) {
            this.mentoringSession = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder mentoringDate(Date value) {
            mentoringDate = value;
            return this;
        }

        public Builder patientsInitiated(int value) {
            patientsInitiated = value;
            return this;
        }

        public Builder hoursSpent(int value) {
            hoursSpent = value;
            return this;
        }

        public Builder mentoringSession(Facility value) {
            venue = value;
            return this;
        }

        public EmployeeMentoring build() {
            return new EmployeeMentoring(this);
        }
    }

    public String getId() {
        return id;
    }

    public Date getMentoringDate() {
        return mentoringDate;
    }

    public int getPatientsInitiated() {
        return patientsInitiated;
    }

    public int getHoursSpent() {
        return hoursSpent;
    }

    public MentoringSession getMentoringSession() {
        return mentoringSession;
    }

    public Facility getVenue() {
        return venue;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final EmployeeMentoring other = (EmployeeMentoring) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
