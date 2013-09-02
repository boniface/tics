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
public class MentoringMentors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private Long mentorsId;

    private MentoringMentors() {
    }

    private MentoringMentors(Builder builder) {
        id = builder.id;
        mentorsId = builder.mentorsId;
    }

    public static class Builder {

        private String id;
        private Long mentorsId;

        public Builder(Long val) {
            this.mentorsId = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public MentoringMentors build() {
            return new MentoringMentors(this);
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
        final MentoringMentors other = (MentoringMentors) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MentoringMentors{" + "mentorsId=" + mentorsId + "}";
    }

    public String getId() {
        return id;
    }

    /**
     * @return the mentorsId
     */
    public Long getMentorsId() {
        return mentorsId;
    }
}
