/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.ui.location;

import java.io.Serializable;

/**
 *
 * @author boniface
 */

public class LocationAddress implements Serializable {
    private String postalAddress;
    private String physicalAddress;
    private String contactNumber;
    private String postalCode;
    private String emailAddress;

     private TitleList() {
    }

    private TitleList(Builder builder) {
        id = builder.id;
        title = builder.title;
    }

    public static class Builder {

        private String id;
        private String title;

        public Builder(String val) {
            this.title = val;
        }

        public TitleList.Builder id(String value) {
            id = value;
            return this;
        }

        public TitleList build() {
            return new TitleList(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "TitleList{" + "title=" + title + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final TitleList other = (TitleList) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }