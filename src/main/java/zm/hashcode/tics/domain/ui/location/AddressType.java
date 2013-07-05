/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zm.hashcode.tics.domain.ui.location;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author boniface
 */
@Document
public class AddressType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    //Home Address or Work Address 
    @NotNull
    private String addressTypeName;

    public String  getId() {
        return id;
    }

    public void setId(String  id) {
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
        if (!(object instanceof AddressType)) {
            return false;
        }
        AddressType other = (AddressType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashthrims.domain.regionlist.AddressType[id=" + id + "]";
    }

    /**
     * @return the addressTypeName
     */
    public String getAddressTypeName() {
        return addressTypeName;
    }

    /**
     * @param addressTypeName the addressTypeName to set
     */
    public void setAddressTypeName(String addressTypeName) {
        this.addressTypeName = addressTypeName;
    }

}
