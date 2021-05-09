package com.github.xf717.userservice.rpc.user.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.dto.UserWordCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserWordRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserWordUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserWordPageReqDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户_常用语
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
public interface UserWordApi {

  /**
   * 添加数据
   *
   * @param createReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/userWord/save")
  BaseResponse save(@RequestBody UserWordCreateReqDTO createReqDTO);

  /**
   * 更新数据
   *
   * @param updateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/userWord/update")
  BaseResponse update(@RequestBody UserWordUpdateReqDTO updateReqDTO);

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/userWord/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/userWord/get/{id}")
  ObjectRestResponse<UserWordRespDTO> getUserWordById(@PathVariable("id") Long id);


  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/userWord/page")
  TableResultResponse<UserWordRespDTO> page(@RequestBody UserWordPageReqDTO pageReqDTO);

	/**
	 * 置顶
	 * @param id
	 * @param userId
	 * @return
	 */
  @GetMapping("/facade/userWord/top/{id}/uerId/{userId}")
  BaseResponse userWordTopByUserId(@PathVariable("id") Long id,
      @PathVariable("userId") Long userId);

}
