package com.github.xf717.systemservice.dal.mysql.mapper.content;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xf717.mybatis.core.query.QueryWrapperX;
import com.github.xf717.systemservice.dal.mysql.dataobject.content.AgreementInformationExtendDO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendPageReqDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 内容管理-协议信息_扩展息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Repository
public interface AgreementInformationExtendMapper extends BaseMapper<AgreementInformationExtendDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<AgreementInformationExtendDO> selectList(
      AgreementInformationExtendListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<AgreementInformationExtendDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<AgreementInformationExtendDO> selectPage(
      AgreementInformationExtendPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<AgreementInformationExtendDO>());
  }

  /**
   * 根据agreemen_info_id查询数据
   *
   * @param agreemenInfoId
   * @return
   */
  default AgreementInformationExtendDO selectByAgreemenInfoId(Long agreemenInfoId) {
    LambdaQueryWrapper<AgreementInformationExtendDO> queryWrapper = Wrappers.lambdaQuery();
    queryWrapper.eq(AgreementInformationExtendDO::getAgreemenInfoId, agreemenInfoId);
    return selectOne(queryWrapper);
  }

}
