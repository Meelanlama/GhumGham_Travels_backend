package com.milan.Ghumgham_travels.user.service;

import com.milan.Ghumgham_travels.login.model.Status;
import com.milan.Ghumgham_travels.user.model.dto.UserDto;
import com.milan.Ghumgham_travels.user.model.dto.UserRegisterDto;
import com.milan.Ghumgham_travels.user.model.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserServiceInterface {
    User saveUser(UserDto dto);

    UserRegisterDto saveUserDetails(UserRegisterDto dto);

    Page<UserRegisterDto> getAllUser(int offset, int page);

    UserRegisterDto getById(long id);

    UserRegisterDto changeStatus(Status status, long id);

    UserRegisterDto changeRole(long userId, long roleId);

    UserRegisterDto updateUserDetails(UserRegisterDto dto);

    List<UserRegisterDto> getAllUser();
}
