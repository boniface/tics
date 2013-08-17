/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.model;

import zm.hashcode.tics.domain.offices.Cluster;
import zm.hashcode.tics.domain.offices.Node;

/**
 *
 * @author ColinWa
 */
public class FacilityGroupingBean {

    private String id;
    private String nodeId;
    private String clusterId;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nodeId
     */
    public String getNodeId() {
        return nodeId;
    }

    /**
     * @param nodeId the nodeId to set
     */
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * @return the clusterId
     */
    public String getClusterId() {
        return clusterId;
    }

    /**
     * @param clusterId the clusterId to set
     */
    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }
}
