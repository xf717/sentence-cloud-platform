package com.github.xf717.managementweb.manager.dict;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.managementweb.controller.dict.dto.DataDictionaryTypePageDTO;
import com.github.xf717.managementweb.controller.dict.vo.DataDictionaryTypeVO;
import com.github.xf717.managementweb.convert.dict.DataDictionaryTypeConvert;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryTypeRespDTO;
import com.github.xf717.systemservice.rpc.dict.facade.DataDictionaryTypeRpcFacade;
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
