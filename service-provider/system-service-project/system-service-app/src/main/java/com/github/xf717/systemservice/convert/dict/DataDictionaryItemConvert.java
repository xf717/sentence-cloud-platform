package com.github.xf717.systemservice.convert.dict;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.dal.mysql.dataobject.dict.DataDictionaryItemDO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemCreateReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemRespDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * DataDictionaryItemConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Mapper
public interface DataDictionaryItemConvert {

        DataDictionaryItemConvert INSTANCE = Mappers.getMapper(DataDictionaryItemConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      DataDictionaryItemDO convert(DataDictionaryItemCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      DataDictionaryItemDO convert(DataDictionaryItemUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<DataDictionaryItemRespDTO> convertList(List<DataDictionaryItemDO> list);

  /**
   * 对象转换
   *
   * @param dataDictionaryItemDO
   * @return
   */
      DataDictionaryItemRespDTO convert(DataDictionaryItemDO dataDictionaryItemDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<DataDictionaryItemRespDTO> convertPage(IPage<DataDictionaryItemDO> page);


}
