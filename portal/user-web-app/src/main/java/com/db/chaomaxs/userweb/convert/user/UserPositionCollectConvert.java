package com.db.chaomaxs.userweb.convert.user;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionRespDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserPositionCollectAddDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserPositionCollectDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserPositionCollectPageDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserPositionCollectUpdateDTO;
import com.db.chaomaxs.userweb.controller.user.vo.CompanyPositionConvertVO;
import com.db.chaomaxs.userweb.controller.user.vo.UserPositionCollectVO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPositionCollectCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPositionCollectListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPositionCollectPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPositionCollectRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPositionCollectUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换用户_职位_收藏
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Mapper
public interface UserPositionCollectConvert {

  UserPositionCollectConvert INSTANCE = Mappers.getMapper(UserPositionCollectConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  UserPositionCollectCreateReqDTO convert(UserPositionCollectAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  UserPositionCollectUpdateReqDTO convert(UserPositionCollectUpdateDTO updateDTO);

  /**
   * 对象转换
   *
   * @param userPositionCollectDTO 查询参数对象
   * @return
   */
  @Mappings({})
  UserPositionCollectListQueryReqDTO convert(UserPositionCollectDTO userPositionCollectDTO);

  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  UserPositionCollectVO convert(UserPositionCollectRespDTO respDTO);

  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<UserPositionCollectVO> convertList(List<UserPositionCollectRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserPositionCollectVO> convert(
      TableResultResponse<UserPositionCollectRespDTO> tableResultResponse);

  /**
   * 分页对象转换
   *
   * @param pageDTO
   * @return
   */
  @Mappings({})
  UserPositionCollectPageReqDTO convert(UserPositionCollectPageDTO pageDTO);

  /**
   * list 转换成 VO list
   * @param respList
   * @return
   */
  @Mappings({})
  List<CompanyPositionConvertVO> convertPosition(List<CompanyPositionRespDTO> respList);

}
