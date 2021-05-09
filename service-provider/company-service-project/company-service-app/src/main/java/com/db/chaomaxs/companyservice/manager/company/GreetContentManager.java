package com.db.chaomaxs.companyservice.manager.company;

import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentUpdateReqDTO;
import com.db.chaomaxs.companyservice.service.company.GreetContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * GreetContentManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class GreetContentManager {

  @Autowired
  private GreetContentService greetContentService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveGreetContent(GreetContentCreateReqDTO createReqDTO) {
    return greetContentService.saveGreetContent(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateGreetContent(GreetContentUpdateReqDTO updateReqDTO) {
    return greetContentService.updateGreetContent(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteGreetContent(Long id) {
    return greetContentService.deleteGreetContent(id);
  }

  /**
   * 数据查询
   *
   * @param userId
   * @return
   */
  public GreetContentRespDTO getGreetContentsByUserId(Long userId) {
    return greetContentService.getGreetContentsByUserId(userId);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public GreetContentRespDTO getGreetContentById(Long id) {
    return greetContentService.getGreetContentById(id);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<GreetContentRespDTO> pageGreetContent(GreetContentPageReqDTO page) {
    return greetContentService.pageGreetContent(page);
  }


}
