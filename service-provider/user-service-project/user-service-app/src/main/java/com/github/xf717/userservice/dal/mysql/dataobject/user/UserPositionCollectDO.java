package com.github.xf717.userservice.dal.mysql.dataobject.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.xf717.mybatis.core.dataobject.DeletableDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 用户_职位_收藏
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_position_collect")
public class UserPositionCollectDO extends DeletableDO {

    /**
     * 系统id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 企业用户
     */
    private Long companyUserId;

    /**
     * 企业发布的职位id
     */
    private Long positionId;


}
