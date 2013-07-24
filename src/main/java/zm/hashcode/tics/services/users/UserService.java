/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.users;

import zm.hashcode.tics.domain.users.User;
import zm.hashcode.tics.services.Services;

/**
 *
 * @author boniface
 */

public interface UserService extends Services<User,String>{
    public User findByEmail(String email);
  
}
