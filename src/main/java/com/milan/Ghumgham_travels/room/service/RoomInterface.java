package com.milan.Ghumgham_travels.room.service;

import com.milan.Ghumgham_travels.room.model.dto.RoomDto;
import com.milan.Ghumgham_travels.room.model.entity.Room;
import com.milan.Ghumgham_travels.room.model.entity.RoomStatus;

import java.util.List;

public interface RoomInterface {

    Room saveRoom(RoomDto dto);

    List<Room> getByHotelId(int id);

    Room getById(int id);

    Room changeRoomStatus(int id, RoomStatus status);

    void deleteByRoomId(int id);

    List<Room> getAllRoom();
}
