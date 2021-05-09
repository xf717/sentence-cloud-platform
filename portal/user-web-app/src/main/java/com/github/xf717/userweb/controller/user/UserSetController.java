package com.github.xf717.userweb.controller.user;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.userweb.controller.user.dto.UserExtendUpdateEnableHideDTO;
import com.github.xf717.userweb.controller.user.dto.UserSetAddDTO;
import com.github.xf717.userweb.controller.user.dto.UserSetUpdateDTO;
import com.github.xf717.userweb.controller.user.vo.UserSetVO;
import com.github.xf717.userweb.manager.user.UserSetManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 用户_设置
 *
 * @author wst
 * @date 2021-03-29 12:47:47
 */
@Api(value = "用户_设置", description = "用户_设置", tags = "用户_设置")
@RestController
@RequestMapping("/rest/userSet")
public class UserSetController {

	@Autowired
	private UserSetManager userSetManager;

	/**
	* 添加数据
* @param  addDTO
* @return
*/
	@ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
	@PostMapping("/save")
	public BaseResponse save(@Valid @RequestBody UserSetAddDTO addDTO) {
			userSetManager.save(addDTO);
		return BaseResponse.success("保存成功");
	}

	/**
	* 更新数据
* @param updateDTO
* @return
*/
	@ApiOperation(value = "更新数据", produces = "application/json", nickname = "update")
    @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
	@PutMapping("/update/{id}")
	public BaseResponse update(@Valid @RequestBody UserSetUpdateDTO updateDTO) {
		userSetManager.update(updateDTO);
		return BaseResponse.success("更新成功");
	}


	/**
	* 获取数据
* @param id
* @return
*/
	@ApiOperation(value = "获取对象数据", nickname = "get")
	@ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
	@GetMapping("/get/{id}")
	public ObjectRestResponse<UserSetVO> getUserSetById(@PathVariable("id") Long id) {
		return ObjectRestResponse.success(userSetManager.getUserSetById(id));
	}

	/**
	 * 打招呼语和面试通知按钮开关，更新数据
	 * @param userExtendUpdateEnableHideDTO
	 * @return
	 */
	@ApiOperation(value = "打招呼语按钮开关，更新数据", produces = "application/json", nickname = "update")
	@ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
	@PutMapping("/enable/hide/update")
	public BaseResponse updateEnableHide(@Valid @RequestBody UserExtendUpdateEnableHideDTO userExtendUpdateEnableHideDTO) {
		userSetManager.updateEnableHide(userExtendUpdateEnableHideDTO);
		return BaseResponse.success("更新成功");
	}


}
