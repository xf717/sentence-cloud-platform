package com.db.chaomaxs.systemservice.rpc.dict.dto;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 字典分类信息表
 *
 * @author ding
 * @date 2021-04-12
 */
@Data
@Accessors(chain = true)
public class DataDictionaryTypeListIdsReqDTO implements Serializable {

  /**
   * 字典项id集合
   */
  @NotEmpty
  List<Long> ids;

}
