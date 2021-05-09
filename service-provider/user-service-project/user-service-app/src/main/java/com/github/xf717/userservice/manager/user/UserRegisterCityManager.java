package com.github.xf717.userservice.manager.user;

import com.github.xf717.userservice.rpc.user.dto.UserRegisterCityCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserRegisterCityListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserRegisterCityPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserRegisterCityRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserRegisterCityUpdateReqDTO;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.service.user.UserRegisterCityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserRegisterCityManager
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Service
@Validated
public class UserRegisterCityManager {

  @Autowired
  private UserRegisterCityService userRegisterCityService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserRegisterCity(UserRegisterCityCreateReqDTO createReqDTO) {
    return userRegisterCityService.saveUserRegisterCity(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserRegisterCity(UserRegisterCityUpdateReqDTO updateReqDTO) {
      return userRegisterCityService.updateUserRegisterCity(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserRegisterCity(Long id) {
    return userRegisterCityService.deleteUserRegisterCity(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserRegisterCityRespDTO> listUserRegisterCitys(UserRegisterCityListQueryReqDTO listQueryReqDTO) {
    return userRegisterCityService.listUserRegisterCitys(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserRegisterCityRespDTO getUserRegisterCityById(Long id) {
    return userRegisterCityService.getUserRegisterCityById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserRegisterCityRespDTO> pageUserRegisterCity(UserRegisterCityPageReqDTO page) {
    return userRegisterCityService.pageUserRegisterCity(page);
  }


}
