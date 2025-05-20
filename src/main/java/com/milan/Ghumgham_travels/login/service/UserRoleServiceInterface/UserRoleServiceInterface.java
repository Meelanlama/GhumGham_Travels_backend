package com.milan.Ghumgham_travels.login.service.UserRoleServiceInterface;


import com.milan.Ghumgham_travels.login.model.Dto.LoginDto;
import com.milan.Ghumgham_travels.login.model.Login;

public interface UserRoleServiceInterface {
    public Login saveUser(Login user);
    Login getByUser(String username);
    Login updateRole(LoginDto loginDto);

}
