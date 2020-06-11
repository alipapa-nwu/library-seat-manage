package cn.alipapa.seat.bean;

public class Serial {
    private Integer id;
    private String serial;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Serial{" +
                "serial='" + serial + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
