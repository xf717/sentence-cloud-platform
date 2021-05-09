package com.github.xf717.userweb.convert.user;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.companyservice.rpc.track.dto.CompanyUserTrackPageReqDTO;
import com.github.xf717.userweb.controller.user.dto.UserTrackAddDTO;
import com.github.xf717.userweb.controller.user.dto.UserTrackDTO;
import com.github.xf717.userweb.controller.user.dto.UserTrackPageDTO;
import com.github.xf717.userweb.controller.user.vo.UserPositionCollectVO;
import com.github.xf717.userweb.controller.user.vo.UserTrackVO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换我的足迹
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Mapper
public interface UserTrackConvert {

  UserTrackConvert INSTANCE = Mappers.getMapper(UserTrackConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  UserTrackCreateReqDTO convert(UserTrackAddDTO addDTO);


  /**
   * 对象转换
   *
   * @param userTrackDTO 查询参数对象
   * @return
   */
  @Mappings({})
  UserTrackListQueryReqDTO convert(UserTrackDTO userTrackDTO);

  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  UserTrackVO convert(UserTrackRespDTO respDTO);

  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<UserTrackVO> convertList(List<UserTrackRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserTrackVO> convert(
      TableResultResponse<UserTrackRespDTO> tableResultResponse);

  /**
   * 分页对象转换
   *
   * @param pageDTO
   * @return
   */
  @Mappings({})
  UserTrackPageReqDTO convert(UserTrackPageDTO pageDTO);

  /**
   * 分页转换 UserPositionCollectVO
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserPositionCollectVO> convertPosition(
      TableResultResponse<UserTrackRespDTO> tableResultResponse);

  /**
   * 对象转换 CompanyUserTrackPageReqDTO
   *
   * @param userTrackPageDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyUserTrackPageReqDTO convertCompanyUserTrack(UserTrackPageDTO userTrackPageDTO);
}
