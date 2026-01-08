package com.example.PickMeNow.Dtos.Response;

import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Builder
public class CabResponse {
private String cabNumber;

  private String cabModel;
  private boolean available;
  private double perKmRate;
  private DriverResponse driver;
}
