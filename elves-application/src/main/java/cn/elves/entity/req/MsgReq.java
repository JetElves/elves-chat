package cn.elves.entity.req;

public class MsgReq {
    public MsgReq() {
    }

    private String msg;

    private String sessionId;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
