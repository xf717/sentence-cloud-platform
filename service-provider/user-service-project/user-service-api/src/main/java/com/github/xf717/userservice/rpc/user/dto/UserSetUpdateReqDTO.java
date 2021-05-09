package com.github.xf717.userservice.rpc.user.dto;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户_设置
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Data
@Accessors(chain = true)
public class UserSetUpdateReqDTO implements Serializable {


    private Long id;
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 企业用户id
     */
    private Long companyUserId;

    /**
     * 是否拉入黑名单
     * 0 - 否
     * 1 - 是
     */
    private Integer blackSwitch;

    /**
     * 是否拉黑职位
     * 0 - 否
     * 1 - 是
     */
    private Integer blackCompanyUserSwitch;

    /**
     * 消息是否置顶
     * 0 - 否
     * 1 - 是
     */
    private Integer topSwitch;


}
