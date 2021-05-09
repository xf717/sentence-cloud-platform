package com.db.chaomaxs.userweb.controller.user.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 用户_职位_收藏
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserPositionCollectCreateDTO", description = "添加用户_职位_收藏")
public class UserPositionCollectAddDTO {

    /**
     * 用户id
     */
    @ApiModelProperty(name = "userId", value = "用户id")
    private Long userId;

    /**
     * 企业用户
     */
    @ApiModelProperty(name = "companyUserId", value = "企业用户")
    private Long companyUserId;

    /**
     * 企业发布的职位id
     */
    @ApiModelProperty(name = "positionId", value = "企业发布的职位id")
    private Long positionId;
}
