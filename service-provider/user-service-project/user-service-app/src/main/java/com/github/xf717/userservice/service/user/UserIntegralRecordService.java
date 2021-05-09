package com.github.xf717.userservice.service.user;

import static com.github.xf717.userservice.enums.UserErrorCodeConstants.USER_SIGN_ALREADY_EXISTS;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.convert.user.UserIntegralRecordConvert;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserInfoDO;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserIntegralRecordDO;
import com.github.xf717.userservice.dal.mysql.mapper.user.UserInfoMapper;
import com.github.xf717.userservice.dal.mysql.mapper.user.UserIntegralRecordMapper;
import com.github.xf717.userservice.dal.redis.dao.UserSignRedisDAO;
import com.github.xf717.userservice.enums.UserErrorCodeConstants;
import com.github.xf717.userservice.rpc.user.dto.UserIntegralRecordCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserIntegralRecordListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserIntegralRecordPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserIntegralRecordRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserIntegralRecordUpdateReqDTO;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserIntegralRecordService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserIntegralRecordService {

  @Autowired
  private UserIntegralRecordMapper userIntegralRecordMapper;

  @Autowired
  private UserSignRedisDAO userSignRedisDAO;

  @Autowired
  private UserInfoMapper userInfoMapper;

  private static final  int ONE = 1;
  private static final  int FIVE = 5;
  private static final  int SIX = 6;
  private static final  int SEVEN = 7;
  private static final  int FIFTEEN = 15;

  /**
  * 保存数据
* @param createReqDTO
* @return
*/
  public int saveUserIntegralRecord(UserIntegralRecordCreateReqDTO createReqDTO) {
    return userIntegralRecordMapper.insert(UserIntegralRecordConvert.INSTANCE.convert(createReqDTO));
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateUserIntegralRecord(UserIntegralRecordUpdateReqDTO updateReqDTO) {
          UserIntegralRecordDO userIntegralRecordDO = userIntegralRecordMapper.selectById(updateReqDTO.getId());
    if (userIntegralRecordDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
          userIntegralRecordDO = UserIntegralRecordConvert.INSTANCE.convert(updateReqDTO);
    int result = userIntegralRecordMapper.updateById(userIntegralRecordDO);
    return result;
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserIntegralRecord(Long id) {
    if (userIntegralRecordMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = userIntegralRecordMapper.deleteById(id);
    return result;
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserIntegralRecordRespDTO> listUserIntegralRecords(UserIntegralRecordListQueryReqDTO listQueryReqDTO) {
    List<UserIntegralRecordDO> list = userIntegralRecordMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserIntegralRecordConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserIntegralRecordRespDTO getUserIntegralRecordById(Long id) {
          UserIntegralRecordDO userIntegralRecordDO = userIntegralRecordMapper.selectById(id);
    if (userIntegralRecordDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return UserIntegralRecordConvert.INSTANCE.convert(userIntegralRecordDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserIntegralRecordRespDTO> pageUserIntegralRecord(UserIntegralRecordPageReqDTO page) {
    IPage<UserIntegralRecordDO> userIntegralRecordPage = userIntegralRecordMapper.selectPage(page);
    return UserIntegralRecordConvert.INSTANCE.convertPage(userIntegralRecordPage);
  }

  /**
   * 签到
   * @param userId
   * @return
   */
  public int sign(Long userId){
    String signTime  = DateUtil.format(new Date(), "yyyyMMdd");
    final String signRecord = this.userSignRedisDAO.formatKey(signTime,userId);
    if (userSignRedisDAO.exists(signRecord)) {
      throw ServiceExceptionUtil.exception(USER_SIGN_ALREADY_EXISTS);
    }
    userSignRedisDAO.set(signTime,userId);
    UserIntegralRecordDO userIntegralRecordDO = new UserIntegralRecordDO();
    //根据用户查询最近签到时间
    UserIntegralRecordDO recordDO = userIntegralRecordMapper.selectByUserId(userId);
    if(recordDO != null){
      Date signInTime = recordDO.getSignInTime();
      long day = DateUtil.betweenDay(new Date(), signInTime, true);
      //是否相差一天
      if (day == ONE) {
        //设置积分
        switch (recordDO.getCheckDay()) {
          case SIX:
            userIntegralRecordDO.setIntegralValue(FIFTEEN);
            userIntegralRecordDO.setCheckDay(recordDO.getCheckDay() + 1);
            break;
          case SEVEN:
            userIntegralRecordDO.setIntegralValue(FIVE);
            userIntegralRecordDO.setCheckDay(ONE);
            break;
          default:
            userIntegralRecordDO.setIntegralValue(FIVE);
            userIntegralRecordDO.setCheckDay(recordDO.getCheckDay() + 1);
        }
      } else {
        userIntegralRecordDO.setIntegralValue(FIVE);
        userIntegralRecordDO.setCheckDay(1);
      }
    } else {
      userIntegralRecordDO.setIntegralValue(FIVE);
      userIntegralRecordDO.setCheckDay(1);
    }
    UserInfoDO userInfoDO = userInfoMapper.selectUserInfoByUserId(userId);
    userIntegralRecordDO.setUserId(userId);
    userIntegralRecordDO.setMobile(userInfoDO.getMobile());
    userIntegralRecordDO.setSignInTime(new Date());
    // 字典表先默认写字典id
    userIntegralRecordDO.setIntegralExplanationDictionaryId(66L);
    userIntegralRecordDO.setIntegralTypeDictionaryId(67L);
    return userIntegralRecordMapper.insert(userIntegralRecordDO);
  }

}
