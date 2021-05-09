package com.github.xf717.userservice.rpc.user.dto;

import com.github.xf717.common.framework.vo.PageParam;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;


/**
 * 企业投递表
 *
 * @author momo
 * @date 2021-04-08 14:18:28
 */
@Data
@Accessors(chain = true)
public class UserDeliveryPageReqDTO extends PageParam implements Serializable {

    /**
     * 用户id
     */
    private Long userId;


}
