package com.db.chaomaxs.logservice.convert.login;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.logservice.dal.mysql.dataobject.login.UserLoginLogDO;
import com.db.chaomaxs.logservice.rpc.login.dto.UserLoginLogCreateReqDTO;
import com.db.chaomaxs.logservice.rpc.login.dto.UserLoginLogRespDTO;
import com.db.chaomaxs.logservice.rpc.login.dto.UserLoginLogUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserLoginLogConvert
 *
 * @author xiaofeng
 * @date 2021-04-06 17:48:03
 */
@Mapper
public interface UserLoginLogConvert {

        UserLoginLogConvert INSTANCE = Mappers.getMapper(UserLoginLogConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      UserLoginLogDO convert(UserLoginLogCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      UserLoginLogDO convert(UserLoginLogUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserLoginLogRespDTO> convertList(List<UserLoginLogDO> list);

  /**
   * 对象转换
   *
   * @param userLoginLogDO
   * @return
   */
      UserLoginLogRespDTO convert(UserLoginLogDO userLoginLogDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserLoginLogRespDTO> convertPage(IPage<UserLoginLogDO> page);


}
