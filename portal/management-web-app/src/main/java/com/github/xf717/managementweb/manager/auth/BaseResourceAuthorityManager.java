package com.github.xf717.managementweb.manager.auth;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.managementweb.controller.auth.dto.BaseResourceAuthorityAddDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseResourceAuthorityDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseResourceAuthorityPageDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseResourceAuthorityUpdateDTO;
import com.github.xf717.managementweb.controller.auth.vo.BaseResourceAuthorityVO;
import com.github.xf717.managementweb.convert.auth.BaseResourceAuthorityConvert;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityRespDTO;
import com.github.xf717.systemservice.rpc.auth.facade.BaseResourceAuthorityRpcFacade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * BaseResourceAuthorityManager
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Service
@Validated
public class BaseResourceAuthorityManager {

  @Autowired
  private BaseResourceAuthorityRpcFacade baseResourceAuthorityRpcFacade;

  /**
   * 添加数据
   *
   * @param baseResourceAuthorityAddDTO 添加参数
   * @return
   */
  public int save(BaseResourceAuthorityAddDTO baseResourceAuthorityAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = baseResourceAuthorityRpcFacade
        .save(BaseResourceAuthorityConvert.INSTANCE.convert(baseResourceAuthorityAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param baseResourceAuthorityUpdateDTO 更新参数
   * @return
   */
  public int update(BaseResourceAuthorityUpdateDTO baseResourceAuthorityUpdateDTO) {
    BaseResponse baseResponse = baseResourceAuthorityRpcFacade
        .update(BaseResourceAuthorityConvert.INSTANCE.convert(baseResourceAuthorityUpdateDTO));
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
    BaseResponse baseResponse = baseResourceAuthorityRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public BaseResourceAuthorityVO getBaseResourceAuthorityById(Long id) {
    ObjectRestResponse<BaseResourceAuthorityRespDTO> objectRestResponse = baseResourceAuthorityRpcFacade
        .getBaseResourceAuthorityById(id);
    objectRestResponse.checkError();
    return BaseResourceAuthorityConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   *
   * @param baseResourceAuthorityDTO 查询参数
   * @return
   */
  public List<BaseResourceAuthorityVO> listBaseResourceAuthoritys(
      BaseResourceAuthorityDTO baseResourceAuthorityDTO) {
    ObjectRestResponse<List<BaseResourceAuthorityRespDTO>> objectRestResponse = baseResourceAuthorityRpcFacade
        .listBaseResourceAuthoritys(
            BaseResourceAuthorityConvert.INSTANCE.convert(baseResourceAuthorityDTO));
    objectRestResponse.checkError();
    return BaseResourceAuthorityConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   *
   * @param pageDTO 分页参数
   * @return
   */
  public TableResultResponse<BaseResourceAuthorityVO> pageBaseResourceAuthority(
      BaseResourceAuthorityPageDTO pageDTO) {
    TableResultResponse<BaseResourceAuthorityRespDTO> tableResultResponse = baseResourceAuthorityRpcFacade
        .page(BaseResourceAuthorityConvert.INSTANCE.convert(pageDTO));
    tableResultResponse.checkError();
    return BaseResourceAuthorityConvert.INSTANCE.convert(tableResultResponse);
  }


}
