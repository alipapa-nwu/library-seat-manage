package cn.alipapa.seat.bean.request;

public class BindRequest {
    private String serial;
    private String password;
    private String js_code;

    @Override
    public String toString() {
        return "BindRequest{" +
                "serial='" + serial + '\'' +
                ", password='" + password + '\'' +
                ", js_code='" + js_code + '\'' +
                '}';
    }

    public String getJs_code() {
        return js_code;
    }

    public void setJs_code(String js_code) {
        this.js_code = js_code;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
