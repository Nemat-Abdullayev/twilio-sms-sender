package az.a2z.clientapn.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "apn-client", url = "${apn.api}")
public interface ApnClient {

    @RequestMapping(method = RequestMethod.POST,
            value = "/{token}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    ResponseEntity<?> pushNotification(@RequestHeader(value = "apns-priority") int priority,
                                       @RequestHeader(value = "apns-topic") String topic,
                                       @RequestBody String payload,
                                       @PathVariable(value = "token") String token);
}