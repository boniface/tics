/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.repository.people;

import org.springframework.data.repository.PagingAndSortingRepository;
import zm.hashcode.tics.domain.people.EmployeeCourses;

/**
 *
 * @author boniface
 */

public interface EmployeeCoursesRepository extends PagingAndSortingRepository<EmployeeCourses, String> {
   
}
