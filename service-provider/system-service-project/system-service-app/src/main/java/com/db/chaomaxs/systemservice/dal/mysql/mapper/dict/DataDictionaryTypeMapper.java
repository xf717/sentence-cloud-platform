package com.db.chaomaxs.systemservice.dal.mysql.mapper.dict;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.dict.DataDictionaryTypeDO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryTypePageReqDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

/**
 * 字典分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Repository
public interface DataDictionaryTypeMapper extends BaseMapper<DataDictionaryTypeDO> {

  /**
   * 自定义分页查询
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<DataDictionaryTypeDO> findByPage(DataDictionaryTypePageReqDTO pageReqDTO) {
    LambdaQueryWrapper<DataDictionaryTypeDO> queryWrapper = Wrappers.lambdaQuery();
    //关键字查询dict_name or dict_code 字段
    if (StringUtils.isNotBlank(pageReqDTO.getKey())) {
      queryWrapper.and(
          wrapper -> wrapper.like(DataDictionaryTypeDO::getDictName, pageReqDTO.getKey())
              .or().like(DataDictionaryTypeDO::getDictCode, pageReqDTO.getKey())
      );
    }
     return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()), queryWrapper);
  }

}
