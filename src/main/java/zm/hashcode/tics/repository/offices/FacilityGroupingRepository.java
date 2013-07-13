/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.repository.offices;

import org.springframework.data.repository.PagingAndSortingRepository;
import zm.hashcode.tics.domain.offices.FacilityGrouping;

/**
 *
 * @author boniface
 */

public interface FacilityGroupingRepository extends PagingAndSortingRepository<FacilityGrouping, String> {
   
}
