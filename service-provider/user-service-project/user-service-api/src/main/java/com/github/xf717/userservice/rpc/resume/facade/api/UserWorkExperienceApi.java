package com.github.xf717.userservice.rpc.resume.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceUpdateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperiencePageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户_工作经历
 *
 * @author wst
 * @date 2021-03-29 13:08:14
 */
public interface UserWorkExperienceApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/userWorkExperience/save")
	BaseResponse save(@RequestBody UserWorkExperienceCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/userWorkExperience/update")
	BaseResponse update(@RequestBody UserWorkExperienceUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/userWorkExperience/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/userWorkExperience/get/{id}")
	ObjectRestResponse<UserWorkExperienceRespDTO> getUserWorkExperienceById(
      @PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/userWorkExperience/list")
	ObjectRestResponse<List<UserWorkExperienceRespDTO>> listUserWorkExperiences(
      @RequestBody UserWorkExperienceListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/userWorkExperience/page")
	TableResultResponse<UserWorkExperienceRespDTO> page(
      @RequestBody UserWorkExperiencePageReqDTO pageReqDTO);

	/**
	 * 填写资料查询工作经历信息
	 * @param userId
	 * @return
	 */
	@GetMapping("/facade/userWorkExperience/get/last/Step/{userId}")
	ObjectRestResponse<UserWorkExperienceRespDTO> getLastStepByUserId(@PathVariable("userId") Long userId);
}
