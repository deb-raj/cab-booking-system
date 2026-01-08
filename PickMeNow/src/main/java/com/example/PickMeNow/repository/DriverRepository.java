package com.example.PickMeNow.repository;

import com.example.PickMeNow.Enum.Gender;
import com.example.PickMeNow.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer> {
    List<Driver>findByGender(Gender gender);
    List<Driver>findByDriverName(String driverName);
    Driver findByDriverEmail(String driverEmail);
    List<Driver>findByDriverAge(Integer driverAge);
    @Query("SELECT d FROM Driver d WHERE d.cab.cabId = :cabId")
    Driver getDriverByCabId(@Param("cabId") int cabId);
}
