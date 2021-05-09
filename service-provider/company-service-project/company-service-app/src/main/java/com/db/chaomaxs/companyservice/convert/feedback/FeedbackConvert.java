package com.db.chaomaxs.companyservice.convert.feedback;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.feedback.FeedbackDO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackRespDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * FeedbackConvert
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface FeedbackConvert {

  FeedbackConvert INSTANCE = Mappers.getMapper(FeedbackConvert.class);

  /**
   * 将 FeedbackDTO 转成 FeedbackVO
   *
   * @param createReqDTO
   * @return
   */
  FeedbackDO convert(FeedbackCreateReqDTO createReqDTO);

  /**
   * 将更新转成DO
   *
   * @param updateReqDTO
   * @return
   */
  FeedbackDO convert(FeedbackUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<FeedbackRespDTO> convertList(List<FeedbackDO> list);

  /**
   * 对象转换
   *
   * @param feedbackDO
   * @return
   */
  FeedbackRespDTO convert(FeedbackDO feedbackDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<FeedbackRespDTO> convertPage(IPage<FeedbackDO> page);


}
