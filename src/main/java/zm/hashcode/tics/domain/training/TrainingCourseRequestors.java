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

public class TrainingCourseRequestors implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String requestorName;

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
        if (!(object instanceof TrainingCourseRequestors)) {
            return false;
        }
        TrainingCourseRequestors other = (TrainingCourseRequestors) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashthrims.domain.traininglist.TrainingCourseRequestors[id=" + id + "]";
    }

    /**
     * @return the requestorName
     */
    public String getRequestorName() {
        return requestorName;
    }

    /**
     * @param requestorName the requestorName to set
     */
    public void setRequestorName(String requestorName) {
        this.requestorName = requestorName;
    }

}
