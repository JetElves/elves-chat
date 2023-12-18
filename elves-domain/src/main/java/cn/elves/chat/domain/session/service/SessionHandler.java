package cn.elves.chat.domain.session.service;


import cn.elves.chat.domain.session.Session;
import cn.elves.chat.domain.session.repository.ChatModelAdaptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SessionHandler {

    private final ChatModelAdaptor chatModelAdaptor;

    public SessionHandler(ChatModelAdaptor chatModelAdaptor) {
        this.chatModelAdaptor = chatModelAdaptor;
    }


    public Session handleSendedMsg(Session reqSession) {
        return chatModelAdaptor.sendMsg(reqSession);
    }
}
