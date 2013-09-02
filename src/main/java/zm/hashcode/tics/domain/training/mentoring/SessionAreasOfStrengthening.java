/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training.mentoring;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author boniface
 */
@Document
public class SessionAreasOfStrengthening implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String areasOfStrengthening;

    private SessionAreasOfStrengthening() {
    }

    private SessionAreasOfStrengthening(Builder builder) {
        id = builder.id;
        areasOfStrengthening = builder.areasOfStrengthening;
    }

    public static class Builder {

        private String id;
        private String areasOfStrengthening;

        public Builder(String val) {
            this.areasOfStrengthening = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public SessionAreasOfStrengthening build() {
            return new SessionAreasOfStrengthening(this);
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
        final SessionAreasOfStrengthening other = (SessionAreasOfStrengthening) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SessionAreasOfStrengthening{" + "areasOfStrengtheningId=" + areasOfStrengthening + "}";
    }

    public String getId() {
        return id;
    }

    public String getAreasOfStrengthening() {
        return areasOfStrengthening;
    }
}
