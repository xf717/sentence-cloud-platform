package com.db.chaomaxs.companyservice.rpc.company;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.manager.company.GreetContentManager;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.facade.GreetContentRpcFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @data 2021-03-26 10:18:33
 */
@Slf4j
@Service
public class GreetContentRpcImpl implements GreetContentRpcFacade {

  @Autowired
  private GreetContentManager greetContentManager;

  @Override
  public BaseResponse save(GreetContentCreateReqDTO greetContentCreateReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    greetContentManager.saveGreetContent(greetContentCreateReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(GreetContentUpdateReqDTO greetContentUpdateReqDTO) {
    greetContentManager.updateGreetContent(greetContentUpdateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
    return null;
  }

  @Override
  public ObjectRestResponse<GreetContentRespDTO> getGreetContentById(Long id) {
    return null;
  }

  @Override
  public ObjectRestResponse<GreetContentRespDTO> getGreetContentsByUserId(Long userId) {
    GreetContentRespDTO greetContentRespDTO = greetContentManager.getGreetContentsByUserId(userId);
    return new ObjectRestResponse<>().data(greetContentRespDTO);
  }

  @Override
  public TableResultResponse<GreetContentRespDTO> page(GreetContentPageReqDTO pageReqDTO) {
    PageResult<GreetContentRespDTO> pageResult = greetContentManager.pageGreetContent(pageReqDTO);
    TableResultResponse<GreetContentRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

}
