package com.cars.cars.web.Config;

import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cars.cars.domain.exception.NotFoundException;
import com.cars.cars.persistence.crud.UserCrud;

@Service
public class UserDetailService implements UserDetailsService{

    private final UserCrud userCrud;

    
    public UserDetailService(UserCrud userCrud) {
        this.userCrud = userCrud;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userCrud.findById(username).orElseThrow(()-> new UsernameNotFoundException("Username not found"));
        String[] roles = List.of(user.getRole().name()).toArray(new String[0]);


        return org.springframework.security.core.userdetails.User.builder().username(user.getUsername())
                                                                            .password(user.getPassword())
                                                                            .authorities(roles)
                                                                            .disabled(user.isDisabled())
                                                                            .build();
    }
    
}
