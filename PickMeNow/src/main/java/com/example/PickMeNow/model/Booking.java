package com.example.PickMeNow.model;

import com.example.PickMeNow.Enum.Tripstatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int bookingId;

    String pickup;

    String destination;

    double tripDistanceInKm;

    double billAmount;

     Tripstatus tripstatus;

     @CreationTimestamp
    Date bookedAt;
     @UpdateTimestamp
    Date lastUpdate;
}
