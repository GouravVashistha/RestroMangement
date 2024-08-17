package com.user.login_Service.ServiceImpl;

import com.user.login_Service.DAO.LoginRepository;
import com.user.login_Service.Entity.Login;
import com.user.login_Service.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Login createUser(Login login) {

        // Check if the email already exists
        Optional<Login> existUser = loginRepository.findByEmail(login.getEmail());
        if (existUser.isPresent()) {
            throw new IllegalArgumentException("User with this email already exists");
        }

        // Validate password and confirm password match
        if (!login.getPassword().equals(login.getCPassword())) {
            throw new IllegalArgumentException("Password and Confirm Password do not match");
        }

        // Save the user after successful validation
        return loginRepository.save(login);
    }



    @Override
    public Login validateUser(String email, String password) {
        // Find user by email
        Optional<Login> userOptional = loginRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("User does not exist");
        }

        Login user = userOptional.get();

        // Check if the provided password matches the stored password
        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid password");
        }

        // If the email and password match, return the user
        return user;
    }


}
