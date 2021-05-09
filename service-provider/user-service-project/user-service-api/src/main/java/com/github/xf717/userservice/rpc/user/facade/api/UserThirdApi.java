package com.github.xf717.userservice.rpc.user.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.dto.UserThirdCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserThirdListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserThirdPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserThirdRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserThirdUpdateReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户_第三方表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
public interface UserThirdApi {

  /**
   * 添加数据
   *
   * @param createReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/userThird/save")
  BaseResponse save(@RequestBody UserThirdCreateReqDTO createReqDTO);

  /**
   * 用户不存在的时候进行
   *
   * @param createReqDTO
   * @return
   */
  @PostMapping("/facade/userThird/createUserThirdIfAbsent")
  ObjectRestResponse<UserThirdRespDTO> createUserThirdIfAbsent(
      @RequestBody UserThirdCreateReqDTO createReqDTO);

  /**
   * 更新数据
   *
   * @param updateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/userThird/update")
  BaseResponse update(@RequestBody UserThirdUpdateReqDTO updateReqDTO);

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/userThird/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/userThird/get/{id}")
  ObjectRestResponse<UserThirdRespDTO> getUserThirdById(@PathVariable("id") Long id);


  /**
   * 根据条件查找数据
   *
   * @param listQuery 查询参数
   * @return
   */
  @PostMapping("/facade/userThird/list")
  ObjectRestResponse<List<UserThirdRespDTO>> listUserThirds(
      @RequestBody UserThirdListQueryReqDTO listQuery);

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/userThird/page")
  TableResultResponse<UserThirdRespDTO> page(@RequestBody UserThirdPageReqDTO pageReqDTO);

}
