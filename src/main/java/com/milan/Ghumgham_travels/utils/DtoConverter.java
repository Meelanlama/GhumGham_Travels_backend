package com.milan.Ghumgham_travels.utils;


import com.milan.Ghumgham_travels.Support.model.dto.SupportDto;
import com.milan.Ghumgham_travels.Support.model.entity.Support;
import com.milan.Ghumgham_travels.hotel.model.dto.HotelDto;
import com.milan.Ghumgham_travels.hotel.model.dto.HotelReviewDto;
import com.milan.Ghumgham_travels.hotel.model.entity.Hotel;
import com.milan.Ghumgham_travels.hotel.model.entity.HotelReview;
import com.milan.Ghumgham_travels.hotelpackage.model.dto.PackageDto;
import com.milan.Ghumgham_travels.hotelpackage.model.entity.Package;
import com.milan.Ghumgham_travels.packagebooking.model.dto.PackageBookingDto;
import com.milan.Ghumgham_travels.packagebooking.model.entity.PackageBooking;
import com.milan.Ghumgham_travels.personrole.model.PersonRole;
import com.milan.Ghumgham_travels.personrole.model.PersonRoleDto;
import com.milan.Ghumgham_travels.login.model.Dto.LoginDto;
import com.milan.Ghumgham_travels.login.model.Login;
import com.milan.Ghumgham_travels.places.model.dto.PlacesDto;
import com.milan.Ghumgham_travels.places.model.entity.Places;
import com.milan.Ghumgham_travels.room.model.dto.RoomDto;
import com.milan.Ghumgham_travels.room.model.dto.RoomReviewDto;
import com.milan.Ghumgham_travels.room.model.entity.Room;
import com.milan.Ghumgham_travels.room.model.entity.RoomReview;
import com.milan.Ghumgham_travels.room.model.entity.RoomStatus;
import com.milan.Ghumgham_travels.roombooking.model.dto.RoomBookingDto;
import com.milan.Ghumgham_travels.roombooking.model.dto.RoomPackageBookingDto;
import com.milan.Ghumgham_travels.roombooking.model.entity.RoomBooking;
import com.milan.Ghumgham_travels.user.model.dto.UserDto;
import com.milan.Ghumgham_travels.user.model.dto.UserRegisterDto;
import com.milan.Ghumgham_travels.user.model.entity.User;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

public class DtoConverter {

    public static UserDto convert(User entity){
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setPhoneNo(entity.getPhoneNo());
        dto.setFullName(entity.getFullName());
        dto.setUserName(entity.getLogin().getUsername());
        return dto;
    }

    public static User convert(UserDto dto){
        User entity = new User();
        entity.setFullName(dto.getFullName());
        entity.setPhoneNo(dto.getPhoneNo());
        return entity;

    }


    public static PersonRoleDto convert(PersonRole personRole){
        PersonRoleDto dto = new PersonRoleDto();
        dto.setId(personRole.getId());
        dto.setName(personRole.getRoleName());
        return dto;
    }


    public static LoginDto convert(Login login){
        LoginDto dto = new LoginDto();
        dto.setId(login.getId());
        dto.setStatus(login.getStatus());
        dto.setUserRoles(login.getUserRole().getRoleName());
        dto.setEmail(login.getUsername());
        dto.setUserRole(login.getUserRole().getId());
        return dto;
    }
    public static UserRegisterDto convertSend(User user){
        UserRegisterDto dto = new UserRegisterDto();
        if (user!=null) {
            dto.setUser(convert(user));
            dto.setLogin(convert(user.getLogin()));
            return dto;
        }

        return dto;
    }

    public static Places convert(PlacesDto dto){
        Places entity = new Places();
        entity.setId(dto.getId());
        entity.setPlaceName(dto.getPlaceName());
        entity.setFilename(dto.getFilename());
        entity.setShortDesc(dto.getShortDesc());
        entity.setPlaceDesc(dto.getPlaceDesc());
        return entity;
    }

    public static PlacesDto convert(Places entity){
        PlacesDto dto = new PlacesDto();
        dto.setId(entity.getId());
        dto.setPlaceName(entity.getPlaceName());
        dto.setFilename(entity.getFilename());
        dto.setShortDesc(entity.getShortDesc());
        dto.setPlaceDesc(entity.getPlaceDesc());
        return dto;
    }

    public static Hotel convert(HotelDto dto){
        Hotel hotel = new Hotel();
        hotel.setId(dto.getId());
        hotel.setHotelDesc(dto.getHotelDesc());
        hotel.setHotelName(dto.getHotelName());
        hotel.setRatings(dto.getRatings());
        hotel.setFilename(dto.getFilename());
        return hotel;
    }


    public static HotelDto convert(Hotel entity){
        HotelDto dto = new HotelDto();
        dto.setId(entity.getId());
        dto.setHotelDesc(entity.getHotelDesc());
        dto.setHotelName(entity.getHotelName());
        dto.setRatings(entity.getRatings());
        dto.setFilename(entity.getFilename());
        dto.setPlaceId(entity.getPlaces().getId());
        dto.setOwned_by(convert(entity.getOwned_by()));
        dto.setPlaceName(entity.getPlaces().getPlaceName());
        return dto;
    }

    public static UserRegisterDto convertF(Login login){
        UserRegisterDto userRegisterDt = new UserRegisterDto();
        userRegisterDt.setUser(convert(login.getUser()));
        userRegisterDt.setLogin(convertFor(login));

        return userRegisterDt;
    }
    public static  LoginDto convertFor(Login login){
        LoginDto dto = new LoginDto();
        dto.setEmail(login.getUsername());
        dto.setStatus(login.getStatus());
        dto.setUserRoles(login.getUserRole().getRoleName());
        dto.setUserRole(login.getUserRole().getId());
        return dto;
    }

    public static HotelReviewDto convert(HotelReview hotelReview){
        HotelReviewDto dto = new HotelReviewDto();
        dto.setId(hotelReview.getId());
        dto.setReviewDesc(hotelReview.getReviewDesc());
        dto.setHotelId(hotelReview.getHotel().getId());
        dto.setReviewBy(DtoConverter.convert(hotelReview.getReviewBy()));

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        dto.setRating(hotelReview.getRating());

        dto.setReviewDate(dateFormat.format(hotelReview.getReviewDate()));
        return dto;
    }

    public static HotelReview convert(HotelReviewDto dto){
        HotelReview entity = new HotelReview();
        entity.setId(dto.getId());
        entity.setReviewDesc(dto.getReviewDesc());
        entity.setRating(dto.getRating());
        return entity;
    }

public static Room convert(RoomDto dto){
        Room room = new Room();
        room.setId(dto.getId());
        room.setRoomDesc(dto.getRoomDesc());
        room.setRoomType(dto.getRoomType());
        room.setPrice(dto.getPrice());
        room.setFilename(dto.getFilename());
        room.setRating(dto.getRating());
        room.setTotalPerson(dto.getTotalPerson());
        room.setBed(dto.getBed());
        room.setRoomStatus(RoomStatus.Available);
        return room;
}

    public static RoomDto convert(Room entity){
        RoomDto dto = new RoomDto();
        dto.setId(entity.getId());
        dto.setRoomDesc(entity.getRoomDesc());
        dto.setRoomType(entity.getRoomType());
        dto.setPrice(entity.getPrice());
        dto.setFilename(entity.getFilename());
        dto.setRating(entity.getRating());
        dto.setHotelId(entity.getHotel().getId());
        dto.setTotalPerson(entity.getTotalPerson());
        dto.setBed(entity.getBed());
        dto.setStatus(entity.getRoomStatus());
        return dto;
    }

    public static Package convert(PackageDto dto){
        Package packages = new Package();
        packages.setPackageDesc(dto.getPackageDesc());
        packages.setPrice(dto.getPrice());
        packages.setId(dto.getId());
        packages.setPackageName(dto.getPackageName());
        return packages;
    }

    public static PackageDto convert(Package entity){
        PackageDto dto = new PackageDto();
        dto.setPackageDesc(entity.getPackageDesc());
        dto.setPrice(entity.getPrice());
        dto.setId(entity.getId());
        dto.setPackageName(entity.getPackageName());
        dto.setHotelId(entity.getHotel().getId());
        return dto;
    }

    public static RoomBookingDto convert(RoomBooking roomBooking){
        RoomBookingDto dto = new RoomBookingDto();
        dto.setId(roomBooking.getId());
        dto.setStatus(roomBooking.getStatus());
        dto.setPayment(roomBooking.getPayment());
        dto.setBookedBy(convert(roomBooking.getBookedBy()));
        dto.setRoomId(roomBooking.getRoom().getId());
        dto.setAdditionalRequest(roomBooking.getAdditionalRequest());
        dto.setCheckInDate(roomBooking.getCheckInDate());
        dto.setCheckOutDate(roomBooking.getCheckOutDate());
        dto.setHotel(convert(roomBooking.getRoom().getHotel()));
        dto.setRoom(convert(roomBooking.getRoom()));
        return dto;
    }

    public static RoomBooking convert(RoomBookingDto dto){
        RoomBooking entity = new RoomBooking();
        entity.setId(dto.getId());
        entity.setStatus(dto.getStatus());
        entity.setPayment(dto.getPayment());
        entity.setAdditionalRequest(dto.getAdditionalRequest());
        entity.setCheckInDate(dto.getCheckInDate());
        entity.setCheckOutDate(dto.getCheckOutDate());
        return entity;
    }


    public static PackageBookingDto convert(PackageBooking packageBooking){
        PackageBookingDto dto = new PackageBookingDto();
        dto.setId(packageBooking.getId());
        dto.setStatus(packageBooking.getStatus());
        dto.setPayment(packageBooking.getPayment());
        dto.setBookedBy(convert(packageBooking.getBookedBy()));
        dto.setPackageId(packageBooking.getAPackages().getId());
        dto.setAdditionalRequest(packageBooking.getAdditionalRequest());
        dto.setCheckInDate(packageBooking.getCheckInDate());
        dto.setCheckOutDate(packageBooking.getCheckOutDate());
        dto.setApackage(convert(packageBooking.getAPackages()));
        dto.setHotel(convert(packageBooking.getAPackages().getHotel()));
        return dto;
    }

    public static PackageBooking convert(PackageBookingDto dto){
        PackageBooking entity = new PackageBooking();
        entity.setId(dto.getId());
        entity.setStatus(dto.getStatus());
        entity.setPayment(dto.getPayment());
        entity.setAdditionalRequest(dto.getAdditionalRequest());
        entity.setCheckInDate(dto.getCheckInDate());
        entity.setCheckOutDate(dto.getCheckOutDate());
        return entity;
    }


    public static RoomReviewDto convert(RoomReview roomReview){
        RoomReviewDto dto = new RoomReviewDto();
        dto.setId(roomReview.getId());
        dto.setReviewDesc(roomReview.getReviewDesc());
        dto.setRoomId(roomReview.getRoom().getId());
        dto.setReviewBy(DtoConverter.convert(roomReview.getReviewBy()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dto.setRating(roomReview.getRating());
        dto.setReviewDate(dateFormat.format(roomReview.getReviewDate()));
        return dto;
    }

    public static RoomReview convert(RoomReviewDto dto){
        RoomReview entity = new RoomReview();
        entity.setId(dto.getId());
        entity.setReviewDesc(dto.getReviewDesc());
        entity.setRating(dto.getRating());
        return entity;
    }
    public static RoomPackageBookingDto convert(List<RoomBooking> roomBooking, List<PackageBooking> packageBookings){
        RoomPackageBookingDto dto = new RoomPackageBookingDto();
        dto.setRoom(roomBooking.stream().map(DtoConverter::convert).collect(Collectors.toList()));
        dto.setPackages(packageBookings.stream().map(DtoConverter::convert).collect(Collectors.toList()));
        return dto;
    }

    public static SupportDto convert(Support support){
        SupportDto dto = new SupportDto();
        dto.setId(support.getId());
        dto.setSupportDesc(support.getSupportDesc());
        dto.setHotelId(support.getHotel().getId());
        dto.setUser(convert(support.getSupportBy()));
        dto.setHotel(convert(support.getHotel()));
        return dto;
    }



}
