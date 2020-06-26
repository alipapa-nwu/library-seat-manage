package cn.alipapa.seat.bean.response;

public class BindStatusResponse {
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BindStatusResponse{" +
                "status=" + status +
                '}';
    }

    public BindStatusResponse(boolean status) {
        this.status = status;
    }
}
