package com.github.xf717.userweb.manager.user;

import com.github.xf717.userservice.rpc.user.dto.UserBlacklistRespDTO;
import com.github.xf717.userweb.controller.user.dto.UserBlacklistAddDTO;
import com.github.xf717.userweb.controller.user.dto.UserBlacklistUpdateDTO;
import com.github.xf717.userweb.controller.user.dto.UserBlacklistDTO;
import com.github.xf717.userweb.controller.user.dto.UserBlacklistPageDTO;
import com.github.xf717.userweb.controller.user.vo.UserBlacklistVO;
import com.github.xf717.userweb.convert.user.UserBlacklistConvert;
import com.github.xf717.userservice.rpc.user.facade.UserBlacklistRpcFacade;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserBlacklistManager
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Service
@Validated
public class UserBlacklistManager {

  @Autowired
  private UserBlacklistRpcFacade userBlacklistRpcFacade;

  /**
   * 添加数据
   * @param userBlacklistAddDTO 添加参数
   * @return
   */
  public int save(UserBlacklistAddDTO userBlacklistAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = userBlacklistRpcFacade
        .save(UserBlacklistConvert.INSTANCE.convert(userBlacklistAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   * @param userBlacklistUpdateDTO  更新参数
   * @return
   */
  public int update(UserBlacklistUpdateDTO userBlacklistUpdateDTO) {
    BaseResponse baseResponse = userBlacklistRpcFacade
        .update(UserBlacklistConvert.INSTANCE.convert(userBlacklistUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   * @param id  id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = userBlacklistRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   * @param id id
   * @return
   */
  public UserBlacklistVO getUserBlacklistById(Long id) {
    ObjectRestResponse<UserBlacklistRespDTO> objectRestResponse = userBlacklistRpcFacade.getUserBlacklistById(
        id);
    objectRestResponse.checkError();
    return UserBlacklistConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   * @param userBlacklistDTO  查询参数
   * @return
   */
  public List<UserBlacklistVO> listUserBlacklists(UserBlacklistDTO userBlacklistDTO) {
    ObjectRestResponse<List<UserBlacklistRespDTO>> objectRestResponse = userBlacklistRpcFacade.listUserBlacklists(
                UserBlacklistConvert.INSTANCE.convert(userBlacklistDTO));
    objectRestResponse.checkError();
    return UserBlacklistConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   * @param pageDTO  分页参数
   * @return
   */
  public TableResultResponse<UserBlacklistVO> pageUserBlacklist(UserBlacklistPageDTO pageDTO) {
    TableResultResponse<UserBlacklistRespDTO> tableResultResponse = userBlacklistRpcFacade
        .page(UserBlacklistConvert.INSTANCE.convert(pageDTO));
    tableResultResponse.checkError();
    return UserBlacklistConvert.INSTANCE.convert(tableResultResponse);
  }


}
