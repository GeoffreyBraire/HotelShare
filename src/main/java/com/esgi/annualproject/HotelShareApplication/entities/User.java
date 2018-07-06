package com.esgi.annualproject.HotelShareApplication.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.xml.bind.DatatypeConverter;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Set;


@Entity
@Table(name = "USER")
@Getter @NoArgsConstructor
public class User extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER")
    private long idUser;

    @Setter
    @OneToOne(cascade =  CascadeType.ALL, mappedBy = "user")
    private UserProfile userProfile;

    @Setter
    @OneToMany(mappedBy = "user")
    private Set<Hotel> hotels;

    @Setter
    @OneToMany(mappedBy = "user")
    private Set<Room> rooms;

    @Setter
    @OneToMany(mappedBy = "user")
    private Set<Reservation> reservations;

    @Setter
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "users")
    private Set<Review> reviews;

    @Setter
    @NotNull
    @Column(name = "LOGIN")
    private String login;

    @Setter
    @NotNull
    @Email
    @Column(name = "EMAIL_ADDRESS", unique = true)
    private String emailAddress;

    @NotNull
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "IS_ADMIN")
    private boolean isAdmin;

    @Column(name = "FIRSTNAME")
    private String fisrtname;

    @Column(name = "LASTNAME")
    private String lastname;

    public void setPassword(String password) {
        this.password = getSHA256Hash(password);
    }

    public User(UserProfile userProfile, Set<Hotel> hotels, Set<Room> rooms, Set<Reservation> reservations, Set<Review> reviews, @NotNull String login, @NotNull @Email String emailAddress, @NotNull String password, boolean isAdmin, String fisrtname, String lastname) {
        this.userProfile = userProfile;
        this.hotels = hotels;
        this.rooms = rooms;
        this.reservations = reservations;
        this.reviews = reviews;
        this.login = login;
        this.emailAddress = emailAddress;
        this.password = getSHA256Hash(password);
        this.isAdmin = isAdmin;
        this.fisrtname = fisrtname;
        this.lastname = lastname;
    }

    public User(@NotNull String login, @NotNull @Email String emailAddress, @NotNull String password, boolean isAdmin, String fisrtname, String lastname) {
        this.login = login;
        this.emailAddress = emailAddress;
        this.password = getSHA256Hash(password);
        this.isAdmin = isAdmin;
        this.fisrtname = fisrtname;
        this.lastname = lastname;
    }

    private String getSHA256Hash(String data) {
        String result = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes("UTF-8"));
            return bytesToHex(hash); // make it printable
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * Use javax.xml.bind.DatatypeConverter class in JDK to convert byte array
     * to a hexadecimal string. Note that this generates hexadecimal in upper case.
     * @param hash
     * @return
     */
    private String  bytesToHex(byte[] hash) {
        return DatatypeConverter.printHexBinary(hash);
    }

}