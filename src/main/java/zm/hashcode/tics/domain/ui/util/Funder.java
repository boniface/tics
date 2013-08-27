/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.ui.util;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.ui.location.LocationAddress;

/**
 *
 * @author boniface
 */
@Document
public class Funder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String trainingFunderName;
    private String courseCenter;
    @DBRef
    private Location city;
    private LocationAddress contact;

    private Funder() {
    }

    private Funder(Builder builder) {
        id = builder.id;
        trainingFunderName = builder.trainingFunderName;
        courseCenter = builder.courseCenter;
        city = builder.city;
        contact = builder.contact;
    }

    public static class Builder {

        private String id;
        private final String trainingFunderName;
        private String courseCenter;
        private Location city;
        private LocationAddress contact;

        public Builder(String val) {
            this.trainingFunderName = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder courseCenter(String value) {
            courseCenter = value;
            return this;
        }

        public Builder city(Location value) {
            city = value;
            return this;
        }

        public Builder contact(LocationAddress value) {
            contact = value;
            return this;
        }

        public Funder build() {
            return new Funder(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getTrainingFunderName() {
        return trainingFunderName;
    }

    public String getCourseCenter() {
        return courseCenter;
    }

    public Location getCity() {
        return city;
    }

    public LocationAddress getContact() {
        return contact;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Funder other = (Funder) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funder{" + "trainingFunderName=" + trainingFunderName + '}';
    }
}
