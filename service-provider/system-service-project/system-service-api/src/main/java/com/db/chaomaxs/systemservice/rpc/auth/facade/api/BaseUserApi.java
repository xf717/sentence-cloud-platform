package com.db.chaomaxs.systemservice.rpc.auth.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.FrontUserRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.FrontUserV2RespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.MenuTreeRespDTO;
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
public interface BaseUserApi {

  /**
   * 添加数据
   *
   * @param baseUserCreateReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/baseUser/save")
  BaseResponse save(@RequestBody BaseUserCreateReqDTO baseUserCreateReqDTO);

  /**
   * 更新数据
   *
   * @param baseUserUpdateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/baseUser/update")
  BaseResponse update(@RequestBody BaseUserUpdateReqDTO baseUserUpdateReqDTO);

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/baseUser/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/baseUser/get/{id}")
  ObjectRestResponse<BaseUserRespDTO> getBaseUserById(@PathVariable("id") Long id);


  /**
   * 根据条件查找数据
   *
   * @param listQuery 查询参数
   * @return
   */
  @PostMapping("/facade/baseUser/list")
  ObjectRestResponse<List<BaseUserRespDTO>> listBaseUsers(
      @RequestBody BaseUserListQueryReqDTO listQuery);

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/baseUser/page")
  TableResultResponse<BaseUserRespDTO> page(@RequestBody BaseUserPageReqDTO pageReqDTO);

  /**
   * 根据用户名获取用户
   *
   * @param username
   * @return
   */
  @GetMapping("/facade/baseUser/getUserByUsername/{username}")
  ObjectRestResponse<BaseUserRespDTO> getUserByUsername(@PathVariable("username") String username);

  /**
   * 用户信息
   *
   * @param token
   * @return
   */
  @GetMapping(value = "/facade/baseUser/front/info")
  ObjectRestResponse<FrontUserRespDTO> getUserInfo(@RequestParam("token") String token);

  /**
   * 用户信息
   *
   * @return
   */
  @GetMapping(value = "/facade/baseUser/v2/front/info")
  ObjectRestResponse<FrontUserV2RespDTO> getUserInfoV2();

  /**
   * 获取用户菜单
   *
   * @param token
   * @return
   */
  @GetMapping(value = "/facade/baseUser/front/menus")
  ObjectRestResponse<List<MenuTreeRespDTO>> getMenusByUsername(String token);


}
