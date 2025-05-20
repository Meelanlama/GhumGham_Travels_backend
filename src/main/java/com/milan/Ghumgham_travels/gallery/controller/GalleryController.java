package com.milan.Ghumgham_travels.gallery.controller;

import com.milan.Ghumgham_travels.gallery.service.GalleryInterface;
import com.milan.Ghumgham_travels.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/gallery")
public class GalleryController {

    @Autowired
    GalleryInterface service;

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseMessage.success(service.getALl());
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteById(@RequestParam("id") int id){
        service.deleteById(id);
        return ResponseMessage.success(true);
    }

}
