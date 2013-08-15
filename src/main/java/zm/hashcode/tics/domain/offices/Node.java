/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.offices;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author boniface
 */
@Document
public class Node implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String nodeName;

    private Node() {
    }

    private Node(Builder builder) {
        id = builder.id;
        nodeName = builder.nodeName;
    }

    public static class Builder {

        private final String nodeName;
        //optional 
        private String id = null;

        public Builder(String facilityName) {
            this.nodeName = facilityName;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Node build() {
            return new Node(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getNodeName() {
        return nodeName;
    }

  

    @Override
    public String toString() {
        return "Nodes{" + "id=" + id + ", facilityName=" + nodeName + '}';
    }
}
