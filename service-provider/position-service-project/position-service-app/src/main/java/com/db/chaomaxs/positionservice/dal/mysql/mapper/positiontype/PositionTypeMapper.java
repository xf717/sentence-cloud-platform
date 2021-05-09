package com.db.chaomaxs.positionservice.dal.mysql.mapper.positiontype;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.positionservice.constant.CommonConstants;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.positiontype.PositionTypeDO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypePageReqDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 职务职位分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Repository
public interface PositionTypeMapper extends BaseMapper<PositionTypeDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<PositionTypeDO> selectList(PositionTypeListQueryReqDTO listReqDTO) {
    LambdaQueryWrapper<PositionTypeDO> queryWrapper = Wrappers.lambdaQuery();
    if(null != listReqDTO.getTypeName()){
      queryWrapper.like(PositionTypeDO::getTypeName,listReqDTO.getTypeName());
    }
    queryWrapper.orderByAsc(PositionTypeDO::getParentId,PositionTypeDO::getSortOrder);
    return selectList(queryWrapper);
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<PositionTypeDO> selectPage(PositionTypePageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<PositionTypeDO>());
  }

  /**
   * 根据参数查询所有可显示分类
   * @param listQueryReqDTO  查询参数
   * @return
   */
  default List<PositionTypeDO> listDisplayPositionType(PositionTypeListQueryReqDTO listQueryReqDTO){
    LambdaQueryWrapper<PositionTypeDO> queryWrapper = Wrappers.lambdaQuery();
    if(null != listQueryReqDTO.getTypeName()){
      queryWrapper.like(PositionTypeDO::getTypeName,listQueryReqDTO.getTypeName());
    }
    queryWrapper.eq(PositionTypeDO::getDisplayStatus, CommonConstants.TREE_DISPLAY_STATUS);
    queryWrapper.orderByAsc(PositionTypeDO::getParentId,PositionTypeDO::getSortOrder);
    return selectList(queryWrapper);

  }
  /**
   * 根据parentId查询数据,不分页
   * @param parentId  查询参数
   * @return
   */
  default List<PositionTypeDO> listPositionTypeByParentId(Long parentId){
    LambdaQueryWrapper<PositionTypeDO> queryWrapper = Wrappers.lambdaQuery();
    queryWrapper.eq(PositionTypeDO::getParentId, parentId);
    queryWrapper.eq(PositionTypeDO::getDisplayStatus, CommonConstants.TREE_DISPLAY_STATUS);
    return selectList(queryWrapper);
  }


  /**
   * 根据分类名称和父id查询
   *
   * @param reqDTO
   * @return
   */
  default PositionTypeDO listpositionByNameAndParentId(PositionTypeListQueryReqDTO reqDTO) {
    LambdaQueryWrapper<PositionTypeDO> queryWrapper = Wrappers.lambdaQuery();
    queryWrapper.eq(PositionTypeDO::getTypeName,reqDTO.getTypeName())
        .eq(PositionTypeDO::getParentId,reqDTO.getParentId());
    return selectOne(queryWrapper);
  }


  /**
   * 根据分类code查询所有子类，包含本类
   *
   * @param code
   * @return
   */
  default List<PositionTypeDO> listpositionByCode(String code) {
    LambdaQueryWrapper<PositionTypeDO> queryWrapper = Wrappers.lambdaQuery();
    queryWrapper.likeRight(PositionTypeDO::getCode,code);
    return selectList(queryWrapper);
  }


  /**
   * 批量修改type_name,code,`level`,parent_id,display_status属性
   * @param list
   * @return
   */
  int batchUpdate(@Param("list") List<PositionTypeDO> list);

  /**
   * 根据id不区分是否删除
   * @param id
   * @return
   */
  PositionTypeDO getById(@Param("id") Long id);
}
