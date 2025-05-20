package com.milan.Ghumgham_travels.room.controller;


import com.milan.Ghumgham_travels.room.model.dto.RoomReviewDto;
import com.milan.Ghumgham_travels.room.service.RoomReviewInterface;
import com.milan.Ghumgham_travels.utils.DtoConverter;
import com.milan.Ghumgham_travels.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/room/review")
public class RoomReviewController {

    @Autowired
    RoomReviewInterface service;

    @PostMapping
    public ResponseEntity saveHotelReview(@RequestBody RoomReviewDto dto){
        return ResponseMessage.success(DtoConverter.convert(service.saveRoomReview(dto)));
    }

    @GetMapping("/by/room")
    public ResponseEntity getByHotelId(@RequestParam("id") int id){
        return ResponseMessage.success(service.getByRoomId(id).stream().map(DtoConverter::convert).collect(Collectors.toList()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteRoomReview(@RequestParam("id") int id){
        service.deleteRoomReview(id);
        return ResponseMessage.success(true);
    }

}
