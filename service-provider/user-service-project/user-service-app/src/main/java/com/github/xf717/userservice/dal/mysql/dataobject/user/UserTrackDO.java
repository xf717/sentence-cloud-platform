package com.github.xf717.userservice.dal.mysql.dataobject.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.xf717.mybatis.core.dataobject.BaseDO;
import com.github.xf717.mybatis.core.dataobject.DeletableDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;


/**
 * 我的足迹
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_track")
public class UserTrackDO extends DeletableDO {

    /**
     * 主键id
     */
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
