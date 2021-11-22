package az.a2z.clientapn.service;

import az.a2z.clientapn.model.SmsRequest;

public interface SmsSender {
    void sendSms(SmsRequest smsRequest);
}
