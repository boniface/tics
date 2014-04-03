/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.people;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.ui.demographics.Title;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.services.people.predicates.PersonPositionPredicate;

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
    private List<Contact> contacts = new ArrayList<>();
    private Demography demography;
    private List<EmployeePosition> positions = new ArrayList<>();
    private List<EducationHistory> educationHistory = new ArrayList<>();
    private List<ProfessionalRegistration> professionalRegistration = new ArrayList<>();
    private List<EmployeeLanguages> languages = new ArrayList<>();
    private List<MentorExpertiseArea> mentorExpertiseAreas = new ArrayList<>();
    private List<PersonRoles> personRoles = new ArrayList<>();
    @DBRef(lazy = true)
    private List<EmployeeCourses> courses = new ArrayList<>();
    @DBRef(lazy = true)
    private List<EmployeeActionPlan> actionPlans = new ArrayList<>();
    @DBRef(lazy = true)
    private List<EmployeeMentoring> mentoring = new ArrayList<>();
    @DBRef(lazy = true)
    private List<Person> mentees = new ArrayList<>();
    @DBRef(lazy = true)
    private List<PersonIdentities> identities = new ArrayList<>();
    @DBRef(lazy = false)
    private Facility facility;
    @DBRef(lazy = true)
    private Title title;
    private List<String> files;
    private String employeeImage;

    public List<String> getFiles() {
        return files;
    }
    

    public void setFiles(List<String> files) {
        this.files = files;
    }

    public String getEmployeeImage() {
        return employeeImage;
    }

    public void setEmployeeImage(String employeeImage) {
        this.employeeImage = employeeImage;
    }
    
    

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
        title = builder.title;

    }

    public static class Builder {

        private String id;
        private Title title;
        private final String firstname;
        private final String surname;
        private String othername;
        private Location residence;
        private Demography demography;
        private Facility facility;
        private List<Contact> contacts = new ArrayList<>();
        private List<EmployeePosition> positions = new ArrayList<>();
        private List<EducationHistory> educationHistory = new ArrayList<>();
        private List<PersonIdentities> identities = new ArrayList<>();
        private List<ProfessionalRegistration> professionalRegistration = new ArrayList<>();
        private List<EmployeeCourses> courses = new ArrayList<>();
        private List<EmployeeLanguages> languages = new ArrayList<>();
        private List<EmployeeMentoring> mentoring = new ArrayList<>();
        private List<Person> mentees = new ArrayList<>();
        private List<MentorExpertiseArea> mentorExpertiseAreas = new ArrayList<>();
        private List<PersonRoles> personRoles = new ArrayList<>();
        private List<EmployeeActionPlan> actionPlans = new ArrayList<>();

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

        public Builder title(Title value) {
            title = value;
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

        public Builder identities(List<PersonIdentities> value) {
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

        public Builder mentees(List<Person> value) {
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

        public Builder contacts(List<Contact> value) {
            contacts = value;
            return this;
        }

        public Builder person(Person person) {
            id = person.getId();
            othername = person.getOthername();
            residence = person.getResidence();
            contacts = person.getContacts();
            demography = person.getDemography();
            facility = person.getFacility();
            positions = person.getPositions();
            educationHistory = person.getEducationHistory();
            identities = person.getIdentities();
            professionalRegistration = person.getProfessionalRegistration();
            courses = person.getCourses();
            languages = person.getLanguages();
            mentoring = person.getMentoring();
            mentees = person.getMentees();
            mentorExpertiseAreas = person.getMentorExpertiseAreas();
            personRoles = person.getPersonRoles();
            actionPlans = person.getActionPlans();
            title = person.getTitle();
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

    public Title getTitle() {
        return title;
    }

    public Location getResidence() {
        return residence;
    }

    public List<Contact> getContacts() {
        return ImmutableList.copyOf(contacts);
    }

    public Demography getDemography() {
        return demography;
    }

    public Facility getFacility() {
        return facility;
    }

    public List<EmployeePosition> getPositions() {
        return ImmutableList.copyOf(positions);
    }

    public List<EducationHistory> getEducationHistory() {
        return educationHistory;
    }

    public List<PersonIdentities> getIdentities() {
        return ImmutableList.copyOf(identities);
    }

    public List<ProfessionalRegistration> getProfessionalRegistration() {
        return ImmutableList.copyOf(professionalRegistration);
    }

    public List<EmployeeCourses> getCourses() {
        return ImmutableList.copyOf(courses);
    }

    public List<EmployeeLanguages> getLanguages() {
        return ImmutableList.copyOf(languages);
    }

    public List<EmployeeMentoring> getMentoring() {
        return ImmutableList.copyOf(mentoring);
    }

    public List<Person> getMentees() {
        return ImmutableList.copyOf(mentees);
    }

    public List<MentorExpertiseArea> getMentorExpertiseAreas() {
        return ImmutableList.copyOf(mentorExpertiseAreas);
    }

    public List<PersonRoles> getPersonRoles() {
        return ImmutableList.copyOf(personRoles);
    }

    public List<EmployeeActionPlan> getActionPlans() {
        return ImmutableList.copyOf(actionPlans);
    }

    public String getCurrentPosition() {
        Collection<EmployeePosition> pos = Collections2.filter(getPositions(), new PersonPositionPredicate());

        if (pos.size() > 0) {
            EmployeePosition employeePosition = pos.iterator().next();
            if (employeePosition != null) {
                return employeePosition.getStatus();
            }

        }

        return null;
    }
}
