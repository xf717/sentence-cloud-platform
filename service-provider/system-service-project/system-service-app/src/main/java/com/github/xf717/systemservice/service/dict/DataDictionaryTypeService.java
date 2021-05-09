package com.github.xf717.systemservice.service.dict;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.convert.dict.DataDictionaryTypeConvert;
import com.github.xf717.systemservice.dal.mysql.dataobject.dict.DataDictionaryTypeDO;
import com.github.xf717.systemservice.dal.mysql.mapper.dict.DataDictionaryTypeMapper;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryTypePageReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryTypeRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * DataDictionaryTypeService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class DataDictionaryTypeService {

  @Autowired
  private DataDictionaryTypeMapper dataDictionaryTypeMapper;


  /**
   * 分类分页
   *
   * @param page
   * @return
   */
  public PageResult<DataDictionaryTypeRespDTO> pageDataDictionaryType(
      DataDictionaryTypePageReqDTO page) {
    IPage<DataDictionaryTypeDO> dataDictionaryTypePage = dataDictionaryTypeMapper.findByPage(page);
    return DataDictionaryTypeConvert.INSTANCE.convertPage(dataDictionaryTypePage);
  }


}
