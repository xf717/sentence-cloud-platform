package com.db.chaomaxs.systemservice.rpc.content;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.manager.content.ProblemInformationExtendManager;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationExtendCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationExtendListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationExtendPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationExtendRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationExtendUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.facade.ProblemInformationExtendRpcFacade;
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
public class ProblemInformationExtendRpcImpl implements ProblemInformationExtendRpcFacade {

  @Autowired
  private ProblemInformationExtendManager problemInformationExtendManager;

  @Override
  public BaseResponse save(ProblemInformationExtendCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    problemInformationExtendManager.saveProblemInformationExtend(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(ProblemInformationExtendUpdateReqDTO updateReqDTO) {
      problemInformationExtendManager.updateProblemInformationExtend(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      problemInformationExtendManager.deleteProblemInformationExtend(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<ProblemInformationExtendRespDTO> getProblemInformationExtendById(Long id) {
      ProblemInformationExtendRespDTO problemInformationExtend = problemInformationExtendManager.getProblemInformationExtendById(id);
    return new ObjectRestResponse<>().data(problemInformationExtend);
  }

  @Override
  public ObjectRestResponse<List<ProblemInformationExtendRespDTO>> listProblemInformationExtends(ProblemInformationExtendListQueryReqDTO listQuery) {
    List<ProblemInformationExtendRespDTO> list = problemInformationExtendManager.listProblemInformationExtends(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<ProblemInformationExtendRespDTO> page(ProblemInformationExtendPageReqDTO pageReqDTO) {
    PageResult<ProblemInformationExtendRespDTO> pageResult = problemInformationExtendManager.pageProblemInformationExtend(pageReqDTO);
    TableResultResponse<ProblemInformationExtendRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}
