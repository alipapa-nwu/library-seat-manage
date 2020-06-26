package cn.alipapa.seat.bean.request;

public class BindRequest {
    private String serial;
    private String password;

    @Override
    public String toString() {
        return "BindRequest{" +
                "serial='" + serial + '\'' +
                ", password='" + password + '\'' +
                '}';
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
