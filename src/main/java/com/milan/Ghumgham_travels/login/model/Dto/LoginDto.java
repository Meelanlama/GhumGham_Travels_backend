package com.milan.Ghumgham_travels.login.model.Dto;


import com.milan.Ghumgham_travels.login.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    private int id;

    private String email;
    private String password;

    private long userRole;

    private String userRoles;

    private Status status;

}
