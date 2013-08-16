/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.test.service.offices;

import org.testng.Assert;
import org.testng.annotations.Test;
import zm.hashcode.tics.domain.offices.Cluster;
import zm.hashcode.tics.services.offices.ClusterService;
import zm.hashcode.tics.test.AppTest;

/**
 *
 * @author ColinWa
 */
public class ClusterTest extends AppTest {

    private ClusterService service;
    private String id;

    public ClusterTest() {
    }

    @Test
    public void testCreate() {
        service = ctx.getBean(ClusterService.class);
        Cluster cluster = new Cluster.Builder("Clusty").build();
        service.persist(cluster);
        id = cluster.getId();
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() {
        service = ctx.getBean(ClusterService.class);
        Cluster cluster = service.find(id);
        Assert.assertEquals(cluster.getClusterName(), "Clusty");
    }

    @Test(dependsOnMethods = {"testRead"})
    public void testUpdate() {
        service = ctx.getBean(ClusterService.class);
        Cluster cluster = service.find(id);
        Cluster cluster2 = new Cluster.Builder("Clusti")
                .id(cluster.getId())
                .build();
        service.merge(cluster2);
        id = cluster2.getId();
        Cluster updatedCluster = service.find(id);
        Assert.assertEquals(updatedCluster.getClusterName(), "Clusti");
    }

    @Test(dependsOnMethods = {"testUpdate"})
    public void testDelete() {
        service = ctx.getBean(ClusterService.class);
        Cluster cluster = service.find(id);
        service.remove(cluster);
        Cluster cluster2 = service.find(id);
        Assert.assertNull(cluster2);
    }
}
