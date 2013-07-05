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

public class MentoringFunders implements Serializable {
    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
 
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
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MentoringFunders)) {
            return false;
        }
        MentoringFunders other = (MentoringFunders) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashthrims.domain.traininglist.MentoringFunders[id=" + getId() + "]";
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
