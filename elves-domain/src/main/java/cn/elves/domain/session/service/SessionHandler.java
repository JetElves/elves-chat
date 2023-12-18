package cn.elves.domain.session.service;


import cn.elves.domain.session.repository.ChatModelAdaptor;
import cn.elves.domain.session.Session;
import cn.elves.domain.session.SessionBuilderFactory;
import org.springframework.stereotype.Component;

@Component
public class SessionHandler {

    private final SessionBuilderFactory sessionBuilderFactory;

    private final ChatModelAdaptor chatModelAdaptor;

    public SessionHandler( ChatModelAdaptor chatModelAdaptor,SessionBuilderFactory sessionBuilderFactory) {
        this.sessionBuilderFactory = sessionBuilderFactory;
        this.chatModelAdaptor = chatModelAdaptor;
    }


    public Session handleSendedMsg(Session reqSession) {
        return chatModelAdaptor.sendMsg(reqSession);
    }
}
