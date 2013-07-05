/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.repository.users;

import org.springframework.data.repository.PagingAndSortingRepository;
import zm.hashcode.tics.domain.users.Users;

/**
 *
 * @author boniface
 */

public interface UsersRepository extends PagingAndSortingRepository<Users, String> {
   
}
