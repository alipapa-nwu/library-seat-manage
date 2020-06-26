package cn.alipapa.seat.bean.response;

public class LoginStatusResponse {
    private boolean success;
    private String srial;

    public LoginStatusResponse(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "LoginStatusResponse{" +
                "success=" + success +
                ", srial='" + srial + '\'' +
                '}';
    }

    public String getSrial() {
        return srial;
    }

    public void setSrial(String srial) {
        this.srial = srial;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
