package com.milan.Ghumgham_travels.roombooking.controller;

import com.milan.Ghumgham_travels.roombooking.model.dto.RoomBookingDto;
import com.milan.Ghumgham_travels.roombooking.model.entity.RoomBookingStatus;
import com.milan.Ghumgham_travels.roombooking.service.RoomBookingInterface;
import com.milan.Ghumgham_travels.utils.DtoConverter;
import com.milan.Ghumgham_travels.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/room/booking")
public class RoomBookingController {

    @Autowired
    RoomBookingInterface service;

    @PostMapping
    public RedirectView save(@RequestBody RoomBookingDto dto){
        RoomBookingDto dtos = DtoConverter.convert(service.saveRoomBooking(dto));
        return new RedirectView("/home/great");
    }

    @GetMapping("/user")
    public ResponseEntity getByLoggedInUser(){
        return ResponseMessage.success(service.getByLoggedInUser().stream().map(DtoConverter::convert).collect(Collectors.toList()));
    }

    @GetMapping("/user/both")
    public ResponseEntity getBothByLoggedInUser(){
        return ResponseMessage.success(service.getBothByLoggedInUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") int id){
        return ResponseMessage.success(DtoConverter.convert(service.getById(id)));
    }

    @GetMapping("/by/room")
    public ResponseEntity getByRoomId(@RequestParam("roomId") int id){
        return ResponseMessage.success(service.getByRoomId(id).stream().map(DtoConverter::convert).collect(Collectors.toList()));
    }

    @PutMapping("/change/status")
    public ResponseEntity changeStatus(@RequestParam("bookingId") int bookingId,@RequestParam("status")RoomBookingStatus status){
        return ResponseMessage.success(DtoConverter.convert(service.changeStatus(bookingId,status)));
    }

    @GetMapping("/all")
    public ResponseEntity getAll(){
        return ResponseMessage.success(service.getAll().stream().map(DtoConverter::convert).collect(Collectors.toList()));
    }

    @PostMapping("/payment")
    public ResponseEntity setPayment(@RequestParam("id") int id, @RequestParam("amount") float amount){
        return ResponseMessage.success(DtoConverter.convert(service.updatePayment(id,amount)));
    }


}
