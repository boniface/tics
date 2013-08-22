/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.model;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author boniface
 */
public class FacilityBean implements Serializable{
  
    private String id;
    private String facilityName;
    private String  facilityTypeId;
    private String  cityId;
    private String mailingAddress;
    private String telephoneNumber;
    private String cellnumber;
    private String faxnumber;
    private String email;
    private String addressType;
   
    private Set<String> positionsIds;
    private Set<String> facilityMentorsId;
    
    private String facilityGroupingId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(String facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getCellnumber() {
        return cellnumber;
    }

    public void setCellnumber(String cellnumber) {
        this.cellnumber = cellnumber;
    }

    public String getFaxnumber() {
        return faxnumber;
    }

    public void setFaxnumber(String faxnumber) {
        this.faxnumber = faxnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public Set<String> getPositionsIds() {
        return positionsIds;
    }

    public void setPositionsIds(Set<String> positionsIds) {
        this.positionsIds = positionsIds;
    }

    public Set<String> getFacilityMentorsId() {
        return facilityMentorsId;
    }

    public void setFacilityMentorsId(Set<String> facilityMentorsId) {
        this.facilityMentorsId = facilityMentorsId;
    }

    public String getFacilityGroupingId() {
        return facilityGroupingId;
    }

    public void setFacilityGroupingId(String facilityGroupingId) {
        this.facilityGroupingId = facilityGroupingId;
    }
    
    

    
}
