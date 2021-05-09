package com.github.xf717.userservice.rpc.resume.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedAndStatusRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionUpdateReqDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户_期望职位
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
public interface UserExpectedPositionApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/userExpectedPosition/save")
	BaseResponse save(@RequestBody UserExpectedPositionCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/userExpectedPosition/update")
	BaseResponse update(@RequestBody UserExpectedPositionUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/userExpectedPosition/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);


	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/userExpectedPosition/get/{id}")
	ObjectRestResponse<UserExpectedPositionRespDTO> getUserExpectedPositionById(
			@PathVariable("id") Long id);

	/**
	 * 根据用户Id查询求职期望
	 * @param userId userId
	 * @return
	 */
	@GetMapping("/facade/userExpectedPosition/list/{userId}")
	ObjectRestResponse<UserExpectedAndStatusRespDTO> getUserExpectedAndStatusByUserId(
			@PathVariable("userId") Long userId);
}
