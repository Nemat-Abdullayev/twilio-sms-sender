package az.a2z.clientapn.service.impl;

import az.a2z.clientapn.config.TwilioConfiguration;
import az.a2z.clientapn.exception.custom.PhoneNumberIsNotValidException;
import az.a2z.clientapn.model.SmsRequest;
import az.a2z.clientapn.service.SmsSender;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class SmsSenderImpl implements SmsSender {

    private static final Logger logger = LoggerFactory.getLogger(SmsSenderImpl.class);
    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public SmsSenderImpl(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }


    @Override
    public void sendSms(SmsRequest smsRequest) {
        if (isValidPhoneNumber(smsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(
                    to,// destination number
                    from, //from number
                    message // sms body
            );
            creator.create();
            logger.info("Send sms {}",smsRequest);
        } else {
            throw new PhoneNumberIsNotValidException("phone number [" + smsRequest.getPhoneNumber() + "] is not valid");
        }

    }

    private boolean isValidPhoneNumber(String phoneNumber) {

        //TODO: implement phone number validator
        return true;
    }
}
