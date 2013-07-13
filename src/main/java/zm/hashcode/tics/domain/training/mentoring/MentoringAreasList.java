/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training.mentoring;

import java.io.Serializable;

/**
 *
 * @author boniface
 */

public class MentoringAreasList implements Serializable {
    private static final long serialVersionUID = 1L;
 
    private Long id;
    private String areasofStrenthening;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        if (!(object instanceof MentoringAreasList)) {
            return false;
        }
        MentoringAreasList other = (MentoringAreasList) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashthrims.domain.traininglist.MentoringAreasList[ id=" + id + " ]";
    }

    /**
     * @return the areasofStrenthening
     */
    public String getAreasofStrenthening() {
        return areasofStrenthening;
    }

    /**
     * @param areasofStrenthening the areasofStrenthening to set
     */
    public void setAreasofStrenthening(String areasofStrenthening) {
        this.areasofStrenthening = areasofStrenthening;
    }
    
}
