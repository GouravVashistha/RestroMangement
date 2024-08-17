package com.user.login_Service.Controller;

import com.user.login_Service.Dto.LoginDto;
import com.user.login_Service.Entity.Login;
import com.user.login_Service.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/create")
    public ResponseEntity<Login> createUser(@RequestBody Login login) {
        Login createdUser = loginService.createUser(login);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/loginUser")
    public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto) {
        try {
            loginService.validateUser(loginDto.getEmail(), loginDto.getPassword());
            return ResponseEntity.ok("Login Successfully...");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

}
