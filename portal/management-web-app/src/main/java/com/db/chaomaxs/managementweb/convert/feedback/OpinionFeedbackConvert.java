package com.db.chaomaxs.managementweb.convert.feedback;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import java.util.List;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackRespDTO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackUpdateReqDTO;
import com.db.chaomaxs.managementweb.controller.feedback.dto.OpinionFeedbackAddDTO;
import com.db.chaomaxs.managementweb.controller.feedback.dto.OpinionFeedbackDTO;
import com.db.chaomaxs.managementweb.controller.feedback.dto.OpinionFeedbackPageDTO;
import com.db.chaomaxs.managementweb.controller.feedback.dto.OpinionFeedbackUpdateDTO;
import com.db.chaomaxs.managementweb.controller.feedback.vo.OpinionFeedbackVO;


/**
 * 应用层实体对象转换意见反馈信息表
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
* UpdateDTO convert UpdateBO
*
* @param updateDTO 转换对象
* @return
*/
  @Mappings({})
      OpinionFeedbackUpdateReqDTO convert(OpinionFeedbackUpdateDTO updateDTO);

  /**
   *  对象转换
   * @param opinionFeedbackDTO 查询参数对象
   * @return
   */
  @Mappings({})
      OpinionFeedbackListQueryReqDTO convert(OpinionFeedbackDTO opinionFeedbackDTO);

  /**
   *  对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
      OpinionFeedbackVO convert(OpinionFeedbackRespDTO respDTO);

  /**
  * list 转换成 VO list
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

  /**
  *  分页对象转换
* @param pageDTO
* @return
*/
  @Mappings({})
      OpinionFeedbackPageReqDTO convert(OpinionFeedbackPageDTO pageDTO);

}
