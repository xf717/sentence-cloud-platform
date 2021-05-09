package com.db.chaomaxs.companyweb.controller.feedback;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;

import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackPhotoAddDTO;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackPhotoUpdateDTO;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackPhotoDTO;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackPhotoPageDTO;
import com.db.chaomaxs.companyweb.controller.feedback.vo.FeedbackPhotoVO;

import com.db.chaomaxs.companyweb.manager.feedback.FeedbackPhotoManager;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
/**
 * 帮助与反馈_图片说明
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Api(value = "帮助与反馈_图片说明", description = "帮助与反馈_图片说明", tags = "FeedbackPhoto")
@RestController
@RequestMapping("/rest/feedbackPhoto")
public class FeedbackPhotoController {

	@Autowired
	private FeedbackPhotoManager feedbackPhotoManager;

	/**
	* 添加数据
* @param AddDTO
* @return
*/
	@ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
	@PostMapping("/save")
	public BaseResponse save(@Valid @RequestBody FeedbackPhotoAddDTO feedbackPhotoAddDTO) {
			feedbackPhotoManager.save(feedbackPhotoAddDTO);
		return BaseResponse.success("保存成功");
	}

	/**
	* 更新数据
* @param UpdateDTO
* @return
*/
	@ApiOperation(value = "更新数据", produces = "application/json", nickname = "update")
    @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
	@PutMapping("/update/{id}")
	public BaseResponse update(@Valid @RequestBody FeedbackPhotoUpdateDTO feedbackPhotoUpdateDTO) {
		feedbackPhotoManager.update(feedbackPhotoUpdateDTO);
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
			feedbackPhotoManager.remove(id);
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
	public ObjectRestResponse<FeedbackPhotoVO> getFeedbackPhotoById(@PathVariable("id") Long id) {
		return ObjectRestResponse.success(feedbackPhotoManager.getFeedbackPhotoById(id));
	}

	@ApiOperation(value = "根据参数查询数据,不分页", nickname = "list")
	@PostMapping("/list")
	public ObjectRestResponse<List<FeedbackPhotoVO>> listFeedbackPhotos(@Valid @RequestBody FeedbackPhotoDTO feedbackPhotoDTO) {
		List<FeedbackPhotoVO> list = feedbackPhotoManager.listFeedbackPhotos(feedbackPhotoDTO);
		return ObjectRestResponse.success(list);
	}

	@ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
	@PostMapping("/page")
	public TableResultResponse<FeedbackPhotoVO> page(@RequestBody FeedbackPhotoPageDTO pageReqDTO) {
		return feedbackPhotoManager.pageFeedbackPhoto(pageReqDTO);
	}

}
