package com.db.chaomaxs.companyweb.convert.feedback;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoRespDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoUpdateReqDTO;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackPhotoAddDTO;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackPhotoDTO;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackPhotoPageDTO;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackPhotoUpdateDTO;
import com.db.chaomaxs.companyweb.controller.feedback.vo.FeedbackPhotoVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 应用层实体对象转换帮助与反馈_图片说明
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface FeedbackPhotoConvert {

  FeedbackPhotoConvert INSTANCE = Mappers.getMapper(FeedbackPhotoConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  FeedbackPhotoCreateReqDTO convert(FeedbackPhotoAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  FeedbackPhotoUpdateReqDTO convert(FeedbackPhotoUpdateDTO updateDTO);

  @Mappings({})
  FeedbackPhotoListQueryReqDTO convert(FeedbackPhotoDTO feedbackPhotoDTO);

  /**
   * BO convert VO
   *
   * @param feedbackPhotoRespDTO 转换对象
   * @return
   */
  @Mappings({})
  FeedbackPhotoVO convert(FeedbackPhotoRespDTO feedbackPhotoRespDTO);

  @Mappings({})
  List<FeedbackPhotoVO> convertList(List<FeedbackPhotoRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<FeedbackPhotoVO> convert(
      TableResultResponse<FeedbackPhotoRespDTO> tableResultResponse);

  @Mappings({})
  FeedbackPhotoPageReqDTO convert(FeedbackPhotoPageDTO feedbackPhotoPageDTO);

}
