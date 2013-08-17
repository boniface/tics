/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.util;

import zm.hashcode.tics.client.web.content.system.facility.model.NodeBean;
import zm.hashcode.tics.domain.offices.Node;

/**
 *
 * @author geek
 */
public class NodeUtil {

    public NodeBean getBean(Node node) {
        NodeBean bean = new NodeBean();
        bean.setId(node.getId());
        bean.setNodeName(node.getNodeName());
        return bean;
    }
}
