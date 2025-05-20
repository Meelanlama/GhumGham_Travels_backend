package com.milan.Ghumgham_travels.roombooking.model.dto;

import com.milan.Ghumgham_travels.packagebooking.model.dto.PackageBookingDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoomPackageBookingDto {
    List<RoomBookingDto> room;

    List<PackageBookingDto> packages;

}
