package com.github.xf717.systemservice.service.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.convert.auth.BaseMenuConvert;
import com.github.xf717.systemservice.dal.mysql.dataobject.auth.BaseMenuDO;
import com.github.xf717.systemservice.dal.mysql.mapper.auth.BaseMenuMapper;
import com.github.xf717.systemservice.enums.SystemErrorCodeConstants;
import com.github.xf717.systemservice.rpc.auth.dto.BaseMenuCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseMenuListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseMenuPageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseMenuRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseMenuUpdateReqDTO;
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
public class BaseMenuService {

  @Autowired
  private BaseMenuMapper baseMenuMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveBaseMenu(BaseMenuCreateReqDTO createReqDTO) {
    return baseMenuMapper.insert(BaseMenuConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateBaseMenu(BaseMenuUpdateReqDTO updateReqDTO) {
    BaseMenuDO baseMenuDO = baseMenuMapper.selectById(updateReqDTO.getId());
    if (baseMenuDO == null) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    baseMenuDO = BaseMenuConvert.INSTANCE.convert(updateReqDTO);
    int result = baseMenuMapper.updateById(baseMenuDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteBaseMenu(Long id) {
    if (baseMenuMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    int result = baseMenuMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<BaseMenuRespDTO> listBaseMenus(BaseMenuListQueryReqDTO listQueryReqDTO) {
    List<BaseMenuDO> list = baseMenuMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return BaseMenuConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public BaseMenuRespDTO getBaseMenuById(Long id) {
    BaseMenuDO BaseMenuDO = baseMenuMapper.selectById(id);
    if (BaseMenuDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    return BaseMenuConvert.INSTANCE.convert(BaseMenuDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<BaseMenuRespDTO> pageBaseMenu(BaseMenuPageReqDTO page) {
    IPage<BaseMenuDO> baseMenuPage = baseMenuMapper.selectPage(page);
    return BaseMenuConvert.INSTANCE.convertPage(baseMenuPage);
  }

  public List<BaseMenuRespDTO> listAllMenus() {
    List<BaseMenuDO> list = baseMenuMapper.selectAllList();
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return BaseMenuConvert.INSTANCE.convertList(list);
  }


  /**
   * 获取用户可以访问的菜单
   *
   * @param id
   * @return
   */
  public List<BaseMenuRespDTO> getUserAuthorityMenuByUserId(Long id) {
    List<BaseMenuDO> baseMenuDOS = baseMenuMapper.selectAuthorityMenuByUserId(id);
    if (CollectionUtils.isEmpty(baseMenuDOS)) {
      return Collections.emptyList();
    }
    return BaseMenuConvert.INSTANCE.convertList(baseMenuDOS);
  }

  /**
   * 根据用户获取可以访问的系统
   *
   * @param id
   * @return
   */
  public List<BaseMenuRespDTO> getUserAuthoritySystemByUserId(Long id) {
    List<BaseMenuDO> baseMenuDOS = baseMenuMapper.selectAuthoritySystemByUserId(id);
    if (CollectionUtils.isEmpty(baseMenuDOS)) {
      return Collections.emptyList();
    }
    return BaseMenuConvert.INSTANCE.convertList(baseMenuDOS);
  }

  public List<BaseMenuRespDTO> listMenus(String path, Long id) {
    List<BaseMenuDO> list = baseMenuMapper.selectListMenu(path, id);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return BaseMenuConvert.INSTANCE.convertList(list);
  }


}
