package com.github.xf717.systemservice.manager.auth;

import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupMemberCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupMemberListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupMemberPageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupMemberRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupMemberUpdateReqDTO;
import com.github.xf717.systemservice.service.auth.BaseGroupMemberService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * BaseGroupMemberManager
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Service
@Validated
public class BaseGroupMemberManager {

  @Autowired
  private BaseGroupMemberService baseGroupMemberService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveBaseGroupMember(BaseGroupMemberCreateReqDTO createReqDTO) {
    return baseGroupMemberService.saveBaseGroupMember(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateBaseGroupMember(BaseGroupMemberUpdateReqDTO updateReqDTO) {
    return baseGroupMemberService.updateBaseGroupMember(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteBaseGroupMember(Integer id) {
    return baseGroupMemberService.deleteBaseGroupMember(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<BaseGroupMemberRespDTO> listBaseGroupMembers(
      BaseGroupMemberListQueryReqDTO listQueryReqDTO) {
    return baseGroupMemberService.listBaseGroupMembers(listQueryReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public BaseGroupMemberRespDTO getBaseGroupMemberById(Integer id) {
    return baseGroupMemberService.getBaseGroupMemberById(id);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<BaseGroupMemberRespDTO> pageBaseGroupMember(BaseGroupMemberPageReqDTO page) {
    return baseGroupMemberService.pageBaseGroupMember(page);
  }


}
