package com.milan.Ghumgham_travels.room.model.dto;

import com.milan.Ghumgham_travels.user.model.dto.UserDto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class RoomReviewDto {

    private int id;

    private String reviewDate;

    private String reviewDesc;

    private UserDto reviewBy;

    private int roomId;

    private int rating;
}
