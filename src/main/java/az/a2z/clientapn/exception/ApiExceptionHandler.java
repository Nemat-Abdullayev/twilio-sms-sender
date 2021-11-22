package az.a2z.clientapn.exception;

import az.a2z.clientapn.exception.custom.ApiException;
import az.a2z.clientapn.exception.custom.PhoneNumberIsNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {PhoneNumberIsNotValidException.class})
    public ResponseEntity<?> handlePhoneNumberIsNotValidException(PhoneNumberIsNotValidException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = ApiException.builder()
                .message(e.getMessage())
                .throwable(e)
                .httpStatus(badRequest)
                .code(5)
                .zonedDateTime(ZonedDateTime.now(ZoneId.of("Z")))
                .build();
        return new ResponseEntity<>(apiException, badRequest);
    }
}
