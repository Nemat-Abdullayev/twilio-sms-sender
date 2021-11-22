package az.a2z.clientapn.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@NoArgsConstructor
@ConfigurationProperties("twilio")
public class TwilioConfiguration {

    private String accountSid;
    private String authToken;
    private String trialNumber;
}
