package com.github.xf717.userservice.service.resume;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.convert.resume.UserExpectedPositionIndustryConvert;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserExpectedPositionIndustryDO;
import com.github.xf717.userservice.dal.mysql.mapper.resume.UserExpectedPositionIndustryMapper;
import com.github.xf717.userservice.enums.UserErrorCodeConstants;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryPageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


/**
 * UserExpectedPositionIndustryService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserExpectedPositionIndustryService {

  @Autowired
  private UserExpectedPositionIndustryMapper userExpectedPositionIndustryMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveUserExpectedPositionIndustry(
      UserExpectedPositionIndustryCreateReqDTO createReqDTO) {
    return userExpectedPositionIndustryMapper
        .insert(UserExpectedPositionIndustryConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateUserExpectedPositionIndustry(
      UserExpectedPositionIndustryUpdateReqDTO updateReqDTO) {
    UserExpectedPositionIndustryDO userExpectedPositionIndustryDO = userExpectedPositionIndustryMapper
        .selectById(updateReqDTO.getId());
    if (userExpectedPositionIndustryDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    userExpectedPositionIndustryDO = UserExpectedPositionIndustryConvert.INSTANCE
        .convert(updateReqDTO);
    int result = userExpectedPositionIndustryMapper.updateById(userExpectedPositionIndustryDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteUserExpectedPositionIndustry(Long id) {
    if (userExpectedPositionIndustryMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = userExpectedPositionIndustryMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<UserExpectedPositionIndustryRespDTO> listUserExpectedPositionIndustrys(
      UserExpectedPositionIndustryListQueryReqDTO listQueryReqDTO) {
    List<UserExpectedPositionIndustryDO> list = userExpectedPositionIndustryMapper
        .selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserExpectedPositionIndustryConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public UserExpectedPositionIndustryRespDTO getUserExpectedPositionIndustryById(Long id) {
    UserExpectedPositionIndustryDO userExpectedPositionIndustryDO = userExpectedPositionIndustryMapper
        .selectById(id);
    if (userExpectedPositionIndustryDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return UserExpectedPositionIndustryConvert.INSTANCE.convert(userExpectedPositionIndustryDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<UserExpectedPositionIndustryRespDTO> pageUserExpectedPositionIndustry(
      UserExpectedPositionIndustryPageReqDTO page) {
    IPage<UserExpectedPositionIndustryDO> userExpectedPositionIndustryPage = userExpectedPositionIndustryMapper
        .selectPage(page);
    return UserExpectedPositionIndustryConvert.INSTANCE
        .convertPage(userExpectedPositionIndustryPage);
  }

  /**
   * 根据求职期望id查询
   * @param expectedPositionId
   * @return
   */
  public List<UserExpectedPositionIndustryRespDTO> listIndustryByExpectedPositionId(Long expectedPositionId){
    List<UserExpectedPositionIndustryDO> list = userExpectedPositionIndustryMapper
        .listIndustryByExpectedPositionId(expectedPositionId);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserExpectedPositionIndustryConvert.INSTANCE.convertList(list);
  }


}
