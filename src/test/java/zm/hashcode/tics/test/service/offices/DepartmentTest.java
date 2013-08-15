/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.test.service.offices;

import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import zm.hashcode.tics.domain.offices.Department;
import zm.hashcode.tics.services.offices.DepartmentService;
import zm.hashcode.tics.test.AppTest;

/**
 *
 * @author ColinWa
 */
public class DepartmentTest extends AppTest {

    private DepartmentService service;
    private String id;

    public DepartmentTest() {
    }

    @Test
    public void testCreate() {
        service = ctx.getBean(DepartmentService.class);
        Department department = new Department.Builder("HR").build();
        service.persist(department);
        id = department.getId();
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() {
        service = ctx.getBean(DepartmentService.class);
        Department department = service.find(id);
        Assert.assertEquals(department.getName(), "HR");

    }

    @Test(dependsOnMethods = {"testRead"})
    public void testUpdate() {
        service = ctx.getBean(DepartmentService.class);
        Department department = service.find(id);
        Department department2 = new Department.Builder("Finance")
                .id(department.getId())
                .build();
        service.merge(department2);
        id = department2.getId();
        Department updateddepartment = service.find(id);
        Assert.assertEquals(updateddepartment.getName(), "Finance");
    }

    @Test(dependsOnMethods = {"testUpdate"})
    public void testDelete() {
        service = ctx.getBean(DepartmentService.class);
        Department department = service.find(id);
        service.remove(department);
        Department deletedDepartment = service.find(id);
        Assert.assertNull(deletedDepartment);
    }
}
