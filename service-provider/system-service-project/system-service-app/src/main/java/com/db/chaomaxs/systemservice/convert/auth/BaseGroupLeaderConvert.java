package com.db.chaomaxs.systemservice.convert.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.auth.BaseGroupLeaderDO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * BaseGroupLeaderConvert
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Mapper
public interface BaseGroupLeaderConvert {

  BaseGroupLeaderConvert INSTANCE = Mappers.getMapper(
      BaseGroupLeaderConvert.class);

  /**
   * 将 resourceDTO 转成 resourceVO
   *
   * @param createReqDTO
   * @return
   */
  BaseGroupLeaderDO convert(BaseGroupLeaderCreateReqDTO createReqDTO);

  /**
   * 将更新转成DO
   *
   * @param updateReqDTO
   * @return
   */
  BaseGroupLeaderDO convert(BaseGroupLeaderUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<BaseGroupLeaderRespDTO> convertList(List<BaseGroupLeaderDO> list);

  /**
   * 对象转换
   *
   * @param baseGroupLeaderDO
   * @return
   */
  BaseGroupLeaderRespDTO convert(BaseGroupLeaderDO baseGroupLeaderDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<BaseGroupLeaderRespDTO> convertPage(IPage<BaseGroupLeaderDO> page);


}
