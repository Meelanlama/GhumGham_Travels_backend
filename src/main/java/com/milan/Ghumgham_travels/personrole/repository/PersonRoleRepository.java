package com.milan.Ghumgham_travels.personrole.repository;


import com.milan.Ghumgham_travels.personrole.model.PersonRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRoleRepository extends JpaRepository<PersonRole,Long> {

}

