package com.github.xf717.userweb.convert.user;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.dto.UserSetCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserSetListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserSetPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserSetRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserSetUpdateReqDTO;
import com.github.xf717.userweb.controller.user.dto.UserSetAddDTO;
import com.github.xf717.userweb.controller.user.dto.UserSetDTO;
import com.github.xf717.userweb.controller.user.dto.UserSetPageDTO;
import com.github.xf717.userweb.controller.user.dto.UserSetUpdateDTO;
import com.github.xf717.userweb.controller.user.vo.UserSetVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换用户_设置
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Mapper
public interface UserSetConvert {

  UserSetConvert INSTANCE = Mappers.getMapper(UserSetConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  UserSetCreateReqDTO convert(UserSetAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  UserSetUpdateReqDTO convert(UserSetUpdateDTO updateDTO);

  /**
   * 对象转换
   *
   * @param userSetDTO 查询参数对象
   * @return
   */
  @Mappings({})
  UserSetListQueryReqDTO convert(UserSetDTO userSetDTO);

  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  UserSetVO convert(UserSetRespDTO respDTO);

  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<UserSetVO> convertList(List<UserSetRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserSetVO> convert(
      TableResultResponse<UserSetRespDTO> tableResultResponse);

  /**
   * 分页对象转换
   *
   * @param pageDTO
   * @return
   */
  @Mappings({})
  UserSetPageReqDTO convert(UserSetPageDTO pageDTO);

}
