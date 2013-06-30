/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zm.hashcode.tics.domain.people;

import com.hashthrims.domain.employeelist.Language;
import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 *
 * @author boniface
 */

public class EmployeeLanguages implements Serializable {
    private static final long serialVersionUID = 1L;
    @DBRef
    private Language language;
    private String writing;
    private String reading;
    private String speaking;


    /**
     * @return the language
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(Language language) {
        this.language = language;
    }

    /**
     * @return the writing
     */
    public String getWriting() {
        return writing;
    }

    /**
     * @param writing the writing to set
     */
    public void setWriting(String writing) {
        this.writing = writing;
    }

    /**
     * @return the reading
     */
    public String getReading() {
        return reading;
    }

    /**
     * @param reading the reading to set
     */
    public void setReading(String reading) {
        this.reading = reading;
    }

    /**
     * @return the speaking
     */
    public String getSpeaking() {
        return speaking;
    }

    /**
     * @param speaking the speaking to set
     */
    public void setSpeaking(String speaking) {
        this.speaking = speaking;
    }

}
