package com.github.xf717.userweb.convert.user;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.dto.UserExtendUpdateEnableHideReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyBatchInsertReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyUpdateReqDTO;
import com.github.xf717.userweb.controller.user.dto.UserExtendUpdateEnableHideDTO;
import com.github.xf717.userweb.controller.user.dto.UserHideCompanyAddDTO;
import com.github.xf717.userweb.controller.user.dto.UserHideCompanyBatchInsertDTO;
import com.github.xf717.userweb.controller.user.dto.UserHideCompanyDTO;
import com.github.xf717.userweb.controller.user.dto.UserHideCompanyPageDTO;
import com.github.xf717.userweb.controller.user.dto.UserHideCompanyUpdateDTO;
import com.github.xf717.userweb.controller.user.vo.UserHideCompanyVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换用户_屏蔽公司
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Mapper
public interface UserHideCompanyConvert {

  UserHideCompanyConvert INSTANCE = Mappers.getMapper(UserHideCompanyConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  UserHideCompanyCreateReqDTO convert(UserHideCompanyAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  UserHideCompanyUpdateReqDTO convert(UserHideCompanyUpdateDTO updateDTO);

  /**
   * 对象转换
   *
   * @param userHideCompanyDTO 查询参数对象
   * @return
   */
  @Mappings({})
  UserHideCompanyListQueryReqDTO convert(UserHideCompanyDTO userHideCompanyDTO);

  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  UserHideCompanyVO convert(UserHideCompanyRespDTO respDTO);

  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<UserHideCompanyVO> convertList(List<UserHideCompanyRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserHideCompanyVO> convert(
      TableResultResponse<UserHideCompanyRespDTO> tableResultResponse);

  /**
   * 分页对象转换
   *
   * @param pageDTO
   * @return
   */
  @Mappings({})
  UserHideCompanyPageReqDTO convert(UserHideCompanyPageDTO pageDTO);

  /**
   * UserHideCompanyBatchInsertDTO 转 UserHideCompanyBatchInsertReqDTO
   * @param userHideCompanyBatchInsertDTO 转换对象
   * @return
   */
  @Mappings({})
  UserHideCompanyBatchInsertReqDTO convert(
      UserHideCompanyBatchInsertDTO userHideCompanyBatchInsertDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateEnableHideDTO 转换对象
   * @return
   */
  @Mappings({})
  UserExtendUpdateEnableHideReqDTO convert(UserExtendUpdateEnableHideDTO updateEnableHideDTO);

}
