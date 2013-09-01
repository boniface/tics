/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training.schedule;

import java.io.Serializable;

/**
 *
 * @author boniface
 */
public class CourseRating implements Serializable {

    private int rating;
    private String comments;

    private CourseRating() {
    }

    private CourseRating(Builder builder) {
        rating = builder.rating;
        comments = builder.comments;
    }

    public static class Builder {

        private int rating;
        private String comments;

        public Builder(int val) {
            this.rating = val;
        }

        public Builder comments(String value) {
            comments = value;
            return this;
        }

        public CourseRating build() {
            return new CourseRating(this);
        }
    }

    public int getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }
}
