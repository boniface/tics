/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zm.hashcode.tics.domain.ui.location;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author boniface
 */
@Document
public final class AddressType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    //Home Address or Work Address 
    @NotNull
    private String addressTypeName;

   private AddressType() {
    }

    private AddressType(Builder builder) {
        id = builder.id;
        addressTypeName = builder.addressTypeName;
    }

    public static class Builder {

        private String id;
        private String addressTypeName;

        public Builder(String val) {
            this.addressTypeName = val;
        }

        public AddressType.Builder id(String value) {
            id = value;
            return this;
        }

        public AddressType build() {
            return new AddressType(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getAddressTypeName() {
        return addressTypeName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AddressType other = (AddressType) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AddressType{" + "addressTypeName=" + addressTypeName + '}';
    }

}