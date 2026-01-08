package com.example.PickMeNow.model;

import com.example.PickMeNow.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "Customer_info") //this annotation is used for changing the table name;
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String customerName;
    private String customerEmail;
    private int customerAge;
    @Column(name="Gender_") //this annotation is used for changing the column name;
    @Enumerated(value = EnumType.STRING)
   private Gender gender;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    List<Booking> bookings=new ArrayList<>();


}
