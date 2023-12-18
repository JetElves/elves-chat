package cn.elves.domain.session.validator;

import cn.elves.domain.session.exception.SessionException;
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
