package com.github.xf717.userweb.convert.user;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.dto.UserMessageCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserMessageListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserMessagePageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserMessageRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserMessageUpdateReqDTO;
import com.github.xf717.userweb.controller.user.dto.UserMessageAddDTO;
import com.github.xf717.userweb.controller.user.dto.UserMessageDTO;
import com.github.xf717.userweb.controller.user.dto.UserMessagePageDTO;
import com.github.xf717.userweb.controller.user.dto.UserMessageUpdateDTO;
import com.github.xf717.userweb.controller.user.vo.UserMessageVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换用户消息表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Mapper
public interface UserMessageConvert {

  UserMessageConvert INSTANCE = Mappers.getMapper(UserMessageConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  UserMessageCreateReqDTO convert(UserMessageAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  UserMessageUpdateReqDTO convert(UserMessageUpdateDTO updateDTO);

  /**
   * 对象转换
   *
   * @param userMessageDTO 查询参数对象
   * @return
   */
  @Mappings({})
  UserMessageListQueryReqDTO convert(UserMessageDTO userMessageDTO);

  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  UserMessageVO convert(UserMessageRespDTO respDTO);

  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<UserMessageVO> convertList(List<UserMessageRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserMessageVO> convert(
      TableResultResponse<UserMessageRespDTO> tableResultResponse);

  /**
   * 分页对象转换
   *
   * @param pageDTO
   * @return
   */
  @Mappings({})
  UserMessagePageReqDTO convert(UserMessagePageDTO pageDTO);

}
