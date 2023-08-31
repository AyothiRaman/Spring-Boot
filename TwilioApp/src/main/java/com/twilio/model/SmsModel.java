package com.twilio.model;

import lombok.Data;

@Data
public class SmsModel {


    private String destinationMobileNumber;
    private String message;
}
