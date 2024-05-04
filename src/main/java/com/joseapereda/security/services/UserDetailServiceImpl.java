package com.joseapereda.security.services;

import com.joseapereda.security.persistence.entities.UserAppWeb;
import com.joseapereda.security.persistence.interfaces.IUserAppWebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IUserAppWebRepository iUserAppWebRepository;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {

        UserAppWeb userDetails=iUserAppWebRepository.findByMail(mail)
                .orElseThrow(()->new UsernameNotFoundException("El usuario "+ mail+" no existe."));

        Collection<? extends GrantedAuthority> authorities=userDetails.getRoles()
                .stream()
                .map(role->new SimpleGrantedAuthority("ROLE_".concat(role.getName().name())))
                .collect(Collectors.toSet());


        return new User(userDetails.getMail(),
                userDetails.getPassword(),true,true,true,true,authorities);

    }
}
