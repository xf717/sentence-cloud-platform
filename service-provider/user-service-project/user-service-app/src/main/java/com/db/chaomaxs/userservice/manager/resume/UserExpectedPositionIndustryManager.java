package com.db.chaomaxs.userservice.manager.resume;


import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionIndustryCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionIndustryListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionIndustryPageReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionIndustryRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionIndustryUpdateReqDTO;
import com.db.chaomaxs.userservice.service.resume.UserExpectedPositionIndustryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserExpectedPositionIndustryManager
 *
 * @author wst
 * @date 2021-04-12 13:47:08
 */
@Service
@Validated
public class UserExpectedPositionIndustryManager {

  @Autowired
  private UserExpectedPositionIndustryService userExpectedPositionIndustryService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveUserExpectedPositionIndustry(
      UserExpectedPositionIndustryCreateReqDTO createReqDTO) {
    return userExpectedPositionIndustryService.saveUserExpectedPositionIndustry(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateUserExpectedPositionIndustry(
      UserExpectedPositionIndustryUpdateReqDTO updateReqDTO) {
    return userExpectedPositionIndustryService.updateUserExpectedPositionIndustry(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteUserExpectedPositionIndustry(Long id) {
    return userExpectedPositionIndustryService.deleteUserExpectedPositionIndustry(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<UserExpectedPositionIndustryRespDTO> listUserExpectedPositionIndustrys(
      UserExpectedPositionIndustryListQueryReqDTO listQueryReqDTO) {
    return userExpectedPositionIndustryService.listUserExpectedPositionIndustrys(listQueryReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public UserExpectedPositionIndustryRespDTO getUserExpectedPositionIndustryById(Long id) {
    return userExpectedPositionIndustryService.getUserExpectedPositionIndustryById(id);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<UserExpectedPositionIndustryRespDTO> pageUserExpectedPositionIndustry(
      UserExpectedPositionIndustryPageReqDTO page) {
    return userExpectedPositionIndustryService.pageUserExpectedPositionIndustry(page);
  }


}
