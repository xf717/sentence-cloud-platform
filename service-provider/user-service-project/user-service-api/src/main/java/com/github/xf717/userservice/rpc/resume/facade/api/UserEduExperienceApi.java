package com.github.xf717.userservice.rpc.resume.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperienceCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperienceRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperienceUpdateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperienceListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperiencePageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户_教育经历表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
public interface UserEduExperienceApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/userEduExperience/save")
	BaseResponse save(@RequestBody UserEduExperienceCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/userEduExperience/update")
	BaseResponse update(@RequestBody UserEduExperienceUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/userEduExperience/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/userEduExperience/get/{id}")
	ObjectRestResponse<UserEduExperienceRespDTO> getUserEduExperienceById(@PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/userEduExperience/list")
	ObjectRestResponse<List<UserEduExperienceRespDTO>> listUserEduExperiences(
      @RequestBody UserEduExperienceListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/userEduExperience/page")
	TableResultResponse<UserEduExperienceRespDTO> page(
      @RequestBody UserEduExperiencePageReqDTO pageReqDTO);

	/**
	 * 填写个人资料根据用户查询学历信息
	 * @param userId
	 * @return
	 */
	@GetMapping("/facade/userEduExperience/get/last/step/{userId}")
	ObjectRestResponse<UserEduExperienceRespDTO> getLastStepByUserId(@PathVariable("userId") Long userId);
}
