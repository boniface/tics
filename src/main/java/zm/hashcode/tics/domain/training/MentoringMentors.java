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

public class MentoringMentors implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long mentorsId;

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
        if (!(object instanceof MentoringMentors)) {
            return false;
        }
        MentoringMentors other = (MentoringMentors) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashthrims.domain.traininglist.MentoringMentors[id=" + id + "]";
    }

    /**
     * @return the mentorsId
     */
    public Long getMentorsId() {
        return mentorsId;
    }

    /**
     * @param mentorsId the mentorsId to set
     */
    public void setMentorsId(Long mentorsId) {
        this.mentorsId = mentorsId;
    }

}
