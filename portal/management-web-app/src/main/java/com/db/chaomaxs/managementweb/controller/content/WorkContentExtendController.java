package com.db.chaomaxs.managementweb.controller.content;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;

import com.db.chaomaxs.managementweb.controller.content.dto.WorkContentExtendAddDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.WorkContentExtendUpdateDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.WorkContentExtendDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.WorkContentExtendPageDTO;
import com.db.chaomaxs.managementweb.controller.content.vo.WorkContentExtendVO;

import com.db.chaomaxs.managementweb.manager.content.WorkContentExtendManager;

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
 * 内容管理-工作内容_扩展信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Api(value = "内容管理-工作内容_扩展信息表", description = "内容管理-工作内容_扩展信息表", tags = "WorkContentExtend")
@RestController
@RequestMapping("/rest/workContentExtend")
public class WorkContentExtendController {

	@Autowired
	private WorkContentExtendManager workContentExtendManager;

	/**
	* 添加数据
* @param  addDTO
* @return
*/
	@ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
	@PostMapping("/save")
	public BaseResponse save(@Valid @RequestBody WorkContentExtendAddDTO addDTO) {
			workContentExtendManager.save(addDTO);
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
	public BaseResponse update(@Valid @RequestBody WorkContentExtendUpdateDTO updateDTO) {
		workContentExtendManager.update(updateDTO);
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
			workContentExtendManager.remove(id);
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
	public ObjectRestResponse<WorkContentExtendVO> getWorkContentExtendById(@PathVariable("id") Long id) {
		return ObjectRestResponse.success(workContentExtendManager.getWorkContentExtendById(id));
	}

	@ApiOperation(value = "根据参数查询数据,不分页", nickname = "list")
	@PostMapping("/list")
	public ObjectRestResponse<List<WorkContentExtendVO>> listWorkContentExtends(@Valid @RequestBody WorkContentExtendDTO workContentExtendDTO) {
		List<WorkContentExtendVO> list = workContentExtendManager.listWorkContentExtends(workContentExtendDTO);
		return ObjectRestResponse.success(list);
	}

	@ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
	@PostMapping("/page")
	public TableResultResponse<WorkContentExtendVO> page(@RequestBody WorkContentExtendPageDTO pageReqDTO) {
		return workContentExtendManager.pageWorkContentExtend(pageReqDTO);
	}

}
