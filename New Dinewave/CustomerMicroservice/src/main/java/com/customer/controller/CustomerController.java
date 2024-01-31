package com.customer.controller;

import com.customer.dto.CustomerDTO;
import com.customer.model.CustomerDetails;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/save")
    public ResponseEntity<CustomerDetails> saveCustomerDetails(@RequestBody CustomerDetails customerDetails){
        CustomerDetails details = customerService.saveCustomerDetails(customerDetails);

        return new ResponseEntity<>(details, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<CustomerDetails>> getAllDetails(){
         customerService.getAllCustomerDetails();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDetails> getDetailsById(@PathVariable long id){
        customerService.getDetailsByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{first_name}")
    public List<CustomerDetails> findBySomeField(@PathVariable String first_name) {
        return customerRepository.findBySomeField(first_name);
    }
    @PutMapping("/update")
    public ResponseEntity<CustomerDetails> updateDetails(CustomerDetails customerDetails,long id){
        customerService.updateDetailsBasedOnID(id, customerDetails);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<CustomerDetails> deleteCustomerDetails(long id){
        customerService.deleteCustomerDetails(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
