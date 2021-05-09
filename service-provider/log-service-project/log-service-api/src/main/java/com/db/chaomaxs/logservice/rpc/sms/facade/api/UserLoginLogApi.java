package com.db.chaomaxs.logservice.rpc.sms.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.logservice.rpc.login.dto.UserLoginLogCreateReqDTO;
import com.db.chaomaxs.logservice.rpc.login.dto.UserLoginLogListQueryReqDTO;
import com.db.chaomaxs.logservice.rpc.login.dto.UserLoginLogPageReqDTO;
import com.db.chaomaxs.logservice.rpc.login.dto.UserLoginLogRespDTO;
import com.db.chaomaxs.logservice.rpc.login.dto.UserLoginLogUpdateReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户_登录日志
 *
 * @author xiaofeng
 * @date 2021-04-06 17:48:03
 */
public interface UserLoginLogApi {

  /**
   * 添加数据
   *
   * @param createReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/userLoginLog/save")
  BaseResponse save(@RequestBody UserLoginLogCreateReqDTO createReqDTO);

  /**
   * 更新数据
   *
   * @param updateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/userLoginLog/update")
  BaseResponse update(@RequestBody UserLoginLogUpdateReqDTO updateReqDTO);

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/userLoginLog/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/userLoginLog/get/{id}")
  ObjectRestResponse<UserLoginLogRespDTO> getUserLoginLogById(@PathVariable("id") Long id);


  /**
   * 根据条件查找数据
   *
   * @param listQuery 查询参数
   * @return
   */
  @PostMapping("/facade/userLoginLog/list")
  ObjectRestResponse<List<UserLoginLogRespDTO>> listUserLoginLogs(
      @RequestBody UserLoginLogListQueryReqDTO listQuery);

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/userLoginLog/page")
  TableResultResponse<UserLoginLogRespDTO> page(@RequestBody UserLoginLogPageReqDTO pageReqDTO);

}
