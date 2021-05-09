package com.github.xf717.systemservice.service.content;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.convert.content.WorkContentConvert;
import com.github.xf717.systemservice.dal.mysql.dataobject.content.WorkContentDO;
import com.github.xf717.systemservice.dal.mysql.mapper.content.WorkContentMapper;
import com.github.xf717.systemservice.enums.SystemErrorCodeConstants;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentPageReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * WorkContentService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class WorkContentService {

  @Autowired
  private WorkContentMapper workContentMapper;

  /**
  * 保存数据
* @param createReqDTO
* @return
*/
  public int saveWorkContent(WorkContentCreateReqDTO createReqDTO) {
    return workContentMapper.insert(WorkContentConvert.INSTANCE.convert(createReqDTO));
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateWorkContent(WorkContentUpdateReqDTO updateReqDTO) {
          WorkContentDO workContentDO = workContentMapper.selectById(updateReqDTO.getId());
    if (workContentDO == null) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
          workContentDO = WorkContentConvert.INSTANCE.convert(updateReqDTO);
    int result = workContentMapper.updateById(workContentDO);
    return result;
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteWorkContent(Long id) {
    if (workContentMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = workContentMapper.deleteById(id);
    return result;
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<WorkContentRespDTO> listWorkContents(WorkContentListQueryReqDTO listQueryReqDTO) {
    List<WorkContentDO> list = workContentMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return WorkContentConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public WorkContentRespDTO getWorkContentById(Long id) {
          WorkContentDO workContentDO = workContentMapper.selectById(id);
    if (workContentDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return WorkContentConvert.INSTANCE.convert(workContentDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<WorkContentRespDTO> pageWorkContent(WorkContentPageReqDTO page) {
    IPage<WorkContentDO> workContentPage = workContentMapper.selectPage(page);
    return WorkContentConvert.INSTANCE.convertPage(workContentPage);
  }

  public Long workContentDetail(){
     return workContentMapper.selectMaxWorkContentId();
  }

}
