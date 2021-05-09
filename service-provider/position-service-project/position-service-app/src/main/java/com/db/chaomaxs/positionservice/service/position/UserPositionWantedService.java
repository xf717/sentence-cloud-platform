package com.db.chaomaxs.positionservice.service.position;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.convert.position.UserPositionWantedConvert;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.position.UserPositionWantedDO;
import com.db.chaomaxs.positionservice.dal.mysql.mapper.position.UserPositionWantedMapper;
import com.db.chaomaxs.positionservice.enums.PositionErrorCodeConstants;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedPageReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserPositionWantedService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserPositionWantedService {

  @Autowired
  private UserPositionWantedMapper userPositionWantedMapper;

  /**
  * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserPositionWanted(UserPositionWantedCreateReqDTO createReqDTO) {
    return userPositionWantedMapper.insert(UserPositionWantedConvert.INSTANCE.convert(createReqDTO));
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserPositionWanted(UserPositionWantedUpdateReqDTO updateReqDTO) {
          UserPositionWantedDO userPositionWantedDO = userPositionWantedMapper.selectById(updateReqDTO.getId());
    if (userPositionWantedDO == null) {
      throw ServiceExceptionUtil
          .exception(PositionErrorCodeConstants.NOT_EXISTS.getCode());
    }
          userPositionWantedDO = UserPositionWantedConvert.INSTANCE.convert(updateReqDTO);
    int result = userPositionWantedMapper.updateById(userPositionWantedDO);
    return result;
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserPositionWanted(Long id) {
    if (userPositionWantedMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(PositionErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = userPositionWantedMapper.deleteById(id);
    return result;
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserPositionWantedRespDTO> listUserPositionWanteds(UserPositionWantedListQueryReqDTO listQueryReqDTO) {
    List<UserPositionWantedDO> list = userPositionWantedMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserPositionWantedConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserPositionWantedRespDTO getUserPositionWantedById(Long id) {
          UserPositionWantedDO userPositionWantedDO = userPositionWantedMapper.selectById(id);
    if (userPositionWantedDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(PositionErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return UserPositionWantedConvert.INSTANCE.convert(userPositionWantedDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserPositionWantedRespDTO> pageUserPositionWanted(UserPositionWantedPageReqDTO page) {
    IPage<UserPositionWantedDO> userPositionWantedPage = userPositionWantedMapper.selectPage(page);
    return UserPositionWantedConvert.INSTANCE.convertPage(userPositionWantedPage);
  }


}
