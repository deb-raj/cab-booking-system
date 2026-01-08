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
@Builder
@Entity
@Table(name = "Driver_info") //this annotation is used for changing the table name;
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverId;

    private String driverName;

    @Column(unique = true,nullable = false)
    private String driverEmail;

    private int driverAge;

    @Column(name = "Gender_") //this annotation is used for changing the column name;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="driver_id")
    List<Booking> booking=new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cab_id")
    Cab cab;
}
    