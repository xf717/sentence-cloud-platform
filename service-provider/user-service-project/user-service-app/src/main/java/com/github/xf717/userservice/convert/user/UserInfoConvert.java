package com.github.xf717.userservice.convert.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserInfoDO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPersonalInfoRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPersonalInfoUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserInfoConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Mapper
public interface UserInfoConvert {

  UserInfoConvert INSTANCE = Mappers.getMapper(UserInfoConvert.class);

  /**
   * createReq 转换
   *
   * @param createReqDTO
   * @return
   */
  UserInfoDO convert(UserInfoCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
  UserInfoDO convert(UserInfoUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserInfoRespDTO> convertList(List<UserInfoDO> list);

  /**
   * 对象转换
   *
   * @param userInfoDO
   * @return
   */
  UserInfoRespDTO convert(UserInfoDO userInfoDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserInfoRespDTO> convertPage(IPage<UserInfoDO> page);

  /**
   * updateReq 转换
   *
   * @param personalInfoUpdateReqDTO
   * @return
   */
  UserInfoDO convertPersonalInfo(UserPersonalInfoUpdateReqDTO personalInfoUpdateReqDTO);

  /**
   * userPersonalInfoDO 转换
   * @param userPersonalInfoDO
   * @return
   */
  UserPersonalInfoRespDTO convert(UserPersonalInfoDO userPersonalInfoDO);

  /**
   * list 转换
   *
   * @param personalInfoDOList
   * @return
   */
  List<UserPersonalInfoRespDTO> convertPersonalList(List<UserPersonalInfoDO> personalInfoDOList);
}
