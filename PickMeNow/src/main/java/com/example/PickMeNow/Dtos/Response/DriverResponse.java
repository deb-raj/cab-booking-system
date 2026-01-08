package com.example.PickMeNow.Dtos.Response;

import com.example.PickMeNow.Enum.Gender;
import jakarta.persistence.Column;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DriverResponse {
    private int driverId;
    private String driverName;
    private String driverEmail;
    private int driverAge;

    @Column(name = "Gender_") //this annotation is used for changing the column name;
    private Gender gender;
}
