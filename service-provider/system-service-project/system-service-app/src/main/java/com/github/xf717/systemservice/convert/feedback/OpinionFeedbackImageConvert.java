package com.github.xf717.systemservice.convert.feedback;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.dal.mysql.dataobject.feedback.OpinionFeedbackImageDO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackImageCreateReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackImageRespDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackImageUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * OpinionFeedbackImageConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@Mapper
public interface OpinionFeedbackImageConvert {

        OpinionFeedbackImageConvert INSTANCE = Mappers.getMapper(OpinionFeedbackImageConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      OpinionFeedbackImageDO convert(OpinionFeedbackImageCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      OpinionFeedbackImageDO convert(OpinionFeedbackImageUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<OpinionFeedbackImageRespDTO> convertList(List<OpinionFeedbackImageDO> list);

  /**
   * 对象转换
   *
   * @param opinionFeedbackImageDO
   * @return
   */
      OpinionFeedbackImageRespDTO convert(OpinionFeedbackImageDO opinionFeedbackImageDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<OpinionFeedbackImageRespDTO> convertPage(IPage<OpinionFeedbackImageDO> page);


}
