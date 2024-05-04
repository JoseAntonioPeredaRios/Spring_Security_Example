package com.joseapereda.security.controller;

import com.joseapereda.security.utils.enums.ERole;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class SomeController {

    @GetMapping(value = "/free-end-point")
    public ResponseEntity<?> freeEndPoint(){

        return new ResponseEntity<>("Este recurso no está protegido",HttpStatus.OK);
    }

    @GetMapping(value = "/protected")
    public ResponseEntity<?> protectedEndPoint(){

        return new ResponseEntity<>("Obtuviste acceso a un recurso protegido",HttpStatus.OK);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/protected-with-role")
    public ResponseEntity<?> protectedWithRole(){

        return new ResponseEntity<>("Obtuviste acceso a un recurso exclusivo para ADMIN_ROLE",HttpStatus.OK);
    }
}
