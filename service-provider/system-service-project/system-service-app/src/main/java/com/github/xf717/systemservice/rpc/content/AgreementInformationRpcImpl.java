package com.github.xf717.systemservice.rpc.content;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.manager.content.AgreementInformationManager;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationPageReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationUpdateReqDTO;
import com.github.xf717.systemservice.rpc.content.facade.AgreementInformationRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Slf4j
@Service
public class AgreementInformationRpcImpl implements AgreementInformationRpcFacade {

  @Autowired
  private AgreementInformationManager agreementInformationManager;

  @Override
  public BaseResponse save(AgreementInformationCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    agreementInformationManager.saveAgreementInformation(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(AgreementInformationUpdateReqDTO updateReqDTO) {
      agreementInformationManager.updateAgreementInformation(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      agreementInformationManager.deleteAgreementInformation(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<AgreementInformationRespDTO> getAgreementInformationById(Long id) {
      AgreementInformationRespDTO agreementInformation = agreementInformationManager.getAgreementInformationById(id);
    return new ObjectRestResponse<>().data(agreementInformation);
  }

  @Override
  public ObjectRestResponse<List<AgreementInformationRespDTO>> listAgreementInformations(AgreementInformationListQueryReqDTO listQuery) {
    List<AgreementInformationRespDTO> list = agreementInformationManager.listAgreementInformations(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<AgreementInformationRespDTO> page(AgreementInformationPageReqDTO pageReqDTO) {
    PageResult<AgreementInformationRespDTO> pageResult = agreementInformationManager.pageAgreementInformation(pageReqDTO);
    TableResultResponse<AgreementInformationRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }


  @Override
  public ObjectRestResponse<AgreementInformationRespDTO> getAgreementInformationByCode(String code) {
    AgreementInformationRespDTO agreementInformation = agreementInformationManager.getAgreementInformationByCode(code);
    return new ObjectRestResponse<>().data(agreementInformation);
  }

}
