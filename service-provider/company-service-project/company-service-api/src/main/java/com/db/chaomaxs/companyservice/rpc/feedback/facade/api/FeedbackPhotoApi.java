package com.db.chaomaxs.companyservice.rpc.feedback.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoRespDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoUpdateReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 帮助与反馈_图片说明
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
public interface FeedbackPhotoApi {

  /**
   * 添加数据
   *
   * @param createReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/feedbackPhoto/save")
  BaseResponse save(@RequestBody FeedbackPhotoCreateReqDTO createReqDTO);

  /**
   * 更新数据
   *
   * @param updateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/feedbackPhoto/update")
  BaseResponse update(@RequestBody FeedbackPhotoUpdateReqDTO updateReqDTO);

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/feedbackPhoto/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/feedbackPhoto/get/{id}")
  ObjectRestResponse<FeedbackPhotoRespDTO> getFeedbackPhotoById(@PathVariable("id") Long id);


  /**
   * 根据条件查找数据
   *
   * @param listQuery 查询参数
   * @return
   */
  @PostMapping("/facade/feedbackPhoto/list")
  ObjectRestResponse<List<FeedbackPhotoRespDTO>> listFeedbackPhotos(
      @RequestBody FeedbackPhotoListQueryReqDTO listQuery);

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/feedbackPhoto/page")
  TableResultResponse<FeedbackPhotoRespDTO> page(@RequestBody FeedbackPhotoPageReqDTO pageReqDTO);

}
