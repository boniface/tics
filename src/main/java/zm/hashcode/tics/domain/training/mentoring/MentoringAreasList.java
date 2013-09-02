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
public class MentoringAreasList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String areasofStrenthening;

    private MentoringAreasList() {
    }

    private MentoringAreasList(Builder builder) {
        id = builder.id;
        areasofStrenthening = builder.areasofStrenthening;
    }

    public static class Builder {

        private String id;
        private String areasofStrenthening;

        public Builder(String val) {
            this.areasofStrenthening = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public MentoringAreasList build() {
            return new MentoringAreasList(this);
        }
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
        final MentoringAreasList other = (MentoringAreasList) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MentoringAreasList{" + "areasofStrenthening=" + areasofStrenthening + "}";
    }

    public String getId() {
        return id;
    }

    /**
     * @return the areasofStrenthening
     */
    public String getAreasofStrenthening() {
        return areasofStrenthening;
    }
}
