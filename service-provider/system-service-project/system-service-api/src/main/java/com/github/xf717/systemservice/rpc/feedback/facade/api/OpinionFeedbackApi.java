package com.github.xf717.systemservice.rpc.feedback.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackCreateReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackRespDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackUpdateReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackListQueryReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackPageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 意见反馈信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
public interface OpinionFeedbackApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/opinionFeedback/save")
	BaseResponse save(@RequestBody OpinionFeedbackCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/opinionFeedback/update")
	BaseResponse update(@RequestBody OpinionFeedbackUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/opinionFeedback/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/opinionFeedback/get/{id}")
	ObjectRestResponse<OpinionFeedbackRespDTO> getOpinionFeedbackById(@PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/opinionFeedback/list")
	ObjectRestResponse<List<OpinionFeedbackRespDTO>> listOpinionFeedbacks(
      @RequestBody OpinionFeedbackListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/opinionFeedback/page")
	TableResultResponse<OpinionFeedbackRespDTO> page(
      @RequestBody OpinionFeedbackPageReqDTO pageReqDTO);


	@PostMapping("/facade/opinionFeedback/get/Last/feedback")
	ObjectRestResponse<OpinionFeedbackRespDTO> selectLastFeedbackByUserId(@RequestBody OpinionFeedbackListQueryReqDTO listQuery);

}
