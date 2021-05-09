package com.db.chaomaxs.companyservice.rpc.track.dto;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉, 验证添加要自行调整@NotEmpty 自行配置 企业我的足迹
 *
 * @author momo
 * @date 2021-03-26 10:18:32
 */
@Data
@Accessors(chain = true)
public class CompanyUserTrackRespDTO implements Serializable {

  /**
   * 主键id
   */
  @NotEmpty(message = "主键id")
  private Long id;
  /**
   * 用户id
   */
  private Long companyUserId;

  /**
   * 职位id
   */
  private Long positionId;

  /**
   * 修改时间
   */
  private Date updateTime;






}
