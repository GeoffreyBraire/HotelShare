package com.esgi.annualproject.HotelShareApplication.repositories;

import com.esgi.annualproject.HotelShareApplication.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
