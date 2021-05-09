package com.db.chaomaxs.companyservice.rpc.company.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.company.GreetContentRpcImpl;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.facade.api.GreetContentApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 打招呼语
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@RestController
public class GreetContentRpcController implements GreetContentApi {

  @Autowired
  private GreetContentRpcImpl greetContentRpc;

  @Override
  public BaseResponse save(@RequestBody GreetContentCreateReqDTO greetContentCreateReqDTO) {
    return null;
  }

  @Override
  public BaseResponse update(@RequestBody GreetContentUpdateReqDTO greetContentUpdateReqDTO) {
    return greetContentRpc.update(greetContentUpdateReqDTO);
  }

  @Override
  public BaseResponse remove(@PathVariable("id") Long id) {
    return null;
  }

  @Override
  public ObjectRestResponse<GreetContentRespDTO> getGreetContentById(
      @PathVariable("id") Long id) {
    return null;
  }

  @Override
  public ObjectRestResponse<GreetContentRespDTO> getGreetContentsByUserId(
      @PathVariable("userId") Long userId) {
    return greetContentRpc.getGreetContentsByUserId(userId);
  }

  @Override
  public TableResultResponse<GreetContentRespDTO> page(@RequestBody GreetContentPageReqDTO page) {
    return null;
  }
}
