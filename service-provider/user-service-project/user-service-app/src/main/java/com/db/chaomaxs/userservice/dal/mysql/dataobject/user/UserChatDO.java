package com.db.chaomaxs.userservice.dal.mysql.dataobject.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 用户_沟通
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_chat")
public class UserChatDO extends DeletableDO {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 企业发布的职位id
     */
    private Long positionId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 企业用户id
     */
    private Long companyUserId;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer sort;



}
