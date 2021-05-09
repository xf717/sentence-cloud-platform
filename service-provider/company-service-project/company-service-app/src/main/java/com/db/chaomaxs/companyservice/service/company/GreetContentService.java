package com.db.chaomaxs.companyservice.service.company;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.convert.company.GreetContentConvert;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.company.GreetContentDO;
import com.db.chaomaxs.companyservice.dal.mysql.mapper.company.GreetContentMapper;
import com.db.chaomaxs.companyservice.enums.CompanyErrorCodeConstants;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentUpdateReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * GreetContentService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class GreetContentService {

  @Autowired
  private GreetContentMapper greetContentMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveGreetContent(GreetContentCreateReqDTO createReqDTO) {
    return greetContentMapper.insert(GreetContentConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateGreetContent(GreetContentUpdateReqDTO updateReqDTO) {
    GreetContentDO greetContentDO = greetContentMapper.selectByUserId(updateReqDTO.getUserId());
    if (greetContentDO == null) {
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
    }
    greetContentDO = GreetContentConvert.INSTANCE.convert(updateReqDTO);
    int result = greetContentMapper.updateById(greetContentDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteGreetContent(Long id) {
    if (greetContentMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = greetContentMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param userId
   * @return
   */
  public GreetContentRespDTO getGreetContentsByUserId(Long userId) {
    GreetContentDO greetContentDO = greetContentMapper.selectByUserId(userId);
    if (greetContentDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return GreetContentConvert.INSTANCE.convert(greetContentDO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public GreetContentRespDTO getGreetContentById(Long id) {
    GreetContentDO GreetContentDO = greetContentMapper.selectById(id);
    if (GreetContentDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return GreetContentConvert.INSTANCE.convert(GreetContentDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<GreetContentRespDTO> pageGreetContent(GreetContentPageReqDTO page) {
    IPage<GreetContentDO> greetContentPage = greetContentMapper.selectPage(page);
    return GreetContentConvert.INSTANCE.convertPage(greetContentPage);
  }


}
