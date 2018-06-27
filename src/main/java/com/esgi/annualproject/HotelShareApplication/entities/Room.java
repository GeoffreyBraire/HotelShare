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
@Table(name = "ROOM")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Room extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ROOM")
    private long idRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_HOTEL", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ROOMTYPE", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RoomType roomType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_BED", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Bed bed;

    @OneToMany(mappedBy = "room")
    private Set<Reservation> reservations;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "ROOM_EQUIPMENT",
            joinColumns = { @JoinColumn(name = "ID_ROOM") },
            inverseJoinColumns = { @JoinColumn(name = "ID_EQUIPMENT") })
    private Set<Equipment> equipments;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "rooms")
    private Set<Review> reviews;

    @Column(name = "NUMBER_ROOMS")
    private int numberRooms;

    @Column(name = "NUMBER_BEDS")
    private int numberBeds;

    @Column(name = "MAXIMUM_GUEST_ALLOWED")
    private int maximumGuestAllowed;

    @Column(name = "ROOM_SIZE")
    private int roomSize;

    @Column(name = "ROOM_PRICE")
    private long roomPrice;

    @Column(name = "NAME_CONTACT")
    private String nameContact;


}
