package com.db.chaomaxs.systemservice.convert.content;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.content.AgreementInformationDO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * AgreementInformationConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Mapper
public interface AgreementInformationConvert {

        AgreementInformationConvert INSTANCE = Mappers.getMapper(AgreementInformationConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      AgreementInformationDO convert(AgreementInformationCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      AgreementInformationDO convert(AgreementInformationUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<AgreementInformationRespDTO> convertList(List<AgreementInformationDO> list);

  /**
   * 对象转换
   *
   * @param agreementInformationDO
   * @return
   */
      AgreementInformationRespDTO convert(AgreementInformationDO agreementInformationDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<AgreementInformationRespDTO> convertPage(IPage<AgreementInformationDO> page);


}
