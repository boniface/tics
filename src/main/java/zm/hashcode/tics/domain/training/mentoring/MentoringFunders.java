/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training.mentoring;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import zm.hashcode.tics.domain.ui.util.Funder;

/**
 *
 * @author boniface
 */
@Document
public class MentoringFunders implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    private String id;
    private String fundersName;
    @DBRef
    private Funder funder;

    private MentoringFunders() {
    }

    private MentoringFunders(Builder builder) {
        id = builder.id;
        fundersName = builder.fundersName;
        funder = builder.funder;
    }

    public static class Builder {

        private String id;
        private String fundersName;
        private Funder funder;

        public Builder(String val) {
            this.fundersName = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder funder(Funder value) {
            funder = value;
            return this;
        }

        public MentoringFunders build() {
            return new MentoringFunders(this);
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
        final MentoringFunders other = (MentoringFunders) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MentoringFunders{" + "fundersName=" + fundersName + "}";
    }

    public String getId() {
        return id;
    }

    /**
     * @return the fundersName
     */
    public String getFundersName() {
        return fundersName;
    }

    public Funder getFunder() {
        return funder;
    }
}
