package com.github.xf717.systemservice.manager.content;

import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationPageReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationUpdateReqDTO;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.service.content.AgreementInformationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * AgreementInformationManager
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Service
@Validated
public class AgreementInformationManager {

  @Autowired
  private AgreementInformationService agreementInformationService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveAgreementInformation(AgreementInformationCreateReqDTO createReqDTO) {
    return agreementInformationService.saveAgreementInformation(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateAgreementInformation(AgreementInformationUpdateReqDTO updateReqDTO) {
      return agreementInformationService.updateAgreementInformation(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteAgreementInformation(Long id) {
    return agreementInformationService.deleteAgreementInformation(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<AgreementInformationRespDTO> listAgreementInformations(AgreementInformationListQueryReqDTO listQueryReqDTO) {
    return agreementInformationService.listAgreementInformations(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public AgreementInformationRespDTO getAgreementInformationById(Long id) {
    return agreementInformationService.getAgreementInformationById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<AgreementInformationRespDTO> pageAgreementInformation(AgreementInformationPageReqDTO page) {
    return agreementInformationService.pageAgreementInformation(page);
  }


  /**
   * 根据code获取对象
   * @param code
   * @return
   */
  public AgreementInformationRespDTO getAgreementInformationByCode(String code) {
    return agreementInformationService.getAgreementInformationByCode(code);
  }


}
