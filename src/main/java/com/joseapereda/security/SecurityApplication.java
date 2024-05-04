package com.joseapereda.security;

import com.joseapereda.security.persistence.entities.RoleUserAppWeb;
import com.joseapereda.security.persistence.entities.UserAppWeb;
import com.joseapereda.security.persistence.interfaces.IUserAppWebRepository;
import com.joseapereda.security.security.JWTUtils;
import com.joseapereda.security.utils.enums.ERole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
public class SecurityApplication {

	@Autowired
	private JWTUtils jwtUtils;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private IUserAppWebRepository iUserAppWebRepository;


	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}




	/*
	@Bean
	CommandLineRunner init(){
		return args -> {

			Set<RoleUserAppWeb> roleUserAppWebs=new HashSet<>();
			Set<String> strings=new HashSet<>();
			strings.add(String.valueOf(ERole.ADMIN));


			Set<RoleUserAppWeb> roleEntitySet=strings.stream()
					.map(role ->RoleUserAppWeb.builder()
							.name(ERole.valueOf(role))
							.build()).collect(Collectors.toSet());

			UserAppWeb userToaEntity=UserAppWeb.builder()
					.mail("tucorreo@gmail.com")
					.password(passwordEncoder.encode("contrasenia123segura"))
					.roles(roleEntitySet).
					build();


			iUserAppWebRepository.save(userToaEntity);

		};
	}
	 */



}
