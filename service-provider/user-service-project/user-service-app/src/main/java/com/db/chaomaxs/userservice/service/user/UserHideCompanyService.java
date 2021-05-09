package com.db.chaomaxs.userservice.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.convert.user.UserHideCompanyConvert;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserHideCompanyDO;
import com.db.chaomaxs.userservice.dal.mysql.mapper.user.UserHideCompanyMapper;
import com.db.chaomaxs.userservice.enums.UserErrorCodeConstants;
import com.db.chaomaxs.userservice.rpc.user.dto.UserHideCompanyBatchInsertReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserHideCompanyCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserHideCompanyListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserHideCompanyPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserHideCompanyRespDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserHideCompanyService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserHideCompanyService {

  @Autowired
  private UserHideCompanyMapper userHideCompanyMapper;

  /**
  * 保存数据
* @param batchInsertReqDTO
* @return
*/
  public int saveUserHideCompany(UserHideCompanyBatchInsertReqDTO batchInsertReqDTO) {

    List<UserHideCompanyCreateReqDTO> userHideCompanyList = batchInsertReqDTO.getHideCompanyList();
    return userHideCompanyMapper.batchInsert(UserHideCompanyConvert
        .INSTANCE.listConvert(userHideCompanyList));
  }


  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteUserHideCompany(Long id) {
    if (userHideCompanyMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = userHideCompanyMapper.deleteById(id);
    return result;
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<UserHideCompanyRespDTO> listUserHideCompanys(UserHideCompanyListQueryReqDTO listQueryReqDTO) {
    List<UserHideCompanyDO> list = userHideCompanyMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserHideCompanyConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public UserHideCompanyRespDTO getUserHideCompanyById(Long id) {
          UserHideCompanyDO userHideCompanyDO = userHideCompanyMapper.selectById(id);
    if (userHideCompanyDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return UserHideCompanyConvert.INSTANCE.convert(userHideCompanyDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<UserHideCompanyRespDTO> pageUserHideCompany(UserHideCompanyPageReqDTO page) {
    IPage<UserHideCompanyDO> userHideCompanyPage = userHideCompanyMapper.selectPage(page);
    return UserHideCompanyConvert.INSTANCE.convertPage(userHideCompanyPage);
  }


}
