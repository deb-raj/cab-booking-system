package com.example.PickMeNow.repository;

import com.example.PickMeNow.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CabRepository extends JpaRepository<Cab,Integer> {

    @Query(
            value = "SELECT * FROM cab WHERE available = true ORDER BY RAND() LIMIT 1",
            nativeQuery = true)
    Cab getAvailableCabRandomly();
}
