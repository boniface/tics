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
public final class GenderList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String gender;

    private GenderList() {
    }

    private GenderList(Builder builder) {
        id = builder.id;
        gender = builder.gender;
    }

    public static class Builder {

        private String id;
        private final String gender;

        public Builder(String val) {
            this.gender = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public GenderList build() {
            return new GenderList(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final GenderList other = (GenderList) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GenderList{" + "gender=" + gender + '}';
    }
}
