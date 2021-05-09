package com.db.chaomaxs.managementweb.convert.content;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import java.util.List;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentExtendCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentExtendListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentExtendPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentExtendRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentExtendUpdateReqDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.WorkContentExtendAddDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.WorkContentExtendDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.WorkContentExtendPageDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.WorkContentExtendUpdateDTO;
import com.db.chaomaxs.managementweb.controller.content.vo.WorkContentExtendVO;


/**
 * 应用层实体对象转换内容管理-工作内容_扩展信息表
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Mapper
public interface WorkContentExtendConvert {

        WorkContentExtendConvert INSTANCE = Mappers.getMapper(WorkContentExtendConvert.class);

  /**
* AddDTO convert AddBO
*
* @param addDTO 转换对象
* @return
*/
  @Mappings({})
      WorkContentExtendCreateReqDTO convert(WorkContentExtendAddDTO addDTO);

  /**
* UpdateDTO convert UpdateBO
*
* @param updateDTO 转换对象
* @return
*/
  @Mappings({})
      WorkContentExtendUpdateReqDTO convert(WorkContentExtendUpdateDTO updateDTO);

  /**
   *  对象转换
   * @param workContentExtendDTO 查询参数对象
   * @return
   */
  @Mappings({})
      WorkContentExtendListQueryReqDTO convert(WorkContentExtendDTO workContentExtendDTO);

  /**
   *  对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
      WorkContentExtendVO convert(WorkContentExtendRespDTO respDTO);

  /**
  * list 转换成 VO list
* @param listResp
* @return
*/
  @Mappings({})
  List<WorkContentExtendVO> convertList(List<WorkContentExtendRespDTO> listResp);

  /**
* 分页转换
*
* @param tableResultResponse 转换对象
* @return
*/
  @Mappings({})
  TableResultResponse<WorkContentExtendVO> convert(
      TableResultResponse<WorkContentExtendRespDTO> tableResultResponse);

  /**
  *  分页对象转换
* @param pageDTO
* @return
*/
  @Mappings({})
      WorkContentExtendPageReqDTO convert(WorkContentExtendPageDTO pageDTO);

}
