/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.model;

import java.io.Serializable;

/**
 *
 * @author geek
 */
public class PersonIdentitiesBean implements Serializable {

    private String id;
//    @DBRef
    private String identificationTypeId; // IdentificationType
//    @Indexed(unique = true)
    private String idValue;

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
     * @return the identificationTypeId
     */
    public String getIdentificationTypeId() {
        return identificationTypeId;
    }

    /**
     * @param identificationTypeId the identificationTypeId to set
     */
    public void setIdentificationTypeId(String identificationTypeId) {
        this.identificationTypeId = identificationTypeId;
    }

    /**
     * @return the idValue
     */
    public String getIdValue() {
        return idValue;
    }

    /**
     * @param idValue the idValue to set
     */
    public void setIdValue(String idValue) {
        this.idValue = idValue;
    }
}
