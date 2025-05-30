package com.milan.Ghumgham_travels.personrole.model;

import com.milan.Ghumgham_travels.login.model.Login;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String roleName;

    @OneToMany(mappedBy = "userRole")
    private List<Login> login;

}
