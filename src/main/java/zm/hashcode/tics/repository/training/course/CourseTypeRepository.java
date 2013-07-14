/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.repository.training.course;

import org.springframework.data.repository.PagingAndSortingRepository;
import zm.hashcode.tics.domain.training.course.CourseType;

/**
 *
 * @author boniface
 */

public interface CourseTypeRepository extends PagingAndSortingRepository<CourseType, String> {
   
}
