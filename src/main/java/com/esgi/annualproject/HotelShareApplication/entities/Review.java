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
@Table(name = "REVIEW")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Review extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REVIEW")
    private long idReview;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE
            })
    @JoinTable(name = "REVIEW_USER",
            joinColumns = { @JoinColumn(name = "ID_REVIEW") },
            inverseJoinColumns = { @JoinColumn(name = "ID_USER") })
    private Set<User> users;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE
            })
    @JoinTable(name = "REVIEW_HOTEL",
            joinColumns = { @JoinColumn(name = "ID_REVIEW") },
            inverseJoinColumns = { @JoinColumn(name = "ID_HOTEL") })
    private Set<Hotel> hotels;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE
            })
    @JoinTable(name = "REVIEW_ROOM",
            joinColumns = { @JoinColumn(name = "ID_REVIEW") },
            inverseJoinColumns = { @JoinColumn(name = "ID_ROOM") })
    private Set<Room> rooms;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "NUMBER_STARS")
    private int numberStars;
}
