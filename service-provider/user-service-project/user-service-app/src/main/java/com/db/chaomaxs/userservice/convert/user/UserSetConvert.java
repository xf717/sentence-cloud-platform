package com.db.chaomaxs.userservice.convert.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserSetDO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserSetCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserSetRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserSetUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserSetConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Mapper
public interface UserSetConvert {

        UserSetConvert INSTANCE = Mappers.getMapper(UserSetConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      UserSetDO convert(UserSetCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      UserSetDO convert(UserSetUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserSetRespDTO> convertList(List<UserSetDO> list);

  /**
   * 对象转换
   *
   * @param userSetDO
   * @return
   */
      UserSetRespDTO convert(UserSetDO userSetDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserSetRespDTO> convertPage(IPage<UserSetDO> page);


}
