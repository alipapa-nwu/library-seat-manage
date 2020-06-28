package cn.alipapa.seat.bean.request;

public class LoginRequest {
    private String code;


    @Override
    public String toString() {
        return "LoginRequest{" +
                "code='" + code + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
