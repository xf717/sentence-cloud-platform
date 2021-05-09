package com.db.chaomaxs.systemservice.dal.mysql.mapper.dict;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.dict.DataDictionaryItemDO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemQueryRespDTO;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 数据字典项信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Repository
public interface DataDictionaryItemMapper extends BaseMapper<DataDictionaryItemDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<DataDictionaryItemDO> selectList(DataDictionaryItemListQueryReqDTO listReqDTO) {
    LambdaQueryWrapper<DataDictionaryItemDO> queryWrapper = Wrappers.lambdaQuery();
    if(null != listReqDTO.getDictionaryTypeId()){
      queryWrapper.eq(DataDictionaryItemDO::getDictionaryTypeId,listReqDTO.getDictionaryTypeId());
    }
    if(null != listReqDTO.getKey()){
      queryWrapper.and(
          wrapper -> wrapper.like(DataDictionaryItemDO::getDictText, listReqDTO.getKey())
              .or().like(DataDictionaryItemDO::getDictValue, listReqDTO.getKey())
      );
    }
    if(null != listReqDTO.getEnabled()){
      queryWrapper.eq(DataDictionaryItemDO::getEnabled, listReqDTO.getEnabled());
    }
    return selectList(queryWrapper);
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<DataDictionaryItemDO> selectPage(DataDictionaryItemPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<DataDictionaryItemDO>());
  }


  /**
   * 自定义分页查询
   * @param pageReqDTO
   * @return
   */
  default IPage<DataDictionaryItemDO> findByPage(DataDictionaryItemPageReqDTO pageReqDTO) {
    LambdaQueryWrapper<DataDictionaryItemDO> queryWrapperX = Wrappers.lambdaQuery();
    queryWrapperX.eq(DataDictionaryItemDO::getDictionaryTypeId, pageReqDTO.getDictionaryTypeId());

    //关键字查询dict_tex or dict_value 字段
    if (StringUtils.isNotBlank(pageReqDTO.getKey())) {
      queryWrapperX.and(
          wrapper -> wrapper.like(DataDictionaryItemDO::getDictText, pageReqDTO.getKey())
              .or().like(DataDictionaryItemDO::getDictValue, pageReqDTO.getKey())

      );
    }
    if (null != pageReqDTO.getEnabled()) {
      queryWrapperX.and(
          wrapper -> wrapper.eq(DataDictionaryItemDO::getEnabled, pageReqDTO.getEnabled())
      );
    }
    queryWrapperX.orderByDesc(DataDictionaryItemDO::getSort,DataDictionaryItemDO::getId);

    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        queryWrapperX);
  }


  List<DataDictionaryItemQueryRespDTO> getDictItemBydictTypeName(@Param("ids") String ids);
}
