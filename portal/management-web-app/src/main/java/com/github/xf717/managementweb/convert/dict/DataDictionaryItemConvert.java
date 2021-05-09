package com.github.xf717.managementweb.convert.dict;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import java.util.List;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemCreateReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemListQueryReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemPageReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemRespDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemUpdateReqDTO;
import com.github.xf717.managementweb.controller.dict.dto.DataDictionaryItemAddDTO;
import com.github.xf717.managementweb.controller.dict.dto.DataDictionaryItemDTO;
import com.github.xf717.managementweb.controller.dict.dto.DataDictionaryItemPageDTO;
import com.github.xf717.managementweb.controller.dict.dto.DataDictionaryItemUpdateDTO;
import com.github.xf717.managementweb.controller.dict.vo.DataDictionaryItemVO;


/**
 * 应用层实体对象转换数据字典项信息表
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Mapper
public interface DataDictionaryItemConvert {

        DataDictionaryItemConvert INSTANCE = Mappers.getMapper(DataDictionaryItemConvert.class);

  /**
* AddDTO convert AddBO
*
* @param addDTO 转换对象
* @return
*/
  @Mappings({})
      DataDictionaryItemCreateReqDTO convert(DataDictionaryItemAddDTO addDTO);

  /**
* UpdateDTO convert UpdateBO
*
* @param updateDTO 转换对象
* @return
*/
  @Mappings({})
      DataDictionaryItemUpdateReqDTO convert(DataDictionaryItemUpdateDTO updateDTO);

  /**
   *  对象转换
   * @param dataDictionaryItemDTO 查询参数对象
   * @return
   */
  @Mappings({})
      DataDictionaryItemListQueryReqDTO convert(DataDictionaryItemDTO dataDictionaryItemDTO);

  /**
   *  对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
      DataDictionaryItemVO convert(DataDictionaryItemRespDTO respDTO);

  /**
  * list 转换成 VO list
* @param listResp
* @return
*/
  @Mappings({})
  List<DataDictionaryItemVO> convertList(List<DataDictionaryItemRespDTO> listResp);

  /**
* 分页转换
*
* @param tableResultResponse 转换对象
* @return
*/
  @Mappings({})
  TableResultResponse<DataDictionaryItemVO> convert(
      TableResultResponse<DataDictionaryItemRespDTO> tableResultResponse);

  /**
  *  分页对象转换
* @param pageDTO
* @return
*/
  @Mappings({})
      DataDictionaryItemPageReqDTO convert(DataDictionaryItemPageDTO pageDTO);

}
