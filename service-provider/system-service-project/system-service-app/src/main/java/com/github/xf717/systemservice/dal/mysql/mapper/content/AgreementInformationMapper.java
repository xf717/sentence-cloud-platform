package com.github.xf717.systemservice.dal.mysql.mapper.content;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xf717.mybatis.core.query.QueryWrapperX;
import com.github.xf717.systemservice.dal.mysql.dataobject.content.AgreementInformationDO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationPageReqDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 内容管理-协议信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Repository
public interface AgreementInformationMapper extends BaseMapper<AgreementInformationDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<AgreementInformationDO> selectList(AgreementInformationListQueryReqDTO listReqDTO) {
    LambdaQueryWrapper<AgreementInformationDO> queryWrapper = Wrappers.lambdaQuery();
    return selectList(queryWrapper);
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<AgreementInformationDO> selectPage(AgreementInformationPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<AgreementInformationDO>());
  }


  /**
   * 根据code查询数据
   *
   * @param code
   * @return
   */
  default AgreementInformationDO selectByCode(String code) {
    LambdaQueryWrapper<AgreementInformationDO> queryWrapper = Wrappers.lambdaQuery();
    queryWrapper.eq(AgreementInformationDO::getCode, code);
    return selectOne(queryWrapper);
  }

}
