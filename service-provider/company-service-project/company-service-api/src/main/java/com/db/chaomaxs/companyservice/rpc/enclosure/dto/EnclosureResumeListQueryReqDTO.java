package com.db.chaomaxs.companyservice.rpc.enclosure.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 企业附件简历
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
public class EnclosureResumeListQueryReqDTO implements Serializable {


  /**
   *
   */
  @NotEmpty(message = "")
  private Long id;

  /**
   * 企业投递表主键id
   */
  private Long companyDeliveryId;

  /**
   * 对应资源库id
   */
  private Long resourceId;

  /**
   * 是否删除
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
