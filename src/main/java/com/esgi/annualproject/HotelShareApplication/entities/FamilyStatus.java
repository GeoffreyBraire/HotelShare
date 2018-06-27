package com.esgi.annualproject.HotelShareApplication.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "FAMILY_STATUS")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class FamilyStatus extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_STATUS")
    private long idStatus;

    @OneToMany(mappedBy = "familyStatus")
    private Set<UserProfile> userProfiles;

    @Column(name = "NAME_STATUS")
    private String nameStatus;
}
