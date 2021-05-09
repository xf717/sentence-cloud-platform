package com.db.chaomaxs.systemservice.dal.mysql.mapper.content;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.systemservice.constant.CommonConstants;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.content.IndustryTypeDO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypePageReqDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 行业分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Repository
public interface IndustryTypeMapper extends BaseMapper<IndustryTypeDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<IndustryTypeDO> selectList(IndustryTypeListQueryReqDTO listReqDTO) {
    LambdaQueryWrapper<IndustryTypeDO> queryWrapper = Wrappers.lambdaQuery();
    if(null != listReqDTO.getTypeName()){
      queryWrapper.like(IndustryTypeDO::getTypeName,listReqDTO.getTypeName());
    }
    if(null != listReqDTO.getParentId()){
      queryWrapper.eq(IndustryTypeDO::getParentId,listReqDTO.getParentId());
    }
    queryWrapper.orderByAsc(IndustryTypeDO::getParentId,IndustryTypeDO::getSort);
    return selectList(queryWrapper);
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<IndustryTypeDO> selectPage(IndustryTypePageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<IndustryTypeDO>());
  }

  /**
   * 根据参数查询所有可显示分类
   *
   * @param listReqDTO
   * @return
   */
  default List<IndustryTypeDO> listDisplayIndustry(IndustryTypeListQueryReqDTO listReqDTO) {
    LambdaQueryWrapper<IndustryTypeDO> queryWrapper = Wrappers.lambdaQuery();
    if(null != listReqDTO.getTypeName()){
      queryWrapper.like(IndustryTypeDO::getTypeName,listReqDTO.getTypeName());
    }
    if(null != listReqDTO.getParentId()){
      queryWrapper.eq(IndustryTypeDO::getParentId,listReqDTO.getParentId());
    }
    queryWrapper.and(
        quryWrapper -> quryWrapper.eq(IndustryTypeDO::getDisplayStatus, CommonConstants.TYPE_DISPLAY_STATUS_TRUE)
    );
    queryWrapper.orderByAsc(IndustryTypeDO::getParentId,IndustryTypeDO::getSort);
    return selectList(queryWrapper);
  }


  /**
   * 根据分类名称和父id查询
   *
   * @param reqDTO
   * @return
   */
  default IndustryTypeDO listIndustryByNameAndParentId(IndustryTypeListQueryReqDTO reqDTO) {
    LambdaQueryWrapper<IndustryTypeDO> queryWrapper = Wrappers.lambdaQuery();
    queryWrapper.eq(IndustryTypeDO::getTypeName,reqDTO.getTypeName())
    .eq(IndustryTypeDO::getParentId,reqDTO.getParentId());
    return selectOne(queryWrapper);
  }


  /**
   * 查询是否有下级节点
   *
   * @param parentId
   * @return
   */
  default List<IndustryTypeDO> ListIdByParentId(Long parentId) {
    LambdaQueryWrapper<IndustryTypeDO> queryWrapper = Wrappers.lambdaQuery();
      queryWrapper.eq(IndustryTypeDO::getParentId,parentId);
    queryWrapper.select(IndustryTypeDO::getId);
    return selectList(queryWrapper);
  }

  /**
   * 根据分类code查询所有子类，包含本类
   *
   * @param code
   * @return
   */
  default List<IndustryTypeDO> listIndustryByCode(String code) {
    LambdaQueryWrapper<IndustryTypeDO> queryWrapper = Wrappers.lambdaQuery();
    queryWrapper.likeRight(IndustryTypeDO::getCode,code);
    return selectList(queryWrapper);
  }

  /**
   * 批量修改type_name,code,`level`,parent_id,display_status属性
   * @param list
   * @return
   */
  int batchUpdate(@Param("list") List<IndustryTypeDO> list);


  /**
   * 根据id不区分是否删除
   * @param id
   * @return
   */
  IndustryTypeDO getById(@Param("id") Long id);

}
