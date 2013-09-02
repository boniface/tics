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
public class MentoringSessionObjective implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private Long mentoringObjectiveId;

    private MentoringSessionObjective() {
    }

    private MentoringSessionObjective(Builder builder) {
        id = builder.id;
        mentoringObjectiveId = builder.mentoringObjectiveId;
    }

    public static class Builder {

        private String id;
        private Long mentoringObjectiveId;

        public Builder(Long val) {
            this.mentoringObjectiveId = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public MentoringSessionObjective build() {
            return new MentoringSessionObjective(this);
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
        final MentoringSessionObjective other = (MentoringSessionObjective) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MentoringSessionObjective{" + "id=" + id + ", mentoringObjectiveId=" + mentoringObjectiveId + '}';
    }

    public String getId() {
        return id;
    }

    /**
     * @return the mentoringObjectiveId
     */
    public Long getMentoringObjectiveId() {
        return mentoringObjectiveId;
    }
}
