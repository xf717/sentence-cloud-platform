package com.github.xf717.userservice.convert.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserExtendDO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendDetailRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendUpdateEnableHideReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPersonalInfoUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserRecruitUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserExtendConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Mapper
public interface UserExtendConvert {

  UserExtendConvert INSTANCE = Mappers.getMapper(UserExtendConvert.class);

  /**
   * createReq 转换
   *
   * @param createReqDTO
   * @return
   */
  UserExtendDO convert(UserExtendCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
  UserExtendDO convert(UserExtendUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserExtendRespDTO> convertList(List<UserExtendDO> list);

  /**
   * 对象转换
   *
   * @param userExtendDO
   * @return
   */
  UserExtendRespDTO convert(UserExtendDO userExtendDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserExtendRespDTO> convertPage(IPage<UserExtendDO> page);


  /**
   * updateReq 转换
   *
   * @param personalInfoUpdateReqDTO
   * @return
   */
  UserExtendDO convertPersonalInfo(UserPersonalInfoUpdateReqDTO personalInfoUpdateReqDTO);


  /**
   * updateEnableHideReqDTO 转换
   *
   * @param updateEnableHideReqDTO
   * @return
   */
  UserExtendDO convert(UserExtendUpdateEnableHideReqDTO updateEnableHideReqDTO);

  /**
   * updateEnableHideReqDTO 转换
   *
   * @param userRecruitUpdateReqDTO
   * @return
   */
  UserExtendDO convert(UserRecruitUpdateReqDTO userRecruitUpdateReqDTO);

  /**
   * userExtendResp 转换
   * @param userExtendResp
   * @return
   */
  UserExtendDetailRespDTO convert(UserExtendRespDTO userExtendResp);


  /**
   * userInfo转换
   * @param userInfo
   * @return
   */
  UserExtendDetailRespDTO convert(UserInfoRespDTO userInfo);
}
