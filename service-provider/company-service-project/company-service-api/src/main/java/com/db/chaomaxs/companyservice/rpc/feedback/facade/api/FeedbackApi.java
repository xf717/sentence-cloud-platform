package com.db.chaomaxs.companyservice.rpc.feedback.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackRespDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackUpdateReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 帮助与反馈
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
public interface FeedbackApi {

  /**
   * 添加数据
   *
   * @param createReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/feedback/save")
  BaseResponse save(@RequestBody FeedbackCreateReqDTO createReqDTO);

  /**
   * 更新数据
   *
   * @param updateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/feedback/update")
  BaseResponse update(@RequestBody FeedbackUpdateReqDTO updateReqDTO);

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/feedback/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/feedback/get/{id}")
  ObjectRestResponse<FeedbackRespDTO> getFeedbackById(@PathVariable("id") Long id);


  /**
   * 根据条件查找数据
   *
   * @param listQuery 查询参数
   * @return
   */
  @PostMapping("/facade/feedback/list")
  ObjectRestResponse<List<FeedbackRespDTO>> listFeedbacks(
      @RequestBody FeedbackListQueryReqDTO listQuery);

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/feedback/page")
  TableResultResponse<FeedbackRespDTO> page(@RequestBody FeedbackPageReqDTO pageReqDTO);

}
