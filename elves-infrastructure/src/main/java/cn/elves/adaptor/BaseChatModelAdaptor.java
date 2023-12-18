package cn.elves.adaptor;


import cn.elves.domain.session.repository.ChatModelAdaptor;
import cn.elves.domain.session.Session;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;

@Component
public class BaseChatModelAdaptor implements ChatModelAdaptor {

    private final String HOST = "https://chat.weixk.com/";

    private final String CHAT_INTERFACE = "chat";

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
