package com.db.chaomaxs.userweb.manager.dict;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.dict.facade.DataDictionaryItemRpcFacade;
import com.db.chaomaxs.userweb.controller.dict.dto.DataDictionaryItemQueryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * DataDictionaryItemManager
 *
 * @author ding
 * @date 2021-03-29 17:42:11
 */
@Service
@Validated
public class DataDictionaryItemManager {

  @Autowired
  private DataDictionaryItemRpcFacade dataDictionaryItemRpcFacade;


  /**
   * 根据字典类型code集合查询字典项信息
   * @param queryDTO
   * @return
   */
  public ObjectRestResponse getDictItem(DataDictionaryItemQueryDTO queryDTO) {
    DataDictionaryItemQueryReqDTO queryRespDTO = new DataDictionaryItemQueryReqDTO();
    queryRespDTO.setCodes(queryDTO.getCodes());
    return dataDictionaryItemRpcFacade.getDictItem(queryRespDTO);
  }
}
