package com.db.chaomaxs.systemservice.manager.dict;

import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemQueryRespDTO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemRespDTO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemUpdateReqDTO;
import com.db.chaomaxs.systemservice.service.dict.DataDictionaryItemService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * DataDictionaryItemManager
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Service
@Validated
public class DataDictionaryItemManager {

  @Autowired
  private DataDictionaryItemService dataDictionaryItemService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveDataDictionaryItem(DataDictionaryItemCreateReqDTO createReqDTO) {
    return dataDictionaryItemService.saveDataDictionaryItem(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateDataDictionaryItem(DataDictionaryItemUpdateReqDTO updateReqDTO) {
      return dataDictionaryItemService.updateDataDictionaryItem(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteDataDictionaryItem(Long id) {
    return dataDictionaryItemService.deleteDataDictionaryItem(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<DataDictionaryItemRespDTO> listDataDictionaryItems(DataDictionaryItemListQueryReqDTO listQueryReqDTO) {
    return dataDictionaryItemService.listDataDictionaryItems(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public DataDictionaryItemRespDTO getDataDictionaryItemById(Long id) {
    return dataDictionaryItemService.getDataDictionaryItemById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<DataDictionaryItemRespDTO> pageDataDictionaryItem(DataDictionaryItemPageReqDTO page) {
    return dataDictionaryItemService.pageDataDictionaryItem(page);
  }

  /**
   * 根据字典类型code集合查询字典项信息
   * @param queryDTO
   * @return
   */
  public Map<String,List<DataDictionaryItemQueryRespDTO>> getDictItem(DataDictionaryItemQueryReqDTO queryDTO) {
    return dataDictionaryItemService.getDictItem(queryDTO);
  }


  /**
   * 根据ids获取对象
   *
   * @param ids
   * @return
   */
  public List<DataDictionaryItemRespDTO> listDataDictionaryItemByIds(List<Long> ids) {
    return dataDictionaryItemService.getDataDictionaryItemByIds(ids);
  }
}
