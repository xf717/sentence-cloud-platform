package com.db.chaomaxs.systemservice.dal.mysql.dataobject.content;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.BaseDO;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 内容管理-协议信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("agreement_information")
public class AgreementInformationDO extends BaseDO {

  /**
   * 系统id
   */
  private Long id;

  /**
   * 标题
   */
  private String keywordTitle;

	/**
	 * 编号
	 */
	private String code;

  /**
   * 发布状态（1 发布 0未发布）
   */
  private Integer releaseStatus;

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


}
