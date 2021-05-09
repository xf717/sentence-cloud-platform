package com.github.xf717.systemservice.convert.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.dal.mysql.dataobject.auth.BaseMenuDO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseMenuCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseMenuRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseMenuUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * BaseMenuConvert
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Mapper
public interface BaseMenuConvert {

  BaseMenuConvert INSTANCE = Mappers.getMapper(
      BaseMenuConvert.class);

  /**
   * 将 resourceDTO 转成 resourceVO
   *
   * @param createReqDTO
   * @return
   */
  BaseMenuDO convert(BaseMenuCreateReqDTO createReqDTO);

  /**
   * 将更新转成DO
   *
   * @param updateReqDTO
   * @return
   */
  BaseMenuDO convert(BaseMenuUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<BaseMenuRespDTO> convertList(List<BaseMenuDO> list);

  /**
   * 对象转换
   *
   * @param baseMenuDO
   * @return
   */
  BaseMenuRespDTO convert(BaseMenuDO baseMenuDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<BaseMenuRespDTO> convertPage(IPage<BaseMenuDO> page);


}
