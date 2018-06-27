package com.esgi.annualproject.HotelShareApplication.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "ROOM_TYPE")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RoomType extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ROOMTYPE")
    private long idRoomType;

    @OneToMany(mappedBy = "roomType")
    private Set<Room> rooms;

    @Column(name = "NAME_ROOMTYPE")
    private String nameRoomType;
}
