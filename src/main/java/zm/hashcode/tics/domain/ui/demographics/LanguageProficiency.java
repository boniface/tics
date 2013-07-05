/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zm.hashcode.tics.domain.ui.demographics;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author stud
 */
@Document
public class LanguageProficiency implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String proficiency;

    public String  getId() {
        return id;
    }

    public void setId(String  id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LanguageProficiency)) {
            return false;
        }
        LanguageProficiency other = (LanguageProficiency) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashthrims.domain.employeelist.LanguageProficiency[id=" + id + "]";
    }

    /**
     * @return the proficiency
     */
    public String getProficiency() {
        return proficiency;
    }

    /**
     * @param proficiency the proficiency to set
     */
    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

}
