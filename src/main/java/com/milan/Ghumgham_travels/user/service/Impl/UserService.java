package com.milan.Ghumgham_travels.user.service.Impl;


import com.milan.Ghumgham_travels.personrole.model.PersonRole;
import com.milan.Ghumgham_travels.personrole.repository.PersonRoleRepository;
import com.milan.Ghumgham_travels.login.model.Login;
import com.milan.Ghumgham_travels.login.model.Status;
import com.milan.Ghumgham_travels.login.repository.SecurityUserRepository;

import com.milan.Ghumgham_travels.user.model.dto.UserDto;
import com.milan.Ghumgham_travels.user.model.dto.UserRegisterDto;

import com.milan.Ghumgham_travels.user.model.entity.User;

import com.milan.Ghumgham_travels.user.repository.UserRepository;
import com.milan.Ghumgham_travels.user.service.UserServiceInterface;
import com.milan.Ghumgham_travels.utils.DtoConverter;
import com.milan.Ghumgham_travels.utils.exceptions.SendErrorMessageCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserService  implements UserServiceInterface {

    @Autowired
    UserRepository userRepo;

    @Autowired
    SecurityUserRepository loginRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    PersonRoleRepository roleRepo;



    @Override
    public User saveUser(UserDto dto){
        return userRepo.save(DtoConverter.convert(dto));
    }


//    @Transactional
    public UserRegisterDto saveUserDetails(UserRegisterDto dto){

        User user =userRepo.save(DtoConverter.convert(dto.getUser()));
        Login login = new Login();
        login.setUsername(dto.getLogin().getEmail());
        login.setPassword(bCryptPasswordEncoder.encode(dto.getLogin().getPassword()));
        PersonRole personRole = new PersonRole();
        personRole.setId(3);
        login.setUser(user);
        login.setUserRole(personRole);
        login.setStatus(Status.approved);

        Login findLogin = loginRepo.getUserByUsername(dto.getLogin().getEmail());
        if (findLogin==null)
           user.setLogin(loginRepo.save(login));
        else
            throw new SendErrorMessageCustom("Username already exists");
        return DtoConverter.convertSend(user);
    }


    @Override
    public UserRegisterDto updateUserDetails(UserRegisterDto dto){

        User user = userRepo.findById(dto.getUser().getId()).orElseThrow(()->new SendErrorMessageCustom("User Not Available"));
        if (dto.getUser().getFullName()!=null){
            if (!dto.getUser().getFullName().equals("")) {
                user.setFullName(dto.getUser().getFullName());
            }
        }
        if(dto.getUser().getPhoneNo()!=null || !dto.getUser().getPhoneNo().equals("a")){
            if (!dto.getUser().getPhoneNo().equals("")) {
                user.setPhoneNo(dto.getUser().getPhoneNo());
            }
        }

        if(dto.getLogin().getPassword()!=null){
            Login login = loginRepo.findByUser(user);
            String newPassword = bCryptPasswordEncoder.encode(dto.getLogin().getPassword());
            login.setPassword(newPassword);
            loginRepo.save(login);
        }

        return DtoConverter.convertSend(userRepo.save(user));

    }

    @Override
    public Page<UserRegisterDto> getAllUser(int offset, int page) {
        Page<User> getUser= userRepo.findAll(PageRequest.of(offset, page));
        return getUser.map((a)->DtoConverter.convertSend(a));

    }

    @Override
    public List<UserRegisterDto> getAllUser() {
        List<Login> getUser= loginRepo.findAll();
        return getUser.stream().map(DtoConverter::convertF).collect(Collectors.toList());

    }

    @Override
    public UserRegisterDto getById(long id) {
        try {
            User user = userRepo.findById(id).orElseThrow();
            return DtoConverter.convertSend(user);
        }catch (NoSuchElementException ex){
            throw new SendErrorMessageCustom("Provided User Doesn't Exists");
        }

    }

    @Override
    public UserRegisterDto changeStatus(Status status, long id){
        User user = null;
        try {
            user = userRepo.findById(id).orElseThrow();
        }catch (NoSuchElementException ex){
            throw new SendErrorMessageCustom("Provided user doesn't exists");
        }
        Login login = loginRepo.findByUser(user);
        login.setStatus(status);
        loginRepo.save(login);
        return DtoConverter.convertSend(user);
    }

    @Override
    public UserRegisterDto changeRole(long userId, long roleId) {
        User user = null;
        try {
            user = userRepo.findById(userId).orElseThrow();
        }catch (NoSuchElementException ex){
            throw new SendErrorMessageCustom("Provided user doesn't exists");
        }
        Login login = loginRepo.findByUser(user);

        try{
            PersonRole personRole = roleRepo.findById(roleId).orElseThrow();
            login.setUserRole(personRole);
            loginRepo.save(login);
            return DtoConverter.convertSend(user);
        }catch (NoSuchElementException ex){
            throw new SendErrorMessageCustom("Given Role doesn't exists");
        }

    }


}
