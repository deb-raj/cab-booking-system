package com.example.PickMeNow.transformer;

import com.example.PickMeNow.Dtos.Reqest.DriverRequest;
import com.example.PickMeNow.Dtos.Response.DriverResponse;
import com.example.PickMeNow.model.Driver;

public class DriverTransformer {
    public static Driver driverRequestToDriver(DriverRequest driverRequest){
        return Driver.builder()
                .driverName(driverRequest.getDriverName())
                .driverAge(driverRequest.getDriverAge())
                .driverEmail(driverRequest.getDriverEmail())
                .gender(driverRequest.getGender())
                .build();
    }
    public static DriverResponse driverToDriverResponse(Driver driver){
        return DriverResponse.builder()
                .driverName(driver.getDriverName())
                .driverAge(driver.getDriverAge())
                .driverEmail(driver.getDriverEmail())
                .gender(driver.getGender())
                .build();
    }
}
