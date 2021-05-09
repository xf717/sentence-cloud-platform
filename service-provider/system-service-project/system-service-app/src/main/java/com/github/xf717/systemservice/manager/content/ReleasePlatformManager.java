package com.github.xf717.systemservice.manager.content;

import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformPageReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformUpdateReqDTO;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.service.content.ReleasePlatformService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * ReleasePlatformManager
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Service
@Validated
public class ReleasePlatformManager {

  @Autowired
  private ReleasePlatformService releasePlatformService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveReleasePlatform(ReleasePlatformCreateReqDTO createReqDTO) {
    return releasePlatformService.saveReleasePlatform(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateReleasePlatform(ReleasePlatformUpdateReqDTO updateReqDTO) {
      return releasePlatformService.updateReleasePlatform(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteReleasePlatform(Long id) {
    return releasePlatformService.deleteReleasePlatform(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<ReleasePlatformRespDTO> listReleasePlatforms(ReleasePlatformListQueryReqDTO listQueryReqDTO) {
    return releasePlatformService.listReleasePlatforms(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public ReleasePlatformRespDTO getReleasePlatformById(Long id) {
    return releasePlatformService.getReleasePlatformById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<ReleasePlatformRespDTO> pageReleasePlatform(ReleasePlatformPageReqDTO page) {
    return releasePlatformService.pageReleasePlatform(page);
  }


}
