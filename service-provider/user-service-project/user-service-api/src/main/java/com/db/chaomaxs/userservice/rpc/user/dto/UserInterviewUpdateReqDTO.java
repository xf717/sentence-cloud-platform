package com.db.chaomaxs.userservice.rpc.user.dto;

import java.util.Date;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户面试表
 *
 * @author momo
 * @date 2021-04-02 13:58:28
 */
@Data
@Accessors(chain = true)
public class UserInterviewUpdateReqDTO implements Serializable {


    /**
     * 主键id
     */
    @NotEmpty(message = "主键id")
    private Long id;

    /**
     * 状态
     * 0 -  待接受面试
     * 1 -  待面试
     * 2 -  拒绝面试
     * 3 - 通过面试
     * 4 - 拒绝录用
     * 5-  接受录用
     * 6 - 企业已取消
     * 7 - 用户已取消
     */
    private Integer status;


}
