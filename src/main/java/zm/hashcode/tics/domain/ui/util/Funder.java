/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.ui.util;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.ui.location.LocationAddress;

/**
 *
 * @author boniface
 */
@Document
public class Funder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String trainingFunderName;
    private String costCenter;
    @DBRef
    private Location city;
    private LocationAddress contact;

    public String getId() {
        return id;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Location getCity() {
        return city;
    }

    public void setCity(Location city) {
        this.city = city;
    }

    public LocationAddress getContact() {
        return contact;
    }

    public void setContact(LocationAddress contact) {
        this.contact = contact;
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
        if (!(object instanceof Funder)) {
            return false;
        }
        Funder other = (Funder) object;
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
}
