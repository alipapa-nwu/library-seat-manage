package cn.alipapa.seat.bean.request;

public class UserInOutRequest {
    private String serial;

    @Override
    public String toString() {
        return "UserInOutRequest{" +
                "serial='" + serial + '\'' +
                '}';
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}