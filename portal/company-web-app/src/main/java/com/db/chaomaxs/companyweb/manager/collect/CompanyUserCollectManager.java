package com.db.chaomaxs.companyweb.manager.collect;

import com.db.chaomaxs.common.framework.context.BaseContextHandler;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.collect.dto.CompanyUserCollectCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.CompanyUserCollectPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.CompanyUserCollectRespDTO;
import com.db.chaomaxs.companyservice.rpc.collect.facade.CompanyUserCollectRpcFacade;
import com.db.chaomaxs.companyweb.controller.collect.dto.CompanyUserCollectAddDTO;
import com.db.chaomaxs.companyweb.controller.collect.dto.CompanyUserCollectPageDTO;
import com.db.chaomaxs.companyweb.controller.collect.vo.CompanyUserCollectVO;
import com.db.chaomaxs.companyweb.convert.collect.CompanyUserCollectConvert;
import com.db.chaomaxs.companyweb.convert.company.CompanyReceiveResumeConvert;
import com.db.chaomaxs.companyweb.service.resume.UserResumeInfoService;
import com.db.chaomaxs.companyweb.service.resume.bo.UserResumeInfoBO;
import com.db.chaomaxs.companyweb.service.resume.vo.UserResumeInfoVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyUserCollectManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class CompanyUserCollectManager {

  @Autowired
  private CompanyUserCollectRpcFacade companyUserCollectRpcFacade;

  @Autowired
  private UserResumeInfoService userResumeService;

  /**
   * 添加数据
   *
   * @param companyUserCollectAddDTO 添加参数
   * @return
   */
  public int save(CompanyUserCollectAddDTO companyUserCollectAddDTO) {
    CompanyUserCollectCreateReqDTO reqDTO = CompanyUserCollectConvert.INSTANCE
        .convert(companyUserCollectAddDTO);
    reqDTO.setCompanyUserId(BaseContextHandler.getUserId());
    BaseResponse baseResponse = companyUserCollectRpcFacade.save(reqDTO);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }


  /**
   * 根据ID删除数据
   *
   * @param id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = companyUserCollectRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id
   * @return
   */
  public CompanyUserCollectVO getCompanyUserCollectById(Long id) {
    ObjectRestResponse<CompanyUserCollectRespDTO> objectRestResponse = companyUserCollectRpcFacade
        .getCompanyUserCollectById(id);
    objectRestResponse.checkError();
    return CompanyUserCollectConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  public TableResultResponse<UserResumeInfoVO> pageCompanyUserCollect(
      CompanyUserCollectPageDTO pageReqDTO) {
    CompanyUserCollectPageReqDTO reqDTO = CompanyUserCollectConvert.INSTANCE.convert(pageReqDTO);
    reqDTO.setCompanyUserId(1L);
    TableResultResponse<CompanyUserCollectRespDTO> tableResultResponse = companyUserCollectRpcFacade
        .page(reqDTO);
    tableResultResponse.checkError();
    TableResultResponse<UserResumeInfoBO> response = CompanyReceiveResumeConvert.INSTANCE
        .convertFromCollect(tableResultResponse);
    List<UserResumeInfoVO> userResumeInfoList = userResumeService
        .dealResumeDeliveryPageResp(response);
    return new TableResultResponse(tableResultResponse.getData().getTotal(), userResumeInfoList);
  }


}
