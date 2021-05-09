package com.github.xf717.systemservice.manager.auth;

import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityPageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityUpdateReqDTO;
import com.github.xf717.systemservice.service.auth.BaseResourceAuthorityService;
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
  private BaseResourceAuthorityService baseResourceAuthorityService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveBaseResourceAuthority(BaseResourceAuthorityCreateReqDTO createReqDTO) {
    return baseResourceAuthorityService.saveBaseResourceAuthority(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateBaseResourceAuthority(BaseResourceAuthorityUpdateReqDTO updateReqDTO) {
    return baseResourceAuthorityService.updateBaseResourceAuthority(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteBaseResourceAuthority(Long id) {
    return baseResourceAuthorityService.deleteBaseResourceAuthority(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<BaseResourceAuthorityRespDTO> listBaseResourceAuthoritys(
      BaseResourceAuthorityListQueryReqDTO listQueryReqDTO) {
    return baseResourceAuthorityService.listBaseResourceAuthoritys(listQueryReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public BaseResourceAuthorityRespDTO getBaseResourceAuthorityById(Long id) {
    return baseResourceAuthorityService.getBaseResourceAuthorityById(id);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<BaseResourceAuthorityRespDTO> pageBaseResourceAuthority(
      BaseResourceAuthorityPageReqDTO page) {
    return baseResourceAuthorityService.pageBaseResourceAuthority(page);
  }


}
