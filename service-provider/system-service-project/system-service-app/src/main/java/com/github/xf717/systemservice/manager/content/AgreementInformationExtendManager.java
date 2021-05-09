package com.github.xf717.systemservice.manager.content;

import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendPageReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendUpdateReqDTO;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.service.content.AgreementInformationExtendService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * AgreementInformationExtendManager
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Service
@Validated
public class AgreementInformationExtendManager {

  @Autowired
  private AgreementInformationExtendService agreementInformationExtendService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveAgreementInformationExtend(AgreementInformationExtendCreateReqDTO createReqDTO) {
    return agreementInformationExtendService.saveAgreementInformationExtend(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateAgreementInformationExtend(AgreementInformationExtendUpdateReqDTO updateReqDTO) {
      return agreementInformationExtendService.updateAgreementInformationExtend(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteAgreementInformationExtend(Long id) {
    return agreementInformationExtendService.deleteAgreementInformationExtend(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<AgreementInformationExtendRespDTO> listAgreementInformationExtends(AgreementInformationExtendListQueryReqDTO listQueryReqDTO) {
    return agreementInformationExtendService.listAgreementInformationExtends(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public AgreementInformationExtendRespDTO getAgreementInformationExtendById(Long id) {
    return agreementInformationExtendService.getAgreementInformationExtendById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<AgreementInformationExtendRespDTO> pageAgreementInformationExtend(AgreementInformationExtendPageReqDTO page) {
    return agreementInformationExtendService.pageAgreementInformationExtend(page);
  }


}
