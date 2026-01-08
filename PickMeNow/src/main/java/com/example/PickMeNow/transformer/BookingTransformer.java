package com.example.PickMeNow.transformer;

import com.example.PickMeNow.Dtos.Reqest.BookingRequest;
import com.example.PickMeNow.Dtos.Response.BookingResponse;
import com.example.PickMeNow.Enum.Tripstatus;
import com.example.PickMeNow.model.Booking;
import com.example.PickMeNow.model.Cab;
import com.example.PickMeNow.model.Customer;
import com.example.PickMeNow.model.Driver;

public class BookingTransformer {

    public static Booking bookingRequestToBooking(BookingRequest bookingRequest,double perKmRate){
        return Booking.builder()
                .pickup(bookingRequest.getPickup())
                .destination(bookingRequest.getDestination())
                .tripDistanceInKm(bookingRequest.getTripDistanceInKm())
                .tripstatus(Tripstatus.IN_PROGRESS)
                .billAmount(bookingRequest.getTripDistanceInKm()*perKmRate)


                .build();
    }
    public static BookingResponse bookingToBookingResponse(Booking booking, Customer customer, Cab cab, Driver driver){

        return  BookingResponse.builder()
                .pickup(booking.getPickup())
                .tripDistanceInKm(booking.getTripDistanceInKm())
                .destination(booking.getDestination())
                .billAmount(booking.getBillAmount())
                .tripstatus(booking.getTripstatus())
                .lastUpdate(booking.getLastUpdate())
                .bookedAt(booking.getBookedAt())
                .customer(CustomerTransformer.customerToCustomerResponse(customer))
                .cab(CabTransformer.cabToCabResponse(cab,driver))
                .build();
    }

}
