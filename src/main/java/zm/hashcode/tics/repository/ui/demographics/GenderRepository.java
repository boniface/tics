/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.repository.ui.demographics;

import org.springframework.data.repository.PagingAndSortingRepository;
import zm.hashcode.tics.domain.ui.demographics.Gender;

/**
 *
 * @author boniface
 */

public interface GenderRepository extends PagingAndSortingRepository<Gender, String> {
   
}
