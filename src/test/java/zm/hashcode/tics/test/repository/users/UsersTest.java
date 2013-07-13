        /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.test.repository.users;

import zm.hashcode.tics.test.AppTest;
//import static zm.hashcode.tics.test.AppTest.ctx;

/**
 *
 * @author boniface
 */

public class UsersTest extends AppTest {

//    private UsersRepository repository;
//    private RolesListRepository rolesListRepository;
//    private String id;
//    
//    @Test
//    public void testCreate() {
//        repository = ctx.getBean(UsersRepository.class);
//        rolesListRepository = ctx.getBean(RolesListRepository.class);
//        RolesList rolesList1 = new RolesList.Builder("ROLE_ADMIN").description("System Administration").build();
//        RolesList rolesList2 = new RolesList.Builder("ROLE_ADMIN").description("System Administration").build();
//        rolesListRepository.save(rolesList1);
//        rolesListRepository.save(rolesList2);
//        
//        Role role1 = new Role.Builder(rolesList1).build();
//        Role role2 = new Role.Builder(rolesList2).build();
//        
//        List<Role> roles = new ArrayList<>();
//        roles.add(role2);
//        roles.add(role1);
//        
//        User user = new User.Builder("admin1@test.com").enable(true)
//                                                        .firstname("Boniface")
//                                                        .lastname("chanda")
//                                                        .middlename("lulu")
//                                                        .passwd("test123")
//                                                        .roles(roles).build();
//        repository.save(user);
//        id = user.getId();
//        
//        Assert.assertNotNull(user);
//    }
//    
////    @Test(dependsOnMethods = "testCreate")
//    public void testRead() {
//        repository = ctx.getBean(UsersRepository.class);
//        User role = repository.findOne(id);
//        Assert.assertEquals(role.getEmail(), "System Adminiatrator");
//        
//    }
//    
////    @Test(dependsOnMethods = {"testRead"})
//    public void testUpdate() {
//        repository = ctx.getBean(UsersRepository.class);
//        User role = repository.findOne(id);
//        User newrole = new User.Builder("admin@test.com").enable(true)
//                                                        .firstname("Boniface").id(role.getId())
//                                                        .lastname("chanda")
//                                                        .middlename("lulu")
//                                                        .passwd("test123")
//                                                        .roles(role.getRoles()).build();
//        repository.save(newrole);
//        User upDaterole = repository.findOne(id);
//        Assert.assertEquals(upDaterole.getEmail(), "Adminiatrator");
//    }
//    
////    @Test(dependsOnMethods = {"testUpdate"})
//    public void testDelete() {
//        repository = ctx.getBean(UsersRepository.class);
//        User role = repository.findOne(id);
//        repository.delete(role);
//        User deletedRole = repository.findOne(id);
//        Assert.assertNull(deletedRole);
//    }
//    
}
