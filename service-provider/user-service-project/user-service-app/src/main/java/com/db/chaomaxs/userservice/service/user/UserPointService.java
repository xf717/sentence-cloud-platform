package com.db.chaomaxs.userservice.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.convert.user.UserPointConvert;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserPointDO;
import com.db.chaomaxs.userservice.dal.mysql.mapper.user.UserPointMapper;
import com.db.chaomaxs.userservice.enums.UserErrorCodeConstants;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPointCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPointListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPointPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPointRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPointUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserPointService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserPointService {

  @Autowired
  private UserPointMapper userPointMapper;

  /**
  * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserPoint(UserPointCreateReqDTO createReqDTO) {
    return userPointMapper.insert(UserPointConvert.INSTANCE.convert(createReqDTO));
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserPoint(UserPointUpdateReqDTO updateReqDTO) {
          UserPointDO userPointDO = userPointMapper.selectById(updateReqDTO.getId());
    if (userPointDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
          userPointDO = UserPointConvert.INSTANCE.convert(updateReqDTO);
    int result = userPointMapper.updateById(userPointDO);
    return result;
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserPoint(Long id) {
    if (userPointMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = userPointMapper.deleteById(id);
    return result;
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserPointRespDTO> listUserPoints(UserPointListQueryReqDTO listQueryReqDTO) {
    List<UserPointDO> list = userPointMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserPointConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserPointRespDTO getUserPointById(Long id) {
          UserPointDO userPointDO = userPointMapper.selectById(id);
    if (userPointDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return UserPointConvert.INSTANCE.convert(userPointDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserPointRespDTO> pageUserPoint(UserPointPageReqDTO page) {
    IPage<UserPointDO> userPointPage = userPointMapper.selectPage(page);
    return UserPointConvert.INSTANCE.convertPage(userPointPage);
  }


}
