package com.milan.Ghumgham_travels.hotel.service.impl;

import com.milan.Ghumgham_travels.hotel.model.dto.HotelDto;
import com.milan.Ghumgham_travels.hotel.model.entity.Hotel;
import com.milan.Ghumgham_travels.hotel.repository.HotelRepository;
import com.milan.Ghumgham_travels.hotel.repository.HotelReviewRepository;
import com.milan.Ghumgham_travels.hotel.service.HotelInterface;
import com.milan.Ghumgham_travels.hotelpackage.model.entity.Package;
import com.milan.Ghumgham_travels.hotelpackage.repository.PackageRepository;
import com.milan.Ghumgham_travels.hotelpackage.service.PackageInterface;
import com.milan.Ghumgham_travels.places.model.entity.Places;
import com.milan.Ghumgham_travels.places.repository.PlacesRepository;
import com.milan.Ghumgham_travels.room.model.entity.Room;
import com.milan.Ghumgham_travels.room.repository.RoomRepository;
import com.milan.Ghumgham_travels.room.service.RoomInterface;
import com.milan.Ghumgham_travels.security.MyUserDetails;
import com.milan.Ghumgham_travels.user.model.entity.User;
import com.milan.Ghumgham_travels.utils.DtoConverter;
import com.milan.Ghumgham_travels.utils.exceptions.SendErrorMessageCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelImpl implements HotelInterface {

    @Autowired
    HotelRepository repository;

    @Autowired
    PlacesRepository placesRepository;

    @Autowired
    RoomInterface roomInterface;

    @Autowired
    PackageInterface packageInterface;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    PackageRepository packageRepository;

    @Autowired
    HotelReviewRepository hotelReviewRepository;

    @Override
    public Hotel save(HotelDto dto) {
        Hotel hotel = DtoConverter.convert(dto);
        hotel.setOwned_by(getLoggedInUser());
        hotel.setPlaces(placesRepository.findById(dto.getPlaceId()).orElseThrow(()->new SendErrorMessageCustom("No Places with such Id")));
        return repository.save(hotel);
    }

    @Override
    public Page<Hotel> getHotels(int page, int size, int id){
        Places places = new Places();
        places.setId(id);
        return repository.findByPlaces(places, PageRequest.of(page,size));
    }

    @Override
    public List<Hotel> getAll(){
        return repository.findAll();
    }

    @Override
    public Hotel getHotelById(int id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public void hotelDelete(int id){
        Hotel hotel = new Hotel();
        hotel.setId(id);
        List<Room> rooms = roomRepository.findByHotel(hotel);
        for (Room r: rooms){
            roomInterface.deleteByRoomId(r.getId());
        }
        List<Package> packages = packageRepository.findByHotel(hotel);
        for (Package p: packages){
            packageInterface.deleteById(p.getId());
        }
        hotelReviewRepository.deleteAll(hotelReviewRepository.findByHotelOrderByIdDesc(hotel));
        repository.delete(hotel);
    }


    public Hotel getHotelByLoggedInUser(){
        return repository.findByOwned_by(getLoggedInUser()).get(0);
    }

    public User getLoggedInUser(){
        return ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getUser();
    }
}
