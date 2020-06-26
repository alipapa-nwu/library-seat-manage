package cn.alipapa.seat.exception;

import org.springframework.http.HttpStatus;

public class LoginException extends CustomException {
    public LoginException() {
    }

    @Override
    public int httpStatus() {
        return HttpStatus.UNAUTHORIZED.value();
    }

    public LoginException(String message) {
        super(message);
    }
}
