package com.db.chaomaxs.companyservice.dal.mysql.dataobject.track;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.BaseDO;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 企业我的足迹
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("company_user_track")
public class CompanyUserTrackDO extends BaseDO {

  /**
   * 主键id
   */
  private Long id;

  /**
   * 企业用户id
   */
  private Long companyUserId;

  /**
   * 职位id
   */
  private Long positionId;

  /**
   * 用户id
   */
  private Long userId;

  /**
   * 是否删除 0-否 1-是
   */
  @TableLogic
  private Integer isDeleted;

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


}
