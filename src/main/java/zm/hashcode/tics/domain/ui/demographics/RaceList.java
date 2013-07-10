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
public final class RaceList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String raceName;

    private RaceList() {
    }

    private RaceList(Builder builder) {
        id = builder.id;
        raceName = builder.raceName;
    }

    public static class Builder {

        private String id;
        private final String raceName;

        public Builder(String val) {
            this.raceName = val;
        }

        public RaceList.Builder id(String value) {
            id = value;
            return this;
        }

        public RaceList build() {
            return new RaceList(this);
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
        final RaceList other = (RaceList) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
