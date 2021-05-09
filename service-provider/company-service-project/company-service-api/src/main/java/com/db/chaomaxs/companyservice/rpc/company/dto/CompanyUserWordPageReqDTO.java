package com.db.chaomaxs.companyservice.rpc.company.dto;

import com.db.chaomaxs.common.framework.vo.PageParam;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉, 验证添加要自行调整@NotEmpty 自行配置 企业常用语表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
public class CompanyUserWordPageReqDTO extends PageParam implements Serializable {

  /**
   * 主键id
   */
  @NotEmpty(message = "主键id")
  private Long id;

  /**
   * 企业id
   */
  private Long companyId;

  /**
   * 企业用户id
   */
  private Long companyUserId;

  /**
   * 内容
   */
  private String content;

  /**
   * 排序
   */
  private Integer sort;

  /**
   * 是否删除 0 - 否 1-是
   */
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
