package cn.alipapa.seat.exception;

import org.springframework.http.HttpStatus;

public class AccessDeniedException extends CustomException {
    public AccessDeniedException() {
    }

    public AccessDeniedException(String message) {
        super(message);
    }

    @Override
    public int httpStatus() {
        return HttpStatus.FORBIDDEN.value();
    }
}
