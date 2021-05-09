package com.github.xf717.userservice.rpc.resume.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.resume.dto.UserProjectExperienceCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProjectExperienceRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProjectExperienceUpdateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProjectExperienceListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProjectExperiencePageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户_项目经历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
public interface UserProjectExperienceApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/userProjectExperience/save")
	BaseResponse save(@RequestBody UserProjectExperienceCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/userProjectExperience/update")
	BaseResponse update(@RequestBody UserProjectExperienceUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/userProjectExperience/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/userProjectExperience/get/{id}")
	ObjectRestResponse<UserProjectExperienceRespDTO> getUserProjectExperienceById(
      @PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/userProjectExperience/list")
	ObjectRestResponse<List<UserProjectExperienceRespDTO>> listUserProjectExperiences(
      @RequestBody UserProjectExperienceListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/userProjectExperience/page")
	TableResultResponse<UserProjectExperienceRespDTO> page(
      @RequestBody UserProjectExperiencePageReqDTO pageReqDTO);

}
