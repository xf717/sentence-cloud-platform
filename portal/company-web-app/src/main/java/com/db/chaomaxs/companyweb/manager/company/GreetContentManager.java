package com.db.chaomaxs.companyweb.manager.company;

import com.db.chaomaxs.common.framework.context.BaseContextHandler;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.facade.GreetContentRpcFacade;
import com.db.chaomaxs.companyweb.controller.company.dto.GreetContentEnableHideDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.GreetContentUpdateDTO;
import com.db.chaomaxs.companyweb.controller.company.vo.DictionaryItemVO;
import com.db.chaomaxs.companyweb.controller.company.vo.GreetContentVO;
import com.db.chaomaxs.companyweb.convert.company.GreetContentConvert;
import com.db.chaomaxs.systemservice.enums.dict.DataDictionaryEnum;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemRespDTO;
import com.db.chaomaxs.systemservice.rpc.dict.facade.DataDictionaryItemRpcFacade;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendUpdateEnableHideReqDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserExtendRpcFacade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * GreetContentManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class GreetContentManager {

  @Autowired
  private GreetContentRpcFacade greetContentRpcFacade;

  @Autowired
  private DataDictionaryItemRpcFacade dataDictionaryItemRpcFacade;

  @Autowired
  private UserExtendRpcFacade userExtendRpcFacade;


  /**
   * 更新数据
   *
   * @param greetContentUpdateDTO 更新参数
   * @return
   */
  public int update(GreetContentUpdateDTO greetContentUpdateDTO) {
    greetContentUpdateDTO.setUserId(Long.parseLong(BaseContextHandler.getUserID()));
    BaseResponse baseResponse = greetContentRpcFacade
        .update(GreetContentConvert.INSTANCE.convert(greetContentUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }


  /**
   * 查找数据
   *
   * @return
   */
  public GreetContentVO listGreetContents() {
    ObjectRestResponse<GreetContentRespDTO> objectRestResponse = greetContentRpcFacade
        .getGreetContentsByUserId(Long.parseLong(BaseContextHandler.getUserID()));
    objectRestResponse.checkError();
    GreetContentVO greetContentVO = GreetContentConvert.INSTANCE
        .convert(objectRestResponse.getData());
    //查询打招呼字典信息
    DataDictionaryItemListQueryReqDTO dataDictionaryItemDTO = new DataDictionaryItemListQueryReqDTO();
    dataDictionaryItemDTO
        .setDictionaryTypeId(DataDictionaryEnum.GREETINGS_FROM_JOB_APPLICANTS.getKey());
    ObjectRestResponse<List<DataDictionaryItemRespDTO>> listObjectRestResponse = dataDictionaryItemRpcFacade
        .listDataDictionaryItems(dataDictionaryItemDTO);
    List<DictionaryItemVO> dictionaryItemList = GreetContentConvert.INSTANCE
        .convertToList(listObjectRestResponse.getData());
    // 查询打招呼开关按钮
    ObjectRestResponse<UserExtendRespDTO> userExtendResponse = userExtendRpcFacade
        .getUserExtendByUserId(Long.parseLong(BaseContextHandler.getUserID()));
    greetContentVO.setIsEnabledGreet(userExtendResponse.getData().getIsEnabledGreet());
    greetContentVO.setDictionaryItemList(dictionaryItemList);
    return greetContentVO;
  }

  /**
   * 更新打招呼语按钮开关
   * @param greetContentEnableHideDTO
   * @return
   */
  public int updateEnableHideDTO(GreetContentEnableHideDTO greetContentEnableHideDTO) {
    greetContentEnableHideDTO.setUserId(Long.parseLong(BaseContextHandler.getUserID()));
    UserExtendUpdateEnableHideReqDTO reqDTO = GreetContentConvert.INSTANCE.convert(greetContentEnableHideDTO);
    reqDTO.setUserId(Long.parseLong(BaseContextHandler.getUserID()));
    BaseResponse baseResponse = userExtendRpcFacade.updateEnableHideDTO(reqDTO);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }
}
