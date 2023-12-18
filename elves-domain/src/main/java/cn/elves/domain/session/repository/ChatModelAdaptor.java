package cn.elves.domain.session.repository;

import cn.elves.domain.session.Session;
import org.springframework.stereotype.Component;


public interface ChatModelAdaptor {


    Session sendMsg(Session reqSession);
}
