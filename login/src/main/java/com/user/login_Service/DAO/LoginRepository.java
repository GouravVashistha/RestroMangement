package com.user.login_Service.DAO;

import com.user.login_Service.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login,Integer> {

    Optional findByEmail(String email);
}
