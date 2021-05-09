package com.db.chaomaxs.userservice.rpc.user;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.manager.user.UserRegisterCityManager;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRegisterCityCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRegisterCityListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRegisterCityPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRegisterCityRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRegisterCityUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserRegisterCityRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Slf4j
@Service
public class UserRegisterCityRpcImpl implements UserRegisterCityRpcFacade {

  @Autowired
  private UserRegisterCityManager userRegisterCityManager;

  @Override
  public BaseResponse save(UserRegisterCityCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userRegisterCityManager.saveUserRegisterCity(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(UserRegisterCityUpdateReqDTO updateReqDTO) {
    userRegisterCityManager.updateUserRegisterCity(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      userRegisterCityManager.deleteUserRegisterCity(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<UserRegisterCityRespDTO> getUserRegisterCityById(Long id) {
      UserRegisterCityRespDTO userRegisterCity = userRegisterCityManager.getUserRegisterCityById(id);
    return new ObjectRestResponse<>().data(userRegisterCity);
  }

  @Override
  public ObjectRestResponse<List<UserRegisterCityRespDTO>> listUserRegisterCitys(UserRegisterCityListQueryReqDTO listQuery) {
    List<UserRegisterCityRespDTO> list = userRegisterCityManager.listUserRegisterCitys(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<UserRegisterCityRespDTO> page(UserRegisterCityPageReqDTO pageReqDTO) {
    PageResult<UserRegisterCityRespDTO> pageResult = userRegisterCityManager.pageUserRegisterCity(pageReqDTO);
    TableResultResponse<UserRegisterCityRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}
