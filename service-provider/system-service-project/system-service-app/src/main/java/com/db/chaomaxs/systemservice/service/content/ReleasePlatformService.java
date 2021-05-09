package com.db.chaomaxs.systemservice.service.content;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.convert.content.ReleasePlatformConvert;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.content.ReleasePlatformDO;
import com.db.chaomaxs.systemservice.dal.mysql.mapper.content.ReleasePlatformMapper;
import com.db.chaomaxs.systemservice.enums.SystemErrorCodeConstants;
import com.db.chaomaxs.systemservice.rpc.content.dto.ReleasePlatformCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ReleasePlatformListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ReleasePlatformPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ReleasePlatformRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ReleasePlatformUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * ReleasePlatformService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class ReleasePlatformService {

  @Autowired
  private ReleasePlatformMapper releasePlatformMapper;

  /**
  * 保存数据
* @param createReqDTO
* @return
*/
  public int saveReleasePlatform(ReleasePlatformCreateReqDTO createReqDTO) {
    return releasePlatformMapper.insert(ReleasePlatformConvert.INSTANCE.convert(createReqDTO));
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateReleasePlatform(ReleasePlatformUpdateReqDTO updateReqDTO) {
          ReleasePlatformDO releasePlatformDO = releasePlatformMapper.selectById(updateReqDTO.getId());
    if (releasePlatformDO == null) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
          releasePlatformDO = ReleasePlatformConvert.INSTANCE.convert(updateReqDTO);
    int result = releasePlatformMapper.updateById(releasePlatformDO);
    return result;
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteReleasePlatform(Long id) {
    if (releasePlatformMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = releasePlatformMapper.deleteById(id);
    return result;
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<ReleasePlatformRespDTO> listReleasePlatforms(ReleasePlatformListQueryReqDTO listQueryReqDTO) {
    List<ReleasePlatformDO> list = releasePlatformMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return ReleasePlatformConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public ReleasePlatformRespDTO getReleasePlatformById(Long id) {
          ReleasePlatformDO releasePlatformDO = releasePlatformMapper.selectById(id);
    if (releasePlatformDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return ReleasePlatformConvert.INSTANCE.convert(releasePlatformDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<ReleasePlatformRespDTO> pageReleasePlatform(ReleasePlatformPageReqDTO page) {
    IPage<ReleasePlatformDO> releasePlatformPage = releasePlatformMapper.selectPage(page);
    return ReleasePlatformConvert.INSTANCE.convertPage(releasePlatformPage);
  }


}
