package com.milan.Ghumgham_travels.room.model.dto;

import com.milan.Ghumgham_travels.room.model.entity.RoomStatus;
import com.milan.Ghumgham_travels.room.model.entity.RoomType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDto {

    private int id;

    private String filename;

    private int rating;

    private RoomType roomType;

    private float price;

    private String roomDesc;

    private int hotelId;

    private int bed;

    private RoomStatus status;

    private int totalPerson;
}
