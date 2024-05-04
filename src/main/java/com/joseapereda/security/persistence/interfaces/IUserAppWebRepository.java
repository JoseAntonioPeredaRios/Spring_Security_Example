package com.joseapereda.security.persistence.interfaces;

import com.joseapereda.security.persistence.entities.UserAppWeb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserAppWebRepository extends JpaRepository<UserAppWeb,Long> {

    Optional<UserAppWeb> findByMail(String mail);
}
