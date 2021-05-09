package com.db.chaomaxs.systemservice.manager.content;

import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentExtendCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentExtendListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentExtendPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentExtendRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentExtendUpdateReqDTO;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.service.content.WorkContentExtendService;
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
  private WorkContentExtendService workContentExtendService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveWorkContentExtend(WorkContentExtendCreateReqDTO createReqDTO) {
    return workContentExtendService.saveWorkContentExtend(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateWorkContentExtend(WorkContentExtendUpdateReqDTO updateReqDTO) {
      return workContentExtendService.updateWorkContentExtend(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteWorkContentExtend(Long id) {
    return workContentExtendService.deleteWorkContentExtend(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<WorkContentExtendRespDTO> listWorkContentExtends(WorkContentExtendListQueryReqDTO listQueryReqDTO) {
    return workContentExtendService.listWorkContentExtends(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public WorkContentExtendRespDTO getWorkContentExtendById(Long id) {
    return workContentExtendService.getWorkContentExtendById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<WorkContentExtendRespDTO> pageWorkContentExtend(WorkContentExtendPageReqDTO page) {
    return workContentExtendService.pageWorkContentExtend(page);
  }


}
