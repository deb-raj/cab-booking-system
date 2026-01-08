package com.example.PickMeNow.controller;

import com.example.PickMeNow.Dtos.Reqest.CustomerRequest;
import com.example.PickMeNow.Dtos.Response.CustomerResponse;
import com.example.PickMeNow.Enum.Gender;
import com.example.PickMeNow.model.Customer;
import com.example.PickMeNow.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customer")
@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.addCustomer(customerRequest);
    }

    @GetMapping("/get/customer-id/{id}")
    public CustomerResponse getcoustomer(@PathVariable("id") int customerId){
        return customerService.getcoustomer(customerId);
    }

    @GetMapping("/get/gender/{gender}")
    public List<CustomerResponse> getallCustomerByGender(@PathVariable ("gender")Gender gender){
        return customerService.getallCustomerByGender(gender);
    }

    //we fetch using this api is gender and age :-fetch the gender and particuler age

    @GetMapping("/get")
    public  List<CustomerResponse> getAllCustomerByGenderAndPerticulerAge(@RequestParam("gender") Gender gender,
                                                                          @RequestParam("age") int customerAge){

        return customerService.getAllCustomerByGenderAndPerticulerAge(gender,customerAge);

    }

    //we fetch using this api find by name

    @GetMapping("/get/name/{name}")
    public List<CustomerResponse> getALlCustomerByFindByName(@PathVariable("name") String customerName){
        return customerService.getALlCustomerByFindByName(customerName);
    }

    //we fetch using thhis api find by email

    @GetMapping("/get/email/{email}")
    public CustomerResponse getTheCustomerByEmail(@PathVariable ("email") String customerEmail){
        return customerService.getTheCustomerByEmail(customerEmail);
    }
    @GetMapping("/get-by-age-greater-then")
    public List<CustomerResponse> getAllCustomersByGenderAndAgeGreaterThan(@RequestParam("gender")Gender gender,
                                                                                  @RequestParam("age") int customerAge){
        return customerService.getAllCustomersByGenderAndAgeGreaterThan(gender,customerAge);
    }

}
