package com.milan.Ghumgham_travels.roombooking.service;

import com.milan.Ghumgham_travels.roombooking.model.dto.RoomBookingDto;
import com.milan.Ghumgham_travels.roombooking.model.dto.RoomPackageBookingDto;
import com.milan.Ghumgham_travels.roombooking.model.entity.RoomBooking;
import com.milan.Ghumgham_travels.roombooking.model.entity.RoomBookingStatus;

import java.util.List;

public interface RoomBookingInterface {

    RoomBooking saveRoomBooking(RoomBookingDto dto);

    RoomBooking getById(int id);

    List<RoomBooking> getByRoomId(int roomId);

    List<RoomBooking> getByLoggedInUser();

    RoomPackageBookingDto getBothByLoggedInUser();

    RoomBooking changeStatus(int bookingId, RoomBookingStatus status);

    List<RoomBooking> getAll();

    RoomBooking updatePayment(int id, float amount);


}
