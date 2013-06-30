/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.test.repository.users;

import org.testng.annotations.Test;
import zm.hashcode.tics.domain.users.Users;
import zm.hashcode.tics.repository.users.UsersRepository;
import zm.hashcode.tics.test.AppTest;

/**
 *
 * @author boniface
 */
public class UsersTest extends AppTest{
    private UsersRepository usersRepository;
    private Long id;
    
    @Test
    public void testCreateUser(){
         System.out.println(" The Context  "+ctx.getBeanDefinitionCount());
        usersRepository = (UsersRepository)ctx.getBean("usersRepository");
        System.out.println(" THE REPO IS "+usersRepository);
        Users user = new Users();
        user.setEmail("boniface@kabaso.com");
        user.setFirstname("Boniface");
        usersRepository.save(user);
        
        
    }
    
}
