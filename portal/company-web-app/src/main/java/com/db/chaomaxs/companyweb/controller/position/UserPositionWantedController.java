package com.db.chaomaxs.companyweb.controller.position;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;

import com.db.chaomaxs.companyweb.controller.position.dto.UserPositionWantedAddDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.UserPositionWantedUpdateDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.UserPositionWantedDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.UserPositionWantedPageDTO;
import com.db.chaomaxs.companyweb.controller.position.vo.UserPositionWantedVO;

import com.db.chaomaxs.companyweb.manager.position.UserPositionWantedManager;

import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
/**
 * 用户求职
 *
 * @author xiaofeng
 * @date 2021-03-29 16:36:57
 */
@Api(value = "用户求职", description = "用户求职", tags = "UserPositionWanted")
@RestController
@RequestMapping("/rest/userPositionWanted")
public class UserPositionWantedController {

	@Autowired
	private UserPositionWantedManager userPositionWantedManager;

	/**
	* 添加数据
* @param  addDTO
* @return
*/
	@ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
	@PostMapping("/save")
	public BaseResponse save(@Valid @RequestBody UserPositionWantedAddDTO addDTO) {
			userPositionWantedManager.save(addDTO);
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
	public BaseResponse update(@Valid @RequestBody UserPositionWantedUpdateDTO updateDTO) {
		userPositionWantedManager.update(updateDTO);
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
			userPositionWantedManager.remove(id);
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
	public ObjectRestResponse<UserPositionWantedVO> getUserPositionWantedById(@PathVariable("id") Long id) {
		return ObjectRestResponse.success(userPositionWantedManager.getUserPositionWantedById(id));
	}

	@ApiOperation(value = "根据参数查询数据,不分页", nickname = "list")
	@PostMapping("/list")
	public ObjectRestResponse<List<UserPositionWantedVO>> listUserPositionWanteds(@Valid @RequestBody UserPositionWantedDTO userPositionWantedDTO) {
		List<UserPositionWantedVO> list = userPositionWantedManager.listUserPositionWanteds(userPositionWantedDTO);
		return ObjectRestResponse.success(list);
	}

	@ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
	@PostMapping("/page")
	public TableResultResponse<UserPositionWantedVO> page(@RequestBody UserPositionWantedPageDTO pageReqDTO) {
		return userPositionWantedManager.pageUserPositionWanted(pageReqDTO);
	}

}
