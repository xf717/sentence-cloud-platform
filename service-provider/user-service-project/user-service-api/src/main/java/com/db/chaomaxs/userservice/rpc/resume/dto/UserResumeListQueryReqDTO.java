package com.db.chaomaxs.userservice.rpc.resume.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 用户_简历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@Data
@Accessors(chain = true)
public class UserResumeListQueryReqDTO implements Serializable {


  private static final long serialVersionUID = -6550323405673911578L;
  /**
   * 主键Id
   */
  @NotEmpty(message = "主键Id")
  private Long id;

  /**
   * 用户id
   */
  private Long userId;

  /**
   * 出生年
   */
  private Integer birthdayYear;

  /**
   * 出身月
   */
  private Integer birthdayMonth;

  /**
   * 出生日
   */
  private Integer birthdayDay;

  /**
   * 参加工作时间
   */
  private Integer participateJob;

  /**
   * 工作年限
   */
  private Integer workYearTotal;

  /**
   * 自我评价
   */
  private String evaluate;

  /**
   * 求职状态:关键字典表id
   */
  private Long positionWantedDictionaryId;

  /**
   * 求职状态名称，冗余字段
   */
  private String positionWantedStatusName;

  /**
   *
   */
  private Integer isOpen;

  /**
   * 公司id,做为数据隔离
   */
  private Long companyId;

  /**
   * 是否删除 1:是 0否  默认：0
   */
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
