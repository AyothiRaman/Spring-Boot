package com.twilio.service;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SmsService {

   // @Value("{TWILIO_ACC_ID}")
    private String ACCOUNT_ID = "your twilio account id";

   // @Value("{TWILIO_AUTH_TOKEN}")
    private String AUTH_TOKEN="your twilio auth token";

    //@Value("{TWILIO_MOBILE_NUMBER}")
    private String OUTGOING_MOBILE_NUMBER="your twilio mobile number";

    @PostConstruct
    public void setUp() {
        Twilio.init(ACCOUNT_ID,AUTH_TOKEN);
    }

    public String sendSms(String smsMobileNo,String smsMessage){

        Message message1 = Message.creator(new PhoneNumber(smsMobileNo),
                new PhoneNumber(OUTGOING_MOBILE_NUMBER)
        ,smsMessage).create();
        return message1.getStatus().toString();
    }
}
