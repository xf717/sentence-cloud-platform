package com.github.xf717.systemservice.service.content;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.convert.content.WorkContentExtendConvert;
import com.github.xf717.systemservice.dal.mysql.dataobject.content.WorkContentExtendDO;
import com.github.xf717.systemservice.dal.mysql.mapper.content.WorkContentExtendMapper;
import com.github.xf717.systemservice.enums.SystemErrorCodeConstants;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentExtendCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentExtendListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentExtendPageReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentExtendRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentExtendUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * WorkContentExtendService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class WorkContentExtendService {

  @Autowired
  private WorkContentExtendMapper workContentExtendMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveWorkContentExtend(WorkContentExtendCreateReqDTO createReqDTO) {
    return workContentExtendMapper.insert(WorkContentExtendConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateWorkContentExtend(WorkContentExtendUpdateReqDTO updateReqDTO) {
    WorkContentExtendDO workContentExtendDO = workContentExtendMapper
        .selectById(updateReqDTO.getId());
    if (workContentExtendDO == null) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    workContentExtendDO = WorkContentExtendConvert.INSTANCE.convert(updateReqDTO);
    int result = workContentExtendMapper.updateById(workContentExtendDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteWorkContentExtend(Long id) {
    if (workContentExtendMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = workContentExtendMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<WorkContentExtendRespDTO> listWorkContentExtends(
      WorkContentExtendListQueryReqDTO listQueryReqDTO) {
    List<WorkContentExtendDO> list = workContentExtendMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return WorkContentExtendConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public WorkContentExtendRespDTO getWorkContentExtendById(Long id) {
    WorkContentExtendDO workContentExtendDO = workContentExtendMapper.selectById(id);
    if (workContentExtendDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return WorkContentExtendConvert.INSTANCE.convert(workContentExtendDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<WorkContentExtendRespDTO> pageWorkContentExtend(
      WorkContentExtendPageReqDTO page) {
    IPage<WorkContentExtendDO> workContentExtendPage = workContentExtendMapper.selectPage(page);
    return WorkContentExtendConvert.INSTANCE.convertPage(workContentExtendPage);
  }

  public WorkContentExtendRespDTO getWorkContentExtendByContentId(Long contentId) {
    WorkContentExtendDO workContentExtendDO = workContentExtendMapper
        .getWorkContentExtendByContentId(contentId);
    if (workContentExtendDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return WorkContentExtendConvert.INSTANCE.convert(workContentExtendDO);
  }

}
