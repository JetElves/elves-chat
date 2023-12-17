package cn.elves.domain.message.service;


import cn.elves.domain.message.Message;
import cn.elves.domain.message.MessageBuilderFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MsgHandler {

    private final MessageBuilderFactory messageBuilderFactory;

    public MsgHandler(MessageBuilderFactory messageBuilderFactory) {
        this.messageBuilderFactory = messageBuilderFactory;
    }


    public Message handleSendedMsg(Message reqMessage) {
        return reqMessage.sendMsg();
    }
}
