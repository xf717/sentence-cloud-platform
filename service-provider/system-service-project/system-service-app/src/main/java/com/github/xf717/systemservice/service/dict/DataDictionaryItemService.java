package com.github.xf717.systemservice.service.dict;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.util.StringUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.convert.dict.DataDictionaryItemConvert;
import com.github.xf717.systemservice.dal.mysql.dataobject.dict.DataDictionaryItemDO;
import com.github.xf717.systemservice.dal.mysql.mapper.dict.DataDictionaryItemMapper;
import com.github.xf717.systemservice.enums.dict.DataDictionaryEnum;
import com.github.xf717.systemservice.enums.SystemErrorCodeConstants;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemCreateReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemListQueryReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemPageReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemQueryReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemQueryRespDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemRespDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemUpdateReqDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * DataDictionaryItemService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class DataDictionaryItemService {

  @Autowired
  private DataDictionaryItemMapper dataDictionaryItemMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveDataDictionaryItem(DataDictionaryItemCreateReqDTO createReqDTO) {
    return dataDictionaryItemMapper
        .insert(DataDictionaryItemConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateDataDictionaryItem(DataDictionaryItemUpdateReqDTO updateReqDTO) {
    DataDictionaryItemDO dataDictionaryItemDO = dataDictionaryItemMapper
        .selectById(updateReqDTO.getId());
    if (dataDictionaryItemDO == null) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    dataDictionaryItemDO = DataDictionaryItemConvert.INSTANCE.convert(updateReqDTO);
    int result = dataDictionaryItemMapper.updateById(dataDictionaryItemDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteDataDictionaryItem(Long id) {
    if (dataDictionaryItemMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    int result = dataDictionaryItemMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<DataDictionaryItemRespDTO> listDataDictionaryItems(
      DataDictionaryItemListQueryReqDTO listQueryReqDTO) {
    List<DataDictionaryItemDO> list = dataDictionaryItemMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return DataDictionaryItemConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public DataDictionaryItemRespDTO getDataDictionaryItemById(Long id) {
    DataDictionaryItemDO dataDictionaryItemDO = dataDictionaryItemMapper.selectById(id);
    if (dataDictionaryItemDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    return DataDictionaryItemConvert.INSTANCE.convert(dataDictionaryItemDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<DataDictionaryItemRespDTO> pageDataDictionaryItem(
      DataDictionaryItemPageReqDTO page) {
    IPage<DataDictionaryItemDO> dataDictionaryItemPage = dataDictionaryItemMapper.findByPage(page);
    return DataDictionaryItemConvert.INSTANCE.convertPage(dataDictionaryItemPage);
  }

  /**
   *根据字典类型code集合查询字典项信息
   * @param queryDTO
   * @return
   */
  public Map<String, List<DataDictionaryItemQueryRespDTO>> getDictItem(
      DataDictionaryItemQueryReqDTO queryDTO) {
    if (CollectionUtils.isEmpty(queryDTO.getCodes())) {
      return new HashMap<>();
    }
    List<Long> ids = new ArrayList<>();
    //把类型code转换成字典类型id
    for (String code : queryDTO.getCodes()) {
      DataDictionaryEnum dataDictionaryEnum = DataDictionaryEnum.getKey(code);
      if (null == dataDictionaryEnum) {
        continue;
      }
      ids.add(dataDictionaryEnum.getKey());
    }
    if (CollectionUtils.isEmpty(ids)) {
      return new HashMap<>();
    }
    List<DataDictionaryItemQueryRespDTO> list = dataDictionaryItemMapper
        .getDictItemBydictTypeName(StringUtils.join(ids, StrUtil.COMMA));
    //根据类型code进行分组
    Map<String, List<DataDictionaryItemQueryRespDTO>> map = list.stream().collect(
        Collectors.groupingBy(DataDictionaryItemQueryRespDTO::getCode, LinkedHashMap::new,
            Collectors.toList()));
    return map;
  }


  /**
   * 根据ids获取对象
   *
   * @param ids
   * @return
   */
  public List<DataDictionaryItemRespDTO> getDataDictionaryItemByIds(List<Long> ids) {
    List<DataDictionaryItemDO> dataDictionaryItemDOS = dataDictionaryItemMapper.selectBatchIds(ids);
    if (CollectionUtils.isEmpty(dataDictionaryItemDOS)) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.DICTIONARY_ITEM_NOT_EXISTS.getCode());
    }
    return DataDictionaryItemConvert.INSTANCE.convertList(dataDictionaryItemDOS);
  }
}
