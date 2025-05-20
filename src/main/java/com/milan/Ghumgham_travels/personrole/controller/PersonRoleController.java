package com.milan.Ghumgham_travels.personrole.controller;

import com.milan.Ghumgham_travels.personrole.service.Interface.PersonRoleInterface;
import com.milan.Ghumgham_travels.utils.DtoConverter;
import com.milan.Ghumgham_travels.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/person/role")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PersonRoleController {
    @Autowired
    PersonRoleInterface service;

    @GetMapping
    public ResponseEntity getAllPersonRole(){
        return ResponseMessage.success(service.getPersonRole().stream().map(DtoConverter::convert).collect(Collectors.toList()));
    }
}
