package com.db.chaomaxs.userweb.convert.user;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.userweb.controller.user.dto.UserDeliveryAddDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserDeliveryDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserDeliveryPageDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserDeliveryUpdateDTO;
import com.db.chaomaxs.userweb.controller.user.vo.UserDeliveryVO;
import com.db.chaomaxs.userweb.controller.user.vo.UserPositionCollectVO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换企业投递表
 *
 * @author momo
 * @date 2021-04-08 14:18:28
 */
@Mapper
public interface UserDeliveryConvert {

  UserDeliveryConvert INSTANCE = Mappers.getMapper(UserDeliveryConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  UserDeliveryCreateReqDTO convert(UserDeliveryAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  UserDeliveryUpdateReqDTO convert(UserDeliveryUpdateDTO updateDTO);

  /**
   * 对象转换
   *
   * @param userDeliveryDTO 查询参数对象
   * @return
   */
  @Mappings({})
  UserDeliveryListQueryReqDTO convert(UserDeliveryDTO userDeliveryDTO);

  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  UserDeliveryVO convert(UserDeliveryRespDTO respDTO);

  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<UserDeliveryVO> convertList(List<UserDeliveryRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserDeliveryVO> convert(
      TableResultResponse<UserDeliveryRespDTO> tableResultResponse);

  /**
   * 分页对象转换
   *
   * @param pageDTO
   * @return
   */
  @Mappings({})
  UserDeliveryPageReqDTO convert(UserDeliveryPageDTO pageDTO);

  /**
   * 分页转换 UserPositionCollectVO
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserPositionCollectVO> convertPosition(
      TableResultResponse<UserDeliveryRespDTO> tableResultResponse);

}
