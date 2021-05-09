package com.github.xf717.systemservice.convert.dict;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.dal.mysql.dataobject.dict.DataDictionaryTypeDO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryTypeCreateReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryTypeRespDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryTypeUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * DataDictionaryTypeConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Mapper
public interface DataDictionaryTypeConvert {

        DataDictionaryTypeConvert INSTANCE = Mappers.getMapper(DataDictionaryTypeConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      DataDictionaryTypeDO convert(DataDictionaryTypeCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      DataDictionaryTypeDO convert(DataDictionaryTypeUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<DataDictionaryTypeRespDTO> convertList(List<DataDictionaryTypeDO> list);

  /**
   * 对象转换
   *
   * @param dataDictionaryTypeDO
   * @return
   */
      DataDictionaryTypeRespDTO convert(DataDictionaryTypeDO dataDictionaryTypeDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<DataDictionaryTypeRespDTO> convertPage(IPage<DataDictionaryTypeDO> page);


}
