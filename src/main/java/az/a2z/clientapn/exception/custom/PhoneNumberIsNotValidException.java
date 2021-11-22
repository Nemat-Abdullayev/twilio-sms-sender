package az.a2z.clientapn.exception.custom;

public class PhoneNumberIsNotValidException extends RuntimeException {
    public PhoneNumberIsNotValidException(String message) {
        super(message);
    }

    public PhoneNumberIsNotValidException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
