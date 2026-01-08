package com.example.PickMeNow.Dtos.Reqest;

import com.example.PickMeNow.Enum.Gender;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DriverRequest {
    private String driverName;
    private String driverEmail;
    private int driverAge;
    @Column(name = "Gender_") //this annotation is used for changing the column name;
    private Gender gender;
}
