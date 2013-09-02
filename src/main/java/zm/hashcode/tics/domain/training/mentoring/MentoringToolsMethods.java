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
public class MentoringToolsMethods implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String toolsMethod;

    private MentoringToolsMethods() {
    }

    private MentoringToolsMethods(Builder builder) {
        id = builder.id;
        toolsMethod = builder.toolsMethod;
    }

    public static class Builder {

        private String id;
        private String toolsMethod;

        public Builder(String val) {
            this.toolsMethod = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public MentoringToolsMethods build() {
            return new MentoringToolsMethods(this);
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
        final MentoringToolsMethods other = (MentoringToolsMethods) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MentoringField{" + "fieldName=" + toolsMethod + "}";
    }

    public String getId() {
        return id;
    }

    public String getToolsMethod() {
        return toolsMethod;
    }
}
