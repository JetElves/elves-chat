package cn.elves.chat.domain.session.repository;

import cn.elves.chat.domain.session.Session;


public interface ChatModelAdaptor {


    Session sendMsg(Session reqSession);
}
