package com.db.chaomaxs.systemservice.rpc.auth.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseElementCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseElementListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseElementPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseElementRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseElementUpdateReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ding
 * @date 2021-03-24 19:50:39
 */
public interface BaseElementApi {

  /**
   * 添加数据
   *
   * @param baseElementCreateReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/baseElement/save")
  BaseResponse save(@RequestBody BaseElementCreateReqDTO baseElementCreateReqDTO);

  /**
   * 更新数据
   *
   * @param baseElementUpdateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/baseElement/update")
  BaseResponse update(@RequestBody BaseElementUpdateReqDTO baseElementUpdateReqDTO);

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/baseElement/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/baseElement/get/{id}")
  ObjectRestResponse<BaseElementRespDTO> getBaseElementById(@PathVariable("id") Long id);


  /**
   * 根据条件查找数据
   *
   * @param listQuery 查询参数
   * @return
   */
  @PostMapping("/facade/baseElement/list")
  ObjectRestResponse<List<BaseElementRespDTO>> listBaseElements(
      @RequestBody BaseElementListQueryReqDTO listQuery);

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/baseElement/page")
  TableResultResponse<BaseElementRespDTO> page(@RequestBody BaseElementPageReqDTO pageReqDTO);


  /**
   * 根据用户id和菜单id查找相关权限
   *
   * @param userId
   * @param menuId
   * @return
   */
  @GetMapping("/facade/baseElement/getAuthorityMenuElementByUserId")
  ObjectRestResponse<List<BaseElementRespDTO>> getAuthorityMenuElementByUserId(
      @RequestParam("userId") Long userId, @RequestParam("menuId") Long menuId);

  /**
   * 根据用户ID获取权限
   *
   * @param userId
   * @return
   */
  @GetMapping("/facade/baseElement/getAuthorityElementByUserId")
  ObjectRestResponse<List<BaseElementRespDTO>> getAuthorityElementByUserId(
      @RequestParam("userId") Long userId);

  /**
   * 获取全部资源权限
   *
   * @return
   */
  @GetMapping("/facade/baseElement/getAllElementPermissions")
  ObjectRestResponse<List<BaseElementRespDTO>> getAllElementPermissions();


}
