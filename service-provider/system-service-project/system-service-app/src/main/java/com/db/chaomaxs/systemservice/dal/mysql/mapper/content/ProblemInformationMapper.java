package com.db.chaomaxs.systemservice.dal.mysql.mapper.content;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.content.ProblemInformationDO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationPageReqDTO;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 内容管理-问题信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Repository
public interface ProblemInformationMapper extends BaseMapper<ProblemInformationDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<ProblemInformationDO> selectList(ProblemInformationListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<ProblemInformationDO>());
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<ProblemInformationDO> selectPage(ProblemInformationPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<ProblemInformationDO>());
  }


  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<ProblemInformationDO> findByPage(ProblemInformationPageReqDTO pageReqDTO) {

    LambdaQueryWrapper<ProblemInformationDO> queryWrapperX = Wrappers.lambdaQuery();
    if (null != pageReqDTO.getTitle()) {
      queryWrapperX.like(ProblemInformationDO::getTitle, pageReqDTO.getTitle());
    }
    if (null != pageReqDTO.getTypeDictionaryId()) {
      queryWrapperX.eq(ProblemInformationDO::getTypeDictionaryId, pageReqDTO.getTypeDictionaryId());
    }
    if (null != pageReqDTO.getPlatform()) {
      queryWrapperX.eq(ProblemInformationDO::getPlatform, pageReqDTO.getPlatform());
    }
    if (null != pageReqDTO.getStartTime() && null == pageReqDTO.getEndTime()) {
      queryWrapperX
          .between(ProblemInformationDO::getCreateTime, pageReqDTO.getStartTime(), new Date());
    }
    if (null != pageReqDTO.getEndTime() && null == pageReqDTO.getStartTime()) {
      queryWrapperX
          .between(ProblemInformationDO::getCreateTime, new Date(0), pageReqDTO.getEndTime());
    }
    if (null != pageReqDTO.getStartTime() && null != pageReqDTO.getEndTime()) {
      queryWrapperX
          .between(ProblemInformationDO::getCreateTime, pageReqDTO.getStartTime(),
              pageReqDTO.getEndTime());
    }
    if (null != pageReqDTO.getCreateBy()) {
      queryWrapperX.eq(ProblemInformationDO::getCreateBy, pageReqDTO.getCreateBy());
    }
    if (null != pageReqDTO.getReleaseStatus()) {
      queryWrapperX.eq(ProblemInformationDO::getReleaseStatus, pageReqDTO.getReleaseStatus());
    }
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        queryWrapperX);

  }

}
