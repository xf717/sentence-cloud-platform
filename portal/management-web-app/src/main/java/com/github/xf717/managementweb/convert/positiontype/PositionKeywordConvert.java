package com.github.xf717.managementweb.convert.positiontype;

import com.github.xf717.managementweb.controller.positiontype.dto.PositionKeywordAddDTO;
import com.github.xf717.managementweb.controller.positiontype.dto.PositionKeywordDTO;
import com.github.xf717.managementweb.controller.positiontype.dto.PositionKeywordPageDTO;
import com.github.xf717.managementweb.controller.positiontype.dto.PositionKeywordUpdateDTO;
import com.github.xf717.managementweb.controller.positiontype.vo.PositionKeywordVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import java.util.List;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.positionservice.rpc.positiontype.dto.PositionKeywordCreateReqDTO;
import com.github.xf717.positionservice.rpc.positiontype.dto.PositionKeywordListQueryReqDTO;
import com.github.xf717.positionservice.rpc.positiontype.dto.PositionKeywordPageReqDTO;
import com.github.xf717.positionservice.rpc.positiontype.dto.PositionKeywordRespDTO;
import com.github.xf717.positionservice.rpc.positiontype.dto.PositionKeywordUpdateReqDTO;


/**
 * 应用层实体对象转换内容管理-职位关键词信息表
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Mapper
public interface PositionKeywordConvert {

        PositionKeywordConvert INSTANCE = Mappers.getMapper(PositionKeywordConvert.class);

  /**
* AddDTO convert AddBO
*
* @param addDTO 转换对象
* @return
*/
  @Mappings({})
      PositionKeywordCreateReqDTO convert(PositionKeywordAddDTO addDTO);

  /**
* UpdateDTO convert UpdateBO
*
* @param updateDTO 转换对象
* @return
*/
  @Mappings({})
      PositionKeywordUpdateReqDTO convert(PositionKeywordUpdateDTO updateDTO);

  /**
   *  对象转换
   * @param positionKeywordDTO 查询参数对象
   * @return
   */
  @Mappings({})
      PositionKeywordListQueryReqDTO convert(PositionKeywordDTO positionKeywordDTO);

  /**
   *  对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  PositionKeywordVO convert(PositionKeywordRespDTO respDTO);

  /**
  * list 转换成 VO list
* @param listResp
* @return
*/
  @Mappings({})
  List<PositionKeywordVO> convertList(List<PositionKeywordRespDTO> listResp);

  /**
* 分页转换
*
* @param tableResultResponse 转换对象
* @return
*/
  @Mappings({})
  TableResultResponse<PositionKeywordVO> convert(
      TableResultResponse<PositionKeywordRespDTO> tableResultResponse);

  /**
  *  分页对象转换
* @param pageDTO
* @return
*/
  @Mappings({})
      PositionKeywordPageReqDTO convert(PositionKeywordPageDTO pageDTO);

}
