package com.milan.Ghumgham_travels.hotel.service.impl;

import com.milan.Ghumgham_travels.hotel.model.dto.HotelReviewDto;
import com.milan.Ghumgham_travels.hotel.model.entity.Hotel;
import com.milan.Ghumgham_travels.hotel.model.entity.HotelReview;
import com.milan.Ghumgham_travels.hotel.repository.HotelRepository;
import com.milan.Ghumgham_travels.hotel.repository.HotelReviewRepository;
import com.milan.Ghumgham_travels.hotel.service.HotelReviewInterface;
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
public class HotelReviewImpl implements HotelReviewInterface {


    @Autowired
    HotelReviewRepository repo;

    @Autowired
    HotelRepository hotelRepository;


    @Override
    public HotelReview saveHotelReview(HotelReviewDto dto){
        HotelReview hotelReview = DtoConverter.convert(dto);
        hotelReview.setReviewBy(getLoggedInUser());
        hotelReview.setReviewDate(new Date());
        hotelReview.setHotel(hotelRepository.findById(dto.getHotelId()).orElseThrow(()->new SendErrorMessageCustom("No hotel id of such")));
        return repo.save(hotelReview);
    }

    @Override
    public List<HotelReview> getByHotelId(int id){
        Hotel hotel = new Hotel();
        hotel.setId(id);
        return repo.findByHotelOrderByIdDesc(hotel);
    }

    public void deleteHotelReview(int id){
        repo.deleteById(id);
    }
    public User getLoggedInUser(){
        try {
            return ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getUser();
        }catch (Exception ex){
            throw new SendErrorMessageCustom("Token not available");
        }
    }
}
