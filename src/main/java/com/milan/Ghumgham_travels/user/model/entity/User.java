package com.milan.Ghumgham_travels.user.model.entity;

import com.milan.Ghumgham_travels.login.model.Login;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String fullName;

    private String phoneNo;

    @OneToOne(mappedBy = "user")
    private Login login;


}
