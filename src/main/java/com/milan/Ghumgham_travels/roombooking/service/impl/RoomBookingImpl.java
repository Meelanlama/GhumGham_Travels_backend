package com.milan.Ghumgham_travels.roombooking.service.impl;

import com.milan.Ghumgham_travels.packagebooking.model.entity.PackageBooking;
import com.milan.Ghumgham_travels.packagebooking.repository.PackageBookingRepository;
import com.milan.Ghumgham_travels.room.model.entity.Room;
import com.milan.Ghumgham_travels.room.repository.RoomRepository;
import com.milan.Ghumgham_travels.roombooking.model.dto.RoomBookingDto;
import com.milan.Ghumgham_travels.roombooking.model.dto.RoomPackageBookingDto;
import com.milan.Ghumgham_travels.roombooking.model.entity.RoomBooking;
import com.milan.Ghumgham_travels.roombooking.model.entity.RoomBookingStatus;
import com.milan.Ghumgham_travels.roombooking.repository.RoomBookingRepository;
import com.milan.Ghumgham_travels.roombooking.service.RoomBookingInterface;
import com.milan.Ghumgham_travels.security.MyUserDetails;
import com.milan.Ghumgham_travels.user.model.entity.User;
import com.milan.Ghumgham_travels.utils.DtoConverter;
import com.milan.Ghumgham_travels.utils.exceptions.SendErrorMessageCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomBookingImpl implements RoomBookingInterface {

    @Autowired
    RoomBookingRepository repo;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    PackageBookingRepository packageRepository;

    @Override
    public RoomBooking saveRoomBooking(RoomBookingDto dto){
        RoomBooking roomBooking = DtoConverter.convert(dto);
        roomBooking.setStatus(RoomBookingStatus.Pending);
        roomBooking.setBookedBy(getLoggedInUser());
        roomBooking.setRoom(roomRepository.findById(dto.getRoomId()).orElseThrow(()->new SendErrorMessageCustom("No Room Of Such")));
        return repo.save(roomBooking);
    }

    @Override
    public List<RoomBooking> getByLoggedInUser(){

            User loggedInUser = getLoggedInUser();
            return repo.findByBookedByOrderByIdDesc(loggedInUser);

    }

    @Override
    public RoomPackageBookingDto getBothByLoggedInUser(){
        User loggedInUser = getLoggedInUser();
       List<RoomBooking> room=  repo.findByBookedByOrderByIdDesc(loggedInUser);
       List<PackageBooking> packages = packageRepository.findByBookedBy(loggedInUser);
       RoomPackageBookingDto dto = DtoConverter.convert(room,packages);
       return dto;
    }

    @Override
    public RoomBooking changeStatus(int bookingId, RoomBookingStatus status){
        RoomBooking roomBooking = repo.findById(bookingId).orElseThrow(()-> new SendErrorMessageCustom("No Room Of Such Id"));
        roomBooking.setStatus(status);
        return repo.save(roomBooking);
    }

    @Override
    public List<RoomBooking> getAll(){
        return repo.findAll();
    }

    @Override
    public List<RoomBooking> getByRoomId(int roomId){
        Room room = new Room();
        room.setId(roomId);
        return repo.findByRoom(room);
    }

    @Override
    public RoomBooking updatePayment(int id, float amount){
        RoomBooking booking = repo.findById(id).orElse(null);
        booking.setPayment(amount);
        return repo.save(booking);
    }

    @Override
    public RoomBooking getById(int id){
        return repo.findById(id).orElse(null);
    }


    public User getLoggedInUser(){
        try {
            return ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getUser();
        }catch (Exception ex){
            throw new SendErrorMessageCustom("User is not logged in ");
        }
    }
}
