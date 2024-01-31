package com.customer.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerDTO {

    private long id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;

    private String address;
    private final Date date_of_registration = new Date(System.currentTimeMillis());




}
