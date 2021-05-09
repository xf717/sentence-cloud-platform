package com.db.chaomaxs.userservice.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.convert.user.UserRegisterCityConvert;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserRegisterCityDO;
import com.db.chaomaxs.userservice.dal.mysql.mapper.user.UserRegisterCityMapper;
import com.db.chaomaxs.userservice.enums.UserErrorCodeConstants;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRegisterCityCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRegisterCityListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRegisterCityPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRegisterCityRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRegisterCityUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserRegisterCityService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserRegisterCityService {

  @Autowired
  private UserRegisterCityMapper userRegisterCityMapper;

  /**
  * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserRegisterCity(UserRegisterCityCreateReqDTO createReqDTO) {
    return userRegisterCityMapper.insert(UserRegisterCityConvert.INSTANCE.convert(createReqDTO));
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserRegisterCity(UserRegisterCityUpdateReqDTO updateReqDTO) {
          UserRegisterCityDO userRegisterCityDO = userRegisterCityMapper.selectById(updateReqDTO.getId());
    if (userRegisterCityDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
          userRegisterCityDO = UserRegisterCityConvert.INSTANCE.convert(updateReqDTO);
    int result = userRegisterCityMapper.updateById(userRegisterCityDO);
    return result;
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserRegisterCity(Long id) {
    if (userRegisterCityMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = userRegisterCityMapper.deleteById(id);
    return result;
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserRegisterCityRespDTO> listUserRegisterCitys(UserRegisterCityListQueryReqDTO listQueryReqDTO) {
    List<UserRegisterCityDO> list = userRegisterCityMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserRegisterCityConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserRegisterCityRespDTO getUserRegisterCityById(Long id) {
          UserRegisterCityDO userRegisterCityDO = userRegisterCityMapper.selectById(id);
    if (userRegisterCityDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return UserRegisterCityConvert.INSTANCE.convert(userRegisterCityDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserRegisterCityRespDTO> pageUserRegisterCity(UserRegisterCityPageReqDTO page) {
    IPage<UserRegisterCityDO> userRegisterCityPage = userRegisterCityMapper.selectPage(page);
    return UserRegisterCityConvert.INSTANCE.convertPage(userRegisterCityPage);
  }


}
