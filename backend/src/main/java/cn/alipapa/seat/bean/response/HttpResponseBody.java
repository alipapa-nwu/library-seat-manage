package cn.alipapa.seat.bean.response;

public class HttpResponseBody {
    private Integer status;
    private String error;
    private Object data;

    @Override
    public String toString() {
        return "HttpResponseBody{" +
                "status=" + status +
                ", error='" + error + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
