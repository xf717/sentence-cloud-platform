package com.github.xf717.managementweb.manager.content;

import com.github.xf717.managementweb.controller.content.dto.WorkContentExtendAddDTO;
import com.github.xf717.managementweb.controller.content.dto.WorkContentExtendUpdateDTO;
import com.github.xf717.managementweb.controller.content.dto.WorkContentExtendDTO;
import com.github.xf717.managementweb.controller.content.dto.WorkContentExtendPageDTO;
import com.github.xf717.managementweb.controller.content.vo.WorkContentExtendVO;
import com.github.xf717.managementweb.convert.content.WorkContentExtendConvert;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentExtendRespDTO;
import com.github.xf717.systemservice.rpc.content.facade.WorkContentExtendRpcFacade;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * WorkContentExtendManager
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Service
@Validated
public class WorkContentExtendManager {

  @Autowired
  private WorkContentExtendRpcFacade workContentExtendRpcFacade;

  /**
   * 添加数据
   * @param workContentExtendCreateReqDTO 添加参数
   * @return
   */
  public int save(WorkContentExtendAddDTO workContentExtendAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = workContentExtendRpcFacade
        .save(WorkContentExtendConvert.INSTANCE.convert(workContentExtendAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   * @param workContentExtendUpdateDTO  更新参数
   * @return
   */
  public int update(WorkContentExtendUpdateDTO workContentExtendUpdateDTO) {
    BaseResponse baseResponse = workContentExtendRpcFacade
        .update(WorkContentExtendConvert.INSTANCE.convert(workContentExtendUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   * @param id  id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = workContentExtendRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   * @param id id
   * @return
   */
  public WorkContentExtendVO getWorkContentExtendById(Long id) {
    ObjectRestResponse<WorkContentExtendRespDTO> objectRestResponse = workContentExtendRpcFacade.getWorkContentExtendById(
        id);
    objectRestResponse.checkError();
    return WorkContentExtendConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   * @param workContentExtendDTO  查询参数
   * @return
   */
  public List<WorkContentExtendVO> listWorkContentExtends(WorkContentExtendDTO workContentExtendDTO) {
    ObjectRestResponse<List<WorkContentExtendRespDTO>> objectRestResponse = workContentExtendRpcFacade.listWorkContentExtends(
                WorkContentExtendConvert.INSTANCE.convert(workContentExtendDTO));
    objectRestResponse.checkError();
    return WorkContentExtendConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   * @param pageReqDTO  分页参数
   * @return
   */
  public TableResultResponse<WorkContentExtendVO> pageWorkContentExtend(WorkContentExtendPageDTO pageReqDTO) {
    TableResultResponse<WorkContentExtendRespDTO> tableResultResponse = workContentExtendRpcFacade
        .page(WorkContentExtendConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return WorkContentExtendConvert.INSTANCE.convert(tableResultResponse);
  }


}
