/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.people;

import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.DBRef;
import zm.hashcode.tics.domain.ui.demographics.Language;

/**
 *
 * @author boniface
 */
public final class EmployeeLanguages implements Serializable {

    private static final long serialVersionUID = 1L;
    @DBRef
    private Language language;
    private String writing;
    private String reading;
    private String speaking;

    private EmployeeLanguages() {
    }

    private EmployeeLanguages(Builder builder) {
        language = builder.language;
        writing = builder.writing;
        reading = builder.reading;
        speaking = builder.speaking;

    }

    public static class Builder {

        private Language language;
        private String writing;
        private String reading;
        private String speaking;

        public Builder(Language val) {
            this.language = val;
        }

        public Builder writing(String value) {
            writing = value;
            return this;
        }

        public Builder reading(String value) {
            reading = value;
            return this;
        }

        public Builder speaking(String value) {
            speaking = value;
            return this;
        }

        public EmployeeLanguages build() {
            return new EmployeeLanguages(this);
        }
    }

    public Language getLanguage() {
        return language;
    }

    public String getWriting() {
        return writing;
    }

    public String getReading() {
        return reading;
    }

    public String getSpeaking() {
        return speaking;
    }

    
    
}
