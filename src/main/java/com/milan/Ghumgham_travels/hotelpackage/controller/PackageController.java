package com.milan.Ghumgham_travels.hotelpackage.controller;

import com.milan.Ghumgham_travels.hotelpackage.model.dto.PackageDto;
import com.milan.Ghumgham_travels.hotelpackage.service.PackageInterface;
import com.milan.Ghumgham_travels.utils.DtoConverter;
import com.milan.Ghumgham_travels.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/package")
public class PackageController {

    @Autowired
    PackageInterface service;

    @PostMapping
    public ResponseEntity savePackages(@RequestBody PackageDto dto){
        return ResponseMessage.success(DtoConverter.convert(service.savePackage(dto)));
    }

    @GetMapping("/hotel")
    public ResponseEntity getByHotelId(@RequestParam("hotelId") int hotelId){
        return ResponseMessage.success(service.getByHotelId(hotelId).stream().map(DtoConverter::convert).collect(Collectors.toList()));
    }

    @GetMapping("/delete")
    public ResponseEntity deleteById(@RequestParam("id") int id){
        service.deleteById(id);
        return ResponseMessage.success(true);
    }

    @GetMapping("/by")
    public ResponseEntity getById(@RequestParam("id") int id){
        return ResponseMessage.success(DtoConverter.convert(service.getById(id)));
    }






}
