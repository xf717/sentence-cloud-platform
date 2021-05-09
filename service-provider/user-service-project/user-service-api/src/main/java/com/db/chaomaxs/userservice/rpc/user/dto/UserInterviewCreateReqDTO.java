package com.db.chaomaxs.userservice.rpc.user.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 比如：create_time、update_time、create_by、update_by 就可以去掉,
 * 验证添加要自行调整@NotEmpty 自行配置
 * 用户面试表
 *
 * @author momo
 * @date 2021-04-02 13:58:28
 */
@Data
@Accessors(chain = true)
public class UserInterviewCreateReqDTO implements Serializable {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 企业用户面试表id
     */
    private Long companyUserInterviewId;

    /**
     * 状态
     */
    private Integer status;
}
