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
public class FacilityGrouping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String node;
    private String cluster;
    

    private FacilityGrouping() {
    }
    
    private FacilityGrouping(Builder builder) {
        id = builder.id;
        node = builder.node;
        cluster = builder.cluster;
       
    }
    
    public static class Builder {
         //optional 
        private String id = null;
        private String node = null;
        private String cluster = null;
       
        public Builder(String cluster) {
            this.cluster = cluster;
        }
        
        public Builder id(String value) {
            id = value;
            return this;
        }
        
        public Builder node(String value) {
            node = value;
            return this;
        }
        
        public Builder cluster(String value) {
            cluster = value;
            return this;
        }
 
        
        public FacilityGrouping build() {
            return new FacilityGrouping(this);
        }
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
        if (!(object instanceof FacilityGrouping)) {
            return false;
        }
        FacilityGrouping other = (FacilityGrouping) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String getId() {
        return id;
    }

    public String getNode() {
        return node;
    }

    public String getCluster() {
        return cluster;
    }

    @Override
    public String toString() {
        return "FacilityGrouping{" + "node=" + node + ", cluster=" + cluster + '}';
    }

    
    
}
