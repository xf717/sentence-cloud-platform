package com.db.chaomaxs.companyservice.convert.feedback;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.feedback.FeedbackPhotoDO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoRespDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * FeedbackPhotoConvert
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface FeedbackPhotoConvert {

  FeedbackPhotoConvert INSTANCE = Mappers.getMapper(FeedbackPhotoConvert.class);

  /**
   * 将 FeedbackPhotoDTO 转成 FeedbackPhotoVO
   *
   * @param createReqDTO
   * @return
   */
  FeedbackPhotoDO convert(FeedbackPhotoCreateReqDTO createReqDTO);

  /**
   * 将更新转成DO
   *
   * @param updateReqDTO
   * @return
   */
  FeedbackPhotoDO convert(FeedbackPhotoUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<FeedbackPhotoRespDTO> convertList(List<FeedbackPhotoDO> list);

  /**
   * 对象转换
   *
   * @param feedbackPhotoDO
   * @return
   */
  FeedbackPhotoRespDTO convert(FeedbackPhotoDO feedbackPhotoDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<FeedbackPhotoRespDTO> convertPage(IPage<FeedbackPhotoDO> page);


}
