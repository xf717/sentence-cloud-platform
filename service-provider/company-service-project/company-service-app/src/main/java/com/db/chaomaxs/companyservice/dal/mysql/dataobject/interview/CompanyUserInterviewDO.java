package com.db.chaomaxs.companyservice.dal.mysql.dataobject.interview;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.BaseDO;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 企业面试表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("company_user_interview")
public class CompanyUserInterviewDO extends BaseDO {

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
   * 地址
   */
  private String interviewAddress;

  /**
   * 面试时间
   */
  private Date interviemTime;

  /**
   * 职位名
   */
  private String positionName;

  /**
   * 手机号
   */
  private String mobile;

  /**
   * 状态 0 -  待接受面试 1 -  待面试 2 -  拒绝面试 3 - 通过面试 4 - 拒绝录用 5-  接受录用 6 - 已取消
   */
  private Integer status;

  @TableLogic
  private Integer isDeleted;
}
