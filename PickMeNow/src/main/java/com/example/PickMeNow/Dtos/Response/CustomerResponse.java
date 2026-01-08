package com.example.PickMeNow.Dtos.Response;

import com.example.PickMeNow.Enum.Gender;
import jakarta.persistence.Column;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class CustomerResponse {
    private String customerName;
    private String customerEmail;
    private int customerAge;
//    @Column(name="Gender_") //this annotation is used for changing the column name;
//
//    private Gender gender;
}
