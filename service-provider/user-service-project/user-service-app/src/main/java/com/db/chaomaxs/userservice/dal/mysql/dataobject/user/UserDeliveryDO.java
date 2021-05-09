package com.db.chaomaxs.userservice.dal.mysql.dataobject.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 企业投递表
 *
 * @author momo
 * @date 2021-04-08 14:18:28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_delivery")
public class UserDeliveryDO extends DeletableDO {

    /**
     * 主键id
     */
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
     * 职位id
     */
    private Long positionId;

    /**
     * 状态
     */
    private Integer status;


}
