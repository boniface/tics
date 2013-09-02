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
public class MentoringSessionType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private Long mentoringSessionType;

    public String getId() {
        return id;
    }

    private MentoringSessionType() {
    }

    private MentoringSessionType(Builder builder) {
        id = builder.id;
        mentoringSessionType = builder.mentoringSessionType;
    }

    public static class Builder {

        private String id;
        private Long mentoringSessionType;

        public Builder(Long val) {
            this.mentoringSessionType = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public MentoringSessionType build() {
            return new MentoringSessionType(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final MentoringSessionType other = (MentoringSessionType) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MentoringSessionType{" + "id=" + id + ", mentoringSessionType=" + mentoringSessionType + '}';
    }

    /**
     * @return the mentoringSessionType
     */
    public Long getMentoringSessionType() {
        return mentoringSessionType;
    }
}
