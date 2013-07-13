/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.offices;

import java.io.Serializable;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author boniface
 */
@Document
public final class Cluster implements Serializable {

    private String id;
    private String clusterName;

    private Cluster() {
    }

    private Cluster(Builder builder) {
        id = builder.id;
        clusterName = builder.clusterName;
    }

    public static class Builder {

        @Indexed(unique = true)
        private final String clusterName;
        //optional 
        private String id;

        public Builder(String clusterName) {
            this.clusterName = clusterName;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Cluster build() {
            return new Cluster(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getClusterName() {
        return clusterName;
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
        if (!(object instanceof Cluster)) {
            return false;
        }
        Cluster other = (Cluster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clusters{" + "clusterName=" + clusterName + '}';
    }
}
