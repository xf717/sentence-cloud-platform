package com.db.chaomaxs.userservice.dal.mysql.dataobject.user;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.BaseDO;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 用户_常用语
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_word")
public class UserWordDO extends BaseDO {

    /**
     *
     */
    private Long id;

    /**
     * 内容
     */
    private String content;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Long updateBy;

    /**
     * 修改时间
     */
    private Date updateTime;

    @TableLogic
    private Integer isDeleted;



}
