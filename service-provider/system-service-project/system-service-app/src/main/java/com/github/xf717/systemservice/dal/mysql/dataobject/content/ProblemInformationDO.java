package com.github.xf717.systemservice.dal.mysql.dataobject.content;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.xf717.mybatis.core.dataobject.BaseDO;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 内容管理-问题信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("problem_information")
public class ProblemInformationDO extends BaseDO {

  /**
   * 系统id
   */
  private Long id;

  /**
   * 问题标题
   */
  private String title;

  /**
   * 问题类型,关联字典表id
   */
  private Long typeDictionaryId;

  /**
   * 发布状态  是否发布  1:是 0否
   */
  private Integer releaseStatus;

  /**
   * 排序
   */
  private Integer sort;

  /**
   * 是否删除 1:是 0否  默认：0
   */
  @TableLogic
  private Integer isDeleted;

  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 创建人
   */
  private Long createBy;

  /**
   * 修改时间
   */
  private Date updateTime;

  /**
   * 修改人
   */
  private Long updateBy;

  /**
   * 平台
   */
  private Integer platform;


}
