package cn.elves.chat.domain.session.validator;

import cn.elves.chat.domain.session.exception.SessionException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class SessionValidator {


    public void sessionShouldEffective(String sessionId) {
        if(StringUtils.isEmpty(sessionId)){
            throw new SessionException("session无效,请新建会话后重试");
        }
    }
}
