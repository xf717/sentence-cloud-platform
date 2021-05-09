package com.db.chaomaxs.companyweb.manager.company;

import com.db.chaomaxs.common.framework.context.BaseContextHandler;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.enums.CompanyErrorCodeConstants;
import com.db.chaomaxs.companyservice.enums.welfare.CompanyWelfareTypeEnum;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.facade.CompanyWelfareRpcFacade;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyWelfareAddDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyWelfareUpdateDTO;
import com.db.chaomaxs.companyweb.controller.company.vo.CompanyWelfareInfoVO;
import com.db.chaomaxs.companyweb.controller.company.vo.CompanyWelfareVO;
import com.db.chaomaxs.companyweb.convert.company.CompanyWelfareConvert;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyWelfareManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class CompanyWelfareManager {

  @Autowired
  private CompanyWelfareRpcFacade companyWelfareRpcFacade;


  /**
   * 自定义福利类型保存
   *
   * @param companyWelfareCreateReqDTO 添加参数
   * @return
   */
  public int customTypeSave(CompanyWelfareAddDTO companyWelfareAddDTO) {
    companyWelfareAddDTO.setCompanyId(BaseContextHandler.getCompanyId());
    companyWelfareAddDTO.setWelfareType(CompanyWelfareTypeEnum.CUSTOM.getValue());
    BaseResponse baseResponse = companyWelfareRpcFacade
        .customTypeSave(CompanyWelfareConvert.INSTANCE.convert(companyWelfareAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param companyWelfareUpdateDTO 更新参数
   * @return
   */
  public int update(CompanyWelfareUpdateDTO companyWelfareUpdateDTO) {
    // 判断是否为自定义福利类型
    if (CompanyWelfareTypeEnum.GENERAL.getValue().equals(companyWelfareUpdateDTO.getWelfareType())) {
      throw ServiceExceptionUtil.exception(CompanyErrorCodeConstants.DEFAULT_WELFARE_NOT_EDIT.getCode());
    }
    companyWelfareUpdateDTO.setCompanyId(BaseContextHandler.getCompanyId());
    BaseResponse baseResponse = companyWelfareRpcFacade
        .update(CompanyWelfareConvert.INSTANCE.convert(companyWelfareUpdateDTO));
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
    BaseResponse baseResponse = companyWelfareRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public CompanyWelfareVO getCompanyWelfareById(Long id) {
    ObjectRestResponse<CompanyWelfareRespDTO> objectRestResponse = companyWelfareRpcFacade
        .getCompanyWelfareById(id);
    objectRestResponse.checkError();
    return CompanyWelfareConvert.INSTANCE.convert(objectRestResponse.getData());
  }

  /**
   * 获取公司福利类型
   * @return
   */
  public CompanyWelfareInfoVO getCompanyWelfare() {
    ObjectRestResponse<List<CompanyWelfareRespDTO>> chooseWelfareResponse = companyWelfareRpcFacade
        .listWelfareTypes(BaseContextHandler.getCompanyId());
    List<CompanyWelfareVO> chooseWelfareVOs = CompanyWelfareConvert.INSTANCE
        .convertList(chooseWelfareResponse.getData());
    CompanyWelfareInfoVO companyWelfareInfoVO = new CompanyWelfareInfoVO()
        .setCompanyWelfareVOs(chooseWelfareVOs)
        .setChooseNumber((int) chooseWelfareVOs.stream().filter(v -> v.getChoose() == 1).count());
    return companyWelfareInfoVO;
  }

  /**
   * 保存公司福利
   * @param companyWelfareAddDTOs
   * @return
   */
  public void saveChooseWelfare(List<CompanyWelfareAddDTO> companyWelfareAddDTOs) {
    Long companyId = BaseContextHandler.getCompanyId();
    companyWelfareAddDTOs.forEach(v -> v.setCompanyId(companyId));
    companyWelfareRpcFacade.saveChooseWelfare(CompanyWelfareConvert.INSTANCE
        .convertToCompanyWelfareSaveReqDTOs(companyWelfareAddDTOs));
  }

  /**
   * 获取所有福利类型
   * @return
   */
  public List<CompanyWelfareVO> listAllWelfare() {
    ObjectRestResponse<List<CompanyWelfareRespDTO>> welfareResponse = companyWelfareRpcFacade
        .listAllWelfare(BaseContextHandler.getCompanyId());
    return CompanyWelfareConvert.INSTANCE.convertList(welfareResponse.getData());
  }

}
