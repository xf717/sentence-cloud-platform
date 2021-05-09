package com.github.xf717.userservice.rpc.user.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.dto.UserInterviewCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInterviewRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInterviewUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInterviewListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInterviewPageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户面试表
 *
 * @author momo
 * @date 2021-04-02 13:58:28
 */
public interface UserInterviewApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/userInterview/save")
	BaseResponse save(@RequestBody UserInterviewCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/userInterview/update")
	BaseResponse update(@RequestBody UserInterviewUpdateReqDTO updateReqDTO);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/userInterview/get/{id}")
	ObjectRestResponse<UserInterviewRespDTO> getUserInterviewById(@PathVariable("id") Long id);



	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/userInterview/page")
	TableResultResponse<UserInterviewRespDTO> page(@RequestBody UserInterviewPageReqDTO pageReqDTO);

}
