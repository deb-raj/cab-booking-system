package com.example.PickMeNow.services;

import com.example.PickMeNow.Dtos.Reqest.DriverRequest;
import com.example.PickMeNow.Dtos.Response.DriverResponse;
import com.example.PickMeNow.Enum.Gender;
import com.example.PickMeNow.exception.DriverNotFoundException;
import com.example.PickMeNow.model.Driver;
import com.example.PickMeNow.repository.DriverRepository;
import com.example.PickMeNow.transformer.DriverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    @Autowired
    DriverRepository driverRepository;
    public DriverResponse addriver(DriverRequest driverRequest) {
        Driver driver= DriverTransformer.driverRequestToDriver(driverRequest);
        Driver savedDriver= driverRepository.save(driver);
        return DriverTransformer.driverToDriverResponse(savedDriver);
    }


    public DriverResponse getdriver(int driverId) {
        Optional<Driver> optionalDriver=driverRepository.findById(driverId);
        if(optionalDriver.isEmpty()){
            throw new DriverNotFoundException("Invalid driver id ");
        }
        Driver savedDriver=optionalDriver.get();
        return DriverTransformer.driverToDriverResponse(savedDriver);
    }

    public List<DriverResponse> getDriverByGender(Gender gender) {
        List<Driver>drivers=driverRepository.findByGender(gender);
        List<DriverResponse> driverResponses=new ArrayList<>();
        for(Driver driver:drivers){
            driverResponses.add(DriverTransformer.driverToDriverResponse(driver));
        }
        return driverResponses;
    }

    public List<DriverResponse> getDriverByName(String driverName) {
        List<Driver>drivers=driverRepository.findByDriverName(driverName);
        List<DriverResponse>driverResponses=new ArrayList<>();
        for(Driver driver:drivers){
            driverResponses.add(DriverTransformer.driverToDriverResponse(driver));
        }
        return driverResponses;
    }

    public DriverResponse getbyemail(String driverEmail) {
        Driver drivers=driverRepository.findByDriverEmail(driverEmail);
        return DriverTransformer.driverToDriverResponse(drivers);
    }

    public List<DriverResponse> getbydriverage(int driverAge) {
        List<Driver>drivers=driverRepository.findByDriverAge(driverAge);
        List<DriverResponse>driverResponses=new ArrayList<>();
        for(Driver driver:drivers){
            driverResponses.add(DriverTransformer.driverToDriverResponse(driver));
        }
        return driverResponses;
    }
}

