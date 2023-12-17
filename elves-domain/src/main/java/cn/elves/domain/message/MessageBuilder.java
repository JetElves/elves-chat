package cn.elves.domain.message;


import cn.elves.domain.message.validator.SendMsgValidator;

public class MessageBuilder {
    private String reqMsg;
    private String resMsg;
    private String sessionId;

    private final SendMsgValidator sendMsgValidator;


    public MessageBuilder(SendMsgValidator sendMsgValidator) {
        this.sendMsgValidator = sendMsgValidator;
    }

    public MessageBuilder reqMsg(String val) {
        reqMsg = val;
        return this;
    }

    public MessageBuilder resMsg(String val) {
        resMsg = val;
        return this;
    }

    public MessageBuilder sessionId(String val) {
        sessionId = val;
        return this;
    }



    public Message build() {
        sendMsgValidator.sessionShouldEnable(sessionId);
        Message message = new Message();
        message.setReqMsg(reqMsg);
        message.setResMsg(resMsg);
        message.setSessionId(sessionId);
        return message;
    }
}
