package com.github.xf717.managementweb.manager.auth;

import com.github.xf717.common.framework.context.BaseContextHandler;
import com.github.xf717.common.framework.exception.auth.UserTokenException;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.util.TreeUtil;
import com.github.xf717.managementweb.controller.auth.dto.BaseMenuAddDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseMenuDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseMenuPageDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseMenuUpdateDTO;
import com.github.xf717.managementweb.controller.auth.vo.AuthorityMenuTreeVO;
import com.github.xf717.managementweb.controller.auth.vo.BaseMenuVO;
import com.github.xf717.managementweb.controller.auth.vo.MenuTreeVO;
import com.github.xf717.managementweb.convert.auth.BaseMenuConvert;
import com.github.xf717.systemservice.constant.AdminCommonConstant;
import com.github.xf717.systemservice.rpc.auth.dto.AuthorityMenuTreeRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseMenuListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseMenuRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseUserRespDTO;
import com.github.xf717.systemservice.rpc.auth.facade.BaseMenuRpcFacade;
import com.github.xf717.systemservice.rpc.auth.facade.BaseUserRpcFacade;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
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
  private BaseMenuRpcFacade baseMenuRpcFacade;

  @Autowired
  private BaseUserRpcFacade baseUserRpcFacade;

  /**
   * 添加数据
   *
   * @param baseMenuAddDTO 添加参数
   * @return
   */
  public int save(BaseMenuAddDTO baseMenuAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = baseMenuRpcFacade
        .save(BaseMenuConvert.INSTANCE.convert(baseMenuAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param baseMenuUpdateDTO 更新参数
   * @return
   */
  public int update(BaseMenuUpdateDTO baseMenuUpdateDTO) {
    BaseResponse baseResponse = baseMenuRpcFacade
        .update(BaseMenuConvert.INSTANCE.convert(baseMenuUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = baseMenuRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public BaseMenuVO getBaseMenuById(Long id) {
    ObjectRestResponse<BaseMenuRespDTO> objectRestResponse = baseMenuRpcFacade.getBaseMenuById(id);
    objectRestResponse.checkError();
    return BaseMenuConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   *
   * @param baseMenuDTO 查询参数
   * @return
   */
  public List<BaseMenuVO> listBaseMenus(BaseMenuDTO baseMenuDTO) {
    ObjectRestResponse<List<BaseMenuRespDTO>> objectRestResponse = baseMenuRpcFacade
        .listBaseMenus(BaseMenuConvert.INSTANCE.convert(baseMenuDTO));
    objectRestResponse.checkError();
    return BaseMenuConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 获取全部菜单
   *
   * @return
   */
  public List<BaseMenuVO> listAllMenus() {
    ObjectRestResponse<List<BaseMenuRespDTO>> objectRestResponse = baseMenuRpcFacade.listAllMenus();
    objectRestResponse.checkError();
    return BaseMenuConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   *
   * @param pageDTO 分页参数
   * @return
   */
  public TableResultResponse<BaseMenuVO> pageBaseMenu(BaseMenuPageDTO pageDTO) {
    TableResultResponse<BaseMenuRespDTO> tableResultResponse = baseMenuRpcFacade
        .page(BaseMenuConvert.INSTANCE.convert(pageDTO));
    tableResultResponse.checkError();
    return BaseMenuConvert.INSTANCE.convert(tableResultResponse);
  }

  /**
   * 根据 title 查询 tree
   *
   * @param title
   * @return
   */
  public List<MenuTreeVO> getTree(String title) {
    // 组装参数
    BaseMenuListQueryReqDTO listQuery = new BaseMenuListQueryReqDTO().setTitle(title);
    ObjectRestResponse<List<BaseMenuRespDTO>> objectRestResponse = this.baseMenuRpcFacade
        .listBaseMenus(listQuery);
    objectRestResponse.checkError();
    return getMenuTree(objectRestResponse.getData(), AdminCommonConstant.ROOT);
  }


  private List<MenuTreeVO> getMenuTree(List<BaseMenuRespDTO> menus, int root) {
    List<MenuTreeVO> trees = new ArrayList<>();
    MenuTreeVO node = null;
    for (BaseMenuRespDTO menu : menus) {
      node = BaseMenuConvert.INSTANCE.convertTree(menu);
//      BeanUtils.copyProperties(menu, node);
      node.setLabel(menu.getTitle());
      trees.add(node);
    }
    return TreeUtil.bulid(trees, root);
  }

  /**
   * 获取系统菜单
   *
   * @return
   */
  public List<BaseMenuVO> getSystem() {
    BaseMenuListQueryReqDTO listQuery = new BaseMenuListQueryReqDTO()
        .setParentId(Long.valueOf(AdminCommonConstant.ROOT));
    ObjectRestResponse<List<BaseMenuRespDTO>> objectRestResponse = this.baseMenuRpcFacade
        .listBaseMenus(listQuery);
    objectRestResponse.checkError();
    return BaseMenuConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  public List<MenuTreeVO> listMenus(Long parentId) {
    try {
      if (parentId == null) {
        parentId = this.getSystem().get(0).getId();
      }
    } catch (Exception e) {
      return Collections.emptyList();
    }

    ObjectRestResponse<BaseMenuRespDTO> parent = baseMenuRpcFacade
        .getBaseMenuById(parentId);
    parent.checkError();

    ObjectRestResponse<List<BaseMenuRespDTO>> listObjectRestResponse = baseMenuRpcFacade
        .listMenus(parent.getData().getPath(), parent.getData().getId());
    listObjectRestResponse.checkError();

    return getMenuTree(listObjectRestResponse.getData(), parent.getData().getId().intValue());
  }

  /**
   * 获取权限菜单
   * <p>
   * TODO 转换数据未测试，可能会存在问题
   * </p>
   *
   * @return
   */
  public List<AuthorityMenuTreeVO> listAuthorityMenu() {
//    AuthorityMenuTreeRespDTO node = null;
    ObjectRestResponse<List<BaseMenuRespDTO>> objectRestResponse = baseMenuRpcFacade.listAllMenus();
    objectRestResponse.checkError();
    List<AuthorityMenuTreeRespDTO> trees = BaseMenuConvert.INSTANCE
        .convertAuthorityMenuTreeList(objectRestResponse.getData());
    List<AuthorityMenuTreeRespDTO> buildResults = TreeUtil.bulid(trees, AdminCommonConstant.ROOT);
    return BaseMenuConvert.INSTANCE.convertAuthorityMenuTreeListVO(buildResults);
  }

  /**
   * 获取用户可以访问的菜单
   *
   * @param parentId
   * @return
   */
  public List<MenuTreeVO> listUserAuthorityMenus(Long parentId) {
    try {
      if (parentId == null) {
        parentId = this.getSystem().get(0).getId();
      }
    } catch (Exception e) {
      return Collections.emptyList();
    }

    final String username = BaseContextHandler.getUsername();
    if (StringUtils.isEmpty(username)) {
      throw new UserTokenException("获取用户名错误");
    }
    ObjectRestResponse<BaseUserRespDTO> objectRestResponse = baseUserRpcFacade
        .getUserByUsername(username);
    objectRestResponse.checkError();

    //获取用户id
    final Long userId = objectRestResponse.getData().getId();

    ObjectRestResponse<List<BaseMenuRespDTO>> listObjectRestResponse = baseMenuRpcFacade
        .listUserAuthorityMenus(userId);
    listObjectRestResponse.checkError();

    return getMenuTree(listObjectRestResponse.getData(), parentId.intValue());
  }

  /**
   * 根据用户获取可以访问的系统
   *
   * @return
   */
  public List<MenuTreeVO> listUserAuthoritySystem() {
    final String username = BaseContextHandler.getUsername();
    if (StringUtils.isEmpty(username)) {
      throw new UserTokenException("获取用户名错误");
    }
    ObjectRestResponse<BaseUserRespDTO> objectRestResponse = baseUserRpcFacade
        .getUserByUsername(username);
    objectRestResponse.checkError();

    //获取用户id
    final Long userId = objectRestResponse.getData().getId();

    ObjectRestResponse<List<BaseMenuRespDTO>> listObjectRestResponse = baseMenuRpcFacade
        .listUserAuthoritySystems(userId);
    listObjectRestResponse.checkError();
    return BaseMenuConvert.INSTANCE.convertTreeList(listObjectRestResponse.getData());
  }
}
