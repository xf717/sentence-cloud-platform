package com.db.chaomaxs.managementweb.manager.content;

import com.db.chaomaxs.managementweb.controller.content.dto.WorkContentAddDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.WorkContentUpdateDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.WorkContentDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.WorkContentPageDTO;
import com.db.chaomaxs.managementweb.controller.content.vo.WorkContentVO;
import com.db.chaomaxs.managementweb.convert.content.WorkContentConvert;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.facade.WorkContentRpcFacade;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * WorkContentManager
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Service
@Validated
public class WorkContentManager {

  @Autowired
  private WorkContentRpcFacade workContentRpcFacade;

  /**
   * 添加数据
   * @param workContentCreateReqDTO 添加参数
   * @return
   */
  public int save(WorkContentAddDTO workContentAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = workContentRpcFacade
        .save(WorkContentConvert.INSTANCE.convert(workContentAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   * @param workContentUpdateDTO  更新参数
   * @return
   */
  public int update(WorkContentUpdateDTO workContentUpdateDTO) {
    BaseResponse baseResponse = workContentRpcFacade
        .update(WorkContentConvert.INSTANCE.convert(workContentUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   * @param id  id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = workContentRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   * @param id id
   * @return
   */
  public WorkContentVO getWorkContentById(Long id) {
    ObjectRestResponse<WorkContentRespDTO> objectRestResponse = workContentRpcFacade.getWorkContentById(
        id);
    objectRestResponse.checkError();
    return WorkContentConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   * @param workContentDTO  查询参数
   * @return
   */
  public List<WorkContentVO> listWorkContents(WorkContentDTO workContentDTO) {
    ObjectRestResponse<List<WorkContentRespDTO>> objectRestResponse = workContentRpcFacade.listWorkContents(
                WorkContentConvert.INSTANCE.convert(workContentDTO));
    objectRestResponse.checkError();
    return WorkContentConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   * @param pageReqDTO  分页参数
   * @return
   */
  public TableResultResponse<WorkContentVO> pageWorkContent(WorkContentPageDTO pageReqDTO) {
    TableResultResponse<WorkContentRespDTO> tableResultResponse = workContentRpcFacade
        .page(WorkContentConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return WorkContentConvert.INSTANCE.convert(tableResultResponse);
  }


}
