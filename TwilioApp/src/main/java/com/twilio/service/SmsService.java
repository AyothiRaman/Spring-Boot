package com.twilio.service;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.net.URI;

@Service
@Slf4j
public class SmsService {

    // @Value("{TWILIO_ACC_ID}")
    private String ACCOUNT_ID = "AC6c7a6471514e6bc88ada2e3d583af7e4";

    // @Value("{TWILIO_AUTH_TOKEN}")
    private String AUTH_TOKEN = "c67032988a736d37a070ac8fccaa4dae";

    //@Value("{TWILIO_MOBILE_NUMBER}")
    private String OUTGOING_MOBILE_NUMBER = "+16185168352";

    @PostConstruct
    public void setUp() {
        Twilio.init(ACCOUNT_ID, AUTH_TOKEN);
    }

    public String sendSms(String smsMobileNo, String smsMessage) {


            Twilio.init(ACCOUNT_ID, AUTH_TOKEN);

            Message message1 = Message.creator(new PhoneNumber(smsMobileNo),
                    new PhoneNumber(OUTGOING_MOBILE_NUMBER)
                    , smsMessage).create();

        return message1.getStatus().toString();
        //return new ResponseEntity<>("Message Sent Successfully", HttpStatus.OK);
    }

    public void makeCall(String fromMobileNUmber, String toMobileNumber) {
        try {
            Twilio.init(ACCOUNT_ID, AUTH_TOKEN);
            Call cal = Call.creator(new PhoneNumber(toMobileNumber),
                            new PhoneNumber(fromMobileNUmber),
                            URI.create("http://demo.twilio.com/docs/voice.xml"))
                    .setStatusCallback(URI.create("http://postb.in/1234abcd"))
                    .create();
          System.out.println(cal);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
