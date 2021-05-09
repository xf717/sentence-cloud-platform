package com.github.xf717.managementweb.convert.content;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import java.util.List;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.content.dto.IndustryTypeCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.IndustryTypeListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.IndustryTypePageReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.IndustryTypeRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.IndustryTypeUpdateReqDTO;
import com.github.xf717.managementweb.controller.content.dto.IndustryTypeAddDTO;
import com.github.xf717.managementweb.controller.content.dto.IndustryTypeDTO;
import com.github.xf717.managementweb.controller.content.dto.IndustryTypePageDTO;
import com.github.xf717.managementweb.controller.content.dto.IndustryTypeUpdateDTO;
import com.github.xf717.managementweb.controller.content.vo.IndustryTypeVO;


/**
 * 应用层实体对象转换行业分类信息表
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Mapper
public interface IndustryTypeConvert {

        IndustryTypeConvert INSTANCE = Mappers.getMapper(IndustryTypeConvert.class);

  /**
* AddDTO convert AddBO
*
* @param addDTO 转换对象
* @return
*/
  @Mappings({})
      IndustryTypeCreateReqDTO convert(IndustryTypeAddDTO addDTO);

  /**
* UpdateDTO convert UpdateBO
*
* @param updateDTO 转换对象
* @return
*/
  @Mappings({})
      IndustryTypeUpdateReqDTO convert(IndustryTypeUpdateDTO updateDTO);

  /**
   *  对象转换
   * @param industryTypeDTO 查询参数对象
   * @return
   */
  @Mappings({})
      IndustryTypeListQueryReqDTO convert(IndustryTypeDTO industryTypeDTO);

  /**
   *  对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
      IndustryTypeVO convert(IndustryTypeRespDTO respDTO);

  /**
  * list 转换成 VO list
* @param listResp
* @return
*/
  @Mappings({})
  List<IndustryTypeVO> convertList(List<IndustryTypeRespDTO> listResp);

  /**
* 分页转换
*
* @param tableResultResponse 转换对象
* @return
*/
  @Mappings({})
  TableResultResponse<IndustryTypeVO> convert(
      TableResultResponse<IndustryTypeRespDTO> tableResultResponse);

  /**
  *  分页对象转换
* @param pageDTO
* @return
*/
  @Mappings({})
      IndustryTypePageReqDTO convert(IndustryTypePageDTO pageDTO);

}
