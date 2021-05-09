package com.db.chaomaxs.positionservice.convert.recommend;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.recommend.RecommendResumeDO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeRespDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * RecommendResumeConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 17:09:31
 */
@Mapper
public interface RecommendResumeConvert {

        RecommendResumeConvert INSTANCE = Mappers.getMapper(RecommendResumeConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      RecommendResumeDO convert(RecommendResumeCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      RecommendResumeDO convert(RecommendResumeUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<RecommendResumeRespDTO> convertList(List<RecommendResumeDO> list);

  /**
   * 对象转换
   *
   * @param recommendResumeDO
   * @return
   */
      RecommendResumeRespDTO convert(RecommendResumeDO recommendResumeDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<RecommendResumeRespDTO> convertPage(IPage<RecommendResumeDO> page);


}
