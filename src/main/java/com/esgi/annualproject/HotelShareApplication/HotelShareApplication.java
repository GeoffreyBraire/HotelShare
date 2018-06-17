package com.esgi.annualproject.HotelShareApplication;

import com.esgi.annualproject.HotelShareApplication.models.User;
import com.esgi.annualproject.HotelShareApplication.repositories.UserProfileRepository;
import com.esgi.annualproject.HotelShareApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HotelShareApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepo;

    @Autowired
    UserProfileRepository userProfRepo;

	public static void main(String[] args) {
		SpringApplication.run(HotelShareApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
	    userProfRepo.deleteAll();
	    userRepo.deleteAll();

		User user = new User();
		user.setEmailAddress("mail@yahoo.fr");
		user.setEncryptedPassword("passwordTest");

        /*UserProfile userProf = new UserProfile();
        userProf.setFirstName("Prenom");
        userProf.setLastName("Nom");
        userProf.setAdmin(false);
        userProf.setGender(Gender.MALE);
        userProf.setBirthDate(new Date());
        userProf.setActualJob("Student");
        userProf.setCountryResidence(Country.France);
        userProf.setFavoriteCurrency(Currency.Euro);
        userProf.setFamilyStatus(FamilyStatus.SINGLE);
        userProf.setFavoriteLanguage(Language.FRENCH);

        ArrayList<Language> languages = new ArrayList<Language>();
            languages.add(Language.FRENCH);
            languages.add(Language.ENGLISH);
            languages.add(Language.GERMAN);
        userProf.setLanguages(languages);
        userProf.setPhoneNumber("0102030405");
        userProf.setPostalAddress("addressTest");
        userProf.setSchool("School");
        userProf.setTimeZone(TimeZone.UTC_minus1h);
        userProf.setUserDescription("Test");
        userProf.setCreatedDate(new Date());
        userProf.setUpdatedDate(new Date());
        userProf.setUserUpdate(user.getIdUser());

        user.setUserProfile(userProf);*/

		userRepo.save(user);


	}

}
