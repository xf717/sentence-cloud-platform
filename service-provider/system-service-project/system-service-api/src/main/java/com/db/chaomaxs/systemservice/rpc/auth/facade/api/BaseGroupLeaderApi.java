package com.db.chaomaxs.systemservice.rpc.auth.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderUpdateReqDTO;
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
public interface BaseGroupLeaderApi {

  /**
   * 添加数据
   *
   * @param baseGroupLeaderCreateReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/baseGroupLeader/save")
  BaseResponse save(@RequestBody BaseGroupLeaderCreateReqDTO baseGroupLeaderCreateReqDTO);

  /**
   * 更新数据
   *
   * @param baseGroupLeaderUpdateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/baseGroupLeader/update")
  BaseResponse update(@RequestBody BaseGroupLeaderUpdateReqDTO baseGroupLeaderUpdateReqDTO);

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/baseGroupLeader/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/baseGroupLeader/get/{id}")
  ObjectRestResponse<BaseGroupLeaderRespDTO> getBaseGroupLeaderById(@PathVariable("id") Long id);


  /**
   * 根据条件查找数据
   *
   * @param listQuery 查询参数
   * @return
   */
  @PostMapping("/facade/baseGroupLeader/list")
  ObjectRestResponse<List<BaseGroupLeaderRespDTO>> listBaseGroupLeaders(
      @RequestBody BaseGroupLeaderListQueryReqDTO listQuery);

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/baseGroupLeader/page")
  TableResultResponse<BaseGroupLeaderRespDTO> page(
      @RequestBody BaseGroupLeaderPageReqDTO pageReqDTO);

}
