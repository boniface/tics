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

public class CourseFunders implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String fundersName;
    private Long fundersId;

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
        if (!(object instanceof CourseFunders)) {
            return false;
        }
        CourseFunders other = (CourseFunders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashthrims.domain.traininglist.CourseFunders[id=" + id + "]";
    }

    /**
     * @return the fundersName
     */
    public String getFundersName() {
        return fundersName;
    }

    /**
     * @param fundersName the fundersName to set
     */
    public void setFundersName(String fundersName) {
        this.fundersName = fundersName;
    }

    /**
     * @return the fundersId
     */
    public Long getFundersId() {
        return fundersId;
    }

    /**
     * @param fundersId the fundersId to set
     */
    public void setFundersId(Long fundersId) {
        this.fundersId = fundersId;
    }

}
