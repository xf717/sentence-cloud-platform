package com.db.chaomaxs.systemservice.manager.dict;

import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryTypePageReqDTO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryTypeRespDTO;
import com.db.chaomaxs.systemservice.service.dict.DataDictionaryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * DataDictionaryTypeManager
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Service
@Validated
public class DataDictionaryTypeManager {

  @Autowired
  private DataDictionaryTypeService dataDictionaryTypeService;


  /**
  * 分类
* @param page
* @return
*/
  public PageResult<DataDictionaryTypeRespDTO> pageDataDictionaryType(DataDictionaryTypePageReqDTO page) {
    return dataDictionaryTypeService.pageDataDictionaryType(page);
  }


}
