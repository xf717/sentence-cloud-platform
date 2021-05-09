package com.github.xf717.systemservice.service.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.convert.auth.BaseGroupTypeConvert;
import com.github.xf717.systemservice.dal.mysql.dataobject.auth.BaseGroupTypeDO;
import com.github.xf717.systemservice.dal.mysql.mapper.auth.BaseGroupTypeMapper;
import com.github.xf717.systemservice.enums.SystemErrorCodeConstants;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupTypeCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupTypeListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupTypePageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupTypeRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupTypeUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * ResourceService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class BaseGroupTypeService {

  @Autowired
  private BaseGroupTypeMapper baseGroupTypeMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveBaseGroupType(BaseGroupTypeCreateReqDTO createReqDTO) {
    return baseGroupTypeMapper.insert(BaseGroupTypeConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateBaseGroupType(BaseGroupTypeUpdateReqDTO updateReqDTO) {
    BaseGroupTypeDO baseGroupTypeDO = baseGroupTypeMapper.selectById(updateReqDTO.getId());
    if (baseGroupTypeDO == null) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    baseGroupTypeDO = BaseGroupTypeConvert.INSTANCE.convert(updateReqDTO);
    int result = baseGroupTypeMapper.updateById(baseGroupTypeDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteBaseGroupType(Long id) {
    if (baseGroupTypeMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    int result = baseGroupTypeMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<BaseGroupTypeRespDTO> listBaseGroupTypes(
      BaseGroupTypeListQueryReqDTO listQueryReqDTO) {
    List<BaseGroupTypeDO> list = baseGroupTypeMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return BaseGroupTypeConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public BaseGroupTypeRespDTO getBaseGroupTypeById(Long id) {
    BaseGroupTypeDO BaseGroupTypeDO = baseGroupTypeMapper.selectById(id);
    if (BaseGroupTypeDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    return BaseGroupTypeConvert.INSTANCE.convert(BaseGroupTypeDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<BaseGroupTypeRespDTO> pageBaseGroupType(BaseGroupTypePageReqDTO page) {
    IPage<BaseGroupTypeDO> baseGroupTypePage = baseGroupTypeMapper.selectPage(page);
    return BaseGroupTypeConvert.INSTANCE.convertPage(baseGroupTypePage);
  }


}
