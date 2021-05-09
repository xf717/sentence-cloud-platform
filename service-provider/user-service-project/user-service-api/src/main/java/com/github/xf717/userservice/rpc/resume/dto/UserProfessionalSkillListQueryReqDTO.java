package com.github.xf717.userservice.rpc.resume.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 用户_专业技能表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
public class UserProfessionalSkillListQueryReqDTO implements Serializable {


  private static final long serialVersionUID = -6920337187330152528L;
  /**
   * 用户消息id
   */
  @NotEmpty(message = "用户消息id")
  private Long id;

  /**
   * 用户id
   */
  private Long userResumeId;

  /**
   * 阅读时长
   */
  private String skillName;

  /**
   * 读完多少本
   */
  private Integer durationNum;

  /**
   * 掌握程度，关联字典表id
   */
  private Long masteryDictionaryId;

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
