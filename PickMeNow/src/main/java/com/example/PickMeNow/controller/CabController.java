package com.example.PickMeNow.controller;

import com.example.PickMeNow.Dtos.Reqest.CabRequest;
import com.example.PickMeNow.Dtos.Response.CabResponse;
import com.example.PickMeNow.services.CabServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cab")
public class CabController {
    @Autowired
    CabServices cabServices;
    @PostMapping("/register/driver/{driverId}")
    public CabResponse registercab(@RequestBody CabRequest cabRequest,
                                   @PathVariable("driverId") int driverId ){
       return cabServices.registercab(cabRequest ,driverId);

    }

}
