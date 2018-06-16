package com.esgi.annualproject.HotelShareApplication.controllers;

import com.esgi.annualproject.HotelShareApplication.exceptions.ResourceNotFoundException;
import com.esgi.annualproject.HotelShareApplication.models.User;
import com.esgi.annualproject.HotelShareApplication.repositories.UserProfileRepository;
import com.esgi.annualproject.HotelShareApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserProfileRepository userProfileRepository;

    // Get All Users
    @GetMapping("/")
    public List<User> getAllNotes() {
        return userRepository.findAll();
    }

    // Get a Single User
    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }


    // Create a new User
    @PostMapping("/add")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    // Update a User
    @PutMapping("/update/{id}")
    public User updateNote(@PathVariable(value = "id") Long userId,
                           @Valid @RequestBody User userDetails) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        user.setEmailAddress(userDetails.getEmailAddress());
        user.setEncryptedPassword(userDetails.getEncryptedPassword());

        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    // Delete a User
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }
}
