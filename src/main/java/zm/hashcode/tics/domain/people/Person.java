/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.people;

import com.hashthrims.domain.regionlist.City;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 *
 * @author boniface
 */
@Document
public class Person implements Serializable, Comparable<Person> {
    private static long serialVersionUID = 1L;
    @Id
    private Long id;
    private String personName;
    private String personSurname;
    private String personOtherName;
    private City residence;

    private List<Contacts> contacts = new ArrayList<Contacts>();

    private Demography demography = new Demography();

    private List<EmployeePosition> position = new ArrayList<EmployeePosition>();
 
    private List<EmploymentHistory> employmentHistory = new ArrayList<EmploymentHistory>();

    private List<EducationHistory> educationHistory = new ArrayList<EducationHistory>();
 
    private List<Identities> identities = new ArrayList<Identities>();

    private List<ProfessionalRegistration> professionalRegistration = new ArrayList<ProfessionalRegistration>();

    private List<EmployeeCourses> courses = new ArrayList<EmployeeCourses>();

    private List<EmployeeLanguages> languages = new ArrayList<EmployeeLanguages>();

    private List<EmployeeMentoring> mentoring = new ArrayList<EmployeeMentoring>();
    @DBRef
    private List<Mentees> mentees = new ArrayList<Mentees>();

    private List<MentorExpertiseArea> expertiseArea = new ArrayList<MentorExpertiseArea>();

    private List<PersonRoles> personRoles = new ArrayList<PersonRoles>();

    private List<EmployeeActionPlan> actionPlans = new ArrayList<EmployeeActionPlan>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashthrims.domain.Person[id=" + getId() + "]";
    }

    /**
     * @return the personName
     */
    public String getPersonName() {
        return personName;
    }

    /**
     * @param personName the personName to set
     */
    public void setPersonName(String personName) {
        this.personName = personName;
    }

    /**
     * @return the personSurname
     */
    public String getPersonSurname() {
        return personSurname;
    }

    /**
     * @param personSurname the personSurname to set
     */
    public void setPersonSurname(String personSurname) {
        this.personSurname = personSurname;
    }

    /**
     * @return the personOtherName
     */
    public String getPersonOtherName() {
        return personOtherName;
    }

    /**
     * @param personOtherName the personOtherName to set
     */
    public void setPersonOtherName(String personOtherName) {
        this.personOtherName = personOtherName;
    }

    /**
     * @return the residence
     */
    public City getResidence() {
        return residence;
    }

    /**
     * @param residence the residence to set
     */
    public void setResidence(City residence) {
        this.residence = residence;
    }

    /**
     * @return the contacts
     */
    public List<Contacts> getContacts() {
        return contacts;
    }

    /**
     * @param contacts the contacts to set
     */
    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }

    /**
     * @return the demography
     */
    public Demography getDemography() {
        return demography;
    }

    /**
     * @param demography the demography to set
     */
    public void setDemography(Demography demography) {
        this.demography = demography;
    }

    /**
     * @return the position
     */
    public List<EmployeePosition> getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(List<EmployeePosition> position) {
        this.position = position;
    }

    /**
     * @return the employmentHistory
     */
    public List<EmploymentHistory> getEmploymentHistory() {
        return employmentHistory;
    }

    /**
     * @param employmentHistory the employmentHistory to set
     */
    public void setEmploymentHistory(List<EmploymentHistory> employmentHistory) {
        this.employmentHistory = employmentHistory;
    }

    /**
     * @return the educationHistory
     */
    public List<EducationHistory> getEducationHistory() {
        return educationHistory;
    }

    /**
     * @param educationHistory the educationHistory to set
     */
    public void setEducationHistory(List<EducationHistory> educationHistory) {
        this.educationHistory = educationHistory;
    }

    /**
     * @return the identities
     */
    public List<Identities> getIdentities() {
        return identities;
    }

    /**
     * @param identities the identities to set
     */
    public void setIdentities(List<Identities> identities) {
        this.identities = identities;
    }

    /**
     * @return the professionalRegistration
     */
    public List<ProfessionalRegistration> getProfessionalRegistration() {
        return professionalRegistration;
    }

    /**
     * @param professionalRegistration the professionalRegistration to set
     */
    public void setProfessionalRegistration(List<ProfessionalRegistration> professionalRegistration) {
        this.professionalRegistration = professionalRegistration;
    }

    /**
     * @return the languages
     */
    public List<EmployeeLanguages> getLanguages() {
        return languages;
    }

    /**
     * @param languages the languages to set
     */
    public void setLanguages(List<EmployeeLanguages> languages) {
        this.languages = languages;
    }

    /**
     * @return the courses
     */
    public List<EmployeeCourses> getCourses() {
        return courses;
    }

    /**
     * @param courses the courses to set
     */
    public void setCourses(List<EmployeeCourses> courses) {
        this.courses = courses;
    }

    /**
     * @return the mentoring
     */
    public List<EmployeeMentoring> getMentoring() {
        return mentoring;
    }

    /**
     * @param mentoring the mentoring to set
     */
    public void setMentoring(List<EmployeeMentoring> mentoring) {
        this.mentoring = mentoring;
    }

    @Override
    public int compareTo(Person o) {
        return personSurname.compareTo(o.personSurname);
    }

    /**
     * @return the mentees
     */
    public List<Mentees> getMentees() {
        return mentees;
    }

    /**
     * @param mentees the mentees to set
     */
    public void setMentees(List<Mentees> mentees) {
        this.mentees = mentees;
    }

    /**
     * @return the expertiseArea
     */
    public List<MentorExpertiseArea> getExpertiseArea() {
        return expertiseArea;
    }

    /**
     * @param expertiseArea the expertiseArea to set
     */
    public void setExpertiseArea(List<MentorExpertiseArea> expertiseArea) {
        this.expertiseArea = expertiseArea;
    }

    /**
     * @return the personRoles
     */
    public List<PersonRoles> getPersonRoles() {
        return personRoles;
    }

    /**
     * @param personRoles the personRoles to set
     */
    public void setPersonRoles(List<PersonRoles> personRoles) {
        this.personRoles = personRoles;
    }

    /**
     * @return the actionPlans
     */
    public List<EmployeeActionPlan> getActionPlans() {
        return actionPlans;
    }

    /**
     * @param actionPlans the actionPlans to set
     */
    public void setActionPlans(List<EmployeeActionPlan> actionPlans) {
        this.actionPlans = actionPlans;
    }
}
