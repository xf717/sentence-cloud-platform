package com.github.xf717.managementweb.convert.content;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import java.util.List;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformPageReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformUpdateReqDTO;
import com.github.xf717.managementweb.controller.content.dto.ReleasePlatformAddDTO;
import com.github.xf717.managementweb.controller.content.dto.ReleasePlatformDTO;
import com.github.xf717.managementweb.controller.content.dto.ReleasePlatformPageDTO;
import com.github.xf717.managementweb.controller.content.dto.ReleasePlatformUpdateDTO;
import com.github.xf717.managementweb.controller.content.vo.ReleasePlatformVO;


/**
 * 应用层实体对象转换发布平台
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Mapper
public interface ReleasePlatformConvert {

        ReleasePlatformConvert INSTANCE = Mappers.getMapper(ReleasePlatformConvert.class);

  /**
* AddDTO convert AddBO
*
* @param addDTO 转换对象
* @return
*/
  @Mappings({})
      ReleasePlatformCreateReqDTO convert(ReleasePlatformAddDTO addDTO);

  /**
* UpdateDTO convert UpdateBO
*
* @param updateDTO 转换对象
* @return
*/
  @Mappings({})
      ReleasePlatformUpdateReqDTO convert(ReleasePlatformUpdateDTO updateDTO);

  /**
   *  对象转换
   * @param releasePlatformDTO 查询参数对象
   * @return
   */
  @Mappings({})
      ReleasePlatformListQueryReqDTO convert(ReleasePlatformDTO releasePlatformDTO);

  /**
   *  对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
      ReleasePlatformVO convert(ReleasePlatformRespDTO respDTO);

  /**
  * list 转换成 VO list
* @param listResp
* @return
*/
  @Mappings({})
  List<ReleasePlatformVO> convertList(List<ReleasePlatformRespDTO> listResp);

  /**
* 分页转换
*
* @param tableResultResponse 转换对象
* @return
*/
  @Mappings({})
  TableResultResponse<ReleasePlatformVO> convert(
      TableResultResponse<ReleasePlatformRespDTO> tableResultResponse);

  /**
  *  分页对象转换
* @param pageDTO
* @return
*/
  @Mappings({})
      ReleasePlatformPageReqDTO convert(ReleasePlatformPageDTO pageDTO);

}
