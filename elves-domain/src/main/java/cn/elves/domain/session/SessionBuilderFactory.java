package cn.elves.domain.session;

import cn.elves.domain.session.validator.SessionValidator;
import org.springframework.stereotype.Component;

@Component
public class SessionBuilderFactory {

    private final SessionValidator sessionValidator;

    public SessionBuilderFactory(SessionValidator sessionValidator){
        this.sessionValidator = sessionValidator;
    }



    public SessionBuilder create(){
        return new SessionBuilder(sessionValidator);
    }
}
