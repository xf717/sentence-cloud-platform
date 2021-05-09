package com.github.xf717.logservice.rpc.sms.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.logservice.rpc.sms.dto.UserSmsCodeCreateReqDTO;
import com.github.xf717.logservice.rpc.sms.dto.UserSmsCodeListQueryReqDTO;
import com.github.xf717.logservice.rpc.sms.dto.UserSmsCodePageReqDTO;
import com.github.xf717.logservice.rpc.sms.dto.UserSmsCodeRespDTO;
import com.github.xf717.logservice.rpc.sms.dto.UserSmsCodeUpdateReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户短信验证码表
 *
 * @author xiaofeng
 * @date 2021-04-06 17:48:02
 */
public interface UserSmsCodeApi {

  /**
   * 添加数据
   *
   * @param createReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/userSmsCode/save")
  BaseResponse save(@RequestBody UserSmsCodeCreateReqDTO createReqDTO);

  /**
   * 更新数据
   *
   * @param updateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/userSmsCode/update")
  BaseResponse update(@RequestBody UserSmsCodeUpdateReqDTO updateReqDTO);

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/userSmsCode/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/userSmsCode/get/{id}")
  ObjectRestResponse<UserSmsCodeRespDTO> getUserSmsCodeById(@PathVariable("id") Long id);


  /**
   * 根据条件查找数据
   *
   * @param listQuery 查询参数
   * @return
   */
  @PostMapping("/facade/userSmsCode/list")
  ObjectRestResponse<List<UserSmsCodeRespDTO>> listUserSmsCodes(
      @RequestBody UserSmsCodeListQueryReqDTO listQuery);

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/userSmsCode/page")
  TableResultResponse<UserSmsCodeRespDTO> page(@RequestBody UserSmsCodePageReqDTO pageReqDTO);

  /**
   * 获取手机最后的验证码
   *
   * @param mobile 手机号码
   * @param scene  场景
   * @return
   */
  @GetMapping("/facade/userSmsCode/mobile/last/code")
  ObjectRestResponse<UserSmsCodeRespDTO> getLastCodeByMobile(@RequestParam("mobile") String mobile,
      @RequestParam("scene") Integer scene);

}
