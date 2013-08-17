/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.util;

import zm.hashcode.tics.client.web.content.system.facility.model.ClusterBean;
import zm.hashcode.tics.domain.offices.Cluster;

/**
 *
 * @author geek
 */
public class ClusterUtil {

    public ClusterBean getBean(Cluster cluster) {
        ClusterBean bean = new ClusterBean();
        bean.setId(cluster.getId());
        bean.setClusterName(cluster.getClusterName());
        return bean;
    }
}
