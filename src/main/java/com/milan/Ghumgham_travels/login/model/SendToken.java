package com.milan.Ghumgham_travels.login.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendToken {

    private int id;

    private String token;

    private String message;

    private String username;

    private String userRole;

    private String fullName;



}
