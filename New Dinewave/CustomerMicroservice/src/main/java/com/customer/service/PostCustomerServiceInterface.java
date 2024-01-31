package com.customer.service;

import com.customer.model.CustomerDetails;

import java.util.List;
import java.util.Optional;

public interface PostCustomerServiceInterface {

     List<CustomerDetails> getAllCustomerDetails();

   //  CustomerDetails getAllDetailsByName(String first_name, CustomerDetails customerDetails);

     CustomerDetails saveCustomerDetails(CustomerDetails customerDetails);

     CustomerDetails updateDetailsBasedOnID(Long id, CustomerDetails customerDetailsRequest);

    void deleteCustomerDetails(long id);

    Optional<CustomerDetails> getDetailsByID(long id);



}
