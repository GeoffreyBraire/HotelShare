package com.esgi.annualproject.HotelShareApplication.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "BED")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Bed extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BED")
    private long idBed;

    @OneToMany(mappedBy = "bed")
    private Set<Room> rooms;

    @Column(name = "NAME_BED")
    private String nameBed;
}
