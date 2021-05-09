package com.github.xf717.managementweb.convert.content;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import java.util.List;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentPageReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentUpdateReqDTO;
import com.github.xf717.managementweb.controller.content.dto.WorkContentAddDTO;
import com.github.xf717.managementweb.controller.content.dto.WorkContentDTO;
import com.github.xf717.managementweb.controller.content.dto.WorkContentPageDTO;
import com.github.xf717.managementweb.controller.content.dto.WorkContentUpdateDTO;
import com.github.xf717.managementweb.controller.content.vo.WorkContentVO;


/**
 * 应用层实体对象转换内容管理-工作内容息表
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Mapper
public interface WorkContentConvert {

        WorkContentConvert INSTANCE = Mappers.getMapper(WorkContentConvert.class);

  /**
* AddDTO convert AddBO
*
* @param addDTO 转换对象
* @return
*/
  @Mappings({})
      WorkContentCreateReqDTO convert(WorkContentAddDTO addDTO);

  /**
* UpdateDTO convert UpdateBO
*
* @param updateDTO 转换对象
* @return
*/
  @Mappings({})
      WorkContentUpdateReqDTO convert(WorkContentUpdateDTO updateDTO);

  /**
   *  对象转换
   * @param workContentDTO 查询参数对象
   * @return
   */
  @Mappings({})
      WorkContentListQueryReqDTO convert(WorkContentDTO workContentDTO);

  /**
   *  对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
      WorkContentVO convert(WorkContentRespDTO respDTO);

  /**
  * list 转换成 VO list
* @param listResp
* @return
*/
  @Mappings({})
  List<WorkContentVO> convertList(List<WorkContentRespDTO> listResp);

  /**
* 分页转换
*
* @param tableResultResponse 转换对象
* @return
*/
  @Mappings({})
  TableResultResponse<WorkContentVO> convert(
      TableResultResponse<WorkContentRespDTO> tableResultResponse);

  /**
  *  分页对象转换
* @param pageDTO
* @return
*/
  @Mappings({})
      WorkContentPageReqDTO convert(WorkContentPageDTO pageDTO);

}
