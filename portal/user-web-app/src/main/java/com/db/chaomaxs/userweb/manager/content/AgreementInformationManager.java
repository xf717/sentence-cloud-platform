package com.db.chaomaxs.userweb.manager.content;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.facade.AgreementInformationRpcFacade;
import com.db.chaomaxs.userweb.controller.content.vo.AgreementInformationVO;
import com.db.chaomaxs.userweb.convert.content.AgreementInformationConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * AgreementInformationManager
 *
 * @author ding
 * @date 2021-03-29 18:03:04
 */
@Service
@Validated
public class AgreementInformationManager {

  @Autowired
  private AgreementInformationRpcFacade agreementInformationRpcFacade;




  /**
   * 根据code查找
   *
   * @param code
   * @return
   */
  public AgreementInformationVO getAgreementInformationByCode(String code) {
    ObjectRestResponse<AgreementInformationRespDTO> objectRestResponse = agreementInformationRpcFacade
        .getAgreementInformationByCode(code);
    objectRestResponse.checkError();
    return AgreementInformationConvert.INSTANCE.convert(objectRestResponse.getData());
  }


}
