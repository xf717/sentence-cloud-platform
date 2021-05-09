package com.github.xf717.systemservice.rpc.auth;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.manager.auth.BaseMenuManager;
import com.github.xf717.systemservice.rpc.auth.dto.BaseMenuCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseMenuListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseMenuPageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseMenuRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseMenuUpdateReqDTO;
import com.github.xf717.systemservice.rpc.auth.facade.BaseMenuRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BaseMenuRpcImpl implements BaseMenuRpcFacade {

  @Autowired
  private BaseMenuManager baseMenuManager;

  @Override
  public BaseResponse save(BaseMenuCreateReqDTO baseMenuCreateReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    baseMenuManager.saveBaseMenu(baseMenuCreateReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(BaseMenuUpdateReqDTO baseMenuUpdateReqDTO) {
    baseMenuManager.updateBaseMenu(baseMenuUpdateReqDTO);
    return BaseResponse.success("修改成功");
  }

  @Override
  public BaseResponse remove(Long id) {
    baseMenuManager.deleteBaseMenu(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<BaseMenuRespDTO> getBaseMenuById(Long id) {
    BaseMenuRespDTO baseMenuRespDTO = baseMenuManager.getBaseMenuById(id);
    return new ObjectRestResponse<>().data(baseMenuRespDTO);
  }

  @Override
  public ObjectRestResponse<List<BaseMenuRespDTO>> listBaseMenus(
      BaseMenuListQueryReqDTO listQuery) {
    List<BaseMenuRespDTO> list = baseMenuManager.listBaseMenus(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<BaseMenuRespDTO> page(BaseMenuPageReqDTO pageReqDTO) {
    PageResult<BaseMenuRespDTO> pageResult = baseMenuManager.pageBaseMenu(pageReqDTO);
    TableResultResponse<BaseMenuRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

  @Override
  public ObjectRestResponse<List<BaseMenuRespDTO>> listAllMenus() {
    List<BaseMenuRespDTO> list = baseMenuManager.listAllMenus();
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public ObjectRestResponse<List<BaseMenuRespDTO>> listMenus(String path, Long id) {
    List<BaseMenuRespDTO> list = baseMenuManager.listMenus(path, id);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public ObjectRestResponse<List<BaseMenuRespDTO>> listUserAuthorityMenus(Long userId) {
    List<BaseMenuRespDTO> list = baseMenuManager.getUserAuthorityMenuByUserId(userId);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public ObjectRestResponse<List<BaseMenuRespDTO>> listUserAuthoritySystems(Long userId) {
    List<BaseMenuRespDTO> list = baseMenuManager.getUserAuthoritySystemByUserId(userId);
    return new ObjectRestResponse<>().data(list);
  }


  /**
   * 获取用户可以访问的菜单
   *
   * @param id
   * @return
   */
  public List<BaseMenuRespDTO> getUserAuthorityMenuByUserId(Long id) {
    return baseMenuManager.getUserAuthorityMenuByUserId(id);
  }

  /**
   * 根据用户获取可以访问的系统
   *
   * @param id
   * @return
   */
  public List<BaseMenuRespDTO> getUserAuthoritySystemByUserId(Long id) {
    return baseMenuManager.getUserAuthoritySystemByUserId(id);
  }

}
