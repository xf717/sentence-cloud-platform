package com.github.xf717.managementweb.manager.auth;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.managementweb.controller.auth.dto.BaseGroupTypeAddDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseGroupTypeDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseGroupTypePageDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseGroupTypeUpdateDTO;
import com.github.xf717.managementweb.controller.auth.vo.BaseGroupTypeVO;
import com.github.xf717.managementweb.convert.auth.BaseGroupTypeConvert;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupTypeRespDTO;
import com.github.xf717.systemservice.rpc.auth.facade.BaseGroupTypeRpcFacade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * BaseGroupTypeManager
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Service
@Validated
public class BaseGroupTypeManager {

  @Autowired
  private BaseGroupTypeRpcFacade baseGroupTypeRpcFacade;

  /**
   * 添加数据
   *
   * @param baseGroupTypeAddDTO 添加参数
   * @return
   */
  public int save(BaseGroupTypeAddDTO baseGroupTypeAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = baseGroupTypeRpcFacade
        .save(BaseGroupTypeConvert.INSTANCE.convert(baseGroupTypeAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param baseGroupTypeUpdateDTO 更新参数
   * @return
   */
  public int update(BaseGroupTypeUpdateDTO baseGroupTypeUpdateDTO) {
    BaseResponse baseResponse = baseGroupTypeRpcFacade
        .update(BaseGroupTypeConvert.INSTANCE.convert(baseGroupTypeUpdateDTO));
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
    BaseResponse baseResponse = baseGroupTypeRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public BaseGroupTypeVO getBaseGroupTypeById(Long id) {
    ObjectRestResponse<BaseGroupTypeRespDTO> objectRestResponse = baseGroupTypeRpcFacade
        .getBaseGroupTypeById(id);
    objectRestResponse.checkError();
    return BaseGroupTypeConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   *
   * @param baseGroupTypeDTO 查询参数
   * @return
   */
  public List<BaseGroupTypeVO> listBaseGroupTypes(BaseGroupTypeDTO baseGroupTypeDTO) {
    ObjectRestResponse<List<BaseGroupTypeRespDTO>> objectRestResponse = baseGroupTypeRpcFacade
        .listBaseGroupTypes(BaseGroupTypeConvert.INSTANCE.convert(baseGroupTypeDTO));
    objectRestResponse.checkError();
    return BaseGroupTypeConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   *
   * @param pageDTO 分页参数
   * @return
   */
  public TableResultResponse<BaseGroupTypeVO> pageBaseGroupType(BaseGroupTypePageDTO pageDTO) {
    TableResultResponse<BaseGroupTypeRespDTO> tableResultResponse = baseGroupTypeRpcFacade
        .page(BaseGroupTypeConvert.INSTANCE.convert(pageDTO));
    tableResultResponse.checkError();
    return BaseGroupTypeConvert.INSTANCE.convert(tableResultResponse);
  }


}
