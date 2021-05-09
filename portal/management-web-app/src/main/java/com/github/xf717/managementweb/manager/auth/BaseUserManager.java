package com.github.xf717.managementweb.manager.auth;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.managementweb.controller.auth.dto.BaseUserAddDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseUserDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseUserPageDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseUserUpdateDTO;
import com.github.xf717.managementweb.controller.auth.vo.BaseUserVO;
import com.github.xf717.managementweb.controller.auth.vo.FrontUserV2VO;
import com.github.xf717.managementweb.controller.auth.vo.FrontUserVO;
import com.github.xf717.managementweb.controller.auth.vo.MenuTreeVO;
import com.github.xf717.managementweb.convert.auth.BaseMenuConvert;
import com.github.xf717.managementweb.convert.auth.BaseUserConvert;
import com.github.xf717.systemservice.rpc.auth.dto.BaseUserRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.FrontUserRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.FrontUserV2RespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.MenuTreeRespDTO;
import com.github.xf717.systemservice.rpc.auth.facade.BaseUserRpcFacade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * BaseUserManager
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Service
@Validated
public class BaseUserManager {

  @Autowired
  private BaseUserRpcFacade baseUserRpcFacade;


  /**
   * 添加数据
   *
   * @param baseUserAddDTO 添加参数
   * @return
   */
  public int save(BaseUserAddDTO baseUserAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = baseUserRpcFacade
        .save(BaseUserConvert.INSTANCE.convert(baseUserAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param baseUserUpdateDTO 更新参数
   * @return
   */
  public int update(BaseUserUpdateDTO baseUserUpdateDTO) {
    BaseResponse baseResponse = baseUserRpcFacade
        .update(BaseUserConvert.INSTANCE.convert(baseUserUpdateDTO));
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
    BaseResponse baseResponse = baseUserRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public BaseUserVO getBaseUserById(Long id) {
    ObjectRestResponse<BaseUserRespDTO> objectRestResponse = baseUserRpcFacade.getBaseUserById(id);
    objectRestResponse.checkError();
    return BaseUserConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   *
   * @param baseUserDTO 查询参数
   * @return
   */
  public List<BaseUserVO> listBaseUsers(BaseUserDTO baseUserDTO) {
    ObjectRestResponse<List<BaseUserRespDTO>> objectRestResponse = baseUserRpcFacade
        .listBaseUsers(BaseUserConvert.INSTANCE.convert(baseUserDTO));
    objectRestResponse.checkError();
    return BaseUserConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   *
   * @param pageDTO 分页参数
   * @return
   */
  public TableResultResponse<BaseUserVO> pageBaseUser(BaseUserPageDTO pageDTO) {
    TableResultResponse<BaseUserRespDTO> tableResultResponse = baseUserRpcFacade
        .page(BaseUserConvert.INSTANCE.convert(pageDTO));
    tableResultResponse.checkError();
    return BaseUserConvert.INSTANCE.convert(tableResultResponse);
  }

  public FrontUserVO getUserInfo(String token) {
    ObjectRestResponse<FrontUserRespDTO> objectRestResponse = baseUserRpcFacade
        .getUserInfo(token);
    objectRestResponse.checkError();
    return BaseUserConvert.INSTANCE.convert(objectRestResponse.getData());
  }

  public FrontUserV2VO getUserInfoV2() {
    ObjectRestResponse<FrontUserV2RespDTO> objectRestResponse = baseUserRpcFacade.getUserInfoV2();
    objectRestResponse.checkError();
    return BaseUserConvert.INSTANCE.convert(objectRestResponse.getData());
  }

  public List<MenuTreeVO> getMenusByUsername(String token) {
    ObjectRestResponse<List<MenuTreeRespDTO>> objectRestResponse = baseUserRpcFacade
        .getMenusByUsername(token);
    objectRestResponse.checkError();
    return BaseMenuConvert.INSTANCE.convert(objectRestResponse.getData());
  }
}
