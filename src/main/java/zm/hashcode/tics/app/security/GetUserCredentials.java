/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.security;

import java.io.Serializable;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import zm.hashcode.tics.app.facade.user.UserFacade;
import zm.hashcode.tics.domain.users.User;
import zm.hashcode.tics.services.users.UserService;

/**
 *
 * @author boniface
 */
public class GetUserCredentials implements Serializable {

    private UserService userService;
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
    public User getLoggedInUser() {
        userService = UserFacade.getUserService();
        User user = userService.findByEmail(username());
        return user;
    }
}
