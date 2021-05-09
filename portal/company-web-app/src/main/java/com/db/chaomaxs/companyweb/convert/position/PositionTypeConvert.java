package com.db.chaomaxs.companyweb.convert.position;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypePageReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeRespDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeUpdateReqDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.PositionTypeAddDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.PositionTypeDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.PositionTypePageDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.PositionTypeUpdateDTO;
import com.db.chaomaxs.companyweb.controller.position.vo.PositionTypeVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换职务职位分类信息表
 * @author ding
 * @date 2021-04-06 17:45:09
 */
@Mapper
public interface PositionTypeConvert {

        PositionTypeConvert INSTANCE = Mappers.getMapper(PositionTypeConvert.class);

  /**
* AddDTO convert AddBO
*
* @param addDTO 转换对象
* @return
*/
  @Mappings({})
  PositionTypeCreateReqDTO convert(PositionTypeAddDTO addDTO);

  /**
* UpdateDTO convert UpdateBO
*
* @param updateDTO 转换对象
* @return
*/
  @Mappings({})
  PositionTypeUpdateReqDTO convert(PositionTypeUpdateDTO updateDTO);

  /**
   *  对象转换
   * @param positionTypeDTO 查询参数对象
   * @return
   */
  @Mappings({})
  PositionTypeListQueryReqDTO convert(PositionTypeDTO positionTypeDTO);

  /**
   *  对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  PositionTypeVO convert(PositionTypeRespDTO respDTO);

  /**
  * list 转换成 VO list
* @param listResp
* @return
*/
  @Mappings({})
  List<PositionTypeVO> convertList(List<PositionTypeRespDTO> listResp);

  /**
* 分页转换
*
* @param tableResultResponse 转换对象
* @return
*/
  @Mappings({})
  TableResultResponse<PositionTypeVO> convert(
      TableResultResponse<PositionTypeRespDTO> tableResultResponse);

  /**
  *  分页对象转换
* @param pageDTO
* @return
*/
  @Mappings({})
  PositionTypePageReqDTO convert(PositionTypePageDTO pageDTO);

}
