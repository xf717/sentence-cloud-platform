package com.github.xf717.systemservice.rpc.content;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.manager.content.AgreementInformationExtendManager;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendPageReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendUpdateReqDTO;
import com.github.xf717.systemservice.rpc.content.facade.AgreementInformationExtendRpcFacade;
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
public class AgreementInformationExtendRpcImpl implements AgreementInformationExtendRpcFacade {

  @Autowired
  private AgreementInformationExtendManager agreementInformationExtendManager;

  @Override
  public BaseResponse save(AgreementInformationExtendCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    agreementInformationExtendManager.saveAgreementInformationExtend(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(AgreementInformationExtendUpdateReqDTO updateReqDTO) {
      agreementInformationExtendManager.updateAgreementInformationExtend(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      agreementInformationExtendManager.deleteAgreementInformationExtend(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<AgreementInformationExtendRespDTO> getAgreementInformationExtendById(Long id) {
      AgreementInformationExtendRespDTO agreementInformationExtend = agreementInformationExtendManager.getAgreementInformationExtendById(id);
    return new ObjectRestResponse<>().data(agreementInformationExtend);
  }

  @Override
  public ObjectRestResponse<List<AgreementInformationExtendRespDTO>> listAgreementInformationExtends(AgreementInformationExtendListQueryReqDTO listQuery) {
    List<AgreementInformationExtendRespDTO> list = agreementInformationExtendManager.listAgreementInformationExtends(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<AgreementInformationExtendRespDTO> page(AgreementInformationExtendPageReqDTO pageReqDTO) {
    PageResult<AgreementInformationExtendRespDTO> pageResult = agreementInformationExtendManager.pageAgreementInformationExtend(pageReqDTO);
    TableResultResponse<AgreementInformationExtendRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}
