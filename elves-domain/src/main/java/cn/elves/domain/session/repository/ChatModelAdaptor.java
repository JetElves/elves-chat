package cn.elves.domain.session.repository;

import cn.elves.domain.session.Session;

public interface ChatModelAdaptor {


    Session sendMsg(Session reqSession);
}
