package com.milan.Ghumgham_travels.places.model.entity;

import com.milan.Ghumgham_travels.hotel.model.entity.Hotel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Places {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String placeName;

    private String filename;



    @Column(length = 5000)
    private String shortDesc;

    @Column(length = 10000)
    private String placeDesc;

    @OneToMany(mappedBy = "places")
    private List<Hotel> hotels;

}
