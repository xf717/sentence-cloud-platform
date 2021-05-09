package com.db.chaomaxs.companyweb.manager.settings;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetRespDTO;
import com.db.chaomaxs.companyservice.rpc.settings.facade.CompanyUserSetRpcFacade;
import com.db.chaomaxs.companyweb.controller.settings.dto.CompanyUserSetAddDTO;
import com.db.chaomaxs.companyweb.controller.settings.dto.CompanyUserSetDTO;
import com.db.chaomaxs.companyweb.controller.settings.dto.CompanyUserSetPageDTO;
import com.db.chaomaxs.companyweb.controller.settings.dto.CompanyUserSetUpdateDTO;
import com.db.chaomaxs.companyweb.controller.settings.vo.CompanyUserSetVO;
import com.db.chaomaxs.companyweb.convert.settings.CompanyUserSetConvert;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyUserSetManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@Service
@Validated
public class CompanyUserSetManager {

  @Autowired
  private CompanyUserSetRpcFacade companyUserSetRpcFacade;

  /**
   * 添加数据
   * @param companyUserSetAddDTO 添加参数
   * @return
   */
  public int save(CompanyUserSetAddDTO companyUserSetAddDTO){
    // TODO 自己实业务 只是个简单的例子
     BaseResponse baseResponse =  companyUserSetRpcFacade.save(CompanyUserSetConvert.INSTANCE.convert(companyUserSetAddDTO));
     baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   * @param companyUserSetUpdateDTO  更新参数
   * @return
   */
  public int update(CompanyUserSetUpdateDTO companyUserSetUpdateDTO){
    BaseResponse baseResponse =  companyUserSetRpcFacade.update(CompanyUserSetConvert.INSTANCE.convert(companyUserSetUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   * @param id id
   * @return
   */
  public CompanyUserSetVO getCompanyUserSetById(Long id){
    ObjectRestResponse<CompanyUserSetRespDTO> objectRestResponse = companyUserSetRpcFacade.getCompanyUserSetById(id);
    objectRestResponse.checkError();
    return CompanyUserSetConvert.INSTANCE.convert(objectRestResponse.getData());
  }
}
