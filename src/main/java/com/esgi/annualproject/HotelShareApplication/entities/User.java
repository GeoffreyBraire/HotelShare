package com.esgi.annualproject.HotelShareApplication.entities;

import lombok.AllArgsConstructor;
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
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER")
    private long idUser;

    @OneToOne(cascade =  CascadeType.ALL, mappedBy = "user")
    private UserProfile userProfile;

    @OneToMany(mappedBy = "user")
    private Set<Hotel> hotels;

    @OneToMany(mappedBy = "user")
    private Set<Room> rooms;

    @OneToMany(mappedBy = "user")
    private Set<Reservation> reservations;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "users")
    private Set<Review> reviews;

    @NotNull
    @Column(name = "LOGIN")
    private String login;

    @NotNull
    @Email
    @Column(name = "EMAIL_ADDRESS", unique = true)
    private String emailAddress;

    @NotNull
    @Column(name = "PASSWORD")
    private String password;

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