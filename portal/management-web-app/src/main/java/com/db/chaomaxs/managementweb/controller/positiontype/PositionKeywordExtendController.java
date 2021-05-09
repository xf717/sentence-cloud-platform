package com.db.chaomaxs.managementweb.controller.positiontype;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;

import com.db.chaomaxs.managementweb.controller.positiontype.dto.PositionKeywordExtendAddDTO;
import com.db.chaomaxs.managementweb.controller.positiontype.dto.PositionKeywordExtendDTO;
import com.db.chaomaxs.managementweb.controller.positiontype.dto.PositionKeywordExtendPageDTO;
import com.db.chaomaxs.managementweb.controller.positiontype.dto.PositionKeywordExtendUpdateDTO;
import com.db.chaomaxs.managementweb.controller.positiontype.vo.PositionKeywordExtendVO;
import com.db.chaomaxs.managementweb.manager.positiontype.PositionKeywordExtendManager;
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
 * 职务关键词-扩展信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Api(value = "职务关键词-扩展信息表", description = "职务关键词-扩展信息表", tags = "PositionKeywordExtend")
@RestController
@RequestMapping("/rest/positionKeywordExtend")
public class PositionKeywordExtendController {

	@Autowired
	private PositionKeywordExtendManager positionKeywordExtendManager;

	/**
	* 添加数据
* @param  addDTO
* @return
*/
	@ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
	@PostMapping("/save")
	public BaseResponse save(@Valid @RequestBody PositionKeywordExtendAddDTO addDTO) {
			positionKeywordExtendManager.save(addDTO);
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
	public BaseResponse update(@Valid @RequestBody PositionKeywordExtendUpdateDTO updateDTO) {
		positionKeywordExtendManager.update(updateDTO);
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
			positionKeywordExtendManager.remove(id);
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
	public ObjectRestResponse<PositionKeywordExtendVO> getPositionKeywordExtendById(@PathVariable("id") Long id) {
		return ObjectRestResponse.success(positionKeywordExtendManager.getPositionKeywordExtendById(id));
	}

	@ApiOperation(value = "根据参数查询数据,不分页", nickname = "list")
	@PostMapping("/list")
	public ObjectRestResponse<List<PositionKeywordExtendVO>> listPositionKeywordExtends(@Valid @RequestBody PositionKeywordExtendDTO positionKeywordExtendDTO) {
		List<PositionKeywordExtendVO> list = positionKeywordExtendManager.listPositionKeywordExtends(positionKeywordExtendDTO);
		return ObjectRestResponse.success(list);
	}

	@ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
	@PostMapping("/page")
	public TableResultResponse<PositionKeywordExtendVO> page(@RequestBody PositionKeywordExtendPageDTO pageReqDTO) {
		return positionKeywordExtendManager.pagePositionKeywordExtend(pageReqDTO);
	}

}
