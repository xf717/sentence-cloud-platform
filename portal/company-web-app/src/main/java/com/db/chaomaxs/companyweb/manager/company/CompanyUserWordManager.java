package com.db.chaomaxs.companyweb.manager.company;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.facade.CompanyUserWordRpcFacade;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyUserWordAddDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyUserWordDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyUserWordPageDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyUserWordUpdateDTO;
import com.db.chaomaxs.companyweb.controller.company.vo.CompanyUserWordVO;
import com.db.chaomaxs.companyweb.convert.company.CompanyUserWordConvert;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyUserWordManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class CompanyUserWordManager {

  @Autowired
  private CompanyUserWordRpcFacade companyUserWordRpcFacade;

  /**
   * 添加数据
   *
   * @param companyUserWordCreateReqDTO 添加参数
   * @return
   */
  public int save(CompanyUserWordAddDTO companyUserWordAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = companyUserWordRpcFacade
        .save(CompanyUserWordConvert.INSTANCE.convert(companyUserWordAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param companyUserWordUpdateDTO 更新参数
   * @return
   */
  public int update(CompanyUserWordUpdateDTO companyUserWordUpdateDTO) {
    BaseResponse baseResponse = companyUserWordRpcFacade
        .update(CompanyUserWordConvert.INSTANCE.convert(companyUserWordUpdateDTO));
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
    BaseResponse baseResponse = companyUserWordRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public CompanyUserWordVO getCompanyUserWordById(Long id) {
    ObjectRestResponse<CompanyUserWordRespDTO> objectRestResponse = companyUserWordRpcFacade
        .getCompanyUserWordById(id);
    objectRestResponse.checkError();
    return CompanyUserWordConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   *
   * @param companyUserWordDTO 查询参数
   * @return
   */
  public List<CompanyUserWordVO> listCompanyUserWords(CompanyUserWordDTO companyUserWordDTO) {
    ObjectRestResponse<List<CompanyUserWordRespDTO>> objectRestResponse = companyUserWordRpcFacade
        .listCompanyUserWords(CompanyUserWordConvert.INSTANCE.convert(companyUserWordDTO));
    objectRestResponse.checkError();
    return CompanyUserWordConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  public TableResultResponse<CompanyUserWordVO> pageCompanyUserWord(
      CompanyUserWordPageDTO pageDTO) {
    TableResultResponse<CompanyUserWordRespDTO> tableResultResponse = companyUserWordRpcFacade
        .page(CompanyUserWordConvert.INSTANCE.convert(pageDTO));
    tableResultResponse.checkError();
    return CompanyUserWordConvert.INSTANCE.convert(tableResultResponse);
  }


}
