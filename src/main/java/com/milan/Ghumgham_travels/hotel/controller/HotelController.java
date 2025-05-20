package com.milan.Ghumgham_travels.hotel.controller;

import com.milan.Ghumgham_travels.hotel.model.dto.HotelDto;
import com.milan.Ghumgham_travels.hotel.service.HotelInterface;
import com.milan.Ghumgham_travels.utils.DtoConverter;
import com.milan.Ghumgham_travels.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelInterface service;

    @PostMapping
    public ResponseEntity saveHotel(@RequestBody HotelDto dto){
        return ResponseMessage.success(DtoConverter.convert(service.save(dto)));

    }
    @GetMapping
    public ResponseEntity getHotelByPagination(@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("id") int id){
        return ResponseMessage.success(service.getHotels(page,size,id).map(DtoConverter::convert));
    }

    @GetMapping("/all")
    public ResponseEntity getAll(){
        return ResponseMessage.success(service.getAll().stream().map(DtoConverter::convert).collect(Collectors.toList()));
    }

    @GetMapping("get/by/id/{id}")
    public ResponseEntity getById(@PathVariable("id") int id){
        return ResponseMessage.success(DtoConverter.convert(service.getHotelById(id)));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteById(@RequestParam("id") int id){
        service.hotelDelete(id);
        return ResponseMessage.success(true);
    }

    @GetMapping("/logged/user")
    public ResponseEntity getByLoggedInUser(){
        return ResponseMessage.success(DtoConverter.convert(service.getHotelByLoggedInUser()));
    }
}
