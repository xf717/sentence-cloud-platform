package com.db.chaomaxs.positionservice.convert.position;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.position.UserPositionWantedDO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserPositionWantedConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 16:36:57
 */
@Mapper
public interface UserPositionWantedConvert {

        UserPositionWantedConvert INSTANCE = Mappers.getMapper(UserPositionWantedConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      UserPositionWantedDO convert(UserPositionWantedCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      UserPositionWantedDO convert(UserPositionWantedUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserPositionWantedRespDTO> convertList(List<UserPositionWantedDO> list);

  /**
   * 对象转换
   *
   * @param userPositionWantedDO
   * @return
   */
      UserPositionWantedRespDTO convert(UserPositionWantedDO userPositionWantedDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserPositionWantedRespDTO> convertPage(IPage<UserPositionWantedDO> page);


}
