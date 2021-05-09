package com.db.chaomaxs.positionservice.service.positiontype;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.ServiceException;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.constant.CommonConstants;
import com.db.chaomaxs.positionservice.convert.positiontype.PositionTypeConvert;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.positiontype.PositionTypeDO;
import com.db.chaomaxs.positionservice.dal.mysql.mapper.positiontype.PositionTypeMapper;
import com.db.chaomaxs.positionservice.enums.PositionErrorCodeConstants;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypePageReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeRespDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeUpdateReqDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * PositionTypeService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class PositionTypeService {

  @Autowired
  private PositionTypeMapper positionTypeMapper;

  /**
  * 保存数据
* @param createReqDTO
* @return
*/
  @Transactional(rollbackFor = ServiceException.class)
  public int savePositionType(PositionTypeCreateReqDTO createReqDTO) {
    if (null == createReqDTO.getParentId()) {
      createReqDTO.setParentId(CommonConstants.TREE_TOP_PARENT_ID);
    }
    PositionTypeListQueryReqDTO queryReqDTO = new PositionTypeListQueryReqDTO();
    queryReqDTO.setTypeName(createReqDTO.getTypeName());
    queryReqDTO.setParentId(createReqDTO.getParentId());
    PositionTypeDO positionTypeDO = positionTypeMapper.listpositionByNameAndParentId(queryReqDTO);
    if (null != positionTypeDO) {
      throw ServiceExceptionUtil
          .exception(PositionErrorCodeConstants.POSITION_TYPE_EXISTS.getCode());
    }
    positionTypeDO = PositionTypeConvert.INSTANCE.convert(createReqDTO);
    if(StringUtils.isBlank(positionTypeDO.getCode())){
      positionTypeDO.setCode(StrUtil.EMPTY);
    }
    int result = positionTypeMapper.insert(positionTypeDO);
    if (CommonConstants.TREE_TOP_PARENT_ID.equals(createReqDTO.getParentId())) {
      PositionTypeUpdateReqDTO updateReqDTO = new PositionTypeUpdateReqDTO();
      updateReqDTO.setLevel(CommonConstants.TREE_TOP_LEVEL);
      updateReqDTO.setId(positionTypeDO.getId());
      updateReqDTO.setCode(positionTypeDO.getId() + "");
      positionTypeMapper.updateById(PositionTypeConvert.INSTANCE.convert(updateReqDTO));
    } else {
      PositionTypeDO respDTO = positionTypeMapper.selectById(createReqDTO.getParentId());
      if (null == respDTO) {
        throw ServiceExceptionUtil
            .exception(PositionErrorCodeConstants.POSITION_TYPE_NOT_EXISTS.getCode());
      }
      //获取上级code,组成code－id的类型
      String code = respDTO.getCode().trim();
      code = code + StrUtil.DASHED + positionTypeDO.getId();
      PositionTypeUpdateReqDTO updateReqDTO = new PositionTypeUpdateReqDTO();
      updateReqDTO.setId(positionTypeDO.getId());
      updateReqDTO.setCode(code);
      updateReqDTO.setLevel(respDTO.getLevel() + 1);
      positionTypeMapper.updateById(PositionTypeConvert.INSTANCE.convert(updateReqDTO));
    }
    return result;
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  @Transactional(rollbackFor = ServiceException.class)
  public int updatePositionType(PositionTypeUpdateReqDTO updateReqDTO) {
    if (null == updateReqDTO.getParentId()) {
      updateReqDTO.setParentId(CommonConstants.TREE_TOP_PARENT_ID);
    }
    PositionTypeDO positionTypeDO = positionTypeMapper.selectById(updateReqDTO.getId());
    if (positionTypeDO == null) {
      throw ServiceExceptionUtil
          .exception(PositionErrorCodeConstants.POSITION_TYPE_NOT_EXISTS.getCode());
    }
    updateReqDTO.setCode(positionTypeDO.getCode());
    updateReqDTO.setLevel(positionTypeDO.getLevel());
    if(!positionTypeDO.getTypeName().equals(updateReqDTO.getTypeName()) || !positionTypeDO.getParentId().equals(updateReqDTO.getParentId())){
      PositionTypeListQueryReqDTO queryReqDTO = new PositionTypeListQueryReqDTO();
      queryReqDTO.setTypeName(updateReqDTO.getTypeName());
      queryReqDTO.setParentId(updateReqDTO.getParentId());
      PositionTypeDO positionTypeRespDO = positionTypeMapper
          .listpositionByNameAndParentId(queryReqDTO);
      if (null != positionTypeRespDO) {
        throw ServiceExceptionUtil
            .exception(PositionErrorCodeConstants.POSITION_TYPE_EXISTS.getCode());
      }
    }
    List<PositionTypeDO> positionTypeDOS = new ArrayList<>();
    if (!positionTypeDO.getParentId().equals(updateReqDTO.getParentId())) {
      int tempLevel = changeAttributeValue(updateReqDTO,positionTypeDO);
      positionTypeDOS.addAll(positionTypeConvertCode(positionTypeDO.getCode(), updateReqDTO.getCode(), tempLevel));
    }
    if(!positionTypeDO.getDisplayStatus().equals(updateReqDTO.getDisplayStatus())){
      positionTypeDOS = positionTypeConvertDisplayStatus(positionTypeDOS,positionTypeDO.getCode(),updateReqDTO.getDisplayStatus());
    }
    positionTypeDOS.add(PositionTypeConvert.INSTANCE.convert(updateReqDTO));
    int result = positionTypeMapper.batchUpdate(positionTypeDOS);
    return result;
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deletePositionType(Long id) {
    PositionTypeDO positionTypeDO = positionTypeMapper.selectById(id);
    if (null == positionTypeDO) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(PositionErrorCodeConstants.NOT_EXISTS.getCode());
    }
    List<Long> ids = new ArrayList<>();
    List<PositionTypeDO> positionTypeDOS = positionTypeMapper
        .listpositionByCode(positionTypeDO.getCode());
    Set<Long> tempIds = positionTypeDOS.stream().map(PositionTypeDO::getId).collect(Collectors.toSet());
    tempIds.add(id);
    ids.addAll(tempIds);

    int result = positionTypeMapper.deleteBatchIds(ids);
    return result;
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<PositionTypeRespDTO> listPositionTypes(PositionTypeListQueryReqDTO listQueryReqDTO) {
    List<PositionTypeDO> list = positionTypeMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return PositionTypeConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public PositionTypeRespDTO getPositionTypeById(Long id) {
          PositionTypeDO positionTypeDO = positionTypeMapper.getById(id);
    if (positionTypeDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(PositionErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return PositionTypeConvert.INSTANCE.convert(positionTypeDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<PositionTypeRespDTO> pagePositionType(PositionTypePageReqDTO page) {
    IPage<PositionTypeDO> positionTypePage = positionTypeMapper.selectPage(page);
    return PositionTypeConvert.INSTANCE.convertPage(positionTypePage);
  }

  /**
   * 根据参数查询所有可显示分类
   * @param listQueryReqDTO  查询参数
   * @return
   */
  public List<PositionTypeRespDTO> listDisplayPositionType(PositionTypeListQueryReqDTO listQueryReqDTO) {
    List<PositionTypeDO> list = positionTypeMapper.listDisplayPositionType(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return PositionTypeConvert.INSTANCE.convertList(list);

  }
  /**
   * 根据parentId查询数据,不分页
   * @param parentId  查询参数
   * @return
   */
  public List<PositionTypeRespDTO> listPositionTypeByParentId(Long parentId) {
    List<PositionTypeDO> list = positionTypeMapper.listPositionTypeByParentId(parentId);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return PositionTypeConvert.INSTANCE.convertList(list);
  }


  /**
   * 转换类型code和菜单等级
   *
   * @param oldCode
   * @param newCode
   * @param level
   * @return
   */
  public List<PositionTypeDO> positionTypeConvertCode(String oldCode, String newCode, Integer level) {
    List<PositionTypeDO> positionTypeDOS = positionTypeMapper.listpositionByCode(oldCode);
    if (CollectionUtils.isEmpty(positionTypeDOS)) {
      return Collections.emptyList();
    }
    for (PositionTypeDO positionTypeDO : positionTypeDOS) {
      String code = positionTypeDO.getCode();
      positionTypeDO.setCode(code.replace(oldCode, newCode));
      if (level < 0) {
        positionTypeDO.setLevel(positionTypeDO.getLevel() - Math.abs(level));
      } else {
        positionTypeDO.setLevel(positionTypeDO.getLevel() + level);
      }
    }
    return positionTypeDOS;
  }

  /**
   * 转换显示状态
   *
   * @param oldCode
   * @param status
   * @param positionTypeDOS
   * @return
   */
  public List<PositionTypeDO> positionTypeConvertDisplayStatus(List<PositionTypeDO> positionTypeDOS,String oldCode,Integer status) {
    if (CollectionUtils.isEmpty(positionTypeDOS)) {
      positionTypeDOS = positionTypeMapper.listpositionByCode(oldCode);
    }
    for (PositionTypeDO positionTypeDO : positionTypeDOS) {
     positionTypeDO.setDisplayStatus(status);
    }
    return positionTypeDOS;
  }

  /**
   * 修改变量
   * @param updateReqDTO
   * @param positionTypeDO
   * @return
   */
  public int changeAttributeValue(PositionTypeUpdateReqDTO updateReqDTO,PositionTypeDO positionTypeDO){
    int tempLevel = 0;
    if (CommonConstants.TREE_TOP_PARENT_ID.equals(updateReqDTO.getParentId())) {
      updateReqDTO.setParentId(CommonConstants.TREE_TOP_PARENT_ID);
      updateReqDTO.setCode(positionTypeDO.getId() + "");
      updateReqDTO.setLevel(CommonConstants.TREE_TOP_LEVEL);
      //获取修改后分类等级差值，给批量更新提供参考值
      tempLevel = CommonConstants.TREE_TOP_LEVEL - positionTypeDO.getLevel();
    } else {
      PositionTypeDO respDTO = positionTypeMapper.selectById(updateReqDTO.getParentId());
      if (null == respDTO) {
        throw ServiceExceptionUtil
            .exception(PositionErrorCodeConstants.POSITION_TYPE_NOT_EXISTS.getCode());
      }
      //获取上级code 组成code－id的类型
      String code = respDTO.getCode();
      code = code + StrUtil.DASHED + positionTypeDO.getId();
      updateReqDTO.setCode(code);
      updateReqDTO.setLevel(respDTO.getLevel() + 1);
      //获取修改后分类等级差值，给批量更新提供参考值
      tempLevel = updateReqDTO.getLevel() - positionTypeDO.getLevel();
    }
    return tempLevel;
  }
}
