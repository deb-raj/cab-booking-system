package com.example.PickMeNow.repository;

import com.example.PickMeNow.model.Booking;
import com.example.PickMeNow.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Integer> {


}
