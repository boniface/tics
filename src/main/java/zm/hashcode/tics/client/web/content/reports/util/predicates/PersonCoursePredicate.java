/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.reports.util.predicates;

import com.google.common.base.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import zm.hashcode.tics.app.facade.training.course.CourseFacade;
import zm.hashcode.tics.domain.people.EmployeeCourses;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.training.course.Course;

/**
 *
 * @author boniface
 */
public class PersonCoursePredicate implements Predicate<Person> {

    private final String courseId;
    private final Date startDate;
    private final Date endDate;

    public PersonCoursePredicate(String courseId, Date start, Date end) {
        this.courseId = courseId;
        this.startDate = start;
        this.endDate = end;
    }

    @Override
    public boolean apply(Person person) {
        Course course = CourseFacade.getCourseService().find(courseId);
        List<Course> personCourses = getCourses(person.getCourses());
        return personCourses.contains(course);
    }

    private List<Course> getCourses(List<EmployeeCourses> employeeCourseses) {
        List<Course> co = new ArrayList<>();
        for (EmployeeCourses ec : employeeCourseses) {
            if (startDate.before(ec.getCourseStartDate()) && endDate.after(ec.getCourseEndDate())) {
                co.add(ec.getScheduledCourse().getCourse());
            }
        }
        return co;
    }
}
