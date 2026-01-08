package com.example.PickMeNow.controller;

import com.example.PickMeNow.Dtos.Reqest.BookingRequest;
import com.example.PickMeNow.Dtos.Response.BookingResponse;
import com.example.PickMeNow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/boking")
@RestController
public class BookingController {
       @Autowired
    BookingService bookingService;
       @PostMapping("/book/customer/{customerId}")
    public BookingResponse bookCab(@RequestBody BookingRequest bookingRequest,
                                   @PathVariable("customerId")int customerId ){
        return bookingService.bookCab(bookingRequest,customerId);
    }
}
