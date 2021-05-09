package com.github.xf717.userservice.rpc.user.dto;

import com.github.xf717.common.framework.vo.PageParam;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Data
@Accessors(chain = true)
public class UserChatPageReqDTO extends PageParam implements Serializable {


    /**
     * 用户id
     */
    private Long userId;


}
