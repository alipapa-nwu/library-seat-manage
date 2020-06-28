package cn.alipapa.seat.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    public CustomException() {
    }

    public int httpStatus() {
        return HttpStatus.BAD_REQUEST.value();
    }

    public CustomException(String message) {
        super(message);
    }
}
