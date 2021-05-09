package com.github.xf717.userweb.manager.content;

import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.systemservice.rpc.content.dto.IndustryTypeRespDTO;
import com.github.xf717.systemservice.rpc.content.facade.IndustryTypeRpcFacade;
import com.github.xf717.userweb.controller.content.vo.IndustryTypeVO;
import com.github.xf717.userweb.convert.content.IndustryTypeConvert;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * IndustryTypeManager
 *
 * @author ding
 * @date 2021-03-29 18:03:04
 */
@Service
@Validated
public class IndustryTypeManager {

  @Autowired
  private IndustryTypeRpcFacade industryTypeRpcFacade;


  /**
   * 根据parentId查询数据,不分页
   *
   * @param parentId 查询参数
   * @return
   */
  public List<IndustryTypeVO> listIndustryByParentId(Long parentId) {
    ObjectRestResponse<List<IndustryTypeRespDTO>> objectRestResponse = industryTypeRpcFacade
        .listIndustryByParentId(parentId);
    objectRestResponse.checkError();
    return IndustryTypeConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

}
