package com.db.chaomaxs.systemservice.manager.auth;

import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseMenuCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseMenuListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseMenuPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseMenuRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseMenuUpdateReqDTO;
import com.db.chaomaxs.systemservice.service.auth.BaseMenuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * BaseMenuManager
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Service
@Validated
public class BaseMenuManager {

  @Autowired
  private BaseMenuService baseMenuService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveBaseMenu(BaseMenuCreateReqDTO createReqDTO) {
    return baseMenuService.saveBaseMenu(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateBaseMenu(BaseMenuUpdateReqDTO updateReqDTO) {
    return baseMenuService.updateBaseMenu(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteBaseMenu(Long id) {
    return baseMenuService.deleteBaseMenu(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<BaseMenuRespDTO> listBaseMenus(BaseMenuListQueryReqDTO listQueryReqDTO) {
    return baseMenuService.listBaseMenus(listQueryReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public BaseMenuRespDTO getBaseMenuById(Long id) {
    return baseMenuService.getBaseMenuById(id);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<BaseMenuRespDTO> pageBaseMenu(BaseMenuPageReqDTO page) {
    return baseMenuService.pageBaseMenu(page);
  }

  /**
   * 获取用户可以访问的菜单
   *
   * @param id
   * @return
   */
  public List<BaseMenuRespDTO> getUserAuthorityMenuByUserId(Long id) {
    return baseMenuService.getUserAuthorityMenuByUserId(id);
  }

  /**
   * 根据用户获取可以访问的系统
   *
   * @param id
   * @return
   */
  public List<BaseMenuRespDTO> getUserAuthoritySystemByUserId(Long id) {
    return baseMenuService.getUserAuthoritySystemByUserId(id);
  }


  /**
   * 获取菜单
   *
   * @return
   */
  public List<BaseMenuRespDTO> listAllMenus() {
    return baseMenuService.listAllMenus();
  }

  /**
   * 查找like path 属性 和 id 不等于传入的值
   *
   * @param path
   * @param id
   * @return
   */
  public List<BaseMenuRespDTO> listMenus(String path, Long id) {
    return baseMenuService.listMenus(path, id);
  }
}
