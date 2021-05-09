package com.db.chaomaxs.resourceservice.rpc.resource.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceCreateReqDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceListQueryReqDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourcePageReqDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceRespDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceUpdateReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 文件资源表
 *
 * @author xiaofeng
 * @date 2021-03-29 19:47:07
 */
public interface ResourceApi {

  /**
   * 添加数据
   *
   * @param createReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/resource/save")
  ObjectRestResponse<Long> save(@RequestBody ResourceCreateReqDTO createReqDTO);

  /**
   * 更新数据
   *
   * @param updateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/resource/update")
  BaseResponse update(@RequestBody ResourceUpdateReqDTO updateReqDTO);

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/resource/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/resource/get/{id}")
  ObjectRestResponse<ResourceRespDTO> getResourceById(@PathVariable("id") Long id);


  /**
   * 根据条件查找数据
   *
   * @param listQuery 查询参数
   * @return
   */
  @PostMapping("/facade/resource/list")
  ObjectRestResponse<List<ResourceRespDTO>> listResources(
      @RequestBody ResourceListQueryReqDTO listQuery);

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/resource/page")
  TableResultResponse<ResourceRespDTO> page(@RequestBody ResourcePageReqDTO pageReqDTO);

}
