package com.milan.Ghumgham_travels.hotel.controller;


import com.milan.Ghumgham_travels.hotel.model.dto.HotelReviewDto;
import com.milan.Ghumgham_travels.hotel.service.HotelReviewInterface;
import com.milan.Ghumgham_travels.utils.DtoConverter;
import com.milan.Ghumgham_travels.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/hotel/review")
public class HotelReviewController {

    @Autowired
    HotelReviewInterface service;

    @PostMapping
    public ResponseEntity saveHotelReview(@RequestBody HotelReviewDto dto){
        return ResponseMessage.success(DtoConverter.convert(service.saveHotelReview(dto)));
    }

    @GetMapping("/by/hotel")
    public ResponseEntity getByHotelId(@RequestParam("id") int id){
        return ResponseMessage.success(service.getByHotelId(id).stream().map(DtoConverter::convert).collect(Collectors.toList()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteHotelReview(@RequestParam("id") int id){
        service.deleteHotelReview(id);
        return ResponseMessage.success(true);
    }



}
