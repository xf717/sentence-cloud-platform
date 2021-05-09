package com.github.xf717.userservice.rpc.resume.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillUpdateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillPageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户_专业技能表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
public interface UserProfessionalSkillApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/userProfessionalSkill/save")
	BaseResponse save(@RequestBody UserProfessionalSkillCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/userProfessionalSkill/update")
	BaseResponse update(@RequestBody UserProfessionalSkillUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/userProfessionalSkill/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/userProfessionalSkill/get/{id}")
	ObjectRestResponse<UserProfessionalSkillRespDTO> getUserProfessionalSkillById(
      @PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/userProfessionalSkill/list")
	ObjectRestResponse<List<UserProfessionalSkillRespDTO>> listUserProfessionalSkills(
      @RequestBody UserProfessionalSkillListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/userProfessionalSkill/page")
	TableResultResponse<UserProfessionalSkillRespDTO> page(
      @RequestBody UserProfessionalSkillPageReqDTO pageReqDTO);

}
