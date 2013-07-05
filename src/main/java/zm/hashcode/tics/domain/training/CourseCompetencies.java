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

public class CourseCompetencies implements Serializable,Comparable<CourseCompetencies> {
    private static final long serialVersionUID = 1L;
    private Long id;
 
    private String competencyName;
    private Long competencyId;

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
        if (!(object instanceof CourseCompetencies)) {
            return false;
        }
        CourseCompetencies other = (CourseCompetencies) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashthrims.domain.traininglist.CourseCompetencies[id=" + id + "]";
    }

    /**
     * @return the competencyName
     */
    public String getCompetencyName() {
        return competencyName;
    }

    /**
     * @param competencyName the competencyName to set
     */
    public void setCompetencyName(String competencyName) {
        this.competencyName = competencyName;
    }

    /**
     * @return the competencyId
     */
    public Long getCompetencyId() {
        return competencyId;
    }

    /**
     * @param competencyId the competencyId to set
     */
    public void setCompetencyId(Long competencyId) {
        this.competencyId = competencyId;
    }

    @Override
    public int compareTo(CourseCompetencies o) {
        return competencyName.compareTo(o.competencyName);
    }

}
