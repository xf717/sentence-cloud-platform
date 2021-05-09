package com.db.chaomaxs.systemservice.service.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.convert.auth.BaseGroupLeaderConvert;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.auth.BaseGroupLeaderDO;
import com.db.chaomaxs.systemservice.dal.mysql.mapper.auth.BaseGroupLeaderMapper;
import com.db.chaomaxs.systemservice.enums.SystemErrorCodeConstants;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderUpdateReqDTO;
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
public class BaseGroupLeaderService {

  @Autowired
  private BaseGroupLeaderMapper baseGroupLeaderMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveBaseGroupLeader(BaseGroupLeaderCreateReqDTO createReqDTO) {
    return baseGroupLeaderMapper.insert(BaseGroupLeaderConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateBaseGroupLeader(BaseGroupLeaderUpdateReqDTO updateReqDTO) {
    BaseGroupLeaderDO baseGroupLeaderDO = baseGroupLeaderMapper.selectById(updateReqDTO.getId());
    if (baseGroupLeaderDO == null) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    baseGroupLeaderDO = BaseGroupLeaderConvert.INSTANCE.convert(updateReqDTO);
    int result = baseGroupLeaderMapper.updateById(baseGroupLeaderDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteBaseGroupLeader(Long id) {
    if (baseGroupLeaderMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    int result = baseGroupLeaderMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<BaseGroupLeaderRespDTO> listBaseGroupLeaders(
      BaseGroupLeaderListQueryReqDTO listQueryReqDTO) {
    List<BaseGroupLeaderDO> list = baseGroupLeaderMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return BaseGroupLeaderConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public BaseGroupLeaderRespDTO getBaseGroupLeaderById(Long id) {
    BaseGroupLeaderDO BaseGroupLeaderDO = baseGroupLeaderMapper.selectById(id);
    if (BaseGroupLeaderDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    return BaseGroupLeaderConvert.INSTANCE.convert(BaseGroupLeaderDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<BaseGroupLeaderRespDTO> pageBaseGroupLeader(BaseGroupLeaderPageReqDTO page) {
    IPage<BaseGroupLeaderDO> baseGroupLeaderPage = baseGroupLeaderMapper.selectPage(page);
    return BaseGroupLeaderConvert.INSTANCE.convertPage(baseGroupLeaderPage);
  }


}
