package com.milan.Ghumgham_travels.Support.controller;

import com.milan.Ghumgham_travels.Support.model.dto.SupportDto;
import com.milan.Ghumgham_travels.Support.service.SupportInterface;
import com.milan.Ghumgham_travels.utils.DtoConverter;
import com.milan.Ghumgham_travels.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/support")
public class SupportController {

    @Autowired
    SupportInterface service;
    @PostMapping
    public ResponseEntity saveSupport(@RequestBody SupportDto dto){
        return ResponseMessage.success(DtoConverter.convert(service.saveSupport(dto)));
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity getByHotelId(@PathVariable("id") int id){
        return ResponseMessage.success(service.findByHotelId(id).stream().map(DtoConverter::convert).collect(Collectors.toList()));
    }

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseMessage.success(service.findAll().stream().map(DtoConverter::convert).collect(Collectors.toList()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSupportById(@PathVariable("id") int id){
        service.deleteById(id);
        return ResponseMessage.success(true);
    }

}
