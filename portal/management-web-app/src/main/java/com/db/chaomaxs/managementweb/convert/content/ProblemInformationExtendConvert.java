package com.db.chaomaxs.managementweb.convert.content;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import java.util.List;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationExtendCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationExtendListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationExtendPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationExtendRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationExtendUpdateReqDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.ProblemInformationExtendAddDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.ProblemInformationExtendDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.ProblemInformationExtendPageDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.ProblemInformationExtendUpdateDTO;
import com.db.chaomaxs.managementweb.controller.content.vo.ProblemInformationExtendVO;


/**
 * 应用层实体对象转换内容管理-问题扩展信息表
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Mapper
public interface ProblemInformationExtendConvert {

        ProblemInformationExtendConvert INSTANCE = Mappers.getMapper(ProblemInformationExtendConvert.class);

  /**
* AddDTO convert AddBO
*
* @param addDTO 转换对象
* @return
*/
  @Mappings({})
      ProblemInformationExtendCreateReqDTO convert(ProblemInformationExtendAddDTO addDTO);

  /**
* UpdateDTO convert UpdateBO
*
* @param updateDTO 转换对象
* @return
*/
  @Mappings({})
      ProblemInformationExtendUpdateReqDTO convert(ProblemInformationExtendUpdateDTO updateDTO);

  /**
   *  对象转换
   * @param problemInformationExtendDTO 查询参数对象
   * @return
   */
  @Mappings({})
      ProblemInformationExtendListQueryReqDTO convert(
      ProblemInformationExtendDTO problemInformationExtendDTO);

  /**
   *  对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
      ProblemInformationExtendVO convert(ProblemInformationExtendRespDTO respDTO);

  /**
  * list 转换成 VO list
* @param listResp
* @return
*/
  @Mappings({})
  List<ProblemInformationExtendVO> convertList(List<ProblemInformationExtendRespDTO> listResp);

  /**
* 分页转换
*
* @param tableResultResponse 转换对象
* @return
*/
  @Mappings({})
  TableResultResponse<ProblemInformationExtendVO> convert(
      TableResultResponse<ProblemInformationExtendRespDTO> tableResultResponse);

  /**
  *  分页对象转换
* @param pageDTO
* @return
*/
  @Mappings({})
      ProblemInformationExtendPageReqDTO convert(ProblemInformationExtendPageDTO pageDTO);

}
