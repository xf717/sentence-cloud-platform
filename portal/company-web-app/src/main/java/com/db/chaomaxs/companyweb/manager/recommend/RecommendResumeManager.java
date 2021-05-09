package com.db.chaomaxs.companyweb.manager.recommend;

import com.db.chaomaxs.companyweb.controller.recommend.dto.RecommendResumeAddDTO;
import com.db.chaomaxs.companyweb.controller.recommend.dto.RecommendResumeUpdateDTO;
import com.db.chaomaxs.companyweb.controller.recommend.dto.RecommendResumeDTO;
import com.db.chaomaxs.companyweb.controller.recommend.dto.RecommendResumePageDTO;
import com.db.chaomaxs.companyweb.controller.recommend.vo.RecommendResumeVO;
import com.db.chaomaxs.companyweb.convert.recommend.RecommendResumeConvert;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeRespDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.facade.RecommendResumeRpcFacade;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * RecommendResumeManager
 *
 * @author xiaofeng
 * @date 2021-03-29 17:09:31
 */
@Service
@Validated
public class RecommendResumeManager {

  @Autowired
  private RecommendResumeRpcFacade recommendResumeRpcFacade;

  /**
   * 添加数据
   *
   * @param recommendResumeCreateReqDTO 添加参数
   * @return
   */
  public int save(RecommendResumeAddDTO recommendResumeAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = recommendResumeRpcFacade
        .save(RecommendResumeConvert.INSTANCE.convert(recommendResumeAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param recommendResumeUpdateDTO 更新参数
   * @return
   */
  public int update(RecommendResumeUpdateDTO recommendResumeUpdateDTO) {
    BaseResponse baseResponse = recommendResumeRpcFacade
        .update(RecommendResumeConvert.INSTANCE.convert(recommendResumeUpdateDTO));
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
    BaseResponse baseResponse = recommendResumeRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public RecommendResumeVO getRecommendResumeById(Long id) {
    ObjectRestResponse<RecommendResumeRespDTO> objectRestResponse = recommendResumeRpcFacade
        .getRecommendResumeById(
            id);
    objectRestResponse.checkError();
    return RecommendResumeConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   *
   * @param recommendResumeDTO 查询参数
   * @return
   */
  public List<RecommendResumeVO> listRecommendResumes(RecommendResumeDTO recommendResumeDTO) {
    ObjectRestResponse<List<RecommendResumeRespDTO>> objectRestResponse = recommendResumeRpcFacade
        .listRecommendResumes(
            RecommendResumeConvert.INSTANCE.convert(recommendResumeDTO));
    objectRestResponse.checkError();
    return RecommendResumeConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  public TableResultResponse<RecommendResumeVO> pageRecommendResume(
      RecommendResumePageDTO pageReqDTO) {
    TableResultResponse<RecommendResumeRespDTO> tableResultResponse = recommendResumeRpcFacade
        .page(RecommendResumeConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return RecommendResumeConvert.INSTANCE.convert(tableResultResponse);
  }


}
