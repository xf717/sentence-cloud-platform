package com.db.chaomaxs.systemservice.manager.auth;

import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderUpdateReqDTO;
import com.db.chaomaxs.systemservice.service.auth.BaseGroupLeaderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * BaseGroupLeaderManager
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Service
@Validated
public class BaseGroupLeaderManager {

  @Autowired
  private BaseGroupLeaderService baseGroupLeaderService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveBaseGroupLeader(BaseGroupLeaderCreateReqDTO createReqDTO) {
    return baseGroupLeaderService.saveBaseGroupLeader(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateBaseGroupLeader(BaseGroupLeaderUpdateReqDTO updateReqDTO) {
    return baseGroupLeaderService.updateBaseGroupLeader(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteBaseGroupLeader(Long id) {
    return baseGroupLeaderService.deleteBaseGroupLeader(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<BaseGroupLeaderRespDTO> listBaseGroupLeaders(
      BaseGroupLeaderListQueryReqDTO listQueryReqDTO) {
    return baseGroupLeaderService.listBaseGroupLeaders(listQueryReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public BaseGroupLeaderRespDTO getBaseGroupLeaderById(Long id) {
    return baseGroupLeaderService.getBaseGroupLeaderById(id);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<BaseGroupLeaderRespDTO> pageBaseGroupLeader(BaseGroupLeaderPageReqDTO page) {
    return baseGroupLeaderService.pageBaseGroupLeader(page);
  }


}
