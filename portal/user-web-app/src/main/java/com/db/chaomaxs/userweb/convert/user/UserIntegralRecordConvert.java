package com.db.chaomaxs.userweb.convert.user;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.userservice.rpc.user.dto.UserIntegralRecordCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserIntegralRecordListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserIntegralRecordPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserIntegralRecordRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserIntegralRecordUpdateReqDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserIntegralRecordAddDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserIntegralRecordDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserIntegralRecordPageDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserIntegralRecordUpdateDTO;
import com.db.chaomaxs.userweb.controller.user.vo.UserIntegralRecordVO;
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
