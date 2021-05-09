package com.github.xf717.userservice.manager.resume;

import com.github.xf717.userservice.convert.resume.UserExpectedPositionConvert;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserExpectedPositionDO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedAndStatusRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionUpdateReqDTO;
import com.github.xf717.userservice.service.resume.UserExpectedPositionIndustryService;
import com.github.xf717.userservice.service.resume.UserExpectedPositionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserExpectedPositionManager
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Service
@Validated
public class UserExpectedPositionManager {

  @Autowired
  private UserExpectedPositionService userExpectedPositionService;

  @Autowired
  private UserExpectedPositionIndustryService userExpectedPositionIndustryService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserExpectedPosition(UserExpectedPositionCreateReqDTO createReqDTO) {
    return userExpectedPositionService.saveUserExpectedPosition(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserExpectedPosition(UserExpectedPositionUpdateReqDTO updateReqDTO) {
      return userExpectedPositionService.updateUserExpectedPosition(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserExpectedPosition(Long id) {
    return userExpectedPositionService.deleteUserExpectedPosition(id);
  }

  /**
   * 根据id获取对象
   * @param id
   * @return
   */
  public UserExpectedPositionRespDTO getUserExpectedPositionById(Long id) {
    UserExpectedPositionDO expectedPosition = userExpectedPositionService
        .getUserExpectedPositionById(id);
    UserExpectedPositionRespDTO resp = UserExpectedPositionConvert.INSTANCE
        .convert(expectedPosition);
    List<UserExpectedPositionIndustryRespDTO> industryResp = userExpectedPositionIndustryService
        .listIndustryByExpectedPositionId(id);
    resp.setExpectedPositionIndustryList(industryResp);
    return resp;
  }

  /**
   * 根虎用户id 查询全部求职期望以及求职状态
   * @param userId
   * @return
   */
  public UserExpectedAndStatusRespDTO getUserExpectedAndStatusByUserId(Long userId){
    return userExpectedPositionService.getUserExpectedAndStatusByUserId(userId);
  }

}
