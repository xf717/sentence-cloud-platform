package com.db.chaomaxs.companyservice.rpc.delivery;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.manager.delivery.CompanyDeliveryManager;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryRespDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.facade.CompanyDeliveryRpcFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CompanyDeliveryRpcImpl implements CompanyDeliveryRpcFacade {

  @Autowired
  private CompanyDeliveryManager companyDeliveryManager;

  @Override
  public BaseResponse save(CompanyDeliveryCreateReqDTO companyDeliveryCreateReqDTO) {
    companyDeliveryManager.saveCompanyDelivery(companyDeliveryCreateReqDTO);
    return BaseResponse.success("保存成功");
  }


  @Override
  public ObjectRestResponse<CompanyDeliveryRespDTO> getCompanyDeliveryById(Long id) {
    return new ObjectRestResponse<>().data(companyDeliveryManager.getCompanyDeliveryById(id));
  }

  @Override
  public TableResultResponse<CompanyDeliveryRespDTO> page(CompanyDeliveryPageReqDTO pageReqDTO) {
    PageResult<CompanyDeliveryRespDTO> pageResult = companyDeliveryManager.pageCompanyDelivery(pageReqDTO);
    TableResultResponse<CompanyDeliveryRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}
