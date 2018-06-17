package com.esgi.annualproject.HotelShareApplication.models;

import com.esgi.annualproject.HotelShareApplication.Enums.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "UserProfiles")
public class UserProfile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROFILE")
    private Long idUserProfile;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER_PROFILE")
    private User user;

    @NotNull
    @Column(name = "IS_ADMIN")
    private boolean isAdmin;

    @NotNull
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotNull
    @Column(name = "LAST_NAME")
    private String lastName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER")
    private Gender gender;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @NotNull
    @Column(name = "PHONE_NUMBER")
    @Size(max = 15)
    private String phoneNumber;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name= "FAVORITE_LANGUAGE")
    private Language favoriteLanguage;

    @Column(name = "LIST_OF_LANGUAGES")
    private ArrayList<Language> languages;

    @NotNull
    @Column(name = "FAVORITE_CURRENCY")
    private Currency favoriteCurrency;

    @NotNull
    @Column(name = "COUNTRY_RESIDENCE")
    private Country countryResidence;

    @Column(name = "POSTAL_ADDRESS")
    private String postalAddress;

    @NotNull
    @Column(name = "USER_DESCRIPTION")
    private String userDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "FAMILY_STATUS")
    private FamilyStatus familyStatus;

    @Column(name= "SCHOOL")
    private String school;

    @Column(name= "ACTUAL_JOB")
    private String actualJob;

    @Enumerated(EnumType.STRING)
    @Column(name= "TIME_ZONE")
    private TimeZone timeZone;

    @NotNull
    @Column(name="INSERT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;

    @NotNull
    @Column(name="UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER")
    private int userUpdate;

    @Column(name="END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    public UserProfile() { }

    public UserProfile(@NotNull boolean isAdmin, @NotNull String firstName,
                            @NotNull String lastName, @NotNull Gender gender, @NotNull Date birthDate,
                            @NotNull @Size(max = 15) String phoneNumber, @NotNull Language favoriteLanguage,
                            ArrayList<Language> languages, @NotNull Currency favoriteCurrency,
                            @NotNull Country countryResidence, String postalAddress, @NotNull String userDescription,
                            FamilyStatus familyStatus, String school, String actualJob, TimeZone timeZone,
                            @NotNull Date createdDate, @NotNull Date updatedDate, int userUpdate, Date endDate) {
        this.isAdmin = isAdmin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.favoriteLanguage = favoriteLanguage;
        this.languages = languages;
        this.favoriteCurrency = favoriteCurrency;
        this.countryResidence = countryResidence;
        this.postalAddress = postalAddress;
        this.userDescription = userDescription;
        this.familyStatus = familyStatus;
        this.school = school;
        this.actualJob = actualJob;
        this.timeZone = timeZone;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.userUpdate = userUpdate;
        this.endDate = endDate;
    }

    public Long getIdUserProfile() {
        return idUserProfile;
    }

    public void setIdUserProfile(Long idUserProfile) {
        this.idUserProfile = idUserProfile;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Language getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(Language favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public ArrayList<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<Language> languages) {
        this.languages = languages;
    }

    public Currency getFavoriteCurrency() {
        return favoriteCurrency;
    }

    public void setFavoriteCurrency(Currency favoriteCurrency) {
        this.favoriteCurrency = favoriteCurrency;
    }

    public Country getCountryResidence() {
        return countryResidence;
    }

    public void setCountryResidence(Country countryResidence) {
        this.countryResidence = countryResidence;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public FamilyStatus getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(FamilyStatus familyStatus) {
        this.familyStatus = familyStatus;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getActualJob() {
        return actualJob;
    }

    public void setActualJob(String actualJob) {
        this.actualJob = actualJob;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(int userUpdate) {
        this.userUpdate = userUpdate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}