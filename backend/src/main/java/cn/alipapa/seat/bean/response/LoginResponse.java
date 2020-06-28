package cn.alipapa.seat.bean.response;

public class LoginResponse {
    private String serial;
    private String openId;
    private String sessionId;

    public LoginResponse(String openId, String sessionId) {
        this.openId = openId;
        this.sessionId = sessionId;
    }

    public LoginResponse(String serial, String openId, String sessionId) {
        this.serial = serial;
        this.openId = openId;
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "serial='" + serial + '\'' +
                ", openId='" + openId + '\'' +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
