package com.db.chaomaxs.systemservice.service.dict;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.convert.dict.DataDictionaryTypeConvert;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.dict.DataDictionaryTypeDO;
import com.db.chaomaxs.systemservice.dal.mysql.mapper.dict.DataDictionaryTypeMapper;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryTypePageReqDTO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryTypeRespDTO;
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
