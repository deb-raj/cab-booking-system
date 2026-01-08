package com.example.PickMeNow.Dtos.Reqest;

import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CabRequest {

  private   String cabNumber;

   private String cabModel;

    private   double perKmRate;
}
