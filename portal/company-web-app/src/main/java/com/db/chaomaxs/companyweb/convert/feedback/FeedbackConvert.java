package com.db.chaomaxs.companyweb.convert.feedback;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackRespDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackUpdateReqDTO;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackAddDTO;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackDTO;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackPageDTO;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackUpdateDTO;
import com.db.chaomaxs.companyweb.controller.feedback.vo.FeedbackVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 应用层实体对象转换帮助与反馈
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface FeedbackConvert {

  FeedbackConvert INSTANCE = Mappers.getMapper(FeedbackConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  FeedbackCreateReqDTO convert(FeedbackAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  FeedbackUpdateReqDTO convert(FeedbackUpdateDTO updateDTO);

  @Mappings({})
  FeedbackListQueryReqDTO convert(FeedbackDTO feedbackDTO);

  /**
   * BO convert VO
   *
   * @param feedbackRespDTO 转换对象
   * @return
   */
  @Mappings({})
  FeedbackVO convert(FeedbackRespDTO feedbackRespDTO);

  @Mappings({})
  List<FeedbackVO> convertList(List<FeedbackRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<FeedbackVO> convert(
      TableResultResponse<FeedbackRespDTO> tableResultResponse);

  @Mappings({})
  FeedbackPageReqDTO convert(FeedbackPageDTO feedbackPageDTO);

}
