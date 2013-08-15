/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.test.service.offices;

import org.testng.Assert;
import org.testng.annotations.Test;
import zm.hashcode.tics.domain.offices.Node;
import zm.hashcode.tics.services.offices.NodeService;
import zm.hashcode.tics.test.AppTest;

/**
 *
 * @author ColinWa
 */
public class NodeTest extends AppTest {

    private NodeService service;
    private String id;

    public NodeTest() {
    }

    @Test
    public void testCreate() {
        service = ctx.getBean(NodeService.class);
        Node node = new Node.Builder("Noda").build();
        service.persist(node);
        id = node.getId();
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() {
        service = ctx.getBean(NodeService.class);
        Node node = service.find(id);
        Assert.assertEquals(node.getNodeName(), "Noda");
    }

    @Test(dependsOnMethods = {"testRead"})
    public void testUpdate() {
        service = ctx.getBean(NodeService.class);
        Node node = service.find(id);
        Node node2 = new Node.Builder("Nodi")
                .id(node.getId())
                .build();
        service.merge(node2);
        id = node2.getId();
        Node updatedNode = service.find(id);
        Assert.assertEquals(updatedNode.getNodeName(), "Nodi");
    }

    @Test(dependsOnMethods = {"testUpdate"})
    public void testDelete() {
        service = ctx.getBean(NodeService.class);
        Node node = service.find(id);
        service.remove(node);
        Node node2 = service.find(id);
        Assert.assertNull(node2);
    }
}
