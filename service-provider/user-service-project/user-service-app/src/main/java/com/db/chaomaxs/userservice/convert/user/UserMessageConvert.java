package com.db.chaomaxs.userservice.convert.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserMessageDO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessageCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessageRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessageUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserMessageConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Mapper
public interface UserMessageConvert {

        UserMessageConvert INSTANCE = Mappers.getMapper(UserMessageConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      UserMessageDO convert(UserMessageCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      UserMessageDO convert(UserMessageUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserMessageRespDTO> convertList(List<UserMessageDO> list);

  /**
   * 对象转换
   *
   * @param userMessageDO
   * @return
   */
      UserMessageRespDTO convert(UserMessageDO userMessageDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserMessageRespDTO> convertPage(IPage<UserMessageDO> page);


}
