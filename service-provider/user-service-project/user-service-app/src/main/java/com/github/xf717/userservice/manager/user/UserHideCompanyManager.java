package com.github.xf717.userservice.manager.user;

import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyBatchInsertReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyRespDTO;
import com.github.xf717.userservice.service.user.UserHideCompanyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserHideCompanyManager
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Service
@Validated
public class UserHideCompanyManager {

  @Autowired
  private UserHideCompanyService userHideCompanyService;

  /**
 * 保存数据
* @param batchInsertReqDTO
* @return
*/
  public int saveUserHideCompany(UserHideCompanyBatchInsertReqDTO batchInsertReqDTO) {
    return userHideCompanyService.saveUserHideCompany(batchInsertReqDTO);
  }


  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserHideCompany(Long id) {
    return userHideCompanyService.deleteUserHideCompany(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserHideCompanyRespDTO> listUserHideCompanys(UserHideCompanyListQueryReqDTO listQueryReqDTO) {
    return userHideCompanyService.listUserHideCompanys(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserHideCompanyRespDTO getUserHideCompanyById(Long id) {
    return userHideCompanyService.getUserHideCompanyById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserHideCompanyRespDTO> pageUserHideCompany(UserHideCompanyPageReqDTO page) {
    return userHideCompanyService.pageUserHideCompany(page);
  }


}
