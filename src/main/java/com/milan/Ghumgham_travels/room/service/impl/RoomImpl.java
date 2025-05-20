package com.milan.Ghumgham_travels.room.service.impl;

import com.milan.Ghumgham_travels.hotel.model.entity.Hotel;
import com.milan.Ghumgham_travels.hotel.repository.HotelRepository;
import com.milan.Ghumgham_travels.room.model.dto.RoomDto;
import com.milan.Ghumgham_travels.room.model.entity.Room;
import com.milan.Ghumgham_travels.room.model.entity.RoomStatus;
import com.milan.Ghumgham_travels.room.repository.RoomRepository;
import com.milan.Ghumgham_travels.room.repository.RoomReviewRepository;
import com.milan.Ghumgham_travels.room.service.RoomInterface;
import com.milan.Ghumgham_travels.roombooking.repository.RoomBookingRepository;
import com.milan.Ghumgham_travels.utils.DtoConverter;
import com.milan.Ghumgham_travels.utils.exceptions.SendErrorMessageCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomImpl implements RoomInterface {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    RoomBookingRepository roomBookingRepository;

    @Autowired
    RoomReviewRepository roomReviewRepository;


    @Override
    public Room saveRoom(RoomDto dto){
        Room room = DtoConverter.convert(dto);
        room.setHotel(hotelRepository.findById(dto.getHotelId()).orElseThrow(()-> new SendErrorMessageCustom("No Hotel of Such Id")));
        return roomRepository.save(room);
    }

    @Override
    public List<Room> getByHotelId(int id){
        Hotel hotel = hotelRepository.findById(id).orElseThrow(()->new SendErrorMessageCustom("No Hotel Id Of Such"));
        return roomRepository.findByHotel(hotel);
    }

    @Override
    public Room getById(int id){
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public Room changeRoomStatus(int id, RoomStatus status){
        Room room = roomRepository.findById(id).orElse(null);
        room.setRoomStatus(status);
        return roomRepository.save(room);
    }

    @Override
    public void deleteByRoomId(int id){
        Room room = roomRepository.findById(id).orElse(null);
        roomBookingRepository.deleteAll(roomBookingRepository.findByRoom(room));
        roomReviewRepository.deleteAll(roomReviewRepository.findByRoomOrderByIdDesc(room));
        roomRepository.delete(room);
    }

    @Override
    public List<Room> getAllRoom(){
        return roomRepository.findAll();
    }
}
