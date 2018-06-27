package com.esgi.annualproject.HotelShareApplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "HOTEL")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Hotel extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HOTEL")
    private long idHotel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_HOTELTYPE", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private HotelType hotelType;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "hotel")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "HOTEL_LANGUAGE",
            joinColumns = { @JoinColumn(name = "ID_HOTEL") },
            inverseJoinColumns = { @JoinColumn(name = "ID_LANGUAGE") })
    private Set<Language> languages;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "HOTEL_CREDITCARD",
            joinColumns = { @JoinColumn(name = "ID_HOTEL") },
            inverseJoinColumns = { @JoinColumn(name = "ID_CREDITCARD") })
    private Set<CreditCard> creditCards;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "HOTEL_EQUIPMENT",
            joinColumns = { @JoinColumn(name = "ID_HOTEL") },
            inverseJoinColumns = { @JoinColumn(name = "ID_EQUIPMENT") })
    private Set<Equipment> equipments;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "hotels")
    private Set<Review> reviews;

    @Column(name = "NAME_HOTEL")
    private String nameHotel;

    @Column(name = "NUMBER_ROOMS")
    private int numberRooms;

    @Column(name = "NUMBER_STARS")
    private int numberStars;

    @Column(name = "NAME_CONTACT")
    private String nameContact;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "HAS_PARKING")
    private boolean hasParking;

    @Column(name = "WEB_URL")
    private String webURL;

    @Column(name = "ARRIVAL_TIME")
    private String arrivalTime;

    @Column(name = "DEPARTURE_TIME")
    private String departureTime;

    @Column(name = "INTERNET_AVAILABILITY")
    private boolean internetAvailability;

    @Column(name = "INTERNET_COST")
    private long internetCost;

    @Column(name = "PARKING_AVAILABILITY")
    private boolean parkingAvailability;

    @Column(name = "PARKING_COST")
    private long parkingCost;

    @Column(name = "BREAKFAST_AVAILABILITY")
    private boolean breakfastAvailability;

    @Column(name = "BREAKFAST_COST")
    private long breakfastCost;

    @Column(name = "CHILDREN_ALLOWED")
    private boolean childrenAllowed;

    @Column(name = "ANIMALS_ALLOWED")
    private boolean animalAllowed;
}
