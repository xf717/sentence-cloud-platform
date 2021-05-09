package com.db.chaomaxs.userweb.controller.user;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.userweb.controller.user.dto.UserWordAddDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserWordPageDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserWordUpdateDTO;
import com.db.chaomaxs.userweb.controller.user.vo.UserWordVO;
import com.db.chaomaxs.userweb.manager.user.UserWordManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 用户_常用语
 *
 * @author wst
 * @date 2021-03-29 12:47:47
 */
@Api(value = "用户_常用语", description = "用户_常用语", tags = "用户_常用语")
@RestController
@RequestMapping("/rest/userWord")
public class UserWordController {

	@Autowired
	private UserWordManager userWordManager;

	/**
	* 添加数据
* @param  addDTO
* @return
*/
	@ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
	@PostMapping("/save")
	public BaseResponse save(@Valid @RequestBody UserWordAddDTO addDTO) {
			userWordManager.save(addDTO);
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
	public BaseResponse update(@Valid @RequestBody UserWordUpdateDTO updateDTO) {
		userWordManager.update(updateDTO);
		return BaseResponse.success("更新成功");
	}

	/**
	* 删除数据
* @param id
* @return
*/
	@ApiOperation(value = "删除数据", nickname = "remove")
	@ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
	@DeleteMapping("/remove/{id}")
	public BaseResponse remove(@PathVariable("id") Long id) {
			userWordManager.remove(id);
		return BaseResponse.success("删除成功");
	}

	/**
	* 获取数据
* @param id
* @return
*/
	@ApiOperation(value = "获取对象数据", nickname = "get")
	@ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
	@GetMapping("/get/{id}")
	public ObjectRestResponse<UserWordVO> getUserWordById(@PathVariable("id") Long id) {
		return ObjectRestResponse.success(userWordManager.getUserWordById(id));
	}



	@ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
	@PostMapping("/page")
	public TableResultResponse<UserWordVO> page(@RequestBody UserWordPageDTO pageReqDTO) {
		return userWordManager.pageUserWord(pageReqDTO);
	}

	/**
	 * 置顶
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "置顶", nickname = "top")
	@ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
	@DeleteMapping("/top/{id}")
	public BaseResponse top(@PathVariable("id") Long id) {
		userWordManager.userWordTopByUserId(id);
		return BaseResponse.success("置顶成功");
	}

}
