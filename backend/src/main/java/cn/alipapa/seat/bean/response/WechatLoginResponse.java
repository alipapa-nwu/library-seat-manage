package cn.alipapa.seat.bean.response;

public class WechatLoginResponse {
    private String openid;
    private String session_key;
    private Integer errcode;
    private String errmsg;

    @Override
    public String toString() {
        return "WechatLoginResponse{" +
                "openid='" + openid + '\'' +
                ", session_key='" + session_key + '\'' +
                ", errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
