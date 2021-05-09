package com.github.xf717.userweb.manager.user;

import com.github.xf717.common.framework.context.BaseContextHandler;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userweb.controller.user.dto.UserWordAddDTO;
import com.github.xf717.userweb.controller.user.dto.UserWordPageDTO;
import com.github.xf717.userweb.controller.user.dto.UserWordUpdateDTO;
import com.github.xf717.userweb.controller.user.vo.UserWordVO;
import com.github.xf717.userweb.convert.user.UserWordConvert;
import com.github.xf717.userservice.rpc.user.dto.UserWordCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserWordRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserWordUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.facade.UserWordRpcFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserWordManager
 *
 * @author wst
 * @date 2021-03-29 12:47:47
 */
@Service
@Validated
public class UserWordManager {

  @Autowired
  private UserWordRpcFacade userWordRpcFacade;

  /**
   * 添加数据
   *
   * @param userWordAddDTO 添加参数
   * @return
   */
  public int save(UserWordAddDTO userWordAddDTO) {
    UserWordCreateReqDTO userWordCreateReqDTO = UserWordConvert.INSTANCE
        .convert(userWordAddDTO);
    userWordCreateReqDTO.setUserId(Long.parseLong(BaseContextHandler.getUserID()));
    BaseResponse baseResponse = userWordRpcFacade.save(userWordCreateReqDTO);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param userWordUpdateDTO 更新参数
   * @return
   */
  public int update(UserWordUpdateDTO userWordUpdateDTO) {
    UserWordUpdateReqDTO userWordUpdateReqDTO = UserWordConvert.INSTANCE.convert(userWordUpdateDTO);
    userWordUpdateReqDTO.setUpdateBy(1L);
    BaseResponse baseResponse = userWordRpcFacade.update(userWordUpdateReqDTO);
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
    BaseResponse baseResponse = userWordRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public UserWordVO getUserWordById(Long id) {
    ObjectRestResponse<UserWordRespDTO> objectRestResponse = userWordRpcFacade.getUserWordById(
        id);
    objectRestResponse.checkError();
    return UserWordConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 查找数据显示分页
   *
   * @param pageDTO 分页参数
   * @return
   */
  public TableResultResponse<UserWordVO> pageUserWord(UserWordPageDTO pageDTO) {
    TableResultResponse<UserWordRespDTO> tableResultResponse = userWordRpcFacade
        .page(UserWordConvert.INSTANCE.convert(pageDTO));
    tableResultResponse.checkError();
    return UserWordConvert.INSTANCE.convert(tableResultResponse);
  }

  /**
   * 根据ID置顶数据
   *
   * @param id id
   * @return
   */
  public int userWordTopByUserId(Long id) {
    Long userId = Long.parseLong(BaseContextHandler.getUserID());
    BaseResponse baseResponse = userWordRpcFacade.userWordTopByUserId(id, userId);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

}
