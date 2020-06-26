package cn.alipapa.seat.bean.request;

public class UserInOutRequest {
    private Integer user_id;

    @Override
    public String toString() {
        return "UserInOutRequest{" +
                "user_id=" + user_id +
                '}';
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}