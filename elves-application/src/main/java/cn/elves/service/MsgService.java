package cn.elves.service;


import cn.elves.domain.session.Session;
import cn.elves.domain.session.SessionBuilder;
import cn.elves.domain.session.SessionBuilderFactory;
import cn.elves.domain.session.service.SessionHandler;
import cn.elves.entity.req.MsgReq;
import cn.elves.entity.res.MsgRes;
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
