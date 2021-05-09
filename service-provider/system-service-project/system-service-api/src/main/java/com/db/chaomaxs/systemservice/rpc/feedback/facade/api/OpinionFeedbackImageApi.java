package com.db.chaomaxs.systemservice.rpc.feedback.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackImageCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackImageRespDTO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackImageUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackImageListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackImagePageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 意见反馈_图片
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
public interface OpinionFeedbackImageApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/opinionFeedbackImage/save")
	BaseResponse save(@RequestBody OpinionFeedbackImageCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/opinionFeedbackImage/update")
	BaseResponse update(@RequestBody OpinionFeedbackImageUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/opinionFeedbackImage/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/opinionFeedbackImage/get/{id}")
	ObjectRestResponse<OpinionFeedbackImageRespDTO> getOpinionFeedbackImageById(
      @PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/opinionFeedbackImage/list")
	ObjectRestResponse<List<OpinionFeedbackImageRespDTO>> listOpinionFeedbackImages(
      @RequestBody OpinionFeedbackImageListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/opinionFeedbackImage/page")
	TableResultResponse<OpinionFeedbackImageRespDTO> page(
      @RequestBody OpinionFeedbackImagePageReqDTO pageReqDTO);

}
