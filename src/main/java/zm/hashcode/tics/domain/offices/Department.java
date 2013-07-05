/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.offices;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author boniface
 */
@Document
public final class Department implements Serializable {

    @Id
    private String id;
    private String name;

    private Department() {
    }

    private Department(Builder builder) {
        id = builder.id;
        name = builder.name;
    }

    public static class Builder {

        @Indexed(unique = true)
        private final String name;
        //optional 
        private String id;

        public Builder(String name) {
            this.name = name;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Department build() {
            return new Department(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
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
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clusters{" + "clusterName=" + name + '}';
    }
}
