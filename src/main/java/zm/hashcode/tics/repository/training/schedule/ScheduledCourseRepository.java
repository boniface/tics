/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.repository.training.schedule;

import org.springframework.data.repository.PagingAndSortingRepository;
import zm.hashcode.tics.domain.training.schedule.ScheduledCourse;

/**
 *
 * @author boniface
 */

public interface ScheduledCourseRepository extends PagingAndSortingRepository<ScheduledCourse, String> {
   
}
