package cn.alipapa.seat.bean.response;

public class BinaryStatusResponse {
    private boolean success;

    public BinaryStatusResponse() {
    }

    public BinaryStatusResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "BinaryStatusResponse{" +
                "success=" + success +
                '}';
    }
}
