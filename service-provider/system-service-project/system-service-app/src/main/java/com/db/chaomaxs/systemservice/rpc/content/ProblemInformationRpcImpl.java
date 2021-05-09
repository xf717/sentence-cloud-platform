package com.db.chaomaxs.systemservice.rpc.content;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.manager.content.ProblemInformationManager;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.facade.ProblemInformationRpcFacade;
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
public class ProblemInformationRpcImpl implements ProblemInformationRpcFacade {

  @Autowired
  private ProblemInformationManager problemInformationManager;

  @Override
  public BaseResponse save(ProblemInformationCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    problemInformationManager.saveProblemInformation(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(ProblemInformationUpdateReqDTO updateReqDTO) {
      problemInformationManager.updateProblemInformation(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      problemInformationManager.deleteProblemInformation(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<ProblemInformationRespDTO> getProblemInformationById(Long id) {
      ProblemInformationRespDTO problemInformation = problemInformationManager.getProblemInformationById(id);
    return new ObjectRestResponse<>().data(problemInformation);
  }

  @Override
  public ObjectRestResponse<List<ProblemInformationRespDTO>> listProblemInformations(ProblemInformationListQueryReqDTO listQuery) {
    List<ProblemInformationRespDTO> list = problemInformationManager.listProblemInformations(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<ProblemInformationRespDTO> page(ProblemInformationPageReqDTO pageReqDTO) {
    PageResult<ProblemInformationRespDTO> pageResult = problemInformationManager.pageProblemInformation(pageReqDTO);
    TableResultResponse<ProblemInformationRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}
