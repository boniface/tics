/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.repository.ui.demographics;

import org.springframework.data.repository.PagingAndSortingRepository;
import zm.hashcode.tics.domain.ui.demographics.Title;

/**
 *
 * @author boniface
 */

public interface TitleRepository extends PagingAndSortingRepository<Title, String> {
   
}
