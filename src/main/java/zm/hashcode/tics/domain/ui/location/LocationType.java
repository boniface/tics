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
public final class LocationType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @NotNull
    private String name;
    @NotNull
    private String code;

    private LocationType() {
    }

    private LocationType(Builder builder) {
        id = builder.id;
        name = builder.name;
        code = builder.code;

    }
    public static class Builder {
        private String id = null;
        private final String name;
        private String code = null;

        public Builder(String val) {
            this.name = val;
        }
        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder code(String value) {
            code = value;
            return this;
        }
        public LocationType build() {
            return new LocationType(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "LocationType{" + "name=" + name + ", code=" + code + '}';
    }
    
    
}
