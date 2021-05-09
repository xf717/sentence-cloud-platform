package com.db.chaomaxs.companyservice.rpc.company.rest;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatRespDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatStatisticRespDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.PositionIdsReqDTO;
import com.db.chaomaxs.companyservice.rpc.chat.facade.api.CompanyUserChatApi;
import com.db.chaomaxs.companyservice.rpc.company.CompanyUserChatRpcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 企业我的沟通
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@RestController
public class CompanyUserChatRpcController implements CompanyUserChatApi {

  @Autowired
  private CompanyUserChatRpcImpl companyUserChatRpc;

  @Override
  public BaseResponse save(@RequestBody CompanyUserChatCreateReqDTO companyUserChatCreateReqDTO) {
    return companyUserChatRpc.save(companyUserChatCreateReqDTO);
  }



  @Override
  public ObjectRestResponse<CompanyUserChatRespDTO> getCompanyUserChatById(@PathVariable("id") Long id) {
    return companyUserChatRpc.getCompanyUserChatById(id);
  }


  @Override
  public TableResultResponse<CompanyUserChatRespDTO> page(@RequestBody CompanyUserChatPageReqDTO page) {
    return companyUserChatRpc.page(page);
  }

  @Override
  public Map<Long, CompanyUserChatStatisticRespDTO> getStatisticByPositionIds(@RequestBody PositionIdsReqDTO positionIdsReqDTO) {
    return companyUserChatRpc.getStatisticByPositionIds(positionIdsReqDTO);
  }
}
