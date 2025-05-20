package com.milan.Ghumgham_travels.packagebooking.controller;


import com.milan.Ghumgham_travels.packagebooking.model.dto.PackageBookingDto;
import com.milan.Ghumgham_travels.packagebooking.model.entity.PackageBooking;
import com.milan.Ghumgham_travels.packagebooking.service.PackageBookingInterface;
import com.milan.Ghumgham_travels.roombooking.model.entity.RoomBookingStatus;
import com.milan.Ghumgham_travels.utils.DtoConverter;
import com.milan.Ghumgham_travels.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/package/booking")
public class PackageBookingController {

    @Autowired
    PackageBookingInterface service;

    @PostMapping
    public ResponseEntity save(@RequestBody PackageBookingDto dto){
        return ResponseMessage.success(DtoConverter.convert(service.savePackageBooking(dto)));
    }

    @GetMapping("/user")
    public ResponseEntity getByLoggedInUser(){
        return ResponseMessage.success(service.getByLoggedInUser().stream().map(DtoConverter::convert).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") int id){
        return ResponseMessage.success(DtoConverter.convert(service.getById(id)));
    }

    @GetMapping("/by/package")
    public ResponseEntity getByPackageId(@RequestParam("packageId") int id){
        return ResponseMessage.success(service.getByPackageId(id).stream().map(DtoConverter::convert).collect(Collectors.toList()));
    }

    @PutMapping("/change/status")
    public ResponseEntity changeStatus(@RequestParam("bookingId") int bookingId,@RequestParam("status")RoomBookingStatus status){
        return ResponseMessage.success(DtoConverter.convert(service.changeStatus(bookingId,status)));
    }

    @GetMapping("/all")
    public ResponseEntity getAllRoomBooking(){
        List<PackageBooking> bookings = service.getAll();
        return ResponseMessage.success(bookings.stream().map(DtoConverter::convert).collect(Collectors.toList()));
    }


}
