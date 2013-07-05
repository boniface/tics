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
 * @author boniface
 */
@Document
public class RaceList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String raceName;

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
        if (!(object instanceof RaceList)) {
            return false;
        }
        RaceList other = (RaceList) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashthrims.domain.employeelist.RaceList[ id=" + id + " ]";
    }

    /**
     * @return the raceName
     */
    public String getRaceName() {
        return raceName;
    }

    /**
     * @param raceName the raceName to set
     */
    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }
    
}
