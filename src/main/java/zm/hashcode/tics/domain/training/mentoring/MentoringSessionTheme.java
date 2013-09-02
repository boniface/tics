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
public class MentoringSessionTheme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private Long sessionMentoringTheme;

    private MentoringSessionTheme() {
    }

    private MentoringSessionTheme(Builder builder) {
        id = builder.id;
        sessionMentoringTheme = builder.sessionMentoringTheme;
    }

    public static class Builder {

        private String id;
        private Long sessionMentoringTheme;

        public Builder(Long val) {
            this.sessionMentoringTheme = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public MentoringSessionTheme build() {
            return new MentoringSessionTheme(this);
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
        final MentoringSessionTheme other = (MentoringSessionTheme) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MentoringSessionTheme{" + "id=" + id + ", sessionMentoringTheme=" + sessionMentoringTheme + '}';
    }

    public String getId() {
        return id;
    }

    /**
     * @return the sessionMentoringTheme
     */
    public Long getSessionMentoringTheme() {
        return sessionMentoringTheme;
    }
}
