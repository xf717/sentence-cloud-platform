package com.db.chaomaxs.companyservice.rpc.company.dto;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author hlf
 * @version 1.0
 * @description: 福利保存请求类
 * @date 2021/4/28 16:53
 */
@Data
@Accessors(chain = true)
public class CompanyPhotoSaveReqDTO {

  /**
   * companyPhotoReqDTOS
   */
  private List<CompanyPhotoReqDTO> companyPhotoReqDTOS;

  /**
   * 公司id
   */
  private Long companyId;

}
