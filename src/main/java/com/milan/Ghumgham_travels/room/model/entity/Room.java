package com.milan.Ghumgham_travels.room.model.entity;

import com.milan.Ghumgham_travels.hotel.model.entity.Hotel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String filename;


    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;

    private int bed;

    private int totalPerson;

    private int rating;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private float price;

    @Column(length = 5000)
    private String roomDesc;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Hotel hotel;



}
