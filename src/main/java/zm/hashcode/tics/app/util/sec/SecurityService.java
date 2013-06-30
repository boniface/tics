/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.util.sec;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import zm.hashcode.hashwork.app.facade.PersonFacade;
import zm.hashcode.hashwork.domain.people.Person;
import zm.hashcode.hashwork.domain.people.PersonRole;
import zm.hashcode.hashwork.services.model.people.PersonModelService;

/**
 *
 * @author boniface
 */
@Service("securityService")
public class SecurityService implements UserDetailsService {

    private PersonModelService personModelService;

    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
        personModelService = PersonFacade.getEmployeeModelService();
        Person user = personModelService.getByPropertyName("emailAddress", emailAddress);
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return new User(
                user.getEmailAddress(),
                user.getAuthvalue(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(user.getPersonRoles()));
    }

    public Collection<? extends GrantedAuthority> getAuthorities(List<PersonRole> roles) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(roles));
        return authList;
    }

    public List<String> getRoles(List<PersonRole> roles) {
        List<String> roleValues = new ArrayList<String>();
        for (PersonRole personRole : roles) {
            roleValues.add(personRole.getRoleName().getRolename());
        }
        return roleValues;
    }

    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
