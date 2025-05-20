package com.milan.Ghumgham_travels.room.service;

import com.milan.Ghumgham_travels.room.model.dto.RoomReviewDto;
import com.milan.Ghumgham_travels.room.model.entity.RoomReview;

import java.util.List;

public interface RoomReviewInterface {

    List<RoomReview> getByRoomId(int id);

    RoomReview saveRoomReview(RoomReviewDto dto);

    void deleteRoomReview(int id);
}
