package com.db.chaomaxs.userweb.service.postition.bo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author momo
 * @date 2021-05-06 09:49
 */
@Data
public class UserPositionBO {
    /**
     * 主键id
     */
    @NotEmpty(message = "主键id")
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户发布的职位id
     */
    private Long positionId;


    /**
     * 企业用户id
     */
    private Long companyUserId;
}
