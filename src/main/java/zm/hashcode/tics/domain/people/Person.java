/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.people;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.ui.location.Location;

/**
 *
 * @author boniface
 */
@Document
public class Person implements Serializable, Comparable<Person> {

    private static long serialVersionUID = 1L;
    @Id
    private String id;
    private String firstname;
    private String surname;
    private String othername;
    private Location residence;
    private List<Contacts> contacts;
    private Demography demography;
    @DBRef
    private Facility facility;
    private List<EmployeePosition> positions;
    private List<EducationHistory> educationHistory;
    private List<Identities> identities;
    private List<ProfessionalRegistration> professionalRegistration;
    private List<EmployeeCourses> courses;
    private List<EmployeeLanguages> languages;
    @DBRef
    private List<EmployeeMentoring> mentoring;
    @DBRef
    private List<Mentees> mentees;
    private List<MentorExpertiseArea> mentorExpertiseAreas;
    private List<PersonRoles> personRoles;
    private List<EmployeeActionPlan> actionPlans;

    private Person() {
    }

    private Person(Builder builder) {
        id = builder.id;
        firstname = builder.firstname;
        surname = builder.surname;
        othername = builder.othername;
        residence = builder.residence;
        contacts = builder.contacts;
        demography = builder.demography;
        facility = builder.facility;
        positions = builder.positions;
        educationHistory = builder.educationHistory;
        identities = builder.identities;
        professionalRegistration = builder.professionalRegistration;
        courses = builder.courses;
        languages = builder.languages;
        mentoring = builder.mentoring;
        mentees = builder.mentees;
        mentorExpertiseAreas = builder.mentorExpertiseAreas;
        personRoles = builder.personRoles;
        actionPlans = builder.actionPlans;

    }

    public static class Builder {

        private String id;
        private final String firstname;
        private final String surname;
        private String othername;
        private Location residence;
        private Demography demography;
        private Facility facility;
        private List<Contacts> contacts;
        private List<EmployeePosition> positions;
        private List<EducationHistory> educationHistory;
        private List<Identities> identities;
        private List<ProfessionalRegistration> professionalRegistration;
        private List<EmployeeCourses> courses;
        private List<EmployeeLanguages> languages;
        private List<EmployeeMentoring> mentoring;
        private List<Mentees> mentees;
        private List<MentorExpertiseArea> mentorExpertiseAreas;
        private List<PersonRoles> personRoles;
        private List<EmployeeActionPlan> actionPlans;

        public Builder(String firstname, String surname) {
            this.firstname = firstname;
            this.surname = surname;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder othername(String value) {
            othername = value;
            return this;
        }

        public Builder residence(Location value) {
            residence = value;
            return this;
        }

        public Builder demography(Demography value) {
            demography = value;
            return this;
        }

        public Builder facility(Facility value) {
            facility = value;
            return this;
        }

        public Builder identities(List<Identities> value) {
            identities = value;
            return this;
        }

        public Builder positions(List<EmployeePosition> value) {
            positions = value;
            return this;
        }

        public Builder educationHistory(List<EducationHistory> value) {
            educationHistory = value;
            return this;
        }

        public Builder professionalRegistration(List<ProfessionalRegistration> value) {
            professionalRegistration = value;
            return this;
        }

        public Builder courses(List<EmployeeCourses> value) {
            courses = value;
            return this;
        }

        public Builder languages(List<EmployeeLanguages> value) {
            languages = value;
            return this;
        }

        public Builder mentoring(List<EmployeeMentoring> value) {
            mentoring = value;
            return this;
        }

        public Builder mentees(List<Mentees> value) {
            mentees = value;
            return this;
        }

        public Builder mentorExpertiseAreas(List<MentorExpertiseArea> value) {
            mentorExpertiseAreas = value;
            return this;
        }

        public Builder personRoles(List<PersonRoles> value) {
            personRoles = value;
            return this;
        }

        public Builder actionPlans(List<EmployeeActionPlan> value) {
            actionPlans = value;
            return this;
        }

        public Builder contacts(List<Contacts> value) {
            contacts = value;
            return this;
        }

        public Person build() {
            return new Person(this);
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
        final Person other = (Person) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "firstname=" + firstname + ", surname=" + surname + '}';
    }

    @Override
    public int compareTo(Person o) {
        return surname.compareTo(o.surname);
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getOthername() {
        return othername;
    }

    public Location getResidence() {
        return residence;
    }

    public List<Contacts> getContacts() {
        return contacts;
    }

    public Demography getDemography() {
        return demography;
    }

    public Facility getFacility() {
        return facility;
    }

    public List<EmployeePosition> getPositions() {
        return positions;
    }

    public List<EducationHistory> getEducationHistory() {
        return educationHistory;
    }

    public List<Identities> getIdentities() {
        return identities;
    }

    public List<ProfessionalRegistration> getProfessionalRegistration() {
        return professionalRegistration;
    }

    public List<EmployeeCourses> getCourses() {
        return courses;
    }

    public List<EmployeeLanguages> getLanguages() {
        return languages;
    }

    public List<EmployeeMentoring> getMentoring() {
        return mentoring;
    }

    public List<Mentees> getMentees() {
        return mentees;
    }

    public List<MentorExpertiseArea> getMentorExpertiseAreas() {
        return mentorExpertiseAreas;
    }

    public List<PersonRoles> getPersonRoles() {
        return personRoles;
    }

    public List<EmployeeActionPlan> getActionPlans() {
        return actionPlans;
    }
    
    
}
