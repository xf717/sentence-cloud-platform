package com.github.xf717.systemservice.dal.mysql.mapper.content;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xf717.mybatis.core.query.QueryWrapperX;
import com.github.xf717.systemservice.dal.mysql.dataobject.content.ProblemInformationExtendDO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationExtendListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationExtendPageReqDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 内容管理-问题扩展信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Repository
public interface ProblemInformationExtendMapper extends BaseMapper<ProblemInformationExtendDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<ProblemInformationExtendDO> selectList(
      ProblemInformationExtendListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<ProblemInformationExtendDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<ProblemInformationExtendDO> selectPage(
      ProblemInformationExtendPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<ProblemInformationExtendDO>());
  }


  /**
   * 根据参数查询数据
   *
   * @param problemInfoId
   * @return
   */
  default ProblemInformationExtendDO getByProblemInfoId(
      Long problemInfoId) {
    LambdaQueryWrapper<ProblemInformationExtendDO> queryWrapper = Wrappers.lambdaQuery();
    queryWrapper.eq(ProblemInformationExtendDO::getProblemInfoId,problemInfoId);
    return selectOne(queryWrapper);
  }

  /**
   * 根据problemInfoId软删除数据
   * @param problemInfoId
   * @return
   */
  int deleteByProblemInfoId(Long problemInfoId);

}
