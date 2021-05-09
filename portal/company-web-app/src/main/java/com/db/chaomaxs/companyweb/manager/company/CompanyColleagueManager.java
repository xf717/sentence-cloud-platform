package com.db.chaomaxs.companyweb.manager.company;

import com.db.chaomaxs.common.framework.context.BaseContextHandler;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewHandoverReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.facade.CompanyUserInterviewRpcFacade;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyColleagueInfoDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyColleaguePageDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyColleagueTransferReqDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyColleagueUpdateDTO;
import com.db.chaomaxs.companyweb.controller.company.vo.CompanyColleagueVO;
import com.db.chaomaxs.companyweb.convert.company.CompanyColleagueConvert;
import com.db.chaomaxs.positionservice.enums.position.PositionStatusEnum;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionHandoverReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionUpdateStateDTO;
import com.db.chaomaxs.positionservice.rpc.position.facade.CompanyPositionRpcFacade;
import com.db.chaomaxs.userservice.enums.user.UserBindingStateEnum;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingCompanyPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingExtendRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingInfoRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingStateUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserBindingCompanyRpcFacade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyColleagueManager
 *
 * @author hlf
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class CompanyColleagueManager {

  @Autowired
  private UserBindingCompanyRpcFacade userBindingCompanyRpcFacade;

  @Autowired
  private CompanyPositionRpcFacade companyPositionRpcFacade;

  @Autowired
  private CompanyUserInterviewRpcFacade companyUserInterviewRpcFacade;

  /**
   * 公司同事分页列表
   * @param companyColleaguePageDTO
   * @return
   */
  public TableResultResponse<CompanyColleagueVO> colleaguePage(CompanyColleaguePageDTO companyColleaguePageDTO) {

    UserBindingCompanyPageReqDTO userBindingCompanyPageReqDTO = new UserBindingCompanyPageReqDTO()
        .setBindingState(companyColleaguePageDTO.getBindingState())
        .setCompanyId(BaseContextHandler.getCompanyId());
    userBindingCompanyPageReqDTO.setPageNo(companyColleaguePageDTO.getPageNo());
    userBindingCompanyPageReqDTO.setPageSize(companyColleaguePageDTO.getPageSize());

    TableResultResponse<UserBindingInfoRespDTO> userBindingInfoPage = userBindingCompanyRpcFacade
        .page(userBindingCompanyPageReqDTO);
    return CompanyColleagueConvert.INSTANCE.convertTableResult(userBindingInfoPage);
  }

  /**
   * 绑定状态修改
   * @param companyColleagueUpdateDTO
   * @return
   */
  public void updateBindingState(CompanyColleagueUpdateDTO companyColleagueUpdateDTO) {
    userBindingCompanyRpcFacade.updateBindingState(new UserBindingStateUpdateReqDTO()
        .setId(companyColleagueUpdateDTO.getId())
        .setUserId(companyColleagueUpdateDTO.getUserId())
        .setCompanyId(BaseContextHandler.getCompanyId())
        .setBindingState(companyColleagueUpdateDTO.getBindingState()));

    // 解绑时将用户创建的职位修改为关闭状态
    if (UserBindingStateEnum.UNBIND.getValue().equals(companyColleagueUpdateDTO.getBindingState())) {
      CompanyPositionUpdateStateDTO companyPositionUpdateStateDTO = new CompanyPositionUpdateStateDTO()
          .setCompanyUserId(companyColleagueUpdateDTO.getUserId())
          .setStatus(PositionStatusEnum.CLOSE_POSITION.getCode());
      companyPositionRpcFacade.updateByCompanyUserId(companyPositionUpdateStateDTO);
    }
  }

  /**
   * 获取所有同事信息
   * @return
   */
  public ObjectRestResponse<List<CompanyColleagueInfoDTO>> getAllBindingUser() {
    ObjectRestResponse<List<UserBindingExtendRespDTO>> bindingUserRestResponse = userBindingCompanyRpcFacade
        .getAllBindingUser(BaseContextHandler.getCompanyId());
    return CompanyColleagueConvert.INSTANCE.convertList(bindingUserRestResponse);
  }

  /**
   * 管理员转移
   * @param companyColleagueTransferReqDTO
   */
  public void managerTransfer(CompanyColleagueTransferReqDTO companyColleagueTransferReqDTO) {
    companyColleagueTransferReqDTO.setCompanyId(BaseContextHandler.getCompanyId());
    userBindingCompanyRpcFacade.managerTransfer(CompanyColleagueConvert.INSTANCE.convert(companyColleagueTransferReqDTO));
  }

  /**
   * 交接
   * 1.将职位及面试信息用户id修改为交接用户id
   * 2.修改绑定表中交接人及交接状态、删除用户信息
   * @param companyColleagueTransferReqDTO
   */
  public void handover(CompanyColleagueTransferReqDTO companyColleagueTransferReqDTO) {
    companyColleagueTransferReqDTO.setCompanyId(BaseContextHandler.getCompanyId());
    // 修改职位用户id
    companyPositionRpcFacade.handover(new CompanyPositionHandoverReqDTO()
            .setUserId(companyColleagueTransferReqDTO.getUserId())
            .setHandoverUserId(companyColleagueTransferReqDTO.getTransferToUserId()));
    // 修改面试用户id
    companyUserInterviewRpcFacade.handover(new CompanyUserInterviewHandoverReqDTO()
        .setUserId(companyColleagueTransferReqDTO.getUserId())
        .setHandoverUserId(companyColleagueTransferReqDTO.getTransferToUserId()));
    // 修改交接状态及交接人
    userBindingCompanyRpcFacade.handover(CompanyColleagueConvert.INSTANCE.convert(companyColleagueTransferReqDTO));
  }


}
