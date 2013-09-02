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
public class MentoringField implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String fieldName;

    private MentoringField() {
    }

    private MentoringField(Builder builder) {
        id = builder.id;
        fieldName = builder.fieldName;
    }

    public static class Builder {

        private String id;
        private String fieldName;

        public Builder(String val) {
            this.fieldName = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public MentoringField build() {
            return new MentoringField(this);
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
        final MentoringField other = (MentoringField) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MentoringField{" + "fieldName=" + fieldName + "}";
    }

    public String getId() {
        return id;
    }

    /**
     * @return the fieldName
     */
    public String getFieldName() {
        return fieldName;
    }
}
