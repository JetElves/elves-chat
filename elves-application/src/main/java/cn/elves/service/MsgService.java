package cn.elves.service;


import cn.elves.domain.message.Message;
import cn.elves.domain.message.MessageBuilder;
import cn.elves.domain.message.MessageBuilderFactory;
import cn.elves.domain.message.service.MsgHandler;
import cn.elves.entity.req.MsgReq;
import cn.elves.entity.res.MsgRes;
import org.springframework.stereotype.Service;

@Service
public class MsgService {

    private final MessageBuilderFactory messageBuilderFactory;

    private final MsgHandler msgHandler;

    public MsgService(MessageBuilderFactory messageBuilderFactory, MsgHandler msgHandler) {
        this.messageBuilderFactory = messageBuilderFactory;
        this.msgHandler = msgHandler;
    }

    public MsgRes sendMsg(MsgReq msgReq) {
        MessageBuilder messageBuilder = messageBuilderFactory.create();

        Message reqMessage = messageBuilder.reqMsg(msgReq.getMsg())
                .sessionId(msgReq.getSessionId())
                .build();

        Message resMessage = msgHandler.handleSendedMsg(reqMessage);

        return null;
    }
}
