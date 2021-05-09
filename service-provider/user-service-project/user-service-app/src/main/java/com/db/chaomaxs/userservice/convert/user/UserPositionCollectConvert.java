package com.db.chaomaxs.userservice.convert.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserPositionCollectDO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPositionCollectCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPositionCollectRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPositionCollectUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserPositionCollectConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Mapper
public interface UserPositionCollectConvert {

        UserPositionCollectConvert INSTANCE = Mappers.getMapper(UserPositionCollectConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      UserPositionCollectDO convert(UserPositionCollectCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      UserPositionCollectDO convert(UserPositionCollectUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserPositionCollectRespDTO> convertList(List<UserPositionCollectDO> list);

  /**
   * 对象转换
   *
   * @param userPositionCollectDO
   * @return
   */
      UserPositionCollectRespDTO convert(UserPositionCollectDO userPositionCollectDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserPositionCollectRespDTO> convertPage(IPage<UserPositionCollectDO> page);


}
