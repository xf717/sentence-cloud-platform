package com.github.xf717.systemservice.convert.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.dal.mysql.dataobject.auth.BaseResourceAuthorityDO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * BaseResourceAuthorityConvert
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Mapper
public interface BaseResourceAuthorityConvert {

  BaseResourceAuthorityConvert INSTANCE = Mappers.getMapper(
      BaseResourceAuthorityConvert.class);

  /**
   * 将 resourceDTO 转成 resourceVO
   *
   * @param createReqDTO
   * @return
   */
  BaseResourceAuthorityDO convert(BaseResourceAuthorityCreateReqDTO createReqDTO);

  /**
   * 将更新转成DO
   *
   * @param updateReqDTO
   * @return
   */
  BaseResourceAuthorityDO convert(BaseResourceAuthorityUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<BaseResourceAuthorityRespDTO> convertList(List<BaseResourceAuthorityDO> list);

  /**
   * 对象转换
   *
   * @param baseResourceAuthorityDO
   * @return
   */
  BaseResourceAuthorityRespDTO convert(BaseResourceAuthorityDO baseResourceAuthorityDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<BaseResourceAuthorityRespDTO> convertPage(IPage<BaseResourceAuthorityDO> page);


}
