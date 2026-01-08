package com.example.PickMeNow.Dtos.Response;

import com.example.PickMeNow.Enum.Tripstatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookingResponse {

    String pickup;

    String destination;

    double tripDistanceInKm;

    double billAmount;

    Tripstatus tripstatus;


    Date bookedAt;

    Date lastUpdate;
    CustomerResponse customer;

    CabResponse cab;
}
