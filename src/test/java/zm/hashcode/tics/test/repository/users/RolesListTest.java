/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.test.repository.users;

import org.testng.Assert;
import org.testng.annotations.Test;
import zm.hashcode.tics.domain.ui.demographics.RolesList;
import zm.hashcode.tics.repository.ui.demographics.RolesListRepository;
import zm.hashcode.tics.test.AppTest;
import static zm.hashcode.tics.test.AppTest.ctx;

/**
 *
 * @author boniface
 */
public class RolesListTest extends AppTest {

    private RolesListRepository repository;
    private String id;

    @Test
    public void testCreate() {
        repository = ctx.getBean(RolesListRepository.class);
        RolesList role = new RolesList.Builder("ROLE_ADMIN")
                .description("System Adminiatrator").build();
        repository.save(role);
        id = role.getId();
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() {
        repository = ctx.getBean(RolesListRepository.class);
        RolesList role = repository.findOne(id);
        Assert.assertEquals(role.getDescription(), "System Adminiatrator");

    }

    @Test(dependsOnMethods = {"testRead"})
    public void testUpdate() {
        repository = ctx.getBean(RolesListRepository.class);
        RolesList role = repository.findOne(id);
        RolesList newrole = new RolesList.Builder("ROLE_ADMIN").id(role.getId())
                .description("Adminiatrator").build();
        repository.save(newrole);
        RolesList upDaterole = repository.findOne(id);
        Assert.assertEquals(upDaterole.getDescription(), "Adminiatrator");
    }

    @Test(dependsOnMethods = {"testUpdate"})
    public void testDelete() {
        repository = ctx.getBean(RolesListRepository.class);
        RolesList role = repository.findOne(id);
        repository.delete(role);
        RolesList deletedRole = repository.findOne(id);
        Assert.assertNull(deletedRole);
    }
}
