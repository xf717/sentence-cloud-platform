package com.db.chaomaxs.systemservice.manager.content;

import cn.hutool.core.util.RandomUtil;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.convert.content.WorkContentConvert;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentDetailRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentExtendRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentUpdateReqDTO;
import com.db.chaomaxs.systemservice.service.content.WorkContentExtendService;
import com.db.chaomaxs.systemservice.service.content.WorkContentService;
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
  private WorkContentService workContentService;

  @Autowired
  private WorkContentExtendService workContentExtendService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveWorkContent(WorkContentCreateReqDTO createReqDTO) {
    return workContentService.saveWorkContent(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateWorkContent(WorkContentUpdateReqDTO updateReqDTO) {
    return workContentService.updateWorkContent(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteWorkContent(Long id) {
    return workContentService.deleteWorkContent(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<WorkContentRespDTO> listWorkContents(WorkContentListQueryReqDTO listQueryReqDTO) {
    return workContentService.listWorkContents(listQueryReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public WorkContentRespDTO getWorkContentById(Long id) {
    return workContentService.getWorkContentById(id);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<WorkContentRespDTO> pageWorkContent(WorkContentPageReqDTO page) {
    return workContentService.pageWorkContent(page);
  }

  /**
   * 查询一条随机工作内容
   *
   * @return
   */
  public WorkContentDetailRespDTO workContentDetail() {
    Long workContentId = workContentService.workContentDetail();
    if (null == workContentId) {
      return null;
    }
    Long contentId = RandomUtil.randomLong(1, workContentId+1);
    WorkContentRespDTO workContentResp = workContentService.getWorkContentById(contentId);
    if (null == workContentResp) {
      workContentDetail();
    }
    WorkContentDetailRespDTO workContentDetailResp = WorkContentConvert.INSTANCE
        .convert(workContentResp);
    WorkContentExtendRespDTO workContentExtend = workContentExtendService
        .getWorkContentExtendByContentId(contentId);
    workContentDetailResp.setContent(workContentExtend.getContent());
    return workContentDetailResp;
  }

}
