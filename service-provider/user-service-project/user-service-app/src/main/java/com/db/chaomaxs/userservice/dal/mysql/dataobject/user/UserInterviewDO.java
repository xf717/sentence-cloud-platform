package com.db.chaomaxs.userservice.dal.mysql.dataobject.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 用户面试表
 *
 * @author momo
 * @date 2021-04-02 13:58:28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_interview")
public class UserInterviewDO extends DeletableDO {

    /**
     * 主键id
     */
    private Long id;

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
