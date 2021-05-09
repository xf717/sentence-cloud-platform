package com.github.xf717.systemservice.service.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.convert.auth.BaseElementConvert;
import com.github.xf717.systemservice.dal.mysql.dataobject.auth.BaseElementDO;
import com.github.xf717.systemservice.dal.mysql.mapper.auth.BaseElementMapper;
import com.github.xf717.systemservice.enums.SystemErrorCodeConstants;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementPageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementUpdateReqDTO;
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
public class BaseElementService {

  @Autowired
  private BaseElementMapper baseElementMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveBaseElement(BaseElementCreateReqDTO createReqDTO) {
    return baseElementMapper.insert(BaseElementConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateBaseElement(BaseElementUpdateReqDTO updateReqDTO) {
    BaseElementDO baseElementDO = baseElementMapper.selectById(updateReqDTO.getId());
    if (baseElementDO == null) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    baseElementDO = BaseElementConvert.INSTANCE.convert(updateReqDTO);
    int result = baseElementMapper.updateById(baseElementDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteBaseElement(Long id) {
    if (baseElementMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    int result = baseElementMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<BaseElementRespDTO> listBaseElements(BaseElementListQueryReqDTO listQueryReqDTO) {
    List<BaseElementDO> list = baseElementMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return BaseElementConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public BaseElementRespDTO getBaseElementById(Long id) {
    BaseElementDO BaseElementDO = baseElementMapper.selectById(id);
    if (BaseElementDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    return BaseElementConvert.INSTANCE.convert(BaseElementDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<BaseElementRespDTO> pageBaseElement(BaseElementPageReqDTO page) {
    IPage<BaseElementDO> baseElementPage = baseElementMapper.selectPage(page);
    return BaseElementConvert.INSTANCE.convertPage(baseElementPage);
  }

  /**
   * 获取用户资源权限
   *
   * @param userId
   * @return
   */
  public List<BaseElementRespDTO> getAuthorityElementByUserId(Long userId) {
    List<BaseElementDO> baseElementDOS = baseElementMapper.selectAuthorityElementByUserId(userId);
    if (CollectionUtils.isEmpty(baseElementDOS)) {
      return Collections.emptyList();
    }
    return BaseElementConvert.INSTANCE.convertList(baseElementDOS);
  }

  /**
   * 查询用户菜单资源权限
   *
   * @param userId
   * @param menuId
   * @return
   */
  public List<BaseElementRespDTO> getAuthorityMenuElementByUserId(Long userId, Long menuId) {
    List<BaseElementDO> baseElementDOS = baseElementMapper
        .selectAuthorityMenuElementByUserId(userId, menuId);
    if (CollectionUtils.isEmpty(baseElementDOS)) {
      return Collections.emptyList();
    }
    return BaseElementConvert.INSTANCE.convertList(baseElementDOS);
  }

  /**
   * 获取全部资源权限
   * @return
   */
  public List<BaseElementRespDTO> getAllElementPermissions() {
    List<BaseElementDO> baseElementDOS = baseElementMapper.selectAllElementPermissions();
    if (CollectionUtils.isEmpty(baseElementDOS)) {
      return Collections.emptyList();
    }
    return BaseElementConvert.INSTANCE.convertList(baseElementDOS);
  }


}
