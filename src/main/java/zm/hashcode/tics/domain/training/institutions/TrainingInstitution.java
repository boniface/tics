/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training.institutions;


import zm.hashcode.tics.domain.training.schedule.ScheduledCourse;
import zm.hashcode.tics.domain.training.course.Course;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.DBRef;
import zm.hashcode.tics.domain.people.Contacts;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.users.Users;

/**
 *
 * @author boniface
 */

public class TrainingInstitution implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String trainingInstitution;
    private Location city;
    private Contacts contact;
    @DBRef
    private List<Users> users;
    @DBRef
    private List<TrainingInstructors> trainingInstructors;
    @DBRef
    private List<Course> courses;
    @DBRef List<ScheduledCourse> scheduledCourseses;
    
   
}
