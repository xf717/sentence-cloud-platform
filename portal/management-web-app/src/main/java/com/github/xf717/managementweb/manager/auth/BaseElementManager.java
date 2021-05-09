package com.github.xf717.managementweb.manager.auth;

import com.github.xf717.common.framework.context.BaseContextHandler;
import com.github.xf717.common.framework.exception.auth.UserTokenException;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.managementweb.controller.auth.dto.BaseElementAddDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseElementDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseElementPageDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseElementUpdateDTO;
import com.github.xf717.managementweb.controller.auth.vo.BaseElementVO;
import com.github.xf717.managementweb.convert.auth.BaseElementConvert;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseUserRespDTO;
import com.github.xf717.systemservice.rpc.auth.facade.BaseElementRpcFacade;
import com.github.xf717.systemservice.rpc.auth.facade.BaseUserRpcFacade;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * BaseElementManager
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Service
@Validated
public class BaseElementManager {

  @Autowired
  private BaseElementRpcFacade baseElementRpcFacade;

  @Autowired
  private BaseUserRpcFacade baseUserRpcFacade;

  /**
   * 添加数据
   *
   * @param baseElementAddDTO 添加参数
   * @return
   */
  public int save(BaseElementAddDTO baseElementAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = baseElementRpcFacade
        .save(BaseElementConvert.INSTANCE.convert(baseElementAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param baseElementUpdateDTO 更新参数
   * @return
   */
  public int update(BaseElementUpdateDTO baseElementUpdateDTO) {
    BaseResponse baseResponse = baseElementRpcFacade
        .update(BaseElementConvert.INSTANCE.convert(baseElementUpdateDTO));
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
    BaseResponse baseResponse = baseElementRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public BaseElementVO getBaseElementById(Long id) {
    ObjectRestResponse<BaseElementRespDTO> objectRestResponse = baseElementRpcFacade
        .getBaseElementById(id);
    objectRestResponse.checkError();
    return BaseElementConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   *
   * @param baseElementDTO 查询参数
   * @return
   */
  public List<BaseElementVO> listBaseElements(BaseElementDTO baseElementDTO) {
    ObjectRestResponse<List<BaseElementRespDTO>> objectRestResponse = baseElementRpcFacade
        .listBaseElements(BaseElementConvert.INSTANCE.convert(baseElementDTO));
    objectRestResponse.checkError();
    return BaseElementConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   *
   * @param pageDTO 分页参数
   * @return
   */
  public TableResultResponse<BaseElementVO> pageBaseElement(BaseElementPageDTO pageDTO) {
    TableResultResponse<BaseElementRespDTO> tableResultResponse = baseElementRpcFacade
        .page(BaseElementConvert.INSTANCE.convert(pageDTO));
    tableResultResponse.checkError();
    return BaseElementConvert.INSTANCE.convert(tableResultResponse);
  }

  /**
   * 获取用户权限菜单资源数据
   * <p>
   * VO返回数据需要定义
   * </p>
   *
   * @param menuId
   * @return
   */
  public List<BaseElementVO> getAuthorityMenuElementByUserId(Long menuId) {
    final String username = BaseContextHandler.getUsername();
    if (StringUtils.isEmpty(username)) {
      throw new UserTokenException("获取用户名错误");
    }

    ObjectRestResponse<BaseUserRespDTO> objectRestResponse = baseUserRpcFacade
        .getUserByUsername(username);
    objectRestResponse.checkError();

    //获取用户id
    final Long userId = objectRestResponse.getData().getId();
    ObjectRestResponse<List<BaseElementRespDTO>> listObjectRestResponse = baseElementRpcFacade
        .getAuthorityMenuElementByUserId(userId, menuId);
    objectRestResponse.checkError();

    List<BaseElementRespDTO> list = listObjectRestResponse.getData();
    return BaseElementConvert.INSTANCE.convertList(list);
  }

  /**
   * 获取用户权限资源
   *
   * @return
   */
  public List<BaseElementVO> getAuthorityElementByUserId() {
    final String username = BaseContextHandler.getUsername();
    if (StringUtils.isEmpty(username)) {
      throw new UserTokenException("获取用户名错误");
    }

    ObjectRestResponse<BaseUserRespDTO> objectRestResponse = baseUserRpcFacade
        .getUserByUsername(username);
    objectRestResponse.checkError();

    //获取用户id
    final Long userId = objectRestResponse.getData().getId();
    ObjectRestResponse<List<BaseElementRespDTO>> listObjectRestResponse = baseElementRpcFacade
        .getAuthorityElementByUserId(userId);
    objectRestResponse.checkError();

    List<BaseElementRespDTO> list = listObjectRestResponse.getData();
    return BaseElementConvert.INSTANCE.convertList(list);
  }


}
