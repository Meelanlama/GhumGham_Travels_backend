package com.milan.Ghumgham_travels.user.model.dto;

import com.milan.Ghumgham_travels.login.model.Dto.LoginDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDto {

    private UserDto user;

    private LoginDto login;

}
