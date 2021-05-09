package com.github.xf717.managementweb.manager.content;

import com.github.xf717.managementweb.controller.content.dto.ProblemInformationExtendAddDTO;
import com.github.xf717.managementweb.controller.content.dto.ProblemInformationExtendUpdateDTO;
import com.github.xf717.managementweb.controller.content.dto.ProblemInformationExtendDTO;
import com.github.xf717.managementweb.controller.content.dto.ProblemInformationExtendPageDTO;
import com.github.xf717.managementweb.controller.content.vo.ProblemInformationExtendVO;
import com.github.xf717.managementweb.convert.content.ProblemInformationExtendConvert;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationExtendRespDTO;
import com.github.xf717.systemservice.rpc.content.facade.ProblemInformationExtendRpcFacade;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * ProblemInformationExtendManager
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Service
@Validated
public class ProblemInformationExtendManager {

  @Autowired
  private ProblemInformationExtendRpcFacade problemInformationExtendRpcFacade;

  /**
   * 添加数据
   * @param problemInformationExtendAddDTO 添加参数
   * @return
   */
  public int save(ProblemInformationExtendAddDTO problemInformationExtendAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = problemInformationExtendRpcFacade
        .save(ProblemInformationExtendConvert.INSTANCE.convert(problemInformationExtendAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   * @param problemInformationExtendUpdateDTO  更新参数
   * @return
   */
  public int update(ProblemInformationExtendUpdateDTO problemInformationExtendUpdateDTO) {
    BaseResponse baseResponse = problemInformationExtendRpcFacade
        .update(ProblemInformationExtendConvert.INSTANCE.convert(problemInformationExtendUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   * @param id  id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = problemInformationExtendRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   * @param id id
   * @return
   */
  public ProblemInformationExtendVO getProblemInformationExtendById(Long id) {
    ObjectRestResponse<ProblemInformationExtendRespDTO> objectRestResponse = problemInformationExtendRpcFacade.getProblemInformationExtendById(
        id);
    objectRestResponse.checkError();
    return ProblemInformationExtendConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   * @param problemInformationExtendDTO  查询参数
   * @return
   */
  public List<ProblemInformationExtendVO> listProblemInformationExtends(ProblemInformationExtendDTO problemInformationExtendDTO) {
    ObjectRestResponse<List<ProblemInformationExtendRespDTO>> objectRestResponse = problemInformationExtendRpcFacade.listProblemInformationExtends(
                ProblemInformationExtendConvert.INSTANCE.convert(problemInformationExtendDTO));
    objectRestResponse.checkError();
    return ProblemInformationExtendConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   * @param pageReqDTO  分页参数
   * @return
   */
  public TableResultResponse<ProblemInformationExtendVO> pageProblemInformationExtend(ProblemInformationExtendPageDTO pageReqDTO) {
    TableResultResponse<ProblemInformationExtendRespDTO> tableResultResponse = problemInformationExtendRpcFacade
        .page(ProblemInformationExtendConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return ProblemInformationExtendConvert.INSTANCE.convert(tableResultResponse);
  }


}
