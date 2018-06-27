package com.esgi.annualproject.HotelShareApplication.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "HOTEL_TYPE")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class HotelType extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HOTELTYPE")
    private long idHotelType;

    @OneToMany(mappedBy = "hotelType")
    private Set<Hotel> hotels;

    @Column(name = "NAME_HOTELTYPE")
    private String nameHotelType;
}
