package cn.elves.restful;


import cn.elves.APIResponse;
import cn.elves.entity.req.MsgReq;
import cn.elves.entity.res.MsgRes;
import cn.elves.service.MsgService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final MsgService msgService;

    public ChatController(MsgService msgService, MsgService msgService1) {
        this.msgService = msgService1;
    }

    @PostMapping("sendMsg")
    public APIResponse<MsgRes> sendMsg(MsgReq msgReq) {

        return APIResponse.success(msgService.sendMsg(msgReq));
    }

}
