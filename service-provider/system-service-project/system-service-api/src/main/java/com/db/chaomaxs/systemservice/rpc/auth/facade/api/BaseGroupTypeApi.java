package com.db.chaomaxs.systemservice.rpc.auth.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupTypeCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupTypeListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupTypePageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupTypeRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupTypeUpdateReqDTO;
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
public interface BaseGroupTypeApi {

  /**
   * 添加数据
   *
   * @param baseGroupTypeCreateReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/baseGroupType/save")
  BaseResponse save(@RequestBody BaseGroupTypeCreateReqDTO baseGroupTypeCreateReqDTO);

  /**
   * 更新数据
   *
   * @param baseGroupTypeUpdateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/baseGroupType/update")
  BaseResponse update(@RequestBody BaseGroupTypeUpdateReqDTO baseGroupTypeUpdateReqDTO);

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/baseGroupType/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/baseGroupType/get/{id}")
  ObjectRestResponse<BaseGroupTypeRespDTO> getBaseGroupTypeById(@PathVariable("id") Long id);


  /**
   * 根据条件查找数据
   *
   * @param listQuery 查询参数
   * @return
   */
  @PostMapping("/facade/baseGroupType/list")
  ObjectRestResponse<List<BaseGroupTypeRespDTO>> listBaseGroupTypes(
      @RequestBody BaseGroupTypeListQueryReqDTO listQuery);

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/baseGroupType/page")
  TableResultResponse<BaseGroupTypeRespDTO> page(@RequestBody BaseGroupTypePageReqDTO pageReqDTO);

}
