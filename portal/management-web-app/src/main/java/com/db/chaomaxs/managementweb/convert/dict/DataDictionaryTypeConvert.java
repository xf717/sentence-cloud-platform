package com.db.chaomaxs.managementweb.convert.dict;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.managementweb.controller.dict.dto.DataDictionaryTypeDTO;
import com.db.chaomaxs.managementweb.controller.dict.dto.DataDictionaryTypePageDTO;
import com.db.chaomaxs.managementweb.controller.dict.vo.DataDictionaryTypeVO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryTypeListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryTypePageReqDTO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryTypeRespDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换字典分类信息表
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Mapper
public interface DataDictionaryTypeConvert {

        DataDictionaryTypeConvert INSTANCE = Mappers.getMapper(DataDictionaryTypeConvert.class);


  /**
   *  对象转换
   * @param dataDictionaryTypeDTO 查询参数对象
   * @return
   */
  @Mappings({})
      DataDictionaryTypeListQueryReqDTO convert(DataDictionaryTypeDTO dataDictionaryTypeDTO);

  /**
   *  对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
      DataDictionaryTypeVO convert(DataDictionaryTypeRespDTO respDTO);

  /**
  * list 转换成 VO list
* @param listResp
* @return
*/
  @Mappings({})
  List<DataDictionaryTypeVO> convertList(List<DataDictionaryTypeRespDTO> listResp);

  /**
* 分页转换
*
* @param tableResultResponse 转换对象
* @return
*/
  @Mappings({})
  TableResultResponse<DataDictionaryTypeVO> convert(
      TableResultResponse<DataDictionaryTypeRespDTO> tableResultResponse);

  /**
  *  分页对象转换
* @param pageDTO
* @return
*/
  @Mappings({})
      DataDictionaryTypePageReqDTO convert(DataDictionaryTypePageDTO pageDTO);

}
