package com.db.chaomaxs.companyweb.manager.chat;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatRespDTO;
import com.db.chaomaxs.companyservice.rpc.chat.facade.CompanyUserChatRpcFacade;
import com.db.chaomaxs.companyweb.controller.chat.dto.CompanyUserChatAddDTO;
import com.db.chaomaxs.companyweb.controller.chat.dto.CompanyUserChatPageDTO;
import com.db.chaomaxs.companyweb.controller.chat.vo.CompanyUserChatVO;
import com.db.chaomaxs.companyweb.convert.chat.CompanyUserChatConvert;
import com.db.chaomaxs.companyweb.convert.company.CompanyReceiveResumeConvert;
import com.db.chaomaxs.companyweb.service.resume.UserResumeInfoService;
import com.db.chaomaxs.companyweb.service.resume.bo.UserResumeInfoBO;
import com.db.chaomaxs.companyweb.service.resume.vo.UserResumeInfoVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyUserChatManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class CompanyUserChatManager {

  @Autowired
  private CompanyUserChatRpcFacade companyUserChatRpcFacade;

  @Autowired
  private UserResumeInfoService userResumeService;

  /**
   * 添加数据
   *
   * @param companyUserChatAddDTO 添加参数
   * @return
   */
  public int save(CompanyUserChatAddDTO companyUserChatAddDTO) {
    BaseResponse baseResponse = companyUserChatRpcFacade
        .save(CompanyUserChatConvert.INSTANCE.convert(companyUserChatAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }


  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public CompanyUserChatVO getCompanyUserChatById(Long id) {
    ObjectRestResponse<CompanyUserChatRespDTO> objectRestResponse = companyUserChatRpcFacade
        .getCompanyUserChatById(id);
    objectRestResponse.checkError();
    return CompanyUserChatConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 查找数据显示分页
   *
   * @param pageDTO 分页参数
   * @return
   */
  public TableResultResponse<UserResumeInfoVO> pageCompanyUserChat(CompanyUserChatPageDTO pageDTO) {

    CompanyUserChatPageReqDTO companyUserChatPageReqDTO = CompanyUserChatConvert.INSTANCE
        .convert(pageDTO);
    companyUserChatPageReqDTO.setCompanyUserId(1L);
    TableResultResponse<CompanyUserChatRespDTO> tableResultResponse = companyUserChatRpcFacade
        .page(companyUserChatPageReqDTO);
    tableResultResponse.checkError();
    TableResultResponse<UserResumeInfoBO> response = CompanyReceiveResumeConvert.INSTANCE
        .convertFromUserChat(tableResultResponse);
    List<UserResumeInfoVO> userResumeInfoVOList = userResumeService
        .dealResumeDeliveryPageResp(response);
    return new TableResultResponse(tableResultResponse.getData().getTotal(), userResumeInfoVOList);
  }


}
