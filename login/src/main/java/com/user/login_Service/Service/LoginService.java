package com.user.login_Service.Service;

import com.user.login_Service.Entity.Login;

public interface LoginService {
     Login validateUser(String email, String password) ;

    Login createUser(Login login);
}
