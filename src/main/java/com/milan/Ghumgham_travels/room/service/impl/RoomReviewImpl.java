package com.milan.Ghumgham_travels.room.service.impl;

import com.milan.Ghumgham_travels.room.model.dto.RoomReviewDto;
import com.milan.Ghumgham_travels.room.model.entity.Room;
import com.milan.Ghumgham_travels.room.model.entity.RoomReview;
import com.milan.Ghumgham_travels.room.repository.RoomRepository;
import com.milan.Ghumgham_travels.room.repository.RoomReviewRepository;
import com.milan.Ghumgham_travels.room.service.RoomReviewInterface;
import com.milan.Ghumgham_travels.security.MyUserDetails;
import com.milan.Ghumgham_travels.user.model.entity.User;
import com.milan.Ghumgham_travels.utils.DtoConverter;
import com.milan.Ghumgham_travels.utils.exceptions.SendErrorMessageCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoomReviewImpl implements RoomReviewInterface {

    @Autowired
    RoomReviewRepository repo;

    @Autowired
    RoomRepository hotelRepository;


    @Override
    public RoomReview saveRoomReview(RoomReviewDto dto){
        RoomReview roomReview = DtoConverter.convert(dto);
        roomReview.setReviewBy(getLoggedInUser());
        roomReview.setReviewDate(new Date());
        roomReview.setRoom(hotelRepository.findById(dto.getRoomId()).orElseThrow(()->new SendErrorMessageCustom("No hotel id of such")));
        return repo.save(roomReview);
    }

    @Override
    public List<RoomReview> getByRoomId(int id){
        Room room = new Room();
        room.setId(id);
        return repo.findByRoomOrderByIdDesc(room);
    }

    public User getLoggedInUser(){
        try {
            return ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getUser();
        }catch (Exception ex){
            throw new SendErrorMessageCustom("Token not available");
        }
    }

    @Override
    public void deleteRoomReview(int id){
        repo.deleteById(id);

    }
}
