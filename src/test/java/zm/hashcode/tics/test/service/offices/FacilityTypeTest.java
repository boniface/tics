/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.test.service.offices;

import org.testng.Assert;
import org.testng.annotations.Test;
import zm.hashcode.tics.domain.offices.FacilityType;
import zm.hashcode.tics.services.offices.FacilityTypeService;
import zm.hashcode.tics.test.AppTest;

/**
 *
 * @author ColinWa
 */
public class FacilityTypeTest extends AppTest {

    private FacilityTypeService service;
    private String id;

    public FacilityTypeTest() {
    }

    @Test
    public void testCreate() {
        service = ctx.getBean(FacilityTypeService.class);
        FacilityType facilityType = new FacilityType.Builder("Hospital").build();
        service.persist(facilityType);
        id = facilityType.getId();
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() {
        service = ctx.getBean(FacilityTypeService.class);
        FacilityType facilityType = service.find(id);
        Assert.assertEquals(facilityType.getFacilityName(), "Hospital");

    }

    @Test(dependsOnMethods = {"testRead"})
    public void testUpdate() {
        service = ctx.getBean(FacilityTypeService.class);
        FacilityType facilityType = service.find(id);
        FacilityType facilityType2 = new FacilityType.Builder("Clinic")
                .id(facilityType.getId())
                .build();
        service.merge(facilityType2);
        id = facilityType2.getId();
        FacilityType updatedFacilityType = service.find(id);
        Assert.assertEquals(updatedFacilityType.getFacilityName(), "Clinic");
    }

    @Test(dependsOnMethods = {"testUpdate"})
    public void testDelete() {
        service = ctx.getBean(FacilityTypeService.class);
        FacilityType facilityType = service.find(id);
        service.remove(facilityType);
        FacilityType facilityType2 = service.find(id);
        Assert.assertNull(facilityType2);
    }
}
