package com.milan.Ghumgham_travels.user.model.dto;


import com.milan.Ghumgham_travels.login.model.Dto.LoginDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelAdministratorDto {

    private UserDto user;

    private LoginDto login;
}
