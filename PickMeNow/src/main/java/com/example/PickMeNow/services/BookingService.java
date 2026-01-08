package com.example.PickMeNow.services;

import com.example.PickMeNow.Dtos.Reqest.BookingRequest;
import com.example.PickMeNow.Dtos.Response.BookingResponse;
import com.example.PickMeNow.exception.CabUnavailableException;
import com.example.PickMeNow.exception.CustomerNotFoundException;
import com.example.PickMeNow.exception.DriverNotFoundExceptions;
import com.example.PickMeNow.model.Booking;
import com.example.PickMeNow.model.Cab;
import com.example.PickMeNow.model.Customer;
import com.example.PickMeNow.model.Driver;
import com.example.PickMeNow.repository.BookingRepository;
import com.example.PickMeNow.repository.CabRepository;
import com.example.PickMeNow.repository.CustomerRepository;
import com.example.PickMeNow.repository.DriverRepository;
import com.example.PickMeNow.transformer.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BookingService {
   @Autowired
   CustomerRepository customerRepository;

   @Autowired
    CabRepository cabRepository;

   @Autowired
    DriverRepository driverRepository;

   @Autowired
    BookingRepository bookingRepository;

   @Autowired
    JavaMailSender javaMailSender;

    public BookingResponse bookCab(BookingRequest bookingRequest, int customerId) {

        Optional<Customer>optionalCustomer=customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("invalid customer id ");
        }
        Customer customer=optionalCustomer.get();

        Cab availableCab=cabRepository.getAvailableCabRandomly();
        if(availableCab ==null){
            throw new CabUnavailableException("sorry cab is not available in this time, please try latter ");
        }

      Booking booking= BookingTransformer.bookingRequestToBooking(bookingRequest, availableCab.getPerKmRate());
        Booking savedBooking=bookingRepository.save(booking);

        availableCab.setAvailable(false);
        customer.getBookings().add(savedBooking);

        Driver driver = driverRepository.getDriverByCabId(availableCab.getCabId());
        if (driver == null) {
            throw new DriverNotFoundExceptions("No driver found for cabId " + availableCab.getCabId());
        }
        driver.getBooking().add(savedBooking);

      Customer savedCustomer=  customerRepository.save(customer);
      Driver savedDriver=  driverRepository.save(driver);

        sendMail(savedCustomer,savedBooking);
    return BookingTransformer.bookingToBookingResponse(savedBooking,savedCustomer,availableCab,savedDriver);



    }
    private void sendMail(Customer customer, Booking booking){
        String text = "Congratulations, " + customer.getCustomerName() + "! 🎉\n\n" +
                "Your cab has been successfully booked.\n" +
                "We’re excited to serve you and ensure you have a safe and comfortable ride.\n\n" +
                "📌 Booking Details:\n" +
                "- Pickup Location: " + booking.getPickup() + "\n" +
                "- Drop Location: " + booking.getDestination() + "\n" +
                "- Pickup Time: " + booking.getBookedAt() + "\n\n" +
                "Our driver will contact you shortly before arrival.\n" +
                "If you have any questions or need to make changes, please reach out to our support team.\n\n" +
                "Thank you for choosing Pick-me-now.\n" +
                "We look forward to riding with you! 🚖\n\n" +
                "Best regards,\n" +
                "Pick-me-now Team";

        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("pickmenow93@gmail.com");
        simpleMailMessage.setTo(customer.getCustomerEmail());
        simpleMailMessage.setSubject("cab booked");
        simpleMailMessage.setText(text);
        javaMailSender.send(simpleMailMessage);

    }
}
