package com.github.xf717.userweb.convert.user;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.dto.UserWordCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserWordListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserWordPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserWordRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserWordUpdateReqDTO;
import com.github.xf717.userweb.controller.user.dto.UserWordAddDTO;
import com.github.xf717.userweb.controller.user.dto.UserWordDTO;
import com.github.xf717.userweb.controller.user.dto.UserWordPageDTO;
import com.github.xf717.userweb.controller.user.dto.UserWordUpdateDTO;
import com.github.xf717.userweb.controller.user.vo.UserWordVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换用户_常用语
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Mapper
public interface UserWordConvert {

  UserWordConvert INSTANCE = Mappers.getMapper(UserWordConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  UserWordCreateReqDTO convert(UserWordAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  UserWordUpdateReqDTO convert(UserWordUpdateDTO updateDTO);

  /**
   * 对象转换
   *
   * @param userWordDTO 查询参数对象
   * @return
   */
  @Mappings({})
  UserWordListQueryReqDTO convert(UserWordDTO userWordDTO);

  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  UserWordVO convert(UserWordRespDTO respDTO);

  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<UserWordVO> convertList(List<UserWordRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserWordVO> convert(
      TableResultResponse<UserWordRespDTO> tableResultResponse);

  /**
   * 分页对象转换
   *
   * @param pageDTO
   * @return
   */
  @Mappings({})
  UserWordPageReqDTO convert(UserWordPageDTO pageDTO);

}
