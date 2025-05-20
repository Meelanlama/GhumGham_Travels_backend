package com.milan.Ghumgham_travels.personrole.service.Impl;


import com.milan.Ghumgham_travels.personrole.model.PersonRole;
import com.milan.Ghumgham_travels.personrole.repository.PersonRoleRepository;
import com.milan.Ghumgham_travels.personrole.service.Interface.PersonRoleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonRoleService implements PersonRoleInterface {

    @Autowired
    PersonRoleRepository repo;

    public List<PersonRole> getPersonRole(){
        return repo.findAll();
    }
}
