package com.milan.Ghumgham_travels.guideline.controller;

import com.milan.Ghumgham_travels.guideline.model.entity.Guideline;
import com.milan.Ghumgham_travels.guideline.service.GuidelineInterface;
import com.milan.Ghumgham_travels.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/manage/guideline")
public class GuidelineController {

    @Autowired
    GuidelineInterface service;

    @PostMapping
    public ResponseEntity saveAbout(@RequestBody Guideline aboutUsManage){
        return ResponseMessage.success(service.saveAbout(aboutUsManage));
    }

    @GetMapping
    public ResponseEntity getAbout(){
        return ResponseMessage.success(service.getHotels());
    }


}
