        /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.test.repository.users;

import java.util.ArrayList;
import java.util.List;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import zm.hashcode.tics.domain.ui.demographics.RolesList;
import zm.hashcode.tics.domain.users.Roles;
import zm.hashcode.tics.domain.users.Users;
import zm.hashcode.tics.repository.ui.demographics.RolesListRepository;
import zm.hashcode.tics.repository.users.UsersRepository;
import zm.hashcode.tics.test.AppTest;
import static zm.hashcode.tics.test.AppTest.ctx;

/**
 *
 * @author boniface
 */
@ContextConfiguration
public class UsersTest extends AppTest {

    private UsersRepository repository;
    private RolesListRepository rolesListRepository;
    private String id;
    
    @Test
    public void testCreate() {
        repository = ctx.getBean(UsersRepository.class);
        rolesListRepository = ctx.getBean(RolesListRepository.class);
        RolesList rolesList1 = new RolesList.Builder("ROLE_ADMIN").description("System Administration").build();
        RolesList rolesList2 = new RolesList.Builder("ROLE_ADMIN").description("System Administration").build();
        rolesListRepository.save(rolesList1);
        rolesListRepository.save(rolesList2);
        
        Roles role1 = new Roles.Builder(rolesList1).build();
        Roles role2 = new Roles.Builder(rolesList2).build();
        
        List<Roles> roles = new ArrayList<>();
        roles.add(role2);
        roles.add(role1);
        
        Users user = new Users.Builder("admin@test.com").enable(true)
                                                        .firstname("Boniface")
                                                        .lastname("chanda")
                                                        .middlename("lulu")
                                                        .passwd("test123")
                                                        .roles(roles).build();
        repository.save(user);
        id = user.getId();
        
        Assert.assertNotNull(user);
    }
    
//    @Test(dependsOnMethods = "testCreate")
    public void testRead() {
        repository = ctx.getBean(UsersRepository.class);
        Users role = repository.findOne(id);
        Assert.assertEquals(role.getEmail(), "System Adminiatrator");
        
    }
    
//    @Test(dependsOnMethods = {"testRead"})
    public void testUpdate() {
        repository = ctx.getBean(UsersRepository.class);
        Users role = repository.findOne(id);
        Users newrole = new Users.Builder("admin@test.com").enable(true)
                                                        .firstname("Boniface").id(role.getId())
                                                        .lastname("chanda")
                                                        .middlename("lulu")
                                                        .passwd("test123")
                                                        .roles(role.getRoles()).build();
        repository.save(newrole);
        Users upDaterole = repository.findOne(id);
        Assert.assertEquals(upDaterole.getEmail(), "Adminiatrator");
    }
    
//    @Test(dependsOnMethods = {"testUpdate"})
    public void testDelete() {
        repository = ctx.getBean(UsersRepository.class);
        Users role = repository.findOne(id);
        repository.delete(role);
        Users deletedRole = repository.findOne(id);
        Assert.assertNull(deletedRole);
    }
    
}
