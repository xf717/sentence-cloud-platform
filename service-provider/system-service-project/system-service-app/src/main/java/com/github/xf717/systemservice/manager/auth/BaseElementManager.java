package com.github.xf717.systemservice.manager.auth;


import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementPageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementUpdateReqDTO;
import com.github.xf717.systemservice.service.auth.BaseElementService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * BaseElementManager
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Service
@Validated
public class BaseElementManager {

  @Autowired
  private BaseElementService baseElementService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveBaseElement(BaseElementCreateReqDTO createReqDTO) {
    return baseElementService.saveBaseElement(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateBaseElement(BaseElementUpdateReqDTO updateReqDTO) {
    return baseElementService.updateBaseElement(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteBaseElement(Long id) {
    return baseElementService.deleteBaseElement(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<BaseElementRespDTO> listBaseElements(BaseElementListQueryReqDTO listQueryReqDTO) {
    return baseElementService.listBaseElements(listQueryReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public BaseElementRespDTO getBaseElementById(Long id) {
    return baseElementService.getBaseElementById(id);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<BaseElementRespDTO> pageBaseElement(BaseElementPageReqDTO page) {
    return baseElementService.pageBaseElement(page);
  }

  /**
   * 获取用户资源权限
   *
   * @param userId
   * @return
   */
  public List<BaseElementRespDTO> getAuthorityElementByUserId(Long userId) {
    return baseElementService.getAuthorityElementByUserId(userId);
  }

  /**
   * 查询用户菜单资源权限
   *
   * @param userId
   * @param menuId
   * @return
   */
  public List<BaseElementRespDTO> getAuthorityMenuElementByUserId(Long userId, Long menuId) {
    return baseElementService.getAuthorityMenuElementByUserId(userId, menuId);
  }

  /**
   * 获取全部资源权限
   *
   * @return
   */
  public List<BaseElementRespDTO> getAllElementPermissions() {
    return baseElementService.getAllElementPermissions();
  }


}
