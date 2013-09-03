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
public class MentoringSubjectArea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String subjectArea;

    private MentoringSubjectArea() {
    }

    private MentoringSubjectArea(Builder builder) {
        id = builder.id;
        subjectArea = builder.subjectarea;
    }

    public static class Builder {

        private String id;
        private String subjectarea;

        public Builder(String val) {
            this.subjectarea = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public MentoringSubjectArea build() {
            return new MentoringSubjectArea(this);
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
        final MentoringSubjectArea other = (MentoringSubjectArea) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MentoringSubjectArea{" + "subjectArea=" + subjectArea + "}";
    }

    public String getId() {
        return id;
    }

    /**
     * @return the areasofStrenthening
     */
    public String getSubjectArea() {
        return subjectArea;
    }
}
