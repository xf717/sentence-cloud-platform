package com.github.xf717.userservice.rpc.resume.dto;

import com.github.xf717.common.framework.vo.PageParam;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉, 验证添加要自行调整@NotEmpty 自行配置 用户_附件_简历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
public class UserEnclosureResumePageReqDTO extends PageParam {

  private static final long serialVersionUID = 2394705918826921370L;
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
   * 附件资源ID
   */
  private Long resourceId;

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
