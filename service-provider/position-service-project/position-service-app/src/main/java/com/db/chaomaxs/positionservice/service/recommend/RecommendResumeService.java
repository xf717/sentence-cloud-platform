package com.db.chaomaxs.positionservice.service.recommend;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.convert.recommend.RecommendResumeConvert;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.recommend.RecommendResumeDO;
import com.db.chaomaxs.positionservice.dal.mysql.mapper.recommend.RecommendResumeMapper;
import com.db.chaomaxs.positionservice.enums.PositionErrorCodeConstants;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumePageReqDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeRespDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * RecommendResumeService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class RecommendResumeService {

  @Autowired
  private RecommendResumeMapper recommendResumeMapper;

  /**
  * 保存数据
* @param createReqDTO
* @return
*/
  public int saveRecommendResume(RecommendResumeCreateReqDTO createReqDTO) {
    return recommendResumeMapper.insert(RecommendResumeConvert.INSTANCE.convert(createReqDTO));
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateRecommendResume(RecommendResumeUpdateReqDTO updateReqDTO) {
          RecommendResumeDO recommendResumeDO = recommendResumeMapper.selectById(updateReqDTO.getId());
    if (recommendResumeDO == null) {
      throw ServiceExceptionUtil
          .exception(PositionErrorCodeConstants.NOT_EXISTS.getCode());
    }
          recommendResumeDO = RecommendResumeConvert.INSTANCE.convert(updateReqDTO);
    int result = recommendResumeMapper.updateById(recommendResumeDO);
    return result;
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteRecommendResume(Long id) {
    if (recommendResumeMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(PositionErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = recommendResumeMapper.deleteById(id);
    return result;
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<RecommendResumeRespDTO> listRecommendResumes(RecommendResumeListQueryReqDTO listQueryReqDTO) {
    List<RecommendResumeDO> list = recommendResumeMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return RecommendResumeConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public RecommendResumeRespDTO getRecommendResumeById(Long id) {
          RecommendResumeDO recommendResumeDO = recommendResumeMapper.selectById(id);
    if (recommendResumeDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(PositionErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return RecommendResumeConvert.INSTANCE.convert(recommendResumeDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<RecommendResumeRespDTO> pageRecommendResume(RecommendResumePageReqDTO page) {
    IPage<RecommendResumeDO> recommendResumePage = recommendResumeMapper.selectPage(page);
    return RecommendResumeConvert.INSTANCE.convertPage(recommendResumePage);
  }


}
