package com.esgi.annualproject.HotelShareApplication.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "COUNTRY")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Country extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COUNTRY")
    private long idCountry;

    @OneToMany(mappedBy = "country")
    private Set<Address> addresses;

    @Column(name = "NAME_COUNTRY")
    private String nameCountry;
}
