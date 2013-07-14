/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.repository.ui.location;

import org.springframework.data.repository.PagingAndSortingRepository;
import zm.hashcode.tics.domain.ui.location.Location;

/**
 *
 * @author boniface
 */

public interface LocationRepository extends PagingAndSortingRepository<Location, String> {
   
}
