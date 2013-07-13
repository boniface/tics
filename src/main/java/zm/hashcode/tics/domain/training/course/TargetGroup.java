/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training.course;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author boniface
 */
@Document
public final class TargetGroup implements Serializable {
    @Id
    private String id;
    private String name;

    private TargetGroup() {
    }

    private TargetGroup(Builder builder) {
        id = builder.id;
        name = builder.name;

    }

    public static class Builder {

        private String id;
        private final String name;

        public Builder(String val) {
            this.name = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public TargetGroup build() {
            return new TargetGroup(this);
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
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final TargetGroup other = (TargetGroup) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "TargetGroup{" + "name=" + name + '}';
    }
}
