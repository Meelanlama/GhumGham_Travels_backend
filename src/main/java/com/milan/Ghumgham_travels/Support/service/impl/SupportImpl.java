package com.milan.Ghumgham_travels.Support.service.impl;

import com.milan.Ghumgham_travels.Support.model.dto.SupportDto;
import com.milan.Ghumgham_travels.Support.model.entity.Support;
import com.milan.Ghumgham_travels.Support.repository.SupportRepository;
import com.milan.Ghumgham_travels.Support.service.SupportInterface;
import com.milan.Ghumgham_travels.hotel.model.entity.Hotel;
import com.milan.Ghumgham_travels.hotel.repository.HotelRepository;
import com.milan.Ghumgham_travels.security.MyUserDetails;
import com.milan.Ghumgham_travels.user.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupportImpl implements SupportInterface {

    @Autowired
    SupportRepository repo;

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Support saveSupport(SupportDto dto){
        Support support = new Support();
        support.setSupportBy(getLoggedInUser());
        support.setSupportDesc(dto.getSupportDesc());
        support.setHotel(hotelRepository.findById(dto.getHotelId()).orElse(null));
        return repo.save(support);
    }

    @Override
    public List<Support> findByHotelId(int hotelId){
        Hotel hotel = new Hotel();
        hotel.setId(hotelId);
        return repo.findByHotel(hotel);
    }

    @Override
    public List<Support> findAll(){
        return repo.findAll();
    }

    @Override
    public void deleteById( int id){
        repo.deleteById(id);
    }


    public User getLoggedInUser(){
        return ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getUser();

    }

}
