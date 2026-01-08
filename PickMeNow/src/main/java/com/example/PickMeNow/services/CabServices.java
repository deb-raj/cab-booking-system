package com.example.PickMeNow.services;

import com.example.PickMeNow.Dtos.Reqest.CabRequest;
import com.example.PickMeNow.Dtos.Response.CabResponse;
import com.example.PickMeNow.exception.DriverNotFoundExceptions;
import com.example.PickMeNow.model.Cab;
import com.example.PickMeNow.model.Driver;
import com.example.PickMeNow.repository.CabRepository;
import com.example.PickMeNow.repository.DriverRepository;
import com.example.PickMeNow.transformer.CabTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
public class CabServices {
@Autowired
    DriverRepository driverRepository;
    public CabResponse registercab(CabRequest cabRequest, int driverId) {
        Optional<Driver>optionalDriver=driverRepository.findById(driverId);
        if(optionalDriver.isEmpty()){
            throw new DriverNotFoundExceptions("invalid driver id");
        }
        Driver driver=optionalDriver.get();
        Cab cab= CabTransformer.cabRequestToCab(cabRequest);
        driver.setCab(cab);
        Driver savedDriver=driverRepository.save(driver);
        return CabTransformer.cabToCabResponse(savedDriver.getCab(),savedDriver);
    }

}
