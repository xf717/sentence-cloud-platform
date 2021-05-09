package com.db.chaomaxs.systemservice.manager.feedback;

import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackImageCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackImageListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackImagePageReqDTO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackImageRespDTO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackImageUpdateReqDTO;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.service.feedback.OpinionFeedbackImageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * OpinionFeedbackImageManager
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@Service
@Validated
public class OpinionFeedbackImageManager {

  @Autowired
  private OpinionFeedbackImageService opinionFeedbackImageService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveOpinionFeedbackImage(OpinionFeedbackImageCreateReqDTO createReqDTO) {
    return opinionFeedbackImageService.saveOpinionFeedbackImage(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateOpinionFeedbackImage(OpinionFeedbackImageUpdateReqDTO updateReqDTO) {
      return opinionFeedbackImageService.updateOpinionFeedbackImage(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteOpinionFeedbackImage(Long id) {
    return opinionFeedbackImageService.deleteOpinionFeedbackImage(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<OpinionFeedbackImageRespDTO> listOpinionFeedbackImages(OpinionFeedbackImageListQueryReqDTO listQueryReqDTO) {
    return opinionFeedbackImageService.listOpinionFeedbackImages(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public OpinionFeedbackImageRespDTO getOpinionFeedbackImageById(Long id) {
    return opinionFeedbackImageService.getOpinionFeedbackImageById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<OpinionFeedbackImageRespDTO> pageOpinionFeedbackImage(OpinionFeedbackImagePageReqDTO page) {
    return opinionFeedbackImageService.pageOpinionFeedbackImage(page);
  }


}
