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

public class MentoringSessionTheme implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long sessionMentoringTheme;

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
        if (!(object instanceof MentoringSessionTheme)) {
            return false;
        }
        MentoringSessionTheme other = (MentoringSessionTheme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashthrims.domain.traininglist.MentoringSessionTheme[ id=" + id + " ]";
    }

    /**
     * @return the sessionMentoringTheme
     */
    public Long getSessionMentoringTheme() {
        return sessionMentoringTheme;
    }

    /**
     * @param sessionMentoringTheme the sessionMentoringTheme to set
     */
    public void setSessionMentoringTheme(Long sessionMentoringTheme) {
        this.sessionMentoringTheme = sessionMentoringTheme;
    }
    
}
