package cn.alipapa.seat.bean;

public class Serial {

    // 所有属性均为private

    private String serial;
    private String password;

    // 每个属性均有对应的getter/setter

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

    public Serial(String serial, String password) {
        this.serial = serial;
        this.password = password;
    }
}
