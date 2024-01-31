package com.customer.service;

import com.customer.exception.ResourceNotFoundException;
import com.customer.model.CustomerDetails;
import com.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements PostCustomerServiceInterface {


    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        super();
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDetails> getAllCustomerDetails() {
        return (List<CustomerDetails>) customerRepository.findAll();
    }


    @Override
    public CustomerDetails saveCustomerDetails(CustomerDetails customerDetails) {
        return customerRepository.save(customerDetails);
    }

    @Override
    public CustomerDetails updateDetailsBasedOnID(Long id, CustomerDetails customerDetailsRequest) {
        CustomerDetails customerDetails = customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("CustomerDetails is not available with this given id"));

        customerDetails.setFirst_name(customerDetailsRequest.getFirst_name());
        customerDetails.setLast_name(customerDetailsRequest.getLast_name());
        customerDetails.setEmail(customerDetails.getEmail());
        customerDetails.setAddress(customerDetailsRequest.getAddress());
        customerDetails.setPhone_number(customerDetails.getPhone_number());

        return customerRepository.save(customerDetails);
    }

    @Override
    public void deleteCustomerDetails(long id) {

        CustomerDetails customerDetails = customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("CustomerDetails is not available with this given id"));

        customerRepository.delete(customerDetails);
    }

    @Override
    public Optional<CustomerDetails> getDetailsByID(long id) {

      return   customerRepository.findById(id);
    }
}
