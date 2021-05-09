package com.db.chaomaxs.systemservice.rpc.dict.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DataDictionaryItemQueryRespDTO {

  /**
   * 系统id
   */

  private Long id;



  /**
   * 字典项名称
   */
  private String dictText;

  /**
   * 字典类型编号
   */
  private String dictValue;

  /**
   * 字典类型唯一编码
   */
  private String code;

}
