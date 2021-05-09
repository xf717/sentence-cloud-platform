package com.db.chaomaxs.positionservice.manager.recommend;

import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumePageReqDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeRespDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeUpdateReqDTO;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.service.recommend.RecommendResumeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * RecommendResumeManager
 *
 * @author xiaofeng
 * @date 2021-03-29 17:09:31
 */
@Service
@Validated
public class RecommendResumeManager {

  @Autowired
  private RecommendResumeService recommendResumeService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveRecommendResume(RecommendResumeCreateReqDTO createReqDTO) {
    return recommendResumeService.saveRecommendResume(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateRecommendResume(RecommendResumeUpdateReqDTO updateReqDTO) {
      return recommendResumeService.updateRecommendResume(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteRecommendResume(Long id) {
    return recommendResumeService.deleteRecommendResume(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<RecommendResumeRespDTO> listRecommendResumes(RecommendResumeListQueryReqDTO listQueryReqDTO) {
    return recommendResumeService.listRecommendResumes(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public RecommendResumeRespDTO getRecommendResumeById(Long id) {
    return recommendResumeService.getRecommendResumeById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<RecommendResumeRespDTO> pageRecommendResume(RecommendResumePageReqDTO page) {
    return recommendResumeService.pageRecommendResume(page);
  }


}
