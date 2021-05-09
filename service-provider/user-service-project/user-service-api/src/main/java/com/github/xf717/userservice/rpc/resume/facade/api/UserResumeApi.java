package com.github.xf717.userservice.rpc.resume.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.userservice.rpc.resume.dto.UserIdsReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeDetailRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeUpdateReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户_简历
 *
 * @author wst
 * @date 2021-03-29 13:08:13
 */
public interface UserResumeApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/userResume/save")
	BaseResponse save(@RequestBody UserResumeCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/userResume/update")
	BaseResponse update(@RequestBody UserResumeUpdateReqDTO updateReqDTO);


	/**
	 * 根据用户Id查找
	 * @param userId userId
	 * @return
	 */
	@GetMapping("/facade/userResume/get/{userId}")
	ObjectRestResponse<UserResumeRespDTO> getUserResumeById(@PathVariable("userId") Long userId);


	/**
	 * 根据用户ids 查找用户简历
	 * @param  userIdsReqDTO
	 * @return
	 */
	@PostMapping("/facade/userResume/list/userIds")
	ObjectRestResponse<List<UserResumeDetailRespDTO>> getResumeDetailByUserIds(
			@RequestBody UserIdsReqDTO userIdsReqDTO);

}
