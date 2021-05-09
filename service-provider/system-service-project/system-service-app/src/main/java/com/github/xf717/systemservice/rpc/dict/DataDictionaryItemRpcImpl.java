package com.github.xf717.systemservice.rpc.dict;

import com.github.xf717.common.framework.exception.enums.GlobalErrorCodeConstants;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.manager.dict.DataDictionaryItemManager;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemCreateReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemListQueryReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemPageReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemQueryReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemQueryRespDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemRespDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemUpdateReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryTypeListIdsReqDTO;
import com.github.xf717.systemservice.rpc.dict.facade.DataDictionaryItemRpcFacade;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Slf4j
@Service
public class DataDictionaryItemRpcImpl implements DataDictionaryItemRpcFacade {

  @Autowired
  private DataDictionaryItemManager dataDictionaryItemManager;

  @Override
  public BaseResponse save(DataDictionaryItemCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    dataDictionaryItemManager.saveDataDictionaryItem(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(DataDictionaryItemUpdateReqDTO updateReqDTO) {
      dataDictionaryItemManager.updateDataDictionaryItem(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      dataDictionaryItemManager.deleteDataDictionaryItem(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<DataDictionaryItemRespDTO> getDataDictionaryItemById(Long id) {
      DataDictionaryItemRespDTO dataDictionaryItem = dataDictionaryItemManager.getDataDictionaryItemById(id);
    return new ObjectRestResponse<>().data(dataDictionaryItem);
  }

  @Override
  public ObjectRestResponse<List<DataDictionaryItemRespDTO>> listDataDictionaryItems(DataDictionaryItemListQueryReqDTO listQuery) {
    List<DataDictionaryItemRespDTO> list = dataDictionaryItemManager.listDataDictionaryItems(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<DataDictionaryItemRespDTO> page(DataDictionaryItemPageReqDTO pageReqDTO) {
    PageResult<DataDictionaryItemRespDTO> pageResult = dataDictionaryItemManager.pageDataDictionaryItem(pageReqDTO);
    TableResultResponse<DataDictionaryItemRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    tableResultResponse.setCode(GlobalErrorCodeConstants.SUCCESS.getCode());
    return tableResultResponse;
  }

  /**
   * 根据字典类型code集合查询字典项信息
   * @param queryDTO
   * @return
   */
  @Override
  public ObjectRestResponse getDictItem(DataDictionaryItemQueryReqDTO queryDTO) {
    Map<String, List<DataDictionaryItemQueryRespDTO>> dictItem = dataDictionaryItemManager
        .getDictItem(queryDTO);
    return new ObjectRestResponse<>().data(dictItem);
  }

  /**
   * 根据ids获取对象
   *
   * @param queryDTO
   * @return
   */

  @Override
  public ObjectRestResponse<List<DataDictionaryItemRespDTO>> listDataDictionaryItemByIds(
      DataDictionaryTypeListIdsReqDTO queryDTO) {
    List<DataDictionaryItemRespDTO> list = dataDictionaryItemManager
        .listDataDictionaryItemByIds(queryDTO.getIds());
    return new ObjectRestResponse<>().data(list);
  }

}
