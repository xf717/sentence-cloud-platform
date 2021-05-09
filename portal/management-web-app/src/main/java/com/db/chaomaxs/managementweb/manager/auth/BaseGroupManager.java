package com.db.chaomaxs.managementweb.manager.auth;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.util.TreeUtil;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseGroupAddDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseGroupDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseGroupPageDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseGroupUpdateDTO;
import com.db.chaomaxs.managementweb.controller.auth.vo.AuthorityMenuTreeVO;
import com.db.chaomaxs.managementweb.controller.auth.vo.BaseGroupVO;
import com.db.chaomaxs.managementweb.controller.auth.vo.GroupTreeVO;
import com.db.chaomaxs.managementweb.controller.auth.vo.GroupUsersVO;
import com.db.chaomaxs.managementweb.convert.auth.BaseGroupConvert;
import com.db.chaomaxs.systemservice.constant.AdminCommonConstant;
import com.db.chaomaxs.systemservice.rpc.auth.dto.AuthorityMenuTreeRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.GroupTreeRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.GroupUsersRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.facade.BaseGroupRpcFacade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * BaseGroupManager
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Service
@Validated
public class BaseGroupManager {

  @Autowired
  private BaseGroupRpcFacade baseGroupRpcFacade;

  /**
   * 添加数据
   *
   * @param baseGroupAddDTO 添加参数
   * @return
   */
  public int save(BaseGroupAddDTO baseGroupAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = baseGroupRpcFacade
        .save(BaseGroupConvert.INSTANCE.convert(baseGroupAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param baseGroupUpdateDTO 更新参数
   * @return
   */
  public int update(BaseGroupUpdateDTO baseGroupUpdateDTO) {
    BaseResponse baseResponse = baseGroupRpcFacade
        .update(BaseGroupConvert.INSTANCE.convert(baseGroupUpdateDTO));
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
    BaseResponse baseResponse = baseGroupRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public BaseGroupVO getBaseGroupById(Long id) {
    ObjectRestResponse<BaseGroupRespDTO> objectRestResponse = baseGroupRpcFacade
        .getBaseGroupById(id);
    objectRestResponse.checkError();
    return BaseGroupConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   *
   * @param baseGroupDTO 查询参数
   * @return
   */
  public List<BaseGroupVO> listBaseGroups(BaseGroupDTO baseGroupDTO) {
    ObjectRestResponse<List<BaseGroupRespDTO>> objectRestResponse = baseGroupRpcFacade
        .listBaseGroups(BaseGroupConvert.INSTANCE.convert(baseGroupDTO));
    objectRestResponse.checkError();
    return BaseGroupConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   *
   * @param pageDTO 分页参数
   * @return
   */
  public TableResultResponse<BaseGroupVO> pageBaseGroup(BaseGroupPageDTO pageDTO) {
    TableResultResponse<BaseGroupRespDTO> tableResultResponse = baseGroupRpcFacade
        .page(BaseGroupConvert.INSTANCE.convert(pageDTO));
    tableResultResponse.checkError();
    return BaseGroupConvert.INSTANCE.convert(tableResultResponse);
  }

  /**
   * 修改组用户
   *
   * @param groupId
   * @param members
   * @param leaders
   */
  public void updateGroupUsers(Long groupId, String members, String leaders) {
    BaseResponse baseResponse = baseGroupRpcFacade.updateGroupUsers(groupId, members, leaders);
    baseResponse.checkError();
  }

  /**
   * 获取群组关联用户
   *
   * @param groupId
   * @return
   */
  public GroupUsersVO getGroupUsers(Long groupId) {
    ObjectRestResponse<GroupUsersRespDTO> objectRestResponse = baseGroupRpcFacade
        .getGroupUsers(groupId);
    objectRestResponse.checkError();
    return BaseGroupConvert.INSTANCE.convert(objectRestResponse.getData());
  }

  public void updateAuthorityMenu(Long groupId, String menuTrees) {
    BaseResponse baseResponse = baseGroupRpcFacade.updateAuthorityMenu(groupId, menuTrees);
    baseResponse.checkError();
  }

  /**
   * 获取群主关联的菜单
   *
   * @param groupId
   * @return
   */
  public List<AuthorityMenuTreeVO> listAuthorityMenus(Long groupId) {
    ObjectRestResponse<List<AuthorityMenuTreeRespDTO>> objectRestResponse = baseGroupRpcFacade
        .listAuthorityMenus(groupId);
    objectRestResponse.checkError();
    return BaseGroupConvert.INSTANCE.convertAuthorityMenuTreeListVO(objectRestResponse.getData());
  }

  /**
   * 分配资源权限
   *
   * @param groupId
   * @param elementId
   */
  public void updateAuthorityElement(Long groupId, Long elementId) {
    baseGroupRpcFacade.updateAuthorityElement(groupId, elementId);
  }

  /**
   * 移除资源权限
   *
   * @param groupId
   * @param elementId
   */
  public void removeAuthorityElement(Long groupId, Long elementId) {
    baseGroupRpcFacade.removeAuthorityElement(groupId, elementId);
  }

  /**
   * 获取群组关联的资源
   *
   * @param groupId
   * @return
   */
  public List<Long> listAuthorityElementIds(Long groupId) {
    ObjectRestResponse<List<Long>> objectRestResponse = baseGroupRpcFacade
        .listAuthorityElementIds(groupId);
    objectRestResponse.checkError();
    return objectRestResponse.getData();
  }

  /**
   * 根据组名称和组类型查询tree数据
   *
   * @param name
   * @param groupType
   * @return
   */
  public List<GroupTreeVO> tree(String name, Long groupType) {
    BaseGroupListQueryReqDTO listQuery = new BaseGroupListQueryReqDTO().setName(name)
        .setGroupType(groupType);
    ObjectRestResponse<List<BaseGroupRespDTO>> objectRestResponse = baseGroupRpcFacade
        .listBaseGroups(listQuery);
    objectRestResponse.checkError();

    final List<GroupTreeRespDTO> trees = getTree(objectRestResponse.getData(),
        AdminCommonConstant.ROOT);
    return BaseGroupConvert.INSTANCE.convertGroupTreeVOList(trees);
  }

  private List<GroupTreeRespDTO> getTree(List<BaseGroupRespDTO> groups, int root) {
    final List<GroupTreeRespDTO> trees = BaseGroupConvert.INSTANCE
        .convertGroupTreeList(groups);
    return TreeUtil.bulid(trees, root);
  }
}
