/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import zm.hashcode.tics.domain.people.Contacts;
import zm.hashcode.tics.domain.ui.location.Location;

/**
 *
 * @author boniface
 */

public class TrainingInstitution implements Serializable {

    private static final long serialVersionUID = 1L;
 
    private Long id;
    private String trainingInstitution;
   
    private Location city;
   
    private Contacts contact;
   
    private List<OrganisationTrainers> organisationTrainers = new ArrayList<OrganisationTrainers>();

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
        if (!(object instanceof TrainingInstitution)) {
            return false;
        }
        TrainingInstitution other = (TrainingInstitution) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashthrims.domain.traininglist.TrainingInstitution[id=" + id + "]";
    }

    /**
     * @return the trainingInstitution
     */
    public String getTrainingInstitution() {
        return trainingInstitution;
    }

    /**
     * @param trainingInstitution the trainingInstitution to set
     */
    public void setTrainingInstitution(String trainingInstitution) {
        this.trainingInstitution = trainingInstitution;
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

    /**
     * @return the organisationTrainers
     */
    public List<OrganisationTrainers> getOrganisationTrainers() {
        return organisationTrainers;
    }

    /**
     * @param organisationTrainers the organisationTrainers to set
     */
    public void setOrganisationTrainers(List<OrganisationTrainers> organisationTrainers) {
        this.organisationTrainers = organisationTrainers;
    }
}
