package com.github.xf717.systemservice.convert.content;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.dal.mysql.dataobject.content.AgreementInformationExtendDO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * AgreementInformationExtendConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Mapper
public interface AgreementInformationExtendConvert {

        AgreementInformationExtendConvert INSTANCE = Mappers.getMapper(AgreementInformationExtendConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      AgreementInformationExtendDO convert(AgreementInformationExtendCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      AgreementInformationExtendDO convert(AgreementInformationExtendUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<AgreementInformationExtendRespDTO> convertList(List<AgreementInformationExtendDO> list);

  /**
   * 对象转换
   *
   * @param agreementInformationExtendDO
   * @return
   */
      AgreementInformationExtendRespDTO convert(
          AgreementInformationExtendDO agreementInformationExtendDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<AgreementInformationExtendRespDTO> convertPage(
      IPage<AgreementInformationExtendDO> page);


}
