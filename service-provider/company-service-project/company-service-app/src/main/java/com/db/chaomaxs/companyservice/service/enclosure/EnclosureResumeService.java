package com.db.chaomaxs.companyservice.service.enclosure;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.convert.enclosure.EnclosureResumeConvert;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.enclosure.EnclosureResumeDO;
import com.db.chaomaxs.companyservice.dal.mysql.mapper.enclosure.EnclosureResumeMapper;
import com.db.chaomaxs.companyservice.enums.CompanyErrorCodeConstants;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumePageReqDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeRespDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * EnclosureResumeService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class EnclosureResumeService {

  @Autowired
  private EnclosureResumeMapper enclosureResumeMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveEnclosureResume(EnclosureResumeCreateReqDTO createReqDTO) {
    return enclosureResumeMapper.insert(EnclosureResumeConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateEnclosureResume(EnclosureResumeUpdateReqDTO updateReqDTO) {
    EnclosureResumeDO enclosureResumeDO = enclosureResumeMapper.selectById(updateReqDTO.getId());
    if (enclosureResumeDO == null) {
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
    }
    enclosureResumeDO = EnclosureResumeConvert.INSTANCE.convert(updateReqDTO);
    int result = enclosureResumeMapper.updateById(enclosureResumeDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteEnclosureResume(Long id) {
    if (enclosureResumeMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = enclosureResumeMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<EnclosureResumeRespDTO> listEnclosureResumes(
      EnclosureResumeListQueryReqDTO listQueryReqDTO) {
    List<EnclosureResumeDO> list = enclosureResumeMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return EnclosureResumeConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public EnclosureResumeRespDTO getEnclosureResumeById(Long id) {
    EnclosureResumeDO EnclosureResumeDO = enclosureResumeMapper.selectById(id);
    if (EnclosureResumeDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return EnclosureResumeConvert.INSTANCE.convert(EnclosureResumeDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<EnclosureResumeRespDTO> pageEnclosureResume(EnclosureResumePageReqDTO page) {
    IPage<EnclosureResumeDO> enclosureResumePage = enclosureResumeMapper.selectPage(page);
    return EnclosureResumeConvert.INSTANCE.convertPage(enclosureResumePage);
  }


}
