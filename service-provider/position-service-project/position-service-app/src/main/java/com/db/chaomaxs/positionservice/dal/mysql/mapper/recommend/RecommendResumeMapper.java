package com.db.chaomaxs.positionservice.dal.mysql.mapper.recommend;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.recommend.RecommendResumeDO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumePageReqDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 推荐人才简历
 *
 * @author xiaofeng
 * @date 2021-03-29 17:09:31
 */
@Repository
public interface RecommendResumeMapper extends BaseMapper<RecommendResumeDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<RecommendResumeDO> selectList(RecommendResumeListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<RecommendResumeDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<RecommendResumeDO> selectPage(RecommendResumePageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<RecommendResumeDO>());
  }

}
