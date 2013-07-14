/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.repository.ui.util;

import org.springframework.data.repository.PagingAndSortingRepository;
import zm.hashcode.tics.domain.ui.util.Funder;

/**
 *
 * @author boniface
 */

public interface FunderRepository extends PagingAndSortingRepository<Funder, String> {
   
}
