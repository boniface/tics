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
public class MentoringTheme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String mentoringTheme;
    private MentoringField mentoringField;

    private MentoringTheme() {
    }

    private MentoringTheme(Builder builder) {
        id = builder.id;
        mentoringTheme = builder.mentoringTheme;
        mentoringField = builder.mentoringField;
    }

    public static class Builder {

        private String id;
        private String mentoringTheme;
        private MentoringField mentoringField;

        public Builder(String val) {
            this.mentoringTheme = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder mentoringField(MentoringField value) {
            mentoringField = value;
            return this;
        }

        public MentoringTheme build() {
            return new MentoringTheme(this);
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
        final MentoringTheme other = (MentoringTheme) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MentoringTheme{" + "id=" + id + ", mentoringTheme=" + mentoringTheme + '}';
    }

    public String getId() {
        return id;
    }

    /**
     * @return the mentoringTheme
     */
    public String getMentoringTheme() {
        return mentoringTheme;
    }

    /**
     * @return the mentoringField
     */
    public MentoringField getMentoringField() {
        return mentoringField;
    }
}
