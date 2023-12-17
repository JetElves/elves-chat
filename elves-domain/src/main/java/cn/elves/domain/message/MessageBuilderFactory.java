package cn.elves.domain.message;

import cn.elves.domain.message.validator.SendMsgValidator;
import org.springframework.stereotype.Component;

@Component
public class MessageBuilderFactory {

    private final SendMsgValidator sendMsgValidator;

    public MessageBuilderFactory(SendMsgValidator sendMsgValidator){
        this.sendMsgValidator = sendMsgValidator;
    }



    public MessageBuilder create(){
        return new MessageBuilder(sendMsgValidator);
    }
}
