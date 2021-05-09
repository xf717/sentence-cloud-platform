package com.db.chaomaxs.systemservice.rpc.auth.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Data
@Accessors(chain = true)
public class BaseMenuListQueryReqDTO implements Serializable {

  /**
   * 标题
   */
  private String title;

  /**
   * 父id
   */
  private Long parentId;

  /**
   * 路径
   */
  private String path;




}
