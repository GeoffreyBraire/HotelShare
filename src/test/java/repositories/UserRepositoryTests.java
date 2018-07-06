/*
package repositories;

import com.esgi.annualproject.HotelShareApplication.HotelShareApplication;
import com.esgi.annualproject.HotelShareApplication.entities.User;
import com.esgi.annualproject.HotelShareApplication.repositories.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HotelShareApplication.class)
@ActiveProfiles("test")
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    private User userForTesting;

    @Before
    public void setup() {
        this.userForTesting = saveUser();
    }

    @After
    public void cleanup() {
        userRepository.delete(userForTesting);
    }

    private User saveUser() {
        User user = new User();
        user.setLogin("loginTest");
        user.setEmailAddress("mailTest@test.com");
        user.setPassword("passwordTest");
        User savedUser = userRepository.save(user);
        assertNotNull(savedUser);
        return savedUser;
    }

    @Test
    public void findByPrimaryKey() {
        User foundUser = userRepository.getOne(userForTesting.getIdUser());
        assertNotNull(foundUser);
        assertEquals(userForTesting.getLogin(), foundUser.getLogin());
    }

    @Test
    public void findByLogin() {
        User user = userRepository.findByLogin(userForTesting.getLogin());
        assertNotNull(user);
    }
}
*/
