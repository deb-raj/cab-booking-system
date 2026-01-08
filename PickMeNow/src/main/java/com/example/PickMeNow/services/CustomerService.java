package com.example.PickMeNow.services;

import com.example.PickMeNow.Dtos.Reqest.CustomerRequest;
import com.example.PickMeNow.Dtos.Response.CustomerResponse;
import com.example.PickMeNow.Enum.Gender;
import com.example.PickMeNow.exception.CustomerNotFoundException;
import com.example.PickMeNow.model.Customer;
import com.example.PickMeNow.repository.CustomerRepository;
import com.example.PickMeNow.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
      @Autowired
      CustomerRepository customerRepository;
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
          //Requestdtos >Entity
        Customer customer= CustomerTransformer.customerRequestoToCustomer(customerRequest);

         //save the entity to Db
        Customer savedcustomer= customerRepository.save(customer);

        // savedentity> Responsedtos

        return CustomerTransformer.customerToCustomerResponse(savedcustomer);
    }

    public CustomerResponse getcoustomer(int customerId) {

        Optional<Customer> optionalCustomer=customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("invalid customer id ");
        }

        Customer savedcustomer= optionalCustomer.get();

        //savedentity> Responsedtos

        //CustomerResponse customerResponse=new CustomerResponse();

        return CustomerTransformer.customerToCustomerResponse(savedcustomer);
    }

    public List<CustomerResponse> getallCustomerByGender(Gender gender) {
        List<Customer> customers=customerRepository.findByGender(gender);

        //entity to dtos
        List<CustomerResponse> customerResponses=new ArrayList<>();
        for(Customer customer:customers){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }

    public List<CustomerResponse> getAllCustomerByGenderAndPerticulerAge(Gender gender, int customerAge) {
        List<Customer> customers = customerRepository.findByGenderAndCustomerAge(gender,customerAge);
        //entity to dtos
        List<CustomerResponse> customerResponses=new ArrayList<>();
        for(Customer customer:customers){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;

    }

    public List<CustomerResponse> getALlCustomerByFindByName(String customerName) {
        List<Customer> customers=customerRepository.findByCustomerName(customerName);

        //entity to dtos
        List<CustomerResponse> customerResponses=new ArrayList<>();
        for(Customer customer:customers){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }

    public CustomerResponse getTheCustomerByEmail(String customerEmail) {
      Customer customers=customerRepository.findByCustomerEmail(customerEmail);
      //entity to dtos;
        CustomerResponse customerResponse=CustomerTransformer.customerToCustomerResponse(customers);
        return customerResponse;
    }

    public List<CustomerResponse> getAllCustomersByGenderAndAgeGreaterThan(Gender gender, int customerAge) {
        List<Customer> customers = customerRepository.getAllCustomersByGenderAndAgeGreaterThan(gender,customerAge);
        //entity to dtos
        List<CustomerResponse> customerResponses=new ArrayList<>();
        for(Customer customer:customers){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }



}
