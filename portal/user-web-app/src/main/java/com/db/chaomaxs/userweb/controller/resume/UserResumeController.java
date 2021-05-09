package com.db.chaomaxs.userweb.controller.resume;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.userweb.controller.resume.dto.UserResumeUpdateDTO;
import com.db.chaomaxs.userweb.controller.resume.vo.UserResumeVO;
import com.db.chaomaxs.userweb.manager.resume.UserResumeManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 用户_简历
 *
 * @author wst
 * @date 2021-03-29 13:08:13
 */
@Api(value = "用户_简历", description = "用户_简历", tags = "用户_简历 UserResume")
@RestController
@RequestMapping("/rest/userResume")
public class UserResumeController {

	@Autowired
	private UserResumeManager userResumeManager;


	/**
	* 更新数据
* @param updateDTO
* @return
*/
	@ApiOperation(value = "更新数据", produces = "application/json", nickname = "update")
	@PutMapping("/update")
	public BaseResponse update(@Valid @RequestBody UserResumeUpdateDTO updateDTO) {
		userResumeManager.update(updateDTO);
		return BaseResponse.success("更新成功");
	}


	/**
	* 根据用户id 查询在线简历信息
* @return
*/
	@ApiOperation(value = "根据用户id 查询在线简历信息以及预览简历", nickname = "get")
	@GetMapping("/get")
	public ObjectRestResponse<UserResumeVO> getUserResumeById() {
		return ObjectRestResponse.success(userResumeManager.getUserResumeByUserId());
	}
}
