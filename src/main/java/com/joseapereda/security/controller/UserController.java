package com.joseapereda.security.controller;

import com.joseapereda.security.persistence.entities.RoleUserAppWeb;
import com.joseapereda.security.persistence.entities.UserAppWeb;
import com.joseapereda.security.persistence.interfaces.IUserAppWebRepository;
import com.joseapereda.security.utils.dto.UserDTO;
import com.joseapereda.security.utils.enums.ERole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserAppWebRepository iUserAppWebRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value = "create")
    public ResponseEntity<?> crateUser(@RequestBody UserDTO userDTO){

        Set<RoleUserAppWeb> roleEntitySet=userDTO.getRoles().stream()
                .map(role ->RoleUserAppWeb.builder()
                        .name(ERole.valueOf(role))
                        .build()).collect(Collectors.toSet());

        UserAppWeb userToaEntity=UserAppWeb.builder()
                .mail(userDTO.getEmail())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .roles(roleEntitySet).
                build();


        iUserAppWebRepository.save(userToaEntity);


        return new ResponseEntity<>(userToaEntity,HttpStatus.OK);
    }

}
