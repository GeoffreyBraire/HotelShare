package com.esgi.annualproject.HotelShareApplication.controllers;

import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.given;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("test")
public class UserControllerTests {
    @LocalServerPort
    private int localServerPort;

    @Before
    public void init(){
        RestAssured.port = localServerPort;
    }

    @Test
    @DirtiesContext
    public void add_new_user() {
        given()
            .log().all()
            .formParam("EMAIL_ADDRESS","braire2@yahoo.fr")
            .formParam("ENCRYPTED_PASSWORD","3B27CBT7X6")
        .when()
            .post("api/users/add")
        .then()
            .statusCode(201);
    }
}
