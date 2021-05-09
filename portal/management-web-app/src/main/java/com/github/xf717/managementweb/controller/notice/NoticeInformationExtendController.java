package com.github.xf717.managementweb.controller.notice;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;

import com.github.xf717.managementweb.controller.notice.dto.NoticeInformationExtendAddDTO;
import com.github.xf717.managementweb.controller.notice.dto.NoticeInformationExtendUpdateDTO;
import com.github.xf717.managementweb.controller.notice.dto.NoticeInformationExtendDTO;
import com.github.xf717.managementweb.controller.notice.dto.NoticeInformationExtendPageDTO;
import com.github.xf717.managementweb.controller.notice.vo.NoticeInformationExtendVO;

import com.github.xf717.managementweb.manager.notice.NoticeInformationExtendManager;

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
 * 内容管理通知信息_扩展信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:09:32
 */
@Api(value = "内容管理通知信息_扩展信息表", description = "内容管理通知信息_扩展信息表", tags = "NoticeInformationExtend")
@RestController
@RequestMapping("/rest/noticeInformationExtend")
public class NoticeInformationExtendController {

	@Autowired
	private NoticeInformationExtendManager noticeInformationExtendManager;

	/**
	* 添加数据
* @param  addDTO
* @return
*/
	@ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
	@PostMapping("/save")
	public BaseResponse save(@Valid @RequestBody NoticeInformationExtendAddDTO addDTO) {
			noticeInformationExtendManager.save(addDTO);
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
	public BaseResponse update(@Valid @RequestBody NoticeInformationExtendUpdateDTO updateDTO) {
		noticeInformationExtendManager.update(updateDTO);
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
			noticeInformationExtendManager.remove(id);
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
	public ObjectRestResponse<NoticeInformationExtendVO> getNoticeInformationExtendById(@PathVariable("id") Long id) {
		return ObjectRestResponse.success(noticeInformationExtendManager.getNoticeInformationExtendById(id));
	}

	@ApiOperation(value = "根据参数查询数据,不分页", nickname = "list")
	@PostMapping("/list")
	public ObjectRestResponse<List<NoticeInformationExtendVO>> listNoticeInformationExtends(@Valid @RequestBody NoticeInformationExtendDTO noticeInformationExtendDTO) {
		List<NoticeInformationExtendVO> list = noticeInformationExtendManager.listNoticeInformationExtends(noticeInformationExtendDTO);
		return ObjectRestResponse.success(list);
	}

	@ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
	@PostMapping("/page")
	public TableResultResponse<NoticeInformationExtendVO> page(@RequestBody NoticeInformationExtendPageDTO pageReqDTO) {
		return noticeInformationExtendManager.pageNoticeInformationExtend(pageReqDTO);
	}

}
