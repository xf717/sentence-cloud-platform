package com.github.xf717.userservice.rpc.resume.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkSkillTagCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkSkillTagRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkSkillTagUpdateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkSkillTagListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkSkillTagPageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户_工作经历_技能标签信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
public interface UserWorkSkillTagApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/userWorkSkillTag/save")
	BaseResponse save(@RequestBody UserWorkSkillTagCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/userWorkSkillTag/update")
	BaseResponse update(@RequestBody UserWorkSkillTagUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/userWorkSkillTag/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/userWorkSkillTag/get/{id}")
	ObjectRestResponse<UserWorkSkillTagRespDTO> getUserWorkSkillTagById(@PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/userWorkSkillTag/list")
	ObjectRestResponse<List<UserWorkSkillTagRespDTO>> listUserWorkSkillTags(
      @RequestBody UserWorkSkillTagListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/userWorkSkillTag/page")
	TableResultResponse<UserWorkSkillTagRespDTO> page(
      @RequestBody UserWorkSkillTagPageReqDTO pageReqDTO);

}
