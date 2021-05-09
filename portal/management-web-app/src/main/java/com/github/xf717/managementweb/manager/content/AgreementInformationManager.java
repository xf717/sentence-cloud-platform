package com.github.xf717.managementweb.manager.content;

import com.github.xf717.managementweb.controller.content.dto.AgreementInformationAddDTO;
import com.github.xf717.managementweb.controller.content.dto.AgreementInformationUpdateDTO;
import com.github.xf717.managementweb.controller.content.dto.AgreementInformationDTO;
import com.github.xf717.managementweb.controller.content.dto.AgreementInformationPageDTO;
import com.github.xf717.managementweb.controller.content.vo.AgreementInformationVO;
import com.github.xf717.managementweb.convert.content.AgreementInformationConvert;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationRespDTO;
import com.github.xf717.systemservice.rpc.content.facade.AgreementInformationRpcFacade;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
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
  private AgreementInformationRpcFacade agreementInformationRpcFacade;

  /**
   * 添加数据
   *
   * @param agreementInformationAddDTO 添加参数
   * @return
   */
  public int save(AgreementInformationAddDTO agreementInformationAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = agreementInformationRpcFacade
        .save(AgreementInformationConvert.INSTANCE.convert(agreementInformationAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param agreementInformationUpdateDTO 更新参数
   * @return
   */
  public int update(AgreementInformationUpdateDTO agreementInformationUpdateDTO) {
    BaseResponse baseResponse = agreementInformationRpcFacade
        .update(AgreementInformationConvert.INSTANCE.convert(agreementInformationUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = agreementInformationRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public AgreementInformationVO getAgreementInformationById(Long id) {
    ObjectRestResponse<AgreementInformationRespDTO> objectRestResponse = agreementInformationRpcFacade
        .getAgreementInformationById(
            id);
    objectRestResponse.checkError();
    return AgreementInformationConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   *
   * @param agreementInformationDTO 查询参数
   * @return
   */
  public List<AgreementInformationVO> listAgreementInformations(
      AgreementInformationDTO agreementInformationDTO) {
    ObjectRestResponse<List<AgreementInformationRespDTO>> objectRestResponse = agreementInformationRpcFacade
        .listAgreementInformations(
            AgreementInformationConvert.INSTANCE.convert(agreementInformationDTO));
    objectRestResponse.checkError();
    return AgreementInformationConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  public TableResultResponse<AgreementInformationVO> pageAgreementInformation(
      AgreementInformationPageDTO pageReqDTO) {
    TableResultResponse<AgreementInformationRespDTO> tableResultResponse = agreementInformationRpcFacade
        .page(AgreementInformationConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return AgreementInformationConvert.INSTANCE.convert(tableResultResponse);
  }

}
