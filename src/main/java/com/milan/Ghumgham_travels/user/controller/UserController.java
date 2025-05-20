package com.milan.Ghumgham_travels.user.controller;

import com.milan.Ghumgham_travels.login.model.Status;
import com.milan.Ghumgham_travels.security.MyUserDetails;
import com.milan.Ghumgham_travels.user.model.dto.UserDto;
import com.milan.Ghumgham_travels.user.model.dto.UserRegisterDto;
import com.milan.Ghumgham_travels.user.model.entity.User;
import com.milan.Ghumgham_travels.user.service.UserServiceInterface;
import com.milan.Ghumgham_travels.utils.Constants;
import com.milan.Ghumgham_travels.utils.DtoConverter;
import com.milan.Ghumgham_travels.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    UserServiceInterface userServiceInterface;

    @PostMapping
    public ResponseEntity saveUser(@RequestBody UserDto dto){
        return ResponseMessage.success(userServiceInterface.saveUser(dto));
    }

    @PostMapping("/details")
    public ResponseEntity saveUserDetails(@RequestBody UserRegisterDto dto){
        return ResponseMessage.success(userServiceInterface.saveUserDetails(dto));
    }

    @GetMapping("/{offset}/{page}")
    @PreAuthorize("hasAnyRole('"+ Constants.ROLE_ADMIN +"')")
    public ResponseEntity getUserDetails(@PathVariable("offset") int offset, @PathVariable("page") int page){
        return ResponseMessage.success(userServiceInterface.getAllUser(offset, page));

    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('"+ Constants.ROLE_ADMIN +"')")
    public ResponseEntity getUserById(@PathVariable("id") long id){
        return ResponseMessage.success(userServiceInterface.getById(id));
    }

    @PutMapping("/status/{id}/{status}")
//    @PreAuthorize("hasAnyRole('"+ Constants.ROLE_ADMIN +"')")
    public ResponseEntity changeUserStatus(@PathVariable("id") long id, @PathVariable("status")Status status){
        return ResponseMessage.success(userServiceInterface.changeStatus(status,id));
    }

    @PutMapping("/role")
    @PreAuthorize("hasAnyRole('"+ Constants.ROLE_ADMIN +"')")
    public ResponseEntity changeUserRole(@RequestParam("roleId") long roleId, @RequestParam("userId") long userId){
        return ResponseMessage.success(userServiceInterface.changeRole(userId,roleId));
    }

    @PostMapping("/update")
    public ResponseEntity updateUser(@RequestBody UserRegisterDto dto){
        return ResponseMessage.success(userServiceInterface.updateUserDetails(dto));
    }

    @GetMapping("/all")
        public ResponseEntity getAll(){
            return ResponseMessage.success(userServiceInterface.getAllUser());
        }


    @GetMapping("/logged/in")
    private ResponseEntity getLoggedInUserDetail(){
        User user = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getUser();
        return ResponseMessage.success(DtoConverter.convert(user));
    }

}
