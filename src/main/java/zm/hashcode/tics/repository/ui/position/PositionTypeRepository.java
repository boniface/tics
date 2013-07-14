/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.repository.ui.position;

import org.springframework.data.repository.PagingAndSortingRepository;
import zm.hashcode.tics.domain.ui.position.PositionType;

/**
 *
 * @author boniface
 */

public interface PositionTypeRepository extends PagingAndSortingRepository<PositionType, String> {
   
}
