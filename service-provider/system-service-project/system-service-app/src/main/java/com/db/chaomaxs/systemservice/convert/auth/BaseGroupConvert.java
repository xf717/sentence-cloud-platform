package com.db.chaomaxs.systemservice.convert.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.auth.BaseGroupDO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * BaseGroupConvert
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Mapper
public interface BaseGroupConvert {

  BaseGroupConvert INSTANCE = Mappers.getMapper(
      BaseGroupConvert.class);

  /**
   * 将 resourceDTO 转成 resourceVO
   *
   * @param createReqDTO
   * @return
   */
  BaseGroupDO convert(BaseGroupCreateReqDTO createReqDTO);

  /**
   * 将更新转成DO
   *
   * @param updateReqDTO
   * @return
   */
  BaseGroupDO convert(BaseGroupUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<BaseGroupRespDTO> convertList(List<BaseGroupDO> list);

  /**
   * 对象转换
   *
   * @param baseGroupDO
   * @return
   */
  BaseGroupRespDTO convert(BaseGroupDO baseGroupDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<BaseGroupRespDTO> convertPage(IPage<BaseGroupDO> page);


}
