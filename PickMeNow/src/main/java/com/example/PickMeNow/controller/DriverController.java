package com.example.PickMeNow.controller;

import com.example.PickMeNow.Dtos.Reqest.DriverRequest;
import com.example.PickMeNow.Dtos.Response.CustomerResponse;
import com.example.PickMeNow.Dtos.Response.DriverResponse;
import com.example.PickMeNow.Enum.Gender;
import com.example.PickMeNow.services.CustomerService;
import com.example.PickMeNow.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    DriverService driverService;

    @PostMapping("/add")
    public DriverResponse addriver(@RequestBody  DriverRequest driverRequest){
        return driverService.addriver(driverRequest);
    }
    @GetMapping("/get/driver-id/{id}")
    public DriverResponse getdriver(@PathVariable("id") int driverId){
        return driverService.getdriver(driverId);
    }
    @GetMapping("/get/driver-gender/{gender}")
    public List<DriverResponse> getDriverByGender(@PathVariable("gender")Gender gender){
        return driverService.getDriverByGender(gender);
    }
    @GetMapping("/get/driver-name/{name}")
    public List<DriverResponse> getDriverByName(@PathVariable("name") String driverName){
        return driverService.getDriverByName(driverName);
    }
    @GetMapping("/get/driver-by-email/{email}")
    public DriverResponse getbyemail(@PathVariable("email") String driverEmail){
        return driverService.getbyemail(driverEmail);
    }
    @GetMapping("/get/driver-by-age/{age}")
    public List<DriverResponse> getbydriverage(@PathVariable("age") int driverAge){
        return  driverService.getbydriverage(driverAge);
    }


}
