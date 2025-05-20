package com.milan.Ghumgham_travels.room.repository;

import com.milan.Ghumgham_travels.room.model.entity.Room;
import com.milan.Ghumgham_travels.room.model.entity.RoomReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomReviewRepository extends JpaRepository<RoomReview,Integer> {

    List<RoomReview> findByRoomOrderByIdDesc(Room room);

}
