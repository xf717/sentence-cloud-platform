package com.db.chaomaxs.userservice.convert.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserChatDO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserChatCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserChatRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserChatUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserChatConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Mapper
public interface UserChatConvert {

        UserChatConvert INSTANCE = Mappers.getMapper(UserChatConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      UserChatDO convert(UserChatCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      UserChatDO convert(UserChatUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserChatRespDTO> convertList(List<UserChatDO> list);

  /**
   * 对象转换
   *
   * @param userChatDO
   * @return
   */
      UserChatRespDTO convert(UserChatDO userChatDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserChatRespDTO> convertPage(IPage<UserChatDO> page);


}
