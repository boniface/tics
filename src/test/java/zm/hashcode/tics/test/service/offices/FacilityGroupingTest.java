/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.test.service.offices;

import org.testng.Assert;
import org.testng.annotations.Test;
import zm.hashcode.tics.domain.offices.Cluster;
import zm.hashcode.tics.domain.offices.FacilityGrouping;
import zm.hashcode.tics.domain.offices.Node;
import zm.hashcode.tics.services.offices.ClusterService;
import zm.hashcode.tics.services.offices.FacilityGroupingService;
import zm.hashcode.tics.services.offices.NodeService;
import zm.hashcode.tics.test.AppTest;

/**
 *
 * @author ColinWa
 */
public class FacilityGroupingTest extends AppTest {

    private NodeService nodeService;
    private ClusterService clusterService;
    private FacilityGroupingService facilityGroupingService;
    private String id;
    private String clusterId;
    private String nodeId;

    public FacilityGroupingTest() {
    }

    @Test
    public void testCreate() {
        nodeService = ctx.getBean(NodeService.class);
        Node node = new Node.Builder("Noda").build();
        nodeService.persist(node);
        nodeId = node.getId();

        clusterService = ctx.getBean(ClusterService.class);
        Cluster cluster = new Cluster.Builder("Clusty").build();
        clusterService.persist(cluster);
        clusterId = cluster.getId();

        facilityGroupingService = ctx.getBean(FacilityGroupingService.class);
        FacilityGrouping facilityGrouping = new FacilityGrouping.Builder(cluster)
                .node(node)
                .build();
        facilityGroupingService.persist(facilityGrouping);
        id = facilityGrouping.getId();
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() {
        facilityGroupingService = ctx.getBean(FacilityGroupingService.class);
        FacilityGrouping facilityGrouping = facilityGroupingService.find(id);
        Assert.assertEquals(facilityGrouping.getNode().getNodeName(), "Noda");
    }

    @Test(dependsOnMethods = {"testRead"})
    public void testUpdate() {
        nodeService = ctx.getBean(NodeService.class);
        Node node = nodeService.find(nodeId);
        Node node2 = new Node.Builder("Nodi").id(node.getId()).build();
        nodeService.merge(node2);
        nodeId = node2.getId();

        clusterService = ctx.getBean(ClusterService.class);
        Cluster cluster = clusterService.find(clusterId);

        facilityGroupingService = ctx.getBean(FacilityGroupingService.class);
        FacilityGrouping facilityGrouping = facilityGroupingService.find(id);
        FacilityGrouping updatedFacilityGrouping = new FacilityGrouping.Builder(cluster)
                .node(node2)
                .id(facilityGrouping.getId())
                .build();
        facilityGroupingService.merge(updatedFacilityGrouping);
        id = updatedFacilityGrouping.getId();

        Assert.assertEquals(updatedFacilityGrouping.getNode().getNodeName(), "Nodi");
    }

    @Test(dependsOnMethods = {"testUpdate"})
    public void testDelete() {
        nodeService = ctx.getBean(NodeService.class);
        Node node = nodeService.find(nodeId);
        nodeService.remove(node);
        Node node2 = nodeService.find(nodeId);
        Assert.assertNull(node2);

        clusterService = ctx.getBean(ClusterService.class);
        Cluster cluster = clusterService.find(clusterId);
        clusterService.remove(cluster);
        Cluster cluster2 = clusterService.find(clusterId);
        Assert.assertNull(cluster2);

        facilityGroupingService = ctx.getBean(FacilityGroupingService.class);
        FacilityGrouping facilityGrouping = facilityGroupingService.find(id);
        facilityGroupingService.remove(facilityGrouping);
        FacilityGrouping deletedfacilityGrouping = facilityGroupingService.find(id);
        Assert.assertNull(deletedfacilityGrouping);
    }
}
