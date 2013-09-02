/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training.mentoring;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author boniface
 */
@Document
public class SessionType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String sessionTypeName;

    private SessionType() {
    }

    private SessionType(Builder builder) {
        id = builder.id;
        sessionTypeName = builder.sessionTypeName;
    }

    public static class Builder {

        private String id;
        private String sessionTypeName;

        public Builder(String val) {
            this.sessionTypeName = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public SessionType build() {
            return new SessionType(this);
        }
    }

    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final SessionType other = (SessionType) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SessionType{" + "sessionTypeName=" + sessionTypeName + "}";
    }

    /**
     * @return the sessionTypeName
     */
    public String getSessionTypeName() {
        return sessionTypeName;
    }

    /**
     * @param sessionTypeName the sessionTypeName to set
     */
    public void setSessionTypeName(String sessionTypeName) {
        this.sessionTypeName = sessionTypeName;
    }
}
