package com.db.chaomaxs.systemservice.service.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.convert.auth.BaseGroupMemberConvert;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.auth.BaseGroupMemberDO;
import com.db.chaomaxs.systemservice.dal.mysql.mapper.auth.BaseGroupMemberMapper;
import com.db.chaomaxs.systemservice.enums.SystemErrorCodeConstants;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * ResourceService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class BaseGroupMemberService {

  @Autowired
  private BaseGroupMemberMapper baseGroupMemberMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveBaseGroupMember(BaseGroupMemberCreateReqDTO createReqDTO) {
    return baseGroupMemberMapper.insert(BaseGroupMemberConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateBaseGroupMember(BaseGroupMemberUpdateReqDTO updateReqDTO) {
    BaseGroupMemberDO baseGroupMemberDO = baseGroupMemberMapper.selectById(updateReqDTO.getId());
    if (baseGroupMemberDO == null) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    baseGroupMemberDO = BaseGroupMemberConvert.INSTANCE.convert(updateReqDTO);
    int result = baseGroupMemberMapper.updateById(baseGroupMemberDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteBaseGroupMember(Integer id) {
    if (baseGroupMemberMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    int result = baseGroupMemberMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<BaseGroupMemberRespDTO> listBaseGroupMembers(
      BaseGroupMemberListQueryReqDTO listQueryReqDTO) {
    List<BaseGroupMemberDO> list = baseGroupMemberMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return BaseGroupMemberConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public BaseGroupMemberRespDTO getBaseGroupMemberById(Integer id) {
    BaseGroupMemberDO BaseGroupMemberDO = baseGroupMemberMapper.selectById(id);
    if (BaseGroupMemberDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    return BaseGroupMemberConvert.INSTANCE.convert(BaseGroupMemberDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<BaseGroupMemberRespDTO> pageBaseGroupMember(BaseGroupMemberPageReqDTO page) {
    IPage<BaseGroupMemberDO> baseGroupMemberPage = baseGroupMemberMapper.selectPage(page);
    return BaseGroupMemberConvert.INSTANCE.convertPage(baseGroupMemberPage);
  }


}
