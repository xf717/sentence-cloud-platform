package com.db.chaomaxs.systemservice.convert.feedback;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.feedback.OpinionFeedbackDO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackRespDTO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * OpinionFeedbackConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@Mapper
public interface OpinionFeedbackConvert {

        OpinionFeedbackConvert INSTANCE = Mappers.getMapper(OpinionFeedbackConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      OpinionFeedbackDO convert(OpinionFeedbackCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      OpinionFeedbackDO convert(OpinionFeedbackUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<OpinionFeedbackRespDTO> convertList(List<OpinionFeedbackDO> list);

  /**
   * 对象转换
   *
   * @param opinionFeedbackDO
   * @return
   */
      OpinionFeedbackRespDTO convert(OpinionFeedbackDO opinionFeedbackDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<OpinionFeedbackRespDTO> convertPage(IPage<OpinionFeedbackDO> page);


}
