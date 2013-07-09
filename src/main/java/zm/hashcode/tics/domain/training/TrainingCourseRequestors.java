/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training;

import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.DBRef;
import zm.hashcode.tics.domain.people.Person;

/**
 *
 * @author boniface
 */
public final class TrainingCourseRequestors implements Serializable {

    @DBRef
    private Person personRequestor;

    private TrainingCourseRequestors() {
    }

    private TrainingCourseRequestors(Builder builder) {
        personRequestor = builder.personRequestor;
    }

    public static class Builder {
        private Person personRequestor;

        public Builder(Person val) {
            this.personRequestor = val;
        }

        public TrainingCourseRequestors build() {
            return new TrainingCourseRequestors(this);
        }
    }

    public Person getPersonRequestor() {
        return personRequestor;
    }
    
}
