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
public class MentoringObjective implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String mentoringObjective;

    private MentoringObjective() {
    }

    private MentoringObjective(Builder builder) {
        id = builder.id;
        mentoringObjective = builder.mentoringObjective;
    }

    public static class Builder {

        private String id;
        private String mentoringObjective;

        public Builder(String val) {
            this.mentoringObjective = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public MentoringObjective build() {
            return new MentoringObjective(this);
        }
    }

    public String getId() {
        return id;
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
        final MentoringObjective other = (MentoringObjective) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MentoringObjective{" + "mentoringObjective=" + mentoringObjective + "}";
    }

    /**
     * @return the mentoringObjective
     */
    public String getMentoringObjective() {
        return mentoringObjective;
    }
}
