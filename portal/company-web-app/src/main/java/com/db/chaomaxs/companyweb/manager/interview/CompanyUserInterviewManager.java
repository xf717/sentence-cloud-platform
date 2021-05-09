package com.db.chaomaxs.companyweb.manager.interview;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewRespDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewUpdateStateReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.facade.CompanyUserInterviewRpcFacade;
import com.db.chaomaxs.companyweb.controller.interview.dto.CompanyUserInterviewAddDTO;
import com.db.chaomaxs.companyweb.controller.interview.dto.CompanyUserInterviewPageDTO;
import com.db.chaomaxs.companyweb.controller.interview.dto.CompanyUserInterviewUpdateDTO;
import com.db.chaomaxs.companyweb.controller.interview.vo.CompanyUserInterviewVO;
import com.db.chaomaxs.companyweb.convert.interview.CompanyUserInterviewConvert;
import com.db.chaomaxs.companyweb.manager.interview.interview.CompanyUserInterviewStateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyUserInterviewManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class CompanyUserInterviewManager {

  @Autowired
  private CompanyUserInterviewRpcFacade companyUserInterviewRpcFacade;

  @Autowired
  private CompanyUserInterviewStateFactory companyUserInterviewStateFactory;

  /**
   * 添加数据
   *
   * @param companyUserInterviewAddDTO 添加参数
   * @return
   */
  public int save(CompanyUserInterviewAddDTO companyUserInterviewAddDTO) {
    BaseResponse baseResponse = companyUserInterviewRpcFacade.save(CompanyUserInterviewConvert.INSTANCE.convert(companyUserInterviewAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param companyUserInterviewUpdateDTO 更新参数
   * @return
   */
  public int update(CompanyUserInterviewUpdateDTO companyUserInterviewUpdateDTO) {
    BaseResponse baseResponse = companyUserInterviewRpcFacade.update(CompanyUserInterviewConvert.INSTANCE.convert(companyUserInterviewUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param companyUserInterviewUpdateStateReqDTO 更新参数
   * @return
   */
  public int updateState(CompanyUserInterviewUpdateStateReqDTO companyUserInterviewUpdateStateReqDTO) {
    BaseResponse baseResponse = companyUserInterviewStateFactory.updateUserInterviewState(companyUserInterviewUpdateStateReqDTO);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public CompanyUserInterviewVO getCompanyUserInterviewById(Long id) {
    ObjectRestResponse<CompanyUserInterviewRespDTO> objectRestResponse = companyUserInterviewRpcFacade.getCompanyUserInterviewById(id);
    objectRestResponse.checkError();
    return CompanyUserInterviewConvert.INSTANCE.convert(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  public TableResultResponse<CompanyUserInterviewVO> pageCompanyUserInterview(CompanyUserInterviewPageDTO pageReqDTO) {
    TableResultResponse<CompanyUserInterviewRespDTO> tableResultResponse = companyUserInterviewRpcFacade.page(CompanyUserInterviewConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return CompanyUserInterviewConvert.INSTANCE.convert(tableResultResponse);
  }


}
