/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.repository.offices;

import org.springframework.data.repository.PagingAndSortingRepository;
import zm.hashcode.tics.domain.offices.Department;

/**
 *
 * @author boniface
 */

public interface DepartmentRepository extends PagingAndSortingRepository<Department, String> {
   
}
