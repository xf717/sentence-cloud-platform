package com.db.chaomaxs.userweb.controller.user;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.userweb.manager.user.UserIntegralRecordManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 记录用户签到记录信息
 *
 * @author wst
 * @date 2021-03-29 12:47:48
 */
@Api(value = "记录用户签到记录信息", description = "记录用户签到记录信息", tags = "记录用户签到记录信息")
@RestController
@RequestMapping("/rest/userIntegralRecord")
public class UserIntegralRecordController {

	@Autowired
	private UserIntegralRecordManager userIntegralRecordManager;


	/**
	 * 签到
	 * @param
	 * @return
	 */
	@ApiOperation(value = "签到", produces = "application/json", nickname = "save")
	@PostMapping("/sign")
	public BaseResponse sign() {
		userIntegralRecordManager.sign();
		return BaseResponse.success("签到成功");
	}

}
