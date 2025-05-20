package com.milan.Ghumgham_travels.packagebooking.service;

import com.milan.Ghumgham_travels.packagebooking.model.dto.PackageBookingDto;
import com.milan.Ghumgham_travels.packagebooking.model.entity.PackageBooking;
import com.milan.Ghumgham_travels.roombooking.model.entity.RoomBookingStatus;

import java.util.List;

public interface PackageBookingInterface {

    PackageBooking savePackageBooking(PackageBookingDto dto);

    PackageBooking getById(int id);

    List<PackageBooking> getByPackageId(int roomId);

    List<PackageBooking> getByLoggedInUser();

    List<PackageBooking> getAll();

    PackageBooking changeStatus(int bookingId, RoomBookingStatus status);


}
