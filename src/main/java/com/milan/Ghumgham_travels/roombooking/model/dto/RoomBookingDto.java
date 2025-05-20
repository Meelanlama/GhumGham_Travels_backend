package com.milan.Ghumgham_travels.roombooking.model.dto;

import com.milan.Ghumgham_travels.hotel.model.dto.HotelDto;
import com.milan.Ghumgham_travels.room.model.dto.RoomDto;
import com.milan.Ghumgham_travels.roombooking.model.entity.RoomBookingStatus;
import com.milan.Ghumgham_travels.user.model.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RoomBookingDto {
    private int id;

    private float payment;

    private RoomBookingStatus status;

    private Date checkInDate;

    private Date checkOutDate;

    private String additionalRequest;

    private int roomId;

    private HotelDto hotel;

    private RoomDto room;


    private UserDto bookedBy;
}
