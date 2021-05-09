package com.db.chaomaxs.managementweb.convert.content;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import java.util.List;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationExtendCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationExtendListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationExtendPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationExtendRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationExtendUpdateReqDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.AgreementInformationExtendAddDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.AgreementInformationExtendDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.AgreementInformationExtendPageDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.AgreementInformationExtendUpdateDTO;
import com.db.chaomaxs.managementweb.controller.content.vo.AgreementInformationExtendVO;


/**
 * 应用层实体对象转换内容管理-协议信息_扩展息表
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Mapper
public interface AgreementInformationExtendConvert {

        AgreementInformationExtendConvert INSTANCE = Mappers.getMapper(AgreementInformationExtendConvert.class);

  /**
* AddDTO convert AddBO
*
* @param addDTO 转换对象
* @return
*/
  @Mappings({})
      AgreementInformationExtendCreateReqDTO convert(AgreementInformationExtendAddDTO addDTO);

  /**
* UpdateDTO convert UpdateBO
*
* @param updateDTO 转换对象
* @return
*/
  @Mappings({})
      AgreementInformationExtendUpdateReqDTO convert(AgreementInformationExtendUpdateDTO updateDTO);

  /**
   *  对象转换
   * @param agreementInformationExtendDTO 查询参数对象
   * @return
   */
  @Mappings({})
      AgreementInformationExtendListQueryReqDTO convert(
      AgreementInformationExtendDTO agreementInformationExtendDTO);

  /**
   *  对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
      AgreementInformationExtendVO convert(AgreementInformationExtendRespDTO respDTO);

  /**
  * list 转换成 VO list
* @param listResp
* @return
*/
  @Mappings({})
  List<AgreementInformationExtendVO> convertList(List<AgreementInformationExtendRespDTO> listResp);

  /**
* 分页转换
*
* @param tableResultResponse 转换对象
* @return
*/
  @Mappings({})
  TableResultResponse<AgreementInformationExtendVO> convert(
      TableResultResponse<AgreementInformationExtendRespDTO> tableResultResponse);

  /**
  *  分页对象转换
* @param pageDTO
* @return
*/
  @Mappings({})
      AgreementInformationExtendPageReqDTO convert(AgreementInformationExtendPageDTO pageDTO);

}
