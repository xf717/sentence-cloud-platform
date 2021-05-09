package com.github.xf717.systemservice.rpc.auth.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityPageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityUpdateReqDTO;
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
public interface BaseResourceAuthorityApi {

  /**
   * 添加数据
   *
   * @param baseResourceAuthorityCreateReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/baseResourceAuthority/save")
  BaseResponse save(
      @RequestBody BaseResourceAuthorityCreateReqDTO baseResourceAuthorityCreateReqDTO);

  /**
   * 更新数据
   *
   * @param baseResourceAuthorityUpdateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/baseResourceAuthority/update")
  BaseResponse update(
      @RequestBody BaseResourceAuthorityUpdateReqDTO baseResourceAuthorityUpdateReqDTO);

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/baseResourceAuthority/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/baseResourceAuthority/get/{id}")
  ObjectRestResponse<BaseResourceAuthorityRespDTO> getBaseResourceAuthorityById(
      @PathVariable("id") Long id);


  /**
   * 根据条件查找数据
   *
   * @param listQuery 查询参数
   * @return
   */
  @PostMapping("/facade/baseResourceAuthority/list")
  ObjectRestResponse<List<BaseResourceAuthorityRespDTO>> listBaseResourceAuthoritys(
      @RequestBody BaseResourceAuthorityListQueryReqDTO listQuery);

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/baseResourceAuthority/page")
  TableResultResponse<BaseResourceAuthorityRespDTO> page(
      @RequestBody BaseResourceAuthorityPageReqDTO pageReqDTO);

}
