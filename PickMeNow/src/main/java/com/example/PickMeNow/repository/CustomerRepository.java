package com.example.PickMeNow.repository;

import com.example.PickMeNow.Enum.Gender;
import com.example.PickMeNow.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer>findByGender(Gender gender);
    List<Customer>findByGenderAndCustomerAge(Gender gender,int customerAge);
    List<Customer>findByCustomerName(String customerName);
   Customer findByCustomerEmail(String customerEmail);
   @Query("select c from Customer c where c.gender=:gender and c.customerAge > :customerAge ")    //HQL queary hibernate
   List<Customer>getAllCustomersByGenderAndAgeGreaterThan(@Param("gender") Gender gender,
                                                          @Param("customerAge") int customerAge);

}

