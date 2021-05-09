package com.github.xf717.userweb.manager.content;

import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationRespDTO;
import com.github.xf717.systemservice.rpc.content.facade.AgreementInformationRpcFacade;
import com.github.xf717.userweb.controller.content.vo.AgreementInformationVO;
import com.github.xf717.userweb.convert.content.AgreementInformationConvert;
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
