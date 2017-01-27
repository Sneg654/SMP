package com.smp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Class implements method for working with user details for security
 *
 * @author Ilya_Bondarenko
 */
@Service("userDetailsServiceImpl")
@ComponentScan(basePackages = {"com.epam"})
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.smp.model.User user;
        List<GrantedAuthority> authorities;
//        try {
            user = userService.findByLogin(username);
            authorities = buildUserAuthority(user.getRole());
//        }
//    catch (Exception e) {
//            throw new UsernameNotFoundException("Have no user with username -" + username, e);
//        }
        return buildUserForAuthentication(user, authorities);
    }


     private User buildUserForAuthentication(com.smp.model.User user, List<GrantedAuthority> authorities) {

         //boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities
         boolean isEnabled=true;
         boolean isAccountNonExpired=true;
         boolean isCredentialsNonExpired=true;
         boolean isAccountNonLocked=true;
         return new User(user.getName(), user.getPassword(), isEnabled, isAccountNonExpired, isCredentialsNonExpired, isAccountNonLocked, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Integer userRole) {
        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
        if (userRole.equals(1)) {
            result.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//            result.add(new SimpleGrantedAuthority("ADMIN"));
        } else if (userRole.equals(0)) {
            result.add(new SimpleGrantedAuthority("ROLE_USER"));
       }


        return result;
    }
}
