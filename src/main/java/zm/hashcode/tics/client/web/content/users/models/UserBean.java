/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.users.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author boniface
 */
public final class UserBean implements Serializable,Comparable<UserBean> {
    private String id;
    private String email;
    private String passwd;
    private String firstname;
    private String lastname;
    private String middlename;
    private boolean enabled;
    private Set<String> roleIds = new HashSet<>();
    private Set<String> jusridicationIds = new HashSet<>();

    public Set<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Set<String> roleIds) {
        this.roleIds = roleIds;
    }

    public Set<String> getJusridicationIds() {
        return jusridicationIds;
    }

    public void setJusridicationIds(Set<String> jusridicationIds) {
        this.jusridicationIds = jusridicationIds;
    }

 
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public int compareTo(UserBean o) {
       return this.lastname.compareTo(o.lastname);
    }
    
   
    
}