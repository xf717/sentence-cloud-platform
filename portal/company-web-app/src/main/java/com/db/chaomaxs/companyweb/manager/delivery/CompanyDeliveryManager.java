package com.db.chaomaxs.companyweb.manager.delivery;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryRespDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.facade.CompanyDeliveryRpcFacade;
import com.db.chaomaxs.companyweb.controller.delivery.dto.CompanyDeliveryAddDTO;
import com.db.chaomaxs.companyweb.controller.delivery.dto.CompanyDeliveryPageDTO;
import com.db.chaomaxs.companyweb.controller.delivery.vo.CompanyDeliveryVO;
import com.db.chaomaxs.companyweb.convert.company.CompanyReceiveResumeConvert;
import com.db.chaomaxs.companyweb.convert.delivery.CompanyDeliveryConvert;
import com.db.chaomaxs.companyweb.service.resume.UserResumeInfoService;
import com.db.chaomaxs.companyweb.service.resume.bo.UserResumeInfoBO;
import com.db.chaomaxs.companyweb.service.resume.vo.UserResumeInfoVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyDeliveryManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class CompanyDeliveryManager {

  @Autowired
  private CompanyDeliveryRpcFacade companyDeliveryRpcFacade;

  @Autowired
  private UserResumeInfoService userResumeService;

  /**
   * 添加数据
   *
   * @param companyDeliveryAddDTO 添加参数
   * @return
   */
  public int save(CompanyDeliveryAddDTO companyDeliveryAddDTO) {
    BaseResponse baseResponse = companyDeliveryRpcFacade
        .save(CompanyDeliveryConvert.INSTANCE.convert(companyDeliveryAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }


  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public CompanyDeliveryVO getCompanyDeliveryById(Long id) {
    ObjectRestResponse<CompanyDeliveryRespDTO> objectRestResponse = companyDeliveryRpcFacade
        .getCompanyDeliveryById(id);
    objectRestResponse.checkError();
    return CompanyDeliveryConvert.INSTANCE.convert(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  public TableResultResponse<UserResumeInfoVO> pageCompanyDelivery(
      CompanyDeliveryPageDTO pageReqDTO) {
    CompanyDeliveryPageReqDTO companyDeliveryPageReqDTO = CompanyDeliveryConvert.INSTANCE
        .convert(pageReqDTO);
    companyDeliveryPageReqDTO.setCompanyUserId(1L);
    TableResultResponse<CompanyDeliveryRespDTO> tableResultResponse = companyDeliveryRpcFacade
        .page(companyDeliveryPageReqDTO);
    tableResultResponse.checkError();
    TableResultResponse<UserResumeInfoBO> response = CompanyReceiveResumeConvert.INSTANCE
        .convertFromDelivery(tableResultResponse);
    List<UserResumeInfoVO> userResumeInfoVOList = userResumeService
        .dealResumeDeliveryPageResp(response);
    return new TableResultResponse(tableResultResponse.getData().getTotal(), userResumeInfoVOList);
  }

}
