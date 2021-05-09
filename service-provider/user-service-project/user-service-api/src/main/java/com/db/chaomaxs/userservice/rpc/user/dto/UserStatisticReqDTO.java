package com.db.chaomaxs.userservice.rpc.user.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * 企业我的足迹
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@Data
@Accessors(chain = true)
public class UserStatisticReqDTO implements Serializable {


    /**
     * 企业用户id
     */
    private Long userId;


}
