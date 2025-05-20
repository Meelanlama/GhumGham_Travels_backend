package com.milan.Ghumgham_travels.places.controller;

import com.milan.Ghumgham_travels.places.model.dto.PlacesDto;
import com.milan.Ghumgham_travels.places.service.PlacesInterface;
import com.milan.Ghumgham_travels.utils.DtoConverter;
import com.milan.Ghumgham_travels.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/places")
public class PlacesController {

    @Autowired
    PlacesInterface service;

    @PostMapping
    public ResponseEntity savePlaces(@RequestBody PlacesDto dto){
        return ResponseMessage.success(DtoConverter.convert(service.savePlaces(dto)));
    }

    @GetMapping
    public ResponseEntity getPlaces(){
        return ResponseMessage.success(service.getPlaces().stream().map(DtoConverter::convert).collect(Collectors.toList()));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getById(@PathVariable("id") int id){
        return ResponseMessage.success(DtoConverter.convert(service.getById(id)));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteById(@RequestParam("id") int id){
        service.deleteById(id);
        return ResponseMessage.success(true);
    }

}
