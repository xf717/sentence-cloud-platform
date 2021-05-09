package com.db.chaomaxs.companyweb.manager.feedback;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoRespDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.facade.FeedbackPhotoRpcFacade;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackPhotoAddDTO;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackPhotoDTO;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackPhotoPageDTO;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackPhotoUpdateDTO;
import com.db.chaomaxs.companyweb.controller.feedback.vo.FeedbackPhotoVO;
import com.db.chaomaxs.companyweb.convert.feedback.FeedbackPhotoConvert;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * FeedbackPhotoManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class FeedbackPhotoManager {

  @Autowired
  private FeedbackPhotoRpcFacade feedbackPhotoRpcFacade;

  /**
   * 添加数据
   *
   * @param feedbackPhotoCreateReqDTO 添加参数
   * @return
   */
  public int save(FeedbackPhotoAddDTO feedbackPhotoAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = feedbackPhotoRpcFacade
        .save(FeedbackPhotoConvert.INSTANCE.convert(feedbackPhotoAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param feedbackPhotoUpdateDTO 更新参数
   * @return
   */
  public int update(FeedbackPhotoUpdateDTO feedbackPhotoUpdateDTO) {
    BaseResponse baseResponse = feedbackPhotoRpcFacade
        .update(FeedbackPhotoConvert.INSTANCE.convert(feedbackPhotoUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = feedbackPhotoRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public FeedbackPhotoVO getFeedbackPhotoById(Long id) {
    ObjectRestResponse<FeedbackPhotoRespDTO> objectRestResponse = feedbackPhotoRpcFacade
        .getFeedbackPhotoById(id);
    objectRestResponse.checkError();
    return FeedbackPhotoConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   *
   * @param feedbackPhotoDTO 查询参数
   * @return
   */
  public List<FeedbackPhotoVO> listFeedbackPhotos(FeedbackPhotoDTO feedbackPhotoDTO) {
    ObjectRestResponse<List<FeedbackPhotoRespDTO>> objectRestResponse = feedbackPhotoRpcFacade
        .listFeedbackPhotos(
            FeedbackPhotoConvert.INSTANCE.convert(feedbackPhotoDTO));
    objectRestResponse.checkError();
    return FeedbackPhotoConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  public TableResultResponse<FeedbackPhotoVO> pageFeedbackPhoto(FeedbackPhotoPageDTO pageReqDTO) {
    TableResultResponse<FeedbackPhotoRespDTO> tableResultResponse = feedbackPhotoRpcFacade
        .page(FeedbackPhotoConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return FeedbackPhotoConvert.INSTANCE.convert(tableResultResponse);
  }


}
