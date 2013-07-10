/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.ui.job;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author boniface
 */
@Document
public final class JobClassification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String currentTitle;
    private String oldTitle;
    private String oldCode;
    private String currentCode;
    private String codeConversion;
    private String comment;

    private JobClassification() {
    }

    private JobClassification(Builder builder) {
        id = builder.id;
        currentCode = builder.currentCode;
        currentTitle = builder.currentTitle;
        oldTitle = builder.oldTitle;
        oldCode = builder.oldCode;
        codeConversion = builder.codeConversion;
        comment = builder.comment;

    }

    public static class Builder {

        private String id;
        private final String currentTitle;
        private String oldTitle;
        private String oldCode;
        private String currentCode;
        private String codeConversion;
        private String comment;

        public Builder(String val) {
            this.currentTitle = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder oldTitle(String value) {
            oldTitle = value;
            return this;
        }

        public Builder oldCode(String value) {
            oldCode = value;
            return this;
        }

        public Builder currentCode(String value) {
            currentCode = value;
            return this;
        }

        public Builder codeConversion(String value) {
            codeConversion = value;
            return this;
        }

        public Builder comment(String value) {
            comment = value;
            return this;
        }

        public JobClassification build() {
            return new JobClassification(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getCurrentTitle() {
        return currentTitle;
    }

    public String getOldTitle() {
        return oldTitle;
    }

    public String getOldCode() {
        return oldCode;
    }

    public String getCurrentCode() {
        return currentCode;
    }

    public String getCodeConversion() {
        return codeConversion;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final JobClassification other = (JobClassification) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}