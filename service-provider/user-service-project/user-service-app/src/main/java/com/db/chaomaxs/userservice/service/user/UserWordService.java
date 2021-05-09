package com.db.chaomaxs.userservice.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.convert.user.UserWordConvert;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserWordDO;
import com.db.chaomaxs.userservice.dal.mysql.mapper.user.UserWordMapper;
import com.db.chaomaxs.userservice.enums.UserErrorCodeConstants;
import com.db.chaomaxs.userservice.rpc.user.dto.UserWordCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserWordListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserWordPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserWordRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserWordUpdateReqDTO;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserWordService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserWordService {

  @Autowired
  private UserWordMapper userWordMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveUserWord(UserWordCreateReqDTO createReqDTO) {
    Integer maxSort = userWordMapper.selectMaxSortByUserId(createReqDTO.getUserId());
    UserWordDO userWordDO = UserWordConvert.INSTANCE.convert(createReqDTO);
    userWordDO.setSort(maxSort == null ? 1 : maxSort + 1);
    userWordDO.setUpdateBy(createReqDTO.getUserId());
    return userWordMapper.insert(userWordDO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateUserWord(UserWordUpdateReqDTO updateReqDTO) {
    UserWordDO userWordDO = userWordMapper.getById(updateReqDTO.getId());
    if (userWordDO == null) {
      throw ServiceExceptionUtil.exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    userWordDO = UserWordConvert.INSTANCE.convert(updateReqDTO);
    int result = userWordMapper.updateById(userWordDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteUserWord(Long id) {
    if (userWordMapper.getById(id) == null) {
      throw ServiceExceptionUtil.exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = userWordMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<UserWordRespDTO> listUserWords(UserWordListQueryReqDTO listQueryReqDTO) {
    List<UserWordDO> list = userWordMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserWordConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public UserWordRespDTO getUserWordById(Long id) {
    UserWordDO userWordDO = userWordMapper.getById(id);
    if (userWordDO == null) {
      throw ServiceExceptionUtil.exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return UserWordConvert.INSTANCE.convert(userWordDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<UserWordRespDTO> pageUserWord(UserWordPageReqDTO page) {
    IPage<UserWordDO> userWordPage = userWordMapper.selectPage(page);
    return UserWordConvert.INSTANCE.convertPage(userWordPage);
  }

    /**
     * 置顶
     * @param id
     * @param userId
     * @return
     */
  public int userWordTopByUserId(Long id, Long userId) {
    Integer maxSort = userWordMapper.selectMaxSortByUserId(userId);
    UserWordDO userWordDO = userWordMapper.selectById(id);
    userWordDO.setSort(userWordDO.getSort().compareTo(maxSort) < 0 ? Integer.valueOf(maxSort + 1) : maxSort);
    return userWordMapper.updateById(userWordDO);
  }


}
