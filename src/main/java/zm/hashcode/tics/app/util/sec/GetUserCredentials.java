/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.util.sec;

import java.io.Serializable;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import zm.hashcode.hashwork.app.facade.PersonFacade;
import zm.hashcode.hashwork.domain.people.Person;
import zm.hashcode.hashwork.services.model.people.PersonModelService;

/**
 *
 * @author boniface
 */
public class GetUserCredentials implements Serializable {

    private PersonModelService personModelService;

    public String username() {
        String username = "Anonymous";
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            } else {
                username = principal.toString();
            }
        }
        return username;
    }

    public boolean isUserWithRole(String role) {
        GrantedAuthority authority = new SimpleGrantedAuthority(role);
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            List<GrantedAuthority> authorities = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
            if (authorities.contains(authority)) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    public Person getLoggedInUser() {
        personModelService = PersonFacade.getEmployeeModelService();
        
        Person user = personModelService.getByPropertyName("emailAddress", username());
        return user;
    }
}
