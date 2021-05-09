package com.db.chaomaxs.managementweb.manager.dict;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.managementweb.controller.dict.dto.DataDictionaryTypePageDTO;
import com.db.chaomaxs.managementweb.controller.dict.vo.DataDictionaryTypeVO;
import com.db.chaomaxs.managementweb.convert.dict.DataDictionaryTypeConvert;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryTypeRespDTO;
import com.db.chaomaxs.systemservice.rpc.dict.facade.DataDictionaryTypeRpcFacade;
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
  private DataDictionaryTypeRpcFacade dataDictionaryTypeRpcFacade;


  /**
   * 查找数据显示分页
   * @param pageReqDTO  分页参数
   * @return
   */
  public TableResultResponse<DataDictionaryTypeVO> pageDataDictionaryType(DataDictionaryTypePageDTO pageReqDTO) {
    TableResultResponse<DataDictionaryTypeRespDTO> tableResultResponse = dataDictionaryTypeRpcFacade
        .page(DataDictionaryTypeConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return DataDictionaryTypeConvert.INSTANCE.convert(tableResultResponse);
  }


}
