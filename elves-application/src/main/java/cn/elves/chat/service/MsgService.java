package cn.elves.chat.service;


import cn.elves.chat.domain.session.Session;
import cn.elves.chat.domain.session.SessionBuilder;
import cn.elves.chat.domain.session.SessionBuilderFactory;
import cn.elves.chat.domain.session.service.SessionHandler;
import cn.elves.chat.entity.req.MsgReq;
import cn.elves.chat.entity.res.MsgRes;
import org.springframework.stereotype.Service;

@Service
public class MsgService {

    private final SessionBuilderFactory sessionBuilderFactory;

    private final SessionHandler sessionHandler;

    public MsgService(SessionBuilderFactory sessionBuilderFactory, SessionHandler sessionHandler) {
        this.sessionBuilderFactory = sessionBuilderFactory;
        this.sessionHandler = sessionHandler;
    }

    public MsgRes sendMsg(MsgReq msgReq) {
        SessionBuilder sessionBuilder = sessionBuilderFactory.create();

        Session reqSession = sessionBuilder.reqMsg(msgReq.getMsg())
                .sessionId(msgReq.getSessionId())
                .build();

        Session resSession = sessionHandler.handleSendedMsg(reqSession);

        return buildMsgRes(resSession);
    }

    private static MsgRes buildMsgRes(Session session){
        MsgRes msgRes = new MsgRes();
        msgRes.setMsg(session.getResMsg());
        msgRes.setSessionId(session.getSessionId());
        return msgRes;
    }
}
