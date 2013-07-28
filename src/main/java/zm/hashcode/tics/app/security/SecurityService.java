/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.app.facade.user.UserFacade;
import zm.hashcode.tics.domain.ui.demographics.Role;
import zm.hashcode.tics.domain.users.User;
import zm.hashcode.tics.services.users.UserService;

/**
 *
 * @author boniface
 */
@Service("securityService")
public class SecurityService implements UserDetailsService {
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
        userService = UserFacade.getUserService();
        User user = userService.findByEmail(emailAddress);
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPasswd(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(user.getRoles()));
    }

    public Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(roles));
        return authList;
    }

    public Set<String> getRoles(Set<Role> roles) {
        Set<String> roleValues = new HashSet<>();
        for (Role personRole : roles) {
            roleValues.add(personRole.getRolename());
        }
        return roleValues;
    }

    public static List<GrantedAuthority> getGrantedAuthorities(Set<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
