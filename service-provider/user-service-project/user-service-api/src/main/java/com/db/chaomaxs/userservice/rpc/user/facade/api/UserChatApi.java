package com.db.chaomaxs.userservice.rpc.user.facade.api;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.userservice.rpc.user.dto.UserChatCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserChatRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserChatPageReqDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户_沟通
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
public interface UserChatApi {

    /**
     * 添加数据
     *
     * @param createReqDTO 添加参数
     * @return
     */
    @PostMapping("/facade/userChat/save")
    BaseResponse save(@RequestBody UserChatCreateReqDTO createReqDTO);



    /**
     * 查找数据显示分页
     *
     * @param pageReqDTO 分页参数
     * @return
     */
    @PostMapping("/facade/userChat/page")
    TableResultResponse<UserChatRespDTO> page(@RequestBody UserChatPageReqDTO pageReqDTO);

}
