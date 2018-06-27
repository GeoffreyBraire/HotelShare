package com.esgi.annualproject.HotelShareApplication.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "CURRENCY")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Currency extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CURRENCY")
    private long idCurrency;

    @OneToMany(mappedBy = "currency")
    private Set<UserProfile> userProfiles;

    @Column(name = "NAME_CURRENCY")
    private String nameCurrency;
}
