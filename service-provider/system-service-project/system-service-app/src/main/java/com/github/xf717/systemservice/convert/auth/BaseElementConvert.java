package com.github.xf717.systemservice.convert.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.dal.mysql.dataobject.auth.BaseElementDO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * BaseElementConvert
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Mapper
public interface BaseElementConvert {

  BaseElementConvert INSTANCE = Mappers.getMapper(
      BaseElementConvert.class);

  /**
   * 将 resourceDTO 转成 resourceVO
   *
   * @param createReqDTO
   * @return
   */
  BaseElementDO convert(BaseElementCreateReqDTO createReqDTO);

  /**
   * 将更新转成DO
   *
   * @param updateReqDTO
   * @return
   */
  BaseElementDO convert(BaseElementUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<BaseElementRespDTO> convertList(List<BaseElementDO> list);

  /**
   * 对象转换
   *
   * @param baseElementDO
   * @return
   */
  BaseElementRespDTO convert(BaseElementDO baseElementDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<BaseElementRespDTO> convertPage(IPage<BaseElementDO> page);


}
