/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.ui.demographics;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author boniface
 */
@Document
public final class Race implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String raceName;

    private Race() {
    }

    private Race(Builder builder) {
        id = builder.id;
        raceName = builder.raceName;
    }

    public static class Builder {

        private String id;
        private final String raceName;

        public Builder(String val) {
            this.raceName = val;
        }

        public Race.Builder id(String value) {
            id = value;
            return this;
        }

        public Race build() {
            return new Race(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getRaceName() {
        return raceName;
    }

    @Override
    public String toString() {
        return "RaceList{" + "raceName=" + raceName + '}';
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
        final Race other = (Race) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
