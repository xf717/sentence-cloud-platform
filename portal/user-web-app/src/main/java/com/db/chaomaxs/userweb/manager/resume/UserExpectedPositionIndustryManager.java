package com.db.chaomaxs.userweb.manager.resume;


import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.userweb.controller.resume.dto.UserExpectedPositionIndustryAddDTO;
import com.db.chaomaxs.userweb.controller.resume.dto.UserExpectedPositionIndustryUpdateDTO;
import com.db.chaomaxs.userweb.controller.resume.vo.UserExpectedPositionIndustryVO;
import com.db.chaomaxs.userweb.convert.resume.UserExpectedPositionIndustryConvert;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionIndustryRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.facade.UserExpectedPositionIndustryRpcFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserExpectedPositionIndustryManager
 *
 * @author wst
 * @date 2021-04-12 13:47:08
 */
@Service
@Validated
public class UserExpectedPositionIndustryManager {

  @Autowired
  private UserExpectedPositionIndustryRpcFacade userExpectedPositionIndustryRpcFacade;

  /**
   * 添加数据
   *
   * @param userExpectedPositionIndustryAddDTO 添加参数
   * @return
   */
  public int save(UserExpectedPositionIndustryAddDTO userExpectedPositionIndustryAddDTO) {
    BaseResponse baseResponse = userExpectedPositionIndustryRpcFacade
        .save(UserExpectedPositionIndustryConvert.INSTANCE
            .convert(userExpectedPositionIndustryAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param userExpectedPositionIndustryUpdateDTO 更新参数
   * @return
   */
  public int update(UserExpectedPositionIndustryUpdateDTO userExpectedPositionIndustryUpdateDTO) {
    BaseResponse baseResponse = userExpectedPositionIndustryRpcFacade
        .update(UserExpectedPositionIndustryConvert.INSTANCE
            .convert(userExpectedPositionIndustryUpdateDTO));
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
    BaseResponse baseResponse = userExpectedPositionIndustryRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public UserExpectedPositionIndustryVO getUserExpectedPositionIndustryById(Long id) {
    ObjectRestResponse<UserExpectedPositionIndustryRespDTO> objectRestResponse = userExpectedPositionIndustryRpcFacade
        .getUserExpectedPositionIndustryById(
            id);
    objectRestResponse.checkError();
    return UserExpectedPositionIndustryConvert.INSTANCE.convert(objectRestResponse.getData());
  }


}
