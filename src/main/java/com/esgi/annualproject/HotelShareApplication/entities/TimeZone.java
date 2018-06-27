package com.esgi.annualproject.HotelShareApplication.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "TIMEZONE")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TimeZone extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIMEZONE")
    private long idTimeZone;

    @OneToMany(mappedBy = "timeZone")
    private Set<UserProfile> userProfiles;

    @Column(name = "ABBREVIATION")
    private String abbreviation;

    @Column(name = "NAME_TIMEZONE")
    private String nameTimeZone;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "OFFSET")
    private String offset;
}
