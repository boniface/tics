/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.repository.ui.location;

import org.springframework.data.repository.PagingAndSortingRepository;
import zm.hashcode.tics.domain.ui.location.Contact;

/**
 *
 * @author boniface
 */

public interface ContactListRepository extends PagingAndSortingRepository<Contact, String> {
   
}
