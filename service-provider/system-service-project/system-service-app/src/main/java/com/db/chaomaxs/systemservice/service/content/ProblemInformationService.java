package com.db.chaomaxs.systemservice.service.content;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.ServiceException;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.convert.content.ProblemInformationConvert;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.content.ProblemInformationDO;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.content.ProblemInformationExtendDO;
import com.db.chaomaxs.systemservice.dal.mysql.mapper.content.ProblemInformationExtendMapper;
import com.db.chaomaxs.systemservice.dal.mysql.mapper.content.ProblemInformationMapper;
import com.db.chaomaxs.systemservice.enums.SystemErrorCodeConstants;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * ProblemInformationService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class ProblemInformationService {

  @Autowired
  private ProblemInformationMapper problemInformationMapper;
  @Autowired
  private ProblemInformationExtendMapper problemInformationExtendMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  @Transactional(rollbackFor = ServiceException.class)
  public int saveProblemInformation(ProblemInformationCreateReqDTO createReqDTO) {
    ProblemInformationDO problemInformationDO = ProblemInformationConvert.INSTANCE.convert(createReqDTO);
    int result = problemInformationMapper.insert(problemInformationDO);
    //插入问题扩展信息表
    ProblemInformationExtendDO problemInformationExtendDO = new ProblemInformationExtendDO();
    problemInformationExtendDO.setProblemInfoId(problemInformationDO.getId());
    problemInformationExtendDO.setContent(createReqDTO.getContent());
    problemInformationExtendMapper.insert(problemInformationExtendDO);
    return result;
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  @Transactional(rollbackFor = ServiceException.class)
  public int updateProblemInformation(ProblemInformationUpdateReqDTO updateReqDTO) {
    ProblemInformationDO problemInformationDO = problemInformationMapper
        .selectById(updateReqDTO.getId());
    if (problemInformationDO == null) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    problemInformationDO = ProblemInformationConvert.INSTANCE.convert(updateReqDTO);
    int result = problemInformationMapper.updateById(problemInformationDO);
    //修改问题扩展信息表
    ProblemInformationExtendDO problemInformationExtendDO = new ProblemInformationExtendDO();
    problemInformationExtendDO.setId(updateReqDTO.getInformationExtendId());
    problemInformationExtendDO.setContent(updateReqDTO.getContent());
    problemInformationExtendMapper.updateById(problemInformationExtendDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  @Transactional(rollbackFor = ServiceException.class)
  public int deleteProblemInformation(Long id) {
    if (problemInformationMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = problemInformationMapper.deleteById(id);
    problemInformationExtendMapper.deleteByProblemInfoId(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<ProblemInformationRespDTO> listProblemInformations(
      ProblemInformationListQueryReqDTO listQueryReqDTO) {
    List<ProblemInformationDO> list = problemInformationMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return ProblemInformationConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public ProblemInformationRespDTO getProblemInformationById(Long id) {
    ProblemInformationDO problemInformationDO = problemInformationMapper.selectById(id);
    if (problemInformationDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    ProblemInformationRespDTO problemInformationRespDTO = ProblemInformationConvert.INSTANCE
        .convert(problemInformationDO);
    ProblemInformationExtendDO problemInformationExtendDO = problemInformationExtendMapper
        .getByProblemInfoId(problemInformationDO.getId());
    if (null != problemInformationExtendDO) {
      problemInformationRespDTO.setInformationExtendId(problemInformationExtendDO.getId());
      problemInformationRespDTO.setContent(problemInformationExtendDO.getContent());
    }
    return problemInformationRespDTO;
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<ProblemInformationRespDTO> pageProblemInformation(
      ProblemInformationPageReqDTO page) {
    if (null != page.getStartTime()) {
      DateTime dateTime = DateUtil.beginOfDay(page.getStartTime());
      page.setStartTime(dateTime);
    }
    if (null != page.getEndTime()) {
      DateTime dateTime = DateUtil.endOfDay(page.getEndTime());
      page.setEndTime(dateTime);
    }
    IPage<ProblemInformationDO> problemInformationPage = problemInformationMapper.findByPage(page);
    return ProblemInformationConvert.INSTANCE.convertPage(problemInformationPage);
  }


}
