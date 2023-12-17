package cn.elves.domain.message.validator;

import cn.elves.domain.message.exception.SessionException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class SendMsgValidator {
    public void sessionShouldEnable(String sessionId) {
        if(StringUtils.isEmpty(sessionId)){
            throw new SessionException("session无效,请新建会话后重试");
        }
    }
}
