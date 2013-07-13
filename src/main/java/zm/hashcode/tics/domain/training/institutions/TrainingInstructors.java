/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training.institutions;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author stud
 */
@Document
public final class TrainingInstructors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String otherName;
    private String qualification;
    private String areaOfexpertise;

    private TrainingInstructors() {
    }

    private TrainingInstructors(Builder builder) {
        id = builder.id;
        firstName = builder.firstName;
        lastName = builder.lastName;
        otherName = builder.lastName;
        qualification= builder.qualification;
        areaOfexpertise= builder.areaOfexpertise;
    }
    public static class Builder {

        private String id;
        private String firstName;
        private final String lastName;
        private String otherName;
        private String qualification;
        private String areaOfexpertise;

        public Builder(String val) {
            this.lastName = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder firstName(String value) {
            firstName = value;
            return this;
        }
        
        
        public Builder otherName(String value) {
            otherName = value;
            return this;
        }
        
        
        public Builder qualification(String value) {
            qualification = value;
            return this;
        }
        
        
        public Builder areaOfexpertise(String value) {
            areaOfexpertise = value;
            return this;
        }
    
        public TrainingInstructors build() {
            return new TrainingInstructors(this);
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getOtherName() {
        return otherName;
    }

    public String getQualification() {
        return qualification;
    }

    public String getAreaOfexpertise() {
        return areaOfexpertise;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final TrainingInstructors other = (TrainingInstructors) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "TrainingInstructors{" + "firstName=" + firstName + ", lastName=" + lastName + '}';
    }
    
    
}
