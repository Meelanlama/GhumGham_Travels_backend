package com.milan.Ghumgham_travels.login.controller;

import com.milan.Ghumgham_travels.login.model.Status;
import com.milan.Ghumgham_travels.login.repository.SecurityUserRepository;
import com.milan.Ghumgham_travels.security.JWTGenerator;
//import com.addon.cbps.security.jwtconfig.JwtUtil;
import com.milan.Ghumgham_travels.login.model.Login;
import com.milan.Ghumgham_travels.login.model.SendToken;
//import com.addon.cbps.security.service.JwtService;
import com.milan.Ghumgham_travels.login.service.UserRoleServiceInterface.UserRoleServiceInterface;
import com.milan.Ghumgham_travels.security.MyUserDetails;
import com.milan.Ghumgham_travels.utils.DtoConverter;
import com.milan.Ghumgham_travels.utils.ResponseMessage;
import com.milan.Ghumgham_travels.utils.exceptions.SendErrorMessageCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/login")
public class SecurityController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRoleServiceInterface userRoleServiceInterface;

    @Autowired
    SecurityUserRepository securityUserRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    JWTGenerator jwtGenerator;


    @PostMapping
    public SendToken getToken(@RequestBody Login user){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);

        Login login = securityUserRepository.getUserByUsername(user.getUsername());

        SendToken sendToken = new SendToken();
        if (login!=null){
            if (login.getStatus() == Status.disabled)
                throw new SendErrorMessageCustom("Sorry! You have been disabled");
            if(login.getStatus() == Status.unapproved)
                throw new SendErrorMessageCustom("Sorry! You have not been approved yet");

            sendToken.setUserRole(login.getUserRole().getRoleName());
            sendToken.setUsername(user.getUsername());
            sendToken.setId(login.getId());
            sendToken.setMessage("Successful");
            sendToken.setFullName(login.getUser().getFullName());
            sendToken.setToken(token);
        }

        return sendToken;
    }


    @GetMapping("/check")
    public ResponseEntity check(){
        return ResponseMessage.success();
    }


    @GetMapping("/loggedinuser")
    public ResponseEntity getLoggedInUser(){
       Login user = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
       return ResponseMessage.success(DtoConverter.convert(user));
    }

}
