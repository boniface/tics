/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.repository.ui.position;

import org.springframework.data.repository.PagingAndSortingRepository;
import zm.hashcode.tics.domain.ui.position.DepartureReason;

/**
 *
 * @author boniface
 */

public interface DepartureReasonRepository extends PagingAndSortingRepository<DepartureReason, String> {
   
}
