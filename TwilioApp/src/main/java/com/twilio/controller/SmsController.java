package com.twilio.controller;

import com.twilio.model.SmsModel;
import com.twilio.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class SmsController {

    @Autowired
    private SmsService smsService;

    @PostMapping("/mobile")
    public String sendSms(@RequestBody SmsModel smsModel){

        log.info("processing started"+smsModel);

        return smsService.sendSms(smsModel.getDestinationMobileNumber(),smsModel.getMessage());
    }




}
