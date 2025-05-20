package com.milan.Ghumgham_travels.room.controller;

import com.milan.Ghumgham_travels.room.model.dto.RoomDto;
import com.milan.Ghumgham_travels.room.model.entity.RoomStatus;
import com.milan.Ghumgham_travels.room.service.RoomInterface;
import com.milan.Ghumgham_travels.utils.DtoConverter;
import com.milan.Ghumgham_travels.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomInterface service;

    @PostMapping
    public ResponseEntity saveRoom(@RequestBody RoomDto dto){
        return ResponseMessage.success(DtoConverter.convert(service.saveRoom(dto)));
    }

    @GetMapping
    public ResponseEntity getRoom(@RequestParam("id") int hotelId){
        return ResponseMessage.success(service.getByHotelId(hotelId).stream().map(DtoConverter::convert).collect(Collectors.toList()));
    }

    @GetMapping("/by/id/{id}")
    public ResponseEntity getById(@PathVariable("id") int id){
        return ResponseMessage.success(DtoConverter.convert(service.getById(id)));
    }

    @PutMapping("/change/status")
    public ResponseEntity changeRoomStatus(@RequestParam("roomId") int id,@RequestParam("status") RoomStatus status){
        return ResponseMessage.success(DtoConverter.convert(service.changeRoomStatus(id,status)));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteRoom(@RequestParam("id") int id){
        service.deleteByRoomId(id);
        return ResponseMessage.success(true);
    }

    @GetMapping("/all")
    public ResponseEntity getAll(){
        return ResponseMessage.success(service.getAllRoom().stream().map(DtoConverter::convert).collect(Collectors.toList()));
    }

}
