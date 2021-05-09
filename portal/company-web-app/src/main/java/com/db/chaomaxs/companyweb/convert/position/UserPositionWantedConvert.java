package com.db.chaomaxs.companyweb.convert.position;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import java.util.List;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedPageReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedUpdateReqDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.UserPositionWantedAddDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.UserPositionWantedDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.UserPositionWantedPageDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.UserPositionWantedUpdateDTO;
import com.db.chaomaxs.companyweb.controller.position.vo.UserPositionWantedVO;


/**
 * 应用层实体对象转换用户求职
 * @author xiaofeng
 * @date 2021-03-29 16:36:57
 */
@Mapper
public interface UserPositionWantedConvert {

        UserPositionWantedConvert INSTANCE = Mappers.getMapper(UserPositionWantedConvert.class);

  /**
* AddDTO convert AddBO
*
* @param addDTO 转换对象
* @return
*/
  @Mappings({})
      UserPositionWantedCreateReqDTO convert(UserPositionWantedAddDTO addDTO);

  /**
* UpdateDTO convert UpdateBO
*
* @param updateDTO 转换对象
* @return
*/
  @Mappings({})
      UserPositionWantedUpdateReqDTO convert(UserPositionWantedUpdateDTO updateDTO);

  /**
   *  对象转换
   * @param userPositionWantedDTO 查询参数对象
   * @return
   */
  @Mappings({})
      UserPositionWantedListQueryReqDTO convert(UserPositionWantedDTO userPositionWantedDTO);

  /**
   *  对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
      UserPositionWantedVO convert(UserPositionWantedRespDTO respDTO);

  /**
  * list 转换成 VO list
* @param listResp
* @return
*/
  @Mappings({})
  List<UserPositionWantedVO> convertList(List<UserPositionWantedRespDTO> listResp);

  /**
* 分页转换
*
* @param tableResultResponse 转换对象
* @return
*/
  @Mappings({})
  TableResultResponse<UserPositionWantedVO> convert(
      TableResultResponse<UserPositionWantedRespDTO> tableResultResponse);

  /**
  *  分页对象转换
* @param pageDTO
* @return
*/
  @Mappings({})
      UserPositionWantedPageReqDTO convert(UserPositionWantedPageDTO pageDTO);

}
