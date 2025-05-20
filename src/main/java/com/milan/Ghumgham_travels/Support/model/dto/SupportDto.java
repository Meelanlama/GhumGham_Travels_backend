package com.milan.Ghumgham_travels.Support.model.dto;

import com.milan.Ghumgham_travels.hotel.model.dto.HotelDto;
import com.milan.Ghumgham_travels.user.model.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupportDto {

    private int id;

    private String supportDesc;

    private int hotelId;

    private HotelDto hotel;

    private UserDto user;

}
