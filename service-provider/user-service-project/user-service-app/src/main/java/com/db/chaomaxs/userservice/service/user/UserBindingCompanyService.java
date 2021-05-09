package com.db.chaomaxs.userservice.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.convert.user.UserBindingCompanyConvert;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserBindingCompanyDO;
import com.db.chaomaxs.userservice.dal.mysql.mapper.user.UserBindingCompanyMapper;
import com.db.chaomaxs.userservice.enums.UserErrorCodeConstants;
import com.db.chaomaxs.userservice.enums.user.UserBindingStateEnum;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingCompanyCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingCompanyListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingCompanyPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingCompanyRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingCompanyUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingExtendRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingStateUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingTransferReqDTO;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserBindingCompanyService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserBindingCompanyService {

  @Autowired
  private UserBindingCompanyMapper userBindingCompanyMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveUserBindingCompany(UserBindingCompanyCreateReqDTO createReqDTO) {
    return userBindingCompanyMapper
        .insert(UserBindingCompanyConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateUserBindingCompany(UserBindingCompanyUpdateReqDTO updateReqDTO) {
    UserBindingCompanyDO userBindingCompanyDO = userBindingCompanyMapper
        .selectById(updateReqDTO.getId());
    if (userBindingCompanyDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    userBindingCompanyDO = UserBindingCompanyConvert.INSTANCE.convert(updateReqDTO);
    int result = userBindingCompanyMapper.updateById(userBindingCompanyDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteUserBindingCompany(Long id) {
    if (userBindingCompanyMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = userBindingCompanyMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<UserBindingCompanyRespDTO> listUserBindingCompanys(
      UserBindingCompanyListQueryReqDTO listQueryReqDTO) {
    List<UserBindingCompanyDO> list = userBindingCompanyMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserBindingCompanyConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public UserBindingCompanyRespDTO getUserBindingCompanyById(Long id) {
    UserBindingCompanyDO userBindingCompanyDO = userBindingCompanyMapper.selectById(id);
    if (userBindingCompanyDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return UserBindingCompanyConvert.INSTANCE.convert(userBindingCompanyDO);
  }

  /**
   * 分页列表
   *
   * @param page
   * @return
   */
  public PageResult<UserBindingCompanyRespDTO> pageUserBindingCompany(
      UserBindingCompanyPageReqDTO page) {
    if (null == page.getCompanyId()) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.COMPANY_ID_NULL.getCode());
    }
    IPage<UserBindingCompanyDO> userBindingCompanyPage = userBindingCompanyMapper.selectPage(page);
    PageResult<UserBindingCompanyRespDTO> respDTOPageResult = UserBindingCompanyConvert.INSTANCE
        .convertPage(userBindingCompanyPage);

    // 查询未绑定列表时 筛选出管理员数据
    if (UserBindingStateEnum.UNBOUND.getValue().equals(page.getBindingState())) {
      respDTOPageResult.getList().stream().filter(v -> v.getManager() == 1).collect(Collectors.toList());
    }
    return respDTOPageResult;
  }

  /**
   * 修改绑定状态
   * @param bindingStateUpdateReqDTO
   */
  public void updateBindingState(UserBindingStateUpdateReqDTO bindingStateUpdateReqDTO) {
    userBindingCompanyMapper.updateBindingState(bindingStateUpdateReqDTO);
  }

  /**
   * 获取公司所有绑定用户
   * @param companyId
   */
  public List<UserBindingExtendRespDTO> getAllBindingUser(Long companyId) {
    if (null == companyId) {
      throw ServiceExceptionUtil.exception(UserErrorCodeConstants.COMPANY_ID_NULL.getCode());
    }
    return UserBindingCompanyConvert.INSTANCE.convert(userBindingCompanyMapper.getAllBindingUser(companyId));
  }

  /**
   * 管理员身份转移
   * @param userBindingTransferReqDTO
   */
  public void managerTransfer(UserBindingTransferReqDTO userBindingTransferReqDTO) {
    userBindingCompanyMapper.removeManager(userBindingTransferReqDTO);
    userBindingCompanyMapper.updateManager(userBindingTransferReqDTO);
  }

  /**
   * 交接
   * @param userBindingTransferReqDTO
   */
  public void handover(UserBindingTransferReqDTO userBindingTransferReqDTO) {
    userBindingCompanyMapper.handover(userBindingTransferReqDTO);
  }

}
