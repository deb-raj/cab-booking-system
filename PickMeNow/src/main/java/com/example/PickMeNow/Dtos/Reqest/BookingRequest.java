package com.example.PickMeNow.Dtos.Reqest;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookingRequest {
    String pickup;

    String destination;

    double tripDistanceInKm;

}
