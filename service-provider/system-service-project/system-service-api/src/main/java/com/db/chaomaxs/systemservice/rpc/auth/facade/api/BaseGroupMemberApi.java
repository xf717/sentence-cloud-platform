package com.db.chaomaxs.systemservice.rpc.auth.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberUpdateReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author ding
 * @date 2021-03-24 19:50:39
 */
public interface BaseGroupMemberApi {

  /**
   * 添加数据
   *
   * @param baseGroupMemberCreateReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/baseGroupMember/save")
  BaseResponse save(@RequestBody BaseGroupMemberCreateReqDTO baseGroupMemberCreateReqDTO);

  /**
   * 更新数据
   *
   * @param baseGroupMemberUpdateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/baseGroupMember/update")
  BaseResponse update(@RequestBody BaseGroupMemberUpdateReqDTO baseGroupMemberUpdateReqDTO);

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/baseGroupMember/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/baseGroupMember/get/{id}")
  ObjectRestResponse<BaseGroupMemberRespDTO> getBaseGroupMemberById(@PathVariable("id") Long id);


  /**
   * 根据条件查找数据
   *
   * @param listQuery 查询参数
   * @return
   */
  @PostMapping("/facade/baseGroupMember/list")
  ObjectRestResponse<List<BaseGroupMemberRespDTO>> listBaseGroupMembers(
      @RequestBody BaseGroupMemberListQueryReqDTO listQuery);

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/baseGroupMember/page")
  TableResultResponse<BaseGroupMemberRespDTO> page(
      @RequestBody BaseGroupMemberPageReqDTO pageReqDTO);

}
