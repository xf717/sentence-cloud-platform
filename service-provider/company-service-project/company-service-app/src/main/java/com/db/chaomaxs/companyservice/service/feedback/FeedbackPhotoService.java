package com.db.chaomaxs.companyservice.service.feedback;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.convert.feedback.FeedbackPhotoConvert;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.feedback.FeedbackPhotoDO;
import com.db.chaomaxs.companyservice.dal.mysql.mapper.feedback.FeedbackPhotoMapper;
import com.db.chaomaxs.companyservice.enums.CompanyErrorCodeConstants;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoRespDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * FeedbackPhotoService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class FeedbackPhotoService {

  @Autowired
  private FeedbackPhotoMapper feedbackPhotoMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveFeedbackPhoto(FeedbackPhotoCreateReqDTO createReqDTO) {
    return feedbackPhotoMapper.insert(FeedbackPhotoConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateFeedbackPhoto(FeedbackPhotoUpdateReqDTO updateReqDTO) {
    FeedbackPhotoDO feedbackPhotoDO = feedbackPhotoMapper.selectById(updateReqDTO.getId());
    if (feedbackPhotoDO == null) {
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
    }
    feedbackPhotoDO = FeedbackPhotoConvert.INSTANCE.convert(updateReqDTO);
    int result = feedbackPhotoMapper.updateById(feedbackPhotoDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteFeedbackPhoto(Long id) {
    if (feedbackPhotoMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = feedbackPhotoMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<FeedbackPhotoRespDTO> listFeedbackPhotos(
      FeedbackPhotoListQueryReqDTO listQueryReqDTO) {
    List<FeedbackPhotoDO> list = feedbackPhotoMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return FeedbackPhotoConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public FeedbackPhotoRespDTO getFeedbackPhotoById(Long id) {
    FeedbackPhotoDO feedbackPhotoDO = feedbackPhotoMapper.selectById(id);
    if (feedbackPhotoDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return FeedbackPhotoConvert.INSTANCE.convert(feedbackPhotoDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<FeedbackPhotoRespDTO> pageFeedbackPhoto(FeedbackPhotoPageReqDTO page) {
    IPage<FeedbackPhotoDO> feedbackPhotoPage = feedbackPhotoMapper.selectPage(page);
    return FeedbackPhotoConvert.INSTANCE.convertPage(feedbackPhotoPage);
  }


}
