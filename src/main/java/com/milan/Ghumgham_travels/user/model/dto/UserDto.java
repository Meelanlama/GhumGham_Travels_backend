package com.milan.Ghumgham_travels.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private long id;

    private String fullName;

    private String phoneNo;

    private String userName;

}
