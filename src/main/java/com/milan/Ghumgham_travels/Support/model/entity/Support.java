package com.milan.Ghumgham_travels.Support.model.entity;

import com.milan.Ghumgham_travels.hotel.model.entity.Hotel;
import com.milan.Ghumgham_travels.user.model.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Support {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String supportDesc;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User supportBy;


}
