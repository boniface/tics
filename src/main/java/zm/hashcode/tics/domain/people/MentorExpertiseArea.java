/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.people;

import java.io.Serializable;

/**
 *
 * @author boniface
 */
public final class MentorExpertiseArea implements Serializable {

    private static final long serialVersionUID = 1L;
    private String expertiseAreaName;

    private MentorExpertiseArea() {
    }

    private MentorExpertiseArea(Builder builder) {
        expertiseAreaName = builder.expertiseAreaName;
    }

    public static class Builder {

        private final String expertiseAreaName;

        public Builder(String val) {
            this.expertiseAreaName = val;
        }

        public MentorExpertiseArea build() {
            return new MentorExpertiseArea(this);
        }
    }

    public String getExpertiseAreaName() {
        return expertiseAreaName;
    }
}
