package com.github.xf717.userweb.convert.user;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.dto.UserIntegralRecordCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserIntegralRecordListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserIntegralRecordPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserIntegralRecordRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserIntegralRecordUpdateReqDTO;
import com.github.xf717.userweb.controller.user.dto.UserIntegralRecordAddDTO;
import com.github.xf717.userweb.controller.user.dto.UserIntegralRecordDTO;
import com.github.xf717.userweb.controller.user.dto.UserIntegralRecordPageDTO;
import com.github.xf717.userweb.controller.user.dto.UserIntegralRecordUpdateDTO;
import com.github.xf717.userweb.controller.user.vo.UserIntegralRecordVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换记录用户签到记录信息
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Mapper
public interface UserIntegralRecordConvert {

  UserIntegralRecordConvert INSTANCE = Mappers.getMapper(UserIntegralRecordConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  UserIntegralRecordCreateReqDTO convert(UserIntegralRecordAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  UserIntegralRecordUpdateReqDTO convert(UserIntegralRecordUpdateDTO updateDTO);

  /**
   * 对象转换
   *
   * @param userIntegralRecordDTO 查询参数对象
   * @return
   */
  @Mappings({})
  UserIntegralRecordListQueryReqDTO convert(UserIntegralRecordDTO userIntegralRecordDTO);

  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  UserIntegralRecordVO convert(UserIntegralRecordRespDTO respDTO);

  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<UserIntegralRecordVO> convertList(List<UserIntegralRecordRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserIntegralRecordVO> convert(
      TableResultResponse<UserIntegralRecordRespDTO> tableResultResponse);

  /**
   * 分页对象转换
   *
   * @param pageDTO
   * @return
   */
  @Mappings({})
  UserIntegralRecordPageReqDTO convert(UserIntegralRecordPageDTO pageDTO);

}
