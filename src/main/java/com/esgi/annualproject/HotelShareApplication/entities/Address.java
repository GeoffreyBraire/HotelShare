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

@Entity
@Table(name = "ADDRESS")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Address extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ADDRESS")
    private long idAddress;

    @OneToOne()
    @JoinColumn(name = "ID_PROFILE", nullable = false)
    private UserProfile userProfile;

    @OneToOne()
    @JoinColumn(name = "ID_HOTEL", nullable = false)
    private Hotel hotel;

    @ManyToOne()
    @JoinColumn(name = "ID_COUNTRY", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Country country;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET_NAME")
    private String streetName;

    @Column(name = "STREET_NUMBER")
    private String streetNumber;
}
