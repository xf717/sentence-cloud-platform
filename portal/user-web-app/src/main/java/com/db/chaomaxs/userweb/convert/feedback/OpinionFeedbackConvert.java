package com.db.chaomaxs.userweb.convert.feedback;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.userweb.controller.feedback.dto.OpinionFeedbackAddDTO;
import com.db.chaomaxs.userweb.controller.feedback.vo.OpinionFeedbackVO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackRespDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换意见反馈信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@Mapper
public interface OpinionFeedbackConvert {

  OpinionFeedbackConvert INSTANCE = Mappers.getMapper(OpinionFeedbackConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  OpinionFeedbackCreateReqDTO convert(OpinionFeedbackAddDTO addDTO);


  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  OpinionFeedbackVO convert(OpinionFeedbackRespDTO respDTO);

  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<OpinionFeedbackVO> convertList(List<OpinionFeedbackRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<OpinionFeedbackVO> convert(
      TableResultResponse<OpinionFeedbackRespDTO> tableResultResponse);


}
