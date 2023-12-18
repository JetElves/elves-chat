package cn.elves.chat.domain.session;


import cn.elves.chat.domain.session.validator.SessionValidator;

public class SessionBuilder {
    private String reqMsg;
    private String resMsg;
    private String sessionId;

    private final SessionValidator sessionValidator;


    public SessionBuilder(SessionValidator sessionValidator) {
        this.sessionValidator = sessionValidator;
    }

    public SessionBuilder reqMsg(String val) {
        reqMsg = val;
        return this;
    }

    public SessionBuilder resMsg(String val) {
        resMsg = val;
        return this;
    }

    public SessionBuilder sessionId(String val) {
        sessionId = val;
        return this;
    }



    public Session build() {
        sessionValidator.sessionShouldEffective(sessionId);
        Session session = new Session();
        session.setReqMsg(reqMsg);
        session.setResMsg(resMsg);
        session.setSessionId(sessionId);
        return session;
    }
}
