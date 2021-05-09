package com.db.chaomaxs.userservice.convert.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserBlacklistDO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBlacklistCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBlacklistRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBlacklistUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserBlacklistConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Mapper
public interface UserBlacklistConvert {

  UserBlacklistConvert INSTANCE = Mappers.getMapper(UserBlacklistConvert.class);

  /**
   * createReq 转换
   *
   * @param createReqDTO
   * @return
   */
  UserBlacklistDO convert(UserBlacklistCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
  UserBlacklistDO convert(UserBlacklistUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserBlacklistRespDTO> convertList(List<UserBlacklistDO> list);

  /**
   * 对象转换
   *
   * @param userBlacklistDO
   * @return
   */
  UserBlacklistRespDTO convert(UserBlacklistDO userBlacklistDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserBlacklistRespDTO> convertPage(IPage<UserBlacklistDO> page);


}
