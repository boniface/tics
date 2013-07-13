/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training.schedule;

import zm.hashcode.tics.domain.training.course.Course;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.springframework.data.mongodb.core.mapping.DBRef;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.training.institutions.TrainingInstructors;
import zm.hashcode.tics.domain.ui.location.Location;

/**
 *
 * @author boniface
 */
public class ScheduledCourse implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private int courseCapacity;
    private int creditHours;
    private Date startDate;
    private Date endDate;
    private Course course;
    private String venue;
    private Location location;
    private Set<Person> participants;
    @DBRef
    private List<TrainingInstructors> classInstructors;
    private String notes;
    private List<CourseFunders> courseFunders;
}
