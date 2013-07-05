/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training;

import java.io.Serializable;

/**
 *
 * @author boniface
 */

public class CourseCriteria implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String criteria;
    private Long criteriaID;

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
        if (!(object instanceof CourseCriteria)) {
            return false;
        }
        CourseCriteria other = (CourseCriteria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashthrims.domain.traininglist.CourseCriteria[ id=" + id + " ]";
    }

    /**
     * @return the criteria
     */
    public String getCriteria() {
        return criteria;
    }

    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    /**
     * @return the criteriaID
     */
    public Long getCriteriaID() {
        return criteriaID;
    }

    /**
     * @param criteriaID the criteriaID to set
     */
    public void setCriteriaID(Long criteriaID) {
        this.criteriaID = criteriaID;
    }


    
}
