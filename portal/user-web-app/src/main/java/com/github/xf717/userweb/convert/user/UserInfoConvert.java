package com.github.xf717.userweb.convert.user;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.logservice.rpc.login.dto.UserLoginLogCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPersonalInfoRespDTO;
import com.github.xf717.userweb.controller.user.dto.UserInfoAddDTO;
import com.github.xf717.userweb.controller.user.dto.UserInfoDTO;
import com.github.xf717.userweb.controller.user.dto.UserInfoPageDTO;
import com.github.xf717.userweb.controller.user.dto.UserInfoUpdateDTO;
import com.github.xf717.userweb.controller.user.dto.UserLoginDTO;
import com.github.xf717.userweb.controller.user.vo.UserInfoVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换用户_帐号信息
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Mapper
public interface UserInfoConvert {

  UserInfoConvert INSTANCE = Mappers.getMapper(UserInfoConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  UserInfoCreateReqDTO convert(UserInfoAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  UserInfoUpdateReqDTO convert(UserInfoUpdateDTO updateDTO);

  /**
   * 对象转换
   *
   * @param userInfoDTO 查询参数对象
   * @return
   */
  @Mappings({})
  UserInfoListQueryReqDTO convert(UserInfoDTO userInfoDTO);

  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  UserInfoVO convert(UserInfoRespDTO respDTO);

  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<UserInfoVO> convertList(List<UserInfoRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserInfoVO> convert(
      TableResultResponse<UserInfoRespDTO> tableResultResponse);

  /**
   * 分页对象转换
   *
   * @param pageDTO
   * @return
   */
  @Mappings({})
  UserInfoPageReqDTO convert(UserInfoPageDTO pageDTO);

  /**
   * 对象转换
   *
   * @param userLoginDTO 转换对象
   * @return
   */
  @Mappings({})
  UserLoginLogCreateReqDTO convert(UserLoginDTO userLoginDTO);

  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  UserInfoVO convert(UserPersonalInfoRespDTO respDTO);


}
