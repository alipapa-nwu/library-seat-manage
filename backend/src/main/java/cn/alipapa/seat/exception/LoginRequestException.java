package cn.alipapa.seat.exception;

public class LoginRequestException extends RuntimeException {
    public LoginRequestException() {
    }

    public LoginRequestException(String message) {
        super(message);
    }
}
