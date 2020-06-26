package cn.alipapa.seat.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class LoginException extends CustomException {
    public LoginException() {
    }

    public LoginException(String message) {
        super(message);
    }
}
