/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zm.hashcode.tics.domain.offices;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author boniface
 */
@Document
public final class FacilityType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String facilityName;
    
    private FacilityType() {
    }
    
    private FacilityType(Builder builder) {
        id = builder.id;
        facilityName = builder.facilityName;
    }
    
    public static class Builder {
        
        private final String facilityName;
        //optional 
        private String id = null;
   


        public Builder(String facilityName) {
            this.facilityName = facilityName;
        }
        
        public Builder id(String value) {
            id = value;
            return this;
        }

        public FacilityType build() {
            return new FacilityType(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getFacilityName() {
        return facilityName;
    }

    @Override
    public String toString() {
        return "FacilityType{" + "id=" + id + ", facilityName=" + facilityName + '}';
    }
    
    


}
