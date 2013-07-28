        /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.test.repository.users;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.testng.Assert;
import zm.hashcode.tics.app.security.PasswordEncrypt;
import zm.hashcode.tics.domain.ui.demographics.Role;
import zm.hashcode.tics.domain.users.User;
import zm.hashcode.tics.repository.ui.demographics.RoleRepository;
import zm.hashcode.tics.repository.users.UsersRepository;
import zm.hashcode.tics.test.AppTest;
//import static zm.hashcode.tics.test.AppTest.ctx;

/**
 *
 * @author boniface
 */

public class UsersTest extends AppTest {

    private UsersRepository usersRepository;
    private RoleRepository roleRepository;
    private String userId;
    private String roleId;
    
//    @Test
    public void testCreate() {
        usersRepository = ctx.getBean(UsersRepository.class);
        roleRepository = ctx.getBean(RoleRepository.class);
        Role role = new Role.Builder("ROLE_ADMIN").description("System Administration").build();
        roleRepository.save(role);
        Set<Role> roles = new HashSet<>();
        roles.add(role);   
        String password = PasswordEncrypt.encrypt("pass");
        User user = new User.Builder("pass").enable(true)
                                                        .firstname("Admin")
                                                        .lastname("chanda")
                                                        .middlename("lulu")
                                                        .passwd(password)
                                                        .roles(roles).build();
        usersRepository.save(user);
        userId = user.getId();
        
        Assert.assertNotNull(user);
    }
    
//    @Test(dependsOnMethods = "testCreate")
    public void testRead() {
        usersRepository = ctx.getBean(UsersRepository.class);
        User role = usersRepository.findOne(userId);
        Assert.assertEquals(role.getEmail(), "System Adminiatrator");
        
    }
    
//    @Test(dependsOnMethods = {"testRead"})
    public void testUpdate() {
        usersRepository = ctx.getBean(UsersRepository.class);
        User role = usersRepository.findOne(userId);
        User newrole = new User.Builder("admin@test.com").enable(true)
                                                        .firstname("Boniface").id(role.getId())
                                                        .lastname("chanda")
                                                        .middlename("lulu")
                                                        .passwd("test123")
                                                        .roles(role.getRoles()).build();
        usersRepository.save(newrole);
        User upDaterole = usersRepository.findOne(userId);
        Assert.assertEquals(upDaterole.getEmail(), "Adminiatrator");
    }
    
//    @Test(dependsOnMethods = {"testUpdate"})
    public void testDelete() {
        usersRepository = ctx.getBean(UsersRepository.class);
        User role = usersRepository.findOne(userId);
        usersRepository.delete(role);
        User deletedRole = usersRepository.findOne(userId);
        Assert.assertNull(deletedRole);
    }
    
}
