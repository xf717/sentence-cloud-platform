package com.db.chaomaxs.userservice.rpc.resume.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEnclosureResumeCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEnclosureResumePageReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEnclosureResumeRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEnclosureResumeUpdateReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户_附件_简历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
public interface UserEnclosureResumeApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/userEnclosureResume/save")
	BaseResponse save(@RequestBody UserEnclosureResumeCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/userEnclosureResume/update")
	BaseResponse update(@RequestBody UserEnclosureResumeUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/userEnclosureResume/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/userEnclosureResume/get/{id}")
	ObjectRestResponse<UserEnclosureResumeRespDTO> getUserEnclosureResumeById(
      @PathVariable("id") Long id);


	/**
	 * 根据用户id查询管理附件简历数据
	 * @param userId  查询参数
	 * @return
	 */
	@PostMapping("/facade/userEnclosureResume/list/{userId}")
	ObjectRestResponse<List<UserEnclosureResumeRespDTO>> listUserEnclosureResumes(@PathVariable("userId") Long userId);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/userEnclosureResume/page")
	TableResultResponse<UserEnclosureResumeRespDTO> page(
      @RequestBody UserEnclosureResumePageReqDTO pageReqDTO);

}
