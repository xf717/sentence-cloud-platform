package com.github.xf717.systemservice.service.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.convert.auth.BaseResourceAuthorityConvert;
import com.github.xf717.systemservice.dal.mysql.dataobject.auth.BaseResourceAuthorityDO;
import com.github.xf717.systemservice.dal.mysql.mapper.auth.BaseResourceAuthorityMapper;
import com.github.xf717.systemservice.enums.SystemErrorCodeConstants;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityPageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityUpdateReqDTO;
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
public class BaseResourceAuthorityService {

  @Autowired
  private BaseResourceAuthorityMapper baseResourceAuthorityMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveBaseResourceAuthority(BaseResourceAuthorityCreateReqDTO createReqDTO) {
    return baseResourceAuthorityMapper
        .insert(BaseResourceAuthorityConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateBaseResourceAuthority(BaseResourceAuthorityUpdateReqDTO updateReqDTO) {
    BaseResourceAuthorityDO baseResourceAuthorityDO = baseResourceAuthorityMapper
        .selectById(updateReqDTO.getId());
    if (baseResourceAuthorityDO == null) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    baseResourceAuthorityDO = BaseResourceAuthorityConvert.INSTANCE.convert(updateReqDTO);
    int result = baseResourceAuthorityMapper.updateById(baseResourceAuthorityDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteBaseResourceAuthority(Long id) {
    if (baseResourceAuthorityMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    int result = baseResourceAuthorityMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<BaseResourceAuthorityRespDTO> listBaseResourceAuthoritys(
      BaseResourceAuthorityListQueryReqDTO listQueryReqDTO) {
    List<BaseResourceAuthorityDO> list = baseResourceAuthorityMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return BaseResourceAuthorityConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public BaseResourceAuthorityRespDTO getBaseResourceAuthorityById(Long id) {
    BaseResourceAuthorityDO BaseResourceAuthorityDO = baseResourceAuthorityMapper.selectById(id);
    if (BaseResourceAuthorityDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    return BaseResourceAuthorityConvert.INSTANCE.convert(BaseResourceAuthorityDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<BaseResourceAuthorityRespDTO> pageBaseResourceAuthority(
      BaseResourceAuthorityPageReqDTO page) {
    IPage<BaseResourceAuthorityDO> baseResourceAuthorityPage = baseResourceAuthorityMapper
        .selectPage(page);
    return BaseResourceAuthorityConvert.INSTANCE.convertPage(baseResourceAuthorityPage);
  }


}
