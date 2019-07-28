package com.pvincel.simplestore.security.services;

import com.pvincel.simplestore.model.Role;
import com.pvincel.simplestore.model.User;
import com.pvincel.simplestore.repositories.UserRepository;
import com.pvincel.simplestore.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        Optional<User> user = userRepository.findByUsername(username);
        assert user.orElse(null) != null;
        String usernames = user.orElse(null).getUsername();


        return new com.pvincel.simplestore.security.UserDetails(
                user.orElse(null).getUsername(), user.orElse(null).getPassword(),
                true, true,
                true, true, user.orElse(null).getAuthorities());
    }

    private Collection<? extends GrantedAuthority> getAuth(Collection<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName().toString()));
            role.getPrivileges().stream()
                    .map(p -> new SimpleGrantedAuthority(p.getPrivilegeName().toString()))
                    .forEach(authorities::add);

        }

        return authorities;
    }

}
