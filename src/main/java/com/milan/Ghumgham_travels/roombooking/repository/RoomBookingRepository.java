package com.milan.Ghumgham_travels.roombooking.repository;

import com.milan.Ghumgham_travels.room.model.entity.Room;
import com.milan.Ghumgham_travels.roombooking.model.entity.RoomBooking;
import com.milan.Ghumgham_travels.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomBookingRepository extends JpaRepository<RoomBooking,Integer> {

    List<RoomBooking> findByBookedByOrderByIdDesc(User user);

    List<RoomBooking> findByRoom(Room room);
}
