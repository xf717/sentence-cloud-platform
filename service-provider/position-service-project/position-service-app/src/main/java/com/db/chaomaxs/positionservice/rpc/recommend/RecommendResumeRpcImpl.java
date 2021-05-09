package com.db.chaomaxs.positionservice.rpc.recommend;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.manager.recommend.RecommendResumeManager;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumePageReqDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeRespDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeUpdateReqDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.facade.RecommendResumeRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 17:09:31
 */
@Slf4j
@Service
public class RecommendResumeRpcImpl implements RecommendResumeRpcFacade {

  @Autowired
  private RecommendResumeManager recommendResumeManager;

  @Override
  public BaseResponse save(RecommendResumeCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    recommendResumeManager.saveRecommendResume(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(RecommendResumeUpdateReqDTO updateReqDTO) {
      recommendResumeManager.updateRecommendResume(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      recommendResumeManager.deleteRecommendResume(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<RecommendResumeRespDTO> getRecommendResumeById(Long id) {
      RecommendResumeRespDTO recommendResume = recommendResumeManager.getRecommendResumeById(id);
    return new ObjectRestResponse<>().data(recommendResume);
  }

  @Override
  public ObjectRestResponse<List<RecommendResumeRespDTO>> listRecommendResumes(RecommendResumeListQueryReqDTO listQuery) {
    List<RecommendResumeRespDTO> list = recommendResumeManager.listRecommendResumes(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<RecommendResumeRespDTO> page(RecommendResumePageReqDTO pageReqDTO) {
    PageResult<RecommendResumeRespDTO> pageResult = recommendResumeManager.pageRecommendResume(pageReqDTO);
    TableResultResponse<RecommendResumeRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}
