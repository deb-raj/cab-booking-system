package com.example.PickMeNow.transformer;

import com.example.PickMeNow.Dtos.Reqest.CustomerRequest;
import com.example.PickMeNow.Dtos.Response.CustomerResponse;
import com.example.PickMeNow.model.Customer;

public class CustomerTransformer {
    public static Customer customerRequestoToCustomer(CustomerRequest customerRequest){
//        Customer customer=new Customer();
//
//        customer.setCustomerName(customerRequest.getCustomerName());
//        customer.setCustomerEmail(customerRequest.getCustomerEmail());
//        customer.setGender(customerRequest.getGender());
//        return customer;
        return  Customer.builder()
                .customerName(customerRequest.getCustomerName())
                .customerEmail(customerRequest.getCustomerEmail())
                .gender(customerRequest.getGender())
                .customerAge(customerRequest.getCustomerAge())
                .build();
    }
    public static CustomerResponse customerToCustomerResponse(Customer customer){
//        CustomerResponse customerResponse=new CustomerResponse();
//        customerResponse.setCustomerName(customer.getCustomerName());
//        customerResponse.setCustomerEmail(customer.getCustomerEmail());
//        customerResponse.setGender(customer.getGender());
//        return customerResponse;
       return CustomerResponse.builder()
                .customerName(customer.getCustomerName())
                .customerEmail(customer.getCustomerEmail())
                //.gender(customer.getGender())
               .customerAge(customer.getCustomerAge())
                .build();
    }
}
