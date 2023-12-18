package cn.elves.chat.infrastructure.adaptor;


import cn.elves.chat.domain.session.repository.ChatModelAdaptor;
import cn.elves.chat.domain.session.Session;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;

@Repository
public class BaseChatModelAdaptor implements ChatModelAdaptor {

    private final String HOST = "https://chat.weixk.com";

    private final String CHAT_INTERFACE = "/v1/chat";

    @Resource
    private RestTemplate restTemplate;


    @Override
    public Session sendMsg(Session session) {
        HashMap<String, String> reqBody = new HashMap<>();
        reqBody.put("content", session.getReqMsg());
        reqBody.put("sessionId", session.getSessionId());
        String url = HOST + CHAT_INTERFACE;
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, reqBody, String.class);
        session.setResMsg(responseEntity.getBody());
        return session;
    }
}
