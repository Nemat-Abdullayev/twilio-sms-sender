package az.a2z.clientapn.controller;

import az.a2z.clientapn.model.SmsRequest;
import az.a2z.clientapn.service.impl.SmsSenderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sms")
public class SmsController {

    private final SmsSenderImpl sendSmsService;

    @Autowired
    public SmsController(SmsSenderImpl sendSmsService) {
        this.sendSmsService = sendSmsService;
    }


    @PostMapping(path = "send")
    public void sendSms(@RequestBody SmsRequest smsRequest) {
        sendSmsService.sendSms(smsRequest);
    }
}
