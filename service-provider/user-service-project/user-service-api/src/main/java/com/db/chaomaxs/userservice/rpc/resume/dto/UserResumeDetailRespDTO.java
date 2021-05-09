package com.db.chaomaxs.userservice.rpc.resume.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wst
 * @date 2021/4/13 10:33
 */


@Data
@Accessors(chain = true)
public class UserResumeDetailRespDTO implements Serializable {


  private static final long serialVersionUID = 1577543076661125376L;
  /**
   * 用户id
   */
  private Long userId;

  /**
   * 头像
   */
  private String avatarUrl;

  /**
   * 用户名称
   */
  private String realName;

  /**
   * 年龄
   */
  private Integer age;

  /**
   * 学历
   */
  private Long educationDictionaryId;

  /**
   * 工作年限
   */
  private Integer workYearTotal;

  /**
   * 期望薪资(开始)
   */
  private Integer startSalary;

  /**
   * 期望薪资(结束)
   */
  private Integer endSalary;


  /**
   * 公司名称
   */
  private String companyName;


  /**
   * 职位名称
   */
  private String positionName;


  /**
   * 上家公司工作时间
   */
  private String lastCompanyWorkYear;

  /**
   * 工作经历标签
   */
  private List<UserWorkSkillTagRespDTO> workSkillTagList;

  /**
   * 自我评价
   */
  private String evaluate;

}
