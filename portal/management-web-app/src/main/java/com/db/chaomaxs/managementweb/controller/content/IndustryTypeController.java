package com.db.chaomaxs.managementweb.controller.content;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.managementweb.controller.content.dto.IndustryTypeAddDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.IndustryTypeDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.IndustryTypePageDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.IndustryTypeUpdateDTO;
import com.db.chaomaxs.managementweb.controller.content.vo.IndustryTypeTreeVO;
import com.db.chaomaxs.managementweb.controller.content.vo.IndustryTypeVO;
import com.db.chaomaxs.managementweb.manager.content.IndustryTypeManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;
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
 * 行业分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Api(value = "行业分类信息表", description = "行业分类信息表", tags = "IndustryType")
@RestController
@RequestMapping("/rest/industryType")
public class IndustryTypeController {

	@Autowired
	private IndustryTypeManager industryTypeManager;

	/**
	* 添加数据
* @param  addDTO
* @return
*/
	@ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
	@PostMapping("/save")
	public BaseResponse save(@Valid @RequestBody IndustryTypeAddDTO addDTO) {
			industryTypeManager.save(addDTO);
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
	public BaseResponse update(@Valid @RequestBody IndustryTypeUpdateDTO updateDTO) {
		industryTypeManager.update(updateDTO);
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
			industryTypeManager.remove(id);
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
	public ObjectRestResponse<IndustryTypeVO> getIndustryTypeById(@PathVariable("id") Long id) {
		return ObjectRestResponse.success(industryTypeManager.getIndustryTypeById(id));
	}

	@ApiOperation(value = "根据参数查询数据（树型）,不分页", nickname = "list")
	@PostMapping("/list")
	public ObjectRestResponse<List<IndustryTypeTreeVO>> listIndustryTypes(@Valid @RequestBody IndustryTypeDTO industryTypeDTO) {
		List<IndustryTypeTreeVO> list = industryTypeManager.listIndustryTypes(industryTypeDTO);
		return ObjectRestResponse.success(list);
	}

	@ApiOperation(value = "查询页面右侧，上级分类下拉框数据，pageSize传入最大值", nickname = "page")
	@PostMapping("/page")
	public TableResultResponse<IndustryTypeVO> page(@RequestBody IndustryTypePageDTO pageReqDTO) {
		return industryTypeManager.pageIndustryType(pageReqDTO);
	}


}
