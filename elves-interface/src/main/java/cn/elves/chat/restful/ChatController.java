package cn.elves.chat.restful;


import cn.elves.chat.APIResponse;
import cn.elves.chat.entity.req.MsgReq;
import cn.elves.chat.entity.res.MsgRes;
import cn.elves.chat.service.SessionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final SessionService sessionService;

    public ChatController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping("sendMsg")
    public APIResponse<MsgRes> sendMsg(@RequestBody MsgReq msgReq) {
        return APIResponse.success(sessionService.sendMsg(msgReq));
    }

}
