package com.db.chaomaxs.systemservice.convert.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.auth.BaseUserDO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * BaseUserConvert
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Mapper
public interface BaseUserConvert {

  BaseUserConvert INSTANCE = Mappers.getMapper(
      BaseUserConvert.class);

  /**
   * 将 resourceDTO 转成 resourceVO
   *
   * @param createReqDTO
   * @return
   */
  BaseUserDO convert(BaseUserCreateReqDTO createReqDTO);

  /**
   * 将更新转成DO
   *
   * @param updateReqDTO
   * @return
   */
  BaseUserDO convert(BaseUserUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<BaseUserRespDTO> convertList(List<BaseUserDO> list);

  /**
   * 对象转换
   *
   * @param baseUserDO
   * @return
   */
  BaseUserRespDTO convert(BaseUserDO baseUserDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<BaseUserRespDTO> convertPage(IPage<BaseUserDO> page);


}
