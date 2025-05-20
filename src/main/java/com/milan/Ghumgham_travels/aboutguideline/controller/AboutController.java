package com.milan.Ghumgham_travels.aboutguideline.controller;

import com.milan.Ghumgham_travels.aboutguideline.model.entity.AboutUsManage;
import com.milan.Ghumgham_travels.aboutguideline.service.AboutInterface;
import com.milan.Ghumgham_travels.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/manage/about")
public class AboutController {

    @Autowired
    AboutInterface service;

    @PostMapping
    public ResponseEntity saveAbout(@RequestBody AboutUsManage aboutUsManage){
        return ResponseMessage.success(service.saveAbout(aboutUsManage));
    }

    @GetMapping
    public ResponseEntity getAbout(){
        return ResponseMessage.success(service.getHotels());
    }


}
