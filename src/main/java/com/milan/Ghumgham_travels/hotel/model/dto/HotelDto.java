package com.milan.Ghumgham_travels.hotel.model.dto;

import com.milan.Ghumgham_travels.user.model.dto.UserDto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class HotelDto {

    private int id;

    private String hotelName;

    private int ratings;

    private String filename;

    private String hotelDesc;

    private int placeId;

    private String placeName;

    private UserDto owned_by;
}
