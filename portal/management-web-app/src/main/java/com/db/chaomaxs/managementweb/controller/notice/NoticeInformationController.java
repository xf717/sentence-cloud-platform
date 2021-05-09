package com.db.chaomaxs.managementweb.controller.notice;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;

import com.db.chaomaxs.managementweb.controller.notice.dto.NoticeInformationAddDTO;
import com.db.chaomaxs.managementweb.controller.notice.dto.NoticeInformationUpdateDTO;
import com.db.chaomaxs.managementweb.controller.notice.dto.NoticeInformationDTO;
import com.db.chaomaxs.managementweb.controller.notice.dto.NoticeInformationPageDTO;
import com.db.chaomaxs.managementweb.controller.notice.vo.NoticeInformationVO;

import com.db.chaomaxs.managementweb.manager.notice.NoticeInformationManager;

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
 * 通知信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:09:32
 */
@Api(value = "通知信息表", description = "通知信息表", tags = "NoticeInformation")
@RestController
@RequestMapping("/rest/noticeInformation")
public class NoticeInformationController {

	@Autowired
	private NoticeInformationManager noticeInformationManager;

	/**
	* 添加数据
* @param  addDTO
* @return
*/
	@ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
	@PostMapping("/save")
	public BaseResponse save(@Valid @RequestBody NoticeInformationAddDTO addDTO) {
			noticeInformationManager.save(addDTO);
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
	public BaseResponse update(@Valid @RequestBody NoticeInformationUpdateDTO updateDTO) {
		noticeInformationManager.update(updateDTO);
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
			noticeInformationManager.remove(id);
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
	public ObjectRestResponse<NoticeInformationVO> getNoticeInformationById(@PathVariable("id") Long id) {
		return ObjectRestResponse.success(noticeInformationManager.getNoticeInformationById(id));
	}

	@ApiOperation(value = "根据参数查询数据,不分页", nickname = "list")
	@PostMapping("/list")
	public ObjectRestResponse<List<NoticeInformationVO>> listNoticeInformations(@Valid @RequestBody NoticeInformationDTO noticeInformationDTO) {
		List<NoticeInformationVO> list = noticeInformationManager.listNoticeInformations(noticeInformationDTO);
		return ObjectRestResponse.success(list);
	}

	@ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
	@PostMapping("/page")
	public TableResultResponse<NoticeInformationVO> page(@RequestBody NoticeInformationPageDTO pageReqDTO) {
		return noticeInformationManager.pageNoticeInformation(pageReqDTO);
	}

}
