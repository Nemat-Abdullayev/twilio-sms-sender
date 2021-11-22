package az.a2z.clientapn.exception.custom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiException {


    private String message;
    private Throwable throwable;
    private HttpStatus httpStatus;
    private int code;
    private ZonedDateTime zonedDateTime;
}
