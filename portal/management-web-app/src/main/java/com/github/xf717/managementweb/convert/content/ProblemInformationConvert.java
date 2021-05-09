package com.github.xf717.managementweb.convert.content;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import java.util.List;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationPageReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationUpdateReqDTO;
import com.github.xf717.managementweb.controller.content.dto.ProblemInformationAddDTO;
import com.github.xf717.managementweb.controller.content.dto.ProblemInformationDTO;
import com.github.xf717.managementweb.controller.content.dto.ProblemInformationPageDTO;
import com.github.xf717.managementweb.controller.content.dto.ProblemInformationUpdateDTO;
import com.github.xf717.managementweb.controller.content.vo.ProblemInformationVO;


/**
 * 应用层实体对象转换内容管理-问题信息表
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Mapper
public interface ProblemInformationConvert {

        ProblemInformationConvert INSTANCE = Mappers.getMapper(ProblemInformationConvert.class);

  /**
* AddDTO convert AddBO
*
* @param addDTO 转换对象
* @return
*/
  @Mappings({})
      ProblemInformationCreateReqDTO convert(ProblemInformationAddDTO addDTO);

  /**
* UpdateDTO convert UpdateBO
*
* @param updateDTO 转换对象
* @return
*/
  @Mappings({})
      ProblemInformationUpdateReqDTO convert(ProblemInformationUpdateDTO updateDTO);

  /**
   *  对象转换
   * @param problemInformationDTO 查询参数对象
   * @return
   */
  @Mappings({})
      ProblemInformationListQueryReqDTO convert(ProblemInformationDTO problemInformationDTO);

  /**
   *  对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
      ProblemInformationVO convert(ProblemInformationRespDTO respDTO);

  /**
  * list 转换成 VO list
* @param listResp
* @return
*/
  @Mappings({})
  List<ProblemInformationVO> convertList(List<ProblemInformationRespDTO> listResp);

  /**
* 分页转换
*
* @param tableResultResponse 转换对象
* @return
*/
  @Mappings({})
  TableResultResponse<ProblemInformationVO> convert(
      TableResultResponse<ProblemInformationRespDTO> tableResultResponse);

  /**
  *  分页对象转换
* @param pageDTO
* @return
*/
  @Mappings({})
      ProblemInformationPageReqDTO convert(ProblemInformationPageDTO pageDTO);

}
