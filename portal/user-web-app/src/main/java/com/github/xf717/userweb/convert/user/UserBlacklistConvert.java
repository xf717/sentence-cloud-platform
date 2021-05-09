package com.github.xf717.userweb.convert.user;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.dto.UserBlacklistCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBlacklistListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBlacklistPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBlacklistRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBlacklistUpdateReqDTO;
import com.github.xf717.userweb.controller.user.dto.UserBlacklistAddDTO;
import com.github.xf717.userweb.controller.user.dto.UserBlacklistDTO;
import com.github.xf717.userweb.controller.user.dto.UserBlacklistPageDTO;
import com.github.xf717.userweb.controller.user.dto.UserBlacklistUpdateDTO;
import com.github.xf717.userweb.controller.user.vo.UserBlacklistVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换用户_黑名单
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Mapper
public interface UserBlacklistConvert {

  UserBlacklistConvert INSTANCE = Mappers.getMapper(UserBlacklistConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  UserBlacklistCreateReqDTO convert(UserBlacklistAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  UserBlacklistUpdateReqDTO convert(UserBlacklistUpdateDTO updateDTO);

  /**
   * 对象转换
   *
   * @param userBlacklistDTO 查询参数对象
   * @return
   */
  @Mappings({})
  UserBlacklistListQueryReqDTO convert(UserBlacklistDTO userBlacklistDTO);

  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  UserBlacklistVO convert(UserBlacklistRespDTO respDTO);

  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<UserBlacklistVO> convertList(List<UserBlacklistRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserBlacklistVO> convert(
      TableResultResponse<UserBlacklistRespDTO> tableResultResponse);

  /**
   * 分页对象转换
   *
   * @param pageDTO
   * @return
   */
  @Mappings({})
  UserBlacklistPageReqDTO convert(UserBlacklistPageDTO pageDTO);

}
