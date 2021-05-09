package com.db.chaomaxs.userweb.convert.content;

import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationRespDTO;
import com.db.chaomaxs.userweb.controller.content.vo.AgreementInformationVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * app端应用层实体对象转换内容管理-协议信息表
 *
 * @author ding
 * @date 2021-03-29 18:03:04
 */
@Mapper
public interface AgreementInformationConvert {

  AgreementInformationConvert INSTANCE = Mappers.getMapper(AgreementInformationConvert.class);


  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  AgreementInformationVO convert(AgreementInformationRespDTO respDTO);


}
