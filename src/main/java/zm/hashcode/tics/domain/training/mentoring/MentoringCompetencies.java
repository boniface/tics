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
public class MentoringCompetencies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String competencyName;
    private Long competencyId;

    private MentoringCompetencies() {
    }

    private MentoringCompetencies(Builder builder) {
        id = builder.id;
        competencyName = builder.competencyName;
        competencyId = builder.competencyId;
    }

    public static class Builder {

        private String id;
        private String competencyName;
        private Long competencyId;

        public Builder(String val) {
            this.competencyName = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder competencyId(Long value) {
            competencyId = value;
            return this;
        }

        public MentoringCompetencies build() {
            return new MentoringCompetencies(this);
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
        final MentoringCompetencies other = (MentoringCompetencies) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MentoringCompetencies{" + "competencyName=" + competencyName + "}";
    }

    public String getId() {
        return id;
    }

    /**
     * @return the competencyName
     */
    public String getCompetencyName() {
        return competencyName;
    }

    /**
     * @return the competencyId
     */
    public Long getCompetencyId() {
        return competencyId;
    }
}
