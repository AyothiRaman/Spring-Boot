package com.customer.repository;

import com.customer.model.CustomerDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends CrudRepository<CustomerDetails,Long> {
    //CustomerDetails getDetailsByName(String first_name);

    @Query("SELECT e FROM CustomerDetails e WHERE e.first_name = :value")
    List<CustomerDetails> findBySomeField(@Param("value") String value);

}
