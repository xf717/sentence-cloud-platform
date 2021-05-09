package com.db.chaomaxs.systemservice.service.content;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.constant.CommonConstants;
import com.db.chaomaxs.systemservice.convert.content.IndustryTypeConvert;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.content.IndustryTypeDO;
import com.db.chaomaxs.systemservice.dal.mysql.mapper.content.IndustryTypeMapper;
import com.db.chaomaxs.systemservice.enums.SystemErrorCodeConstants;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypePageReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeUpdateReqDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * IndustryTypeService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class IndustryTypeService {

  @Autowired
  private IndustryTypeMapper industryTypeMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  @Transactional(rollbackFor = Exception.class)
  public int saveIndustryType(IndustryTypeCreateReqDTO createReqDTO) {
    if (null == createReqDTO.getParentId()) {
      createReqDTO.setParentId(CommonConstants.TREE_TOP_PARENT_ID);
    }
    IndustryTypeListQueryReqDTO queryReqDTO = new IndustryTypeListQueryReqDTO();
    queryReqDTO.setTypeName(createReqDTO.getTypeName());
    queryReqDTO.setParentId(createReqDTO.getParentId());
    IndustryTypeDO industryTypeDO = industryTypeMapper.listIndustryByNameAndParentId(queryReqDTO);
    if (null != industryTypeDO) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.INDUSTRY_TYPE_EXISTS.getCode());
    }

    industryTypeDO = IndustryTypeConvert.INSTANCE.convert(createReqDTO);
    int result = industryTypeMapper.insert(industryTypeDO);
    if (CommonConstants.TREE_TOP_PARENT_ID.equals(createReqDTO.getParentId())) {
      IndustryTypeUpdateReqDTO updateReqDTO = new IndustryTypeUpdateReqDTO();
      updateReqDTO.setLevel(CommonConstants.TREE_TOP_LEVEL);
      updateReqDTO.setId(industryTypeDO.getId());
      updateReqDTO.setCode(industryTypeDO.getId() + "");
      IndustryTypeConvert.INSTANCE.convert(updateReqDTO);
      industryTypeMapper.updateById(IndustryTypeConvert.INSTANCE.convert(updateReqDTO));

    } else {
      IndustryTypeDO respDTO = industryTypeMapper.selectById(createReqDTO.getParentId());
      if (null == respDTO) {
        throw ServiceExceptionUtil
            .exception(SystemErrorCodeConstants.INDUSTRY_TYPE_NOT_EXISTS.getCode());
      }
      //获取上级code,组成code－id的类型
      String code = respDTO.getCode().trim();
      code = code + StrUtil.DASHED + industryTypeDO.getId();
      IndustryTypeUpdateReqDTO updateReqDTO = new IndustryTypeUpdateReqDTO();
      updateReqDTO.setId(industryTypeDO.getId());
      updateReqDTO.setCode(code);
      updateReqDTO.setLevel(respDTO.getLevel() + 1);
      industryTypeMapper.updateById(IndustryTypeConvert.INSTANCE.convert(updateReqDTO));
    }
    return result;
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  @Transactional(rollbackFor = Exception.class)
  public int updateIndustryType(IndustryTypeUpdateReqDTO updateReqDTO) {

    if (null == updateReqDTO.getParentId()) {
      updateReqDTO.setParentId(CommonConstants.TREE_TOP_PARENT_ID);
    }
    IndustryTypeDO industryTypeDO = industryTypeMapper.selectById(updateReqDTO.getId());
    if (industryTypeDO == null) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    updateReqDTO.setCode(industryTypeDO.getCode());
    updateReqDTO.setLevel(industryTypeDO.getLevel());
    if (!industryTypeDO.getTypeName().equals(updateReqDTO.getTypeName()) || !industryTypeDO
        .getParentId().equals(updateReqDTO.getParentId())) {
      IndustryTypeListQueryReqDTO queryReqDTO = new IndustryTypeListQueryReqDTO();
      queryReqDTO.setTypeName(updateReqDTO.getTypeName());
      queryReqDTO.setParentId(updateReqDTO.getParentId());
      IndustryTypeDO industryTypeRespDO = industryTypeMapper
          .listIndustryByNameAndParentId(queryReqDTO);
      if (null != industryTypeRespDO) {
        throw ServiceExceptionUtil
            .exception(SystemErrorCodeConstants.INDUSTRY_TYPE_EXISTS.getCode());
      }
    }
    List<IndustryTypeDO> industryTypeDOS = new ArrayList<>();
    if (!industryTypeDO.getParentId().equals(updateReqDTO.getParentId())) {
      int tempLevel = changeAttributeValue(updateReqDTO, industryTypeDO);
      industryTypeDOS.addAll(
          industryTypeConvertCode(industryTypeDO.getCode(), updateReqDTO.getCode(), tempLevel));
    }
    if (!industryTypeDO.getDisplayStatus().equals(updateReqDTO.getDisplayStatus())) {
      industryTypeDOS = industryTypeConvertDisplayStatus(industryTypeDOS, industryTypeDO.getCode(),
          updateReqDTO.getDisplayStatus());
    }
    industryTypeDOS.add(IndustryTypeConvert.INSTANCE.convert(updateReqDTO));
    int result = industryTypeMapper.batchUpdate(industryTypeDOS);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteIndustryType(Long id) {
    IndustryTypeDO industryTypeDO = industryTypeMapper.selectById(id);
    if (null == industryTypeDO) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    List<Long> ids = new ArrayList<>();
    List<IndustryTypeDO> industryTypeDOS = industryTypeMapper
        .listIndustryByCode(industryTypeDO.getCode());
    Set<Long> tempIds = industryTypeDOS.stream().map(IndustryTypeDO::getId)
        .collect(Collectors.toSet());
    tempIds.add(id);
    ids.addAll(tempIds);
    int result = industryTypeMapper.deleteBatchIds(ids);
    return result;

  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<IndustryTypeRespDTO> listIndustryTypes(IndustryTypeListQueryReqDTO listQueryReqDTO) {
    List<IndustryTypeDO> list = industryTypeMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return IndustryTypeConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public IndustryTypeRespDTO getIndustryTypeById(Long id) {
    IndustryTypeDO industryTypeDO = industryTypeMapper.getById(id);
    if (industryTypeDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return IndustryTypeConvert.INSTANCE.convert(industryTypeDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<IndustryTypeRespDTO> pageIndustryType(IndustryTypePageReqDTO page) {
    IPage<IndustryTypeDO> industryTypePage = industryTypeMapper.selectPage(page);
    return IndustryTypeConvert.INSTANCE.convertPage(industryTypePage);
  }


  /**
   * 根据参数查询所有可显示分类
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<IndustryTypeRespDTO> listDisplayIndustry(
      IndustryTypeListQueryReqDTO listQueryReqDTO) {
    List<IndustryTypeDO> list = industryTypeMapper.listDisplayIndustry(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return IndustryTypeConvert.INSTANCE.convertList(list);
  }


  /**
   * 根据分类名称和父id查询
   *
   * @param reqDTO
   * @return
   */
  public IndustryTypeRespDTO getIndustryByNameAndParentId(IndustryTypeListQueryReqDTO reqDTO) {
    IndustryTypeDO industryTypeDO = industryTypeMapper.listIndustryByNameAndParentId(reqDTO);
    if (industryTypeDO == null) {
      return null;
    }
    return IndustryTypeConvert.INSTANCE.convert(industryTypeDO);
  }

  /**
   * 根据parentId查询数据,不分页
   *
   * @param parentId
   * @return
   */
  public List<IndustryTypeRespDTO> listIndustryByParentId(Long parentId) {
    IndustryTypeListQueryReqDTO reqDTO = new IndustryTypeListQueryReqDTO();
    reqDTO.setParentId(parentId);
    List<IndustryTypeDO> list = industryTypeMapper.listDisplayIndustry(reqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return IndustryTypeConvert.INSTANCE.convertList(list);
  }

  /**
   * 转换类型code和菜单等级
   *
   * @param oldCode
   * @param newCode
   * @param level
   * @return
   */
  public List<IndustryTypeDO> industryTypeConvertCode(String oldCode, String newCode,
      Integer level) {
    List<IndustryTypeDO> industryTypeDOS = industryTypeMapper.listIndustryByCode(oldCode);
    if (CollectionUtils.isEmpty(industryTypeDOS)) {
      return Collections.emptyList();
    }
    for (IndustryTypeDO industryTypeDO : industryTypeDOS) {
      String code = industryTypeDO.getCode();
      industryTypeDO.setCode(code.replace(oldCode, newCode));
      if (level < 0) {
        industryTypeDO.setLevel(industryTypeDO.getLevel() - Math.abs(level));
      } else {
        industryTypeDO.setLevel(industryTypeDO.getLevel() + level);
      }
    }
    return industryTypeDOS;
  }

  /**
   * 转换显示状态
   *
   * @param oldCode
   * @param status
   * @param industryTypeDOS
   * @return
   */
  public List<IndustryTypeDO> industryTypeConvertDisplayStatus(List<IndustryTypeDO> industryTypeDOS,
      String oldCode, Integer status) {
    if (CollectionUtils.isEmpty(industryTypeDOS)) {
      industryTypeDOS = industryTypeMapper.listIndustryByCode(oldCode);
    }
    for (IndustryTypeDO industryTypeDO : industryTypeDOS) {
      industryTypeDO.setDisplayStatus(status);
    }
    return industryTypeDOS;
  }

  /**
   * 修改变量
   *
   * @param updateReqDTO
   * @param industryTypeDO
   * @return
   */
  public int changeAttributeValue(IndustryTypeUpdateReqDTO updateReqDTO,
      IndustryTypeDO industryTypeDO) {
    int tempLevel = 0;
    if (CommonConstants.TREE_TOP_PARENT_ID.equals(updateReqDTO.getParentId())) {
      updateReqDTO.setParentId(CommonConstants.TREE_TOP_PARENT_ID);
      updateReqDTO.setCode(industryTypeDO.getId() + "");
      updateReqDTO.setLevel(CommonConstants.TREE_TOP_LEVEL);
      //获取修改后分类等级差值，给批量更新提供参考值
      tempLevel = CommonConstants.TREE_TOP_LEVEL - industryTypeDO.getLevel();
    } else {
      IndustryTypeDO respDTO = industryTypeMapper.selectById(updateReqDTO.getParentId());
      if (null == respDTO) {
        throw ServiceExceptionUtil
            .exception(SystemErrorCodeConstants.INDUSTRY_TYPE_NOT_EXISTS.getCode());
      }
      //获取上级code 组成code－id的类型
      String code = respDTO.getCode();
      code = code + StrUtil.DASHED + industryTypeDO.getId();
      updateReqDTO.setCode(code);
      updateReqDTO.setLevel(respDTO.getLevel() + 1);
      //获取修改后分类等级差值，给批量更新提供参考值
      tempLevel = updateReqDTO.getLevel() - industryTypeDO.getLevel();
    }
    return tempLevel;
  }


}
