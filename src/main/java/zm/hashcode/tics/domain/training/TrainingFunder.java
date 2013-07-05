/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training;

import java.io.Serializable;
import zm.hashcode.tics.domain.people.Contacts;
import zm.hashcode.tics.domain.ui.location.Location;

/**
 *
 * @author boniface
 */

public class TrainingFunder implements Serializable {

    private static final long serialVersionUID = 1L;
  
    private Long id;
    private String trainingFunderName;
 
    private Location  city;
 
    private Contacts contact;

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
        if (!(object instanceof TrainingFunder)) {
            return false;
        }
        TrainingFunder other = (TrainingFunder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashthrims.domain.traininglist.TrainingFunder[id=" + id + "]";
    }

    /**
     * @return the trainingFunderName
     */
    public String getTrainingFunderName() {
        return trainingFunderName;
    }

    /**
     * @param trainingFunderName the trainingFunderName to set
     */
    public void setTrainingFunderName(String trainingFunderName) {
        this.trainingFunderName = trainingFunderName;
    }


    /**
     * @return the contact
     */
    public Contacts getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(Contacts contact) {
        this.contact = contact;
    }

    
}
