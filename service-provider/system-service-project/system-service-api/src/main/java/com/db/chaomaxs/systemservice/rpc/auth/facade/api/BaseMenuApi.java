package com.db.chaomaxs.systemservice.rpc.auth.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseMenuCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseMenuListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseMenuPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseMenuRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseMenuUpdateReqDTO;
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
public interface BaseMenuApi {

  /**
   * 添加数据
   *
   * @param baseMenuCreateReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/baseMenu/save")
  BaseResponse save(@RequestBody BaseMenuCreateReqDTO baseMenuCreateReqDTO);

  /**
   * 更新数据
   *
   * @param baseMenuUpdateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/baseMenu/update")
  BaseResponse update(@RequestBody BaseMenuUpdateReqDTO baseMenuUpdateReqDTO);

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/baseMenu/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/baseMenu/get/{id}")
  ObjectRestResponse<BaseMenuRespDTO> getBaseMenuById(@PathVariable("id") Long id);


  /**
   * 根据条件查找数据
   *
   * @param listQuery 查询参数
   * @return
   */
  @PostMapping("/facade/baseMenu/list")
  ObjectRestResponse<List<BaseMenuRespDTO>> listBaseMenus(
      @RequestBody BaseMenuListQueryReqDTO listQuery);

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/baseMenu/page")
  TableResultResponse<BaseMenuRespDTO> page(@RequestBody BaseMenuPageReqDTO pageReqDTO);

  /**
   * 获取全部菜单
   *
   * @return
   */
  @GetMapping(value = "/facade/baseMenu/list/all")
  ObjectRestResponse<List<BaseMenuRespDTO>> listAllMenus();

  /**
   * 根据条件查询数据
   *
   * @param path
   * @param id
   * @return
   */
  @PostMapping("/facade/baseMenu/list/menus")
  ObjectRestResponse<List<BaseMenuRespDTO>> listMenus(@RequestParam("path") String path,
      @RequestParam("id") Long id);


  /**
   * 获取用户可以访问的菜单
   *
   * @param userId
   * @return
   */
  @GetMapping("/facade/baseMenu/user/{userId}/authority/menus")
  ObjectRestResponse<List<BaseMenuRespDTO>> listUserAuthorityMenus(
      @PathVariable("userId") Long userId);

  /**
   * 根据用户获取可以访问的系统
   *
   * @param userId
   * @return
   */
  @GetMapping("/facade/baseMenu/user/{userId}/authority/system")
  ObjectRestResponse<List<BaseMenuRespDTO>> listUserAuthoritySystems(
      @PathVariable("userId") Long userId);


}
