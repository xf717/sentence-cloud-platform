package com.github.xf717.systemservice.service.feedback;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.exception.ServiceException;
import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.convert.feedback.OpinionFeedbackConvert;
import com.github.xf717.systemservice.dal.mysql.dataobject.feedback.OpinionFeedbackDO;
import com.github.xf717.systemservice.dal.mysql.dataobject.feedback.OpinionFeedbackImageDO;
import com.github.xf717.systemservice.dal.mysql.mapper.feedback.OpinionFeedbackImageMapper;
import com.github.xf717.systemservice.dal.mysql.mapper.feedback.OpinionFeedbackMapper;
import com.github.xf717.systemservice.enums.SystemErrorCodeConstants;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackCreateReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackListQueryReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackPageReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackRespDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackUpdateReqDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * OpinionFeedbackService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class OpinionFeedbackService {

  @Autowired
  private OpinionFeedbackMapper opinionFeedbackMapper;
  @Autowired
  private OpinionFeedbackImageMapper opinionFeedbackImageMapper;


  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  @Transactional(rollbackFor = ServiceException.class)
  public int saveOpinionFeedback(OpinionFeedbackCreateReqDTO createReqDTO) {

    if (null == createReqDTO.getReleaseTime()) {
      createReqDTO.setReleaseTime(new Date());
    }
    OpinionFeedbackDO opinionFeedbackDO = OpinionFeedbackConvert.INSTANCE.convert(createReqDTO);
    if (StringUtils.isBlank(createReqDTO.getContent())) {
      opinionFeedbackDO.setContent(StrUtil.EMPTY);
    }
    int result = opinionFeedbackMapper.insert(opinionFeedbackDO);

    //组装OpinionFeedbackImageDO对象
    if (!CollectionUtils.isEmpty(createReqDTO.getResourceIds())) {
      List<OpinionFeedbackImageDO> opinionFeedbackImageDOS = new ArrayList<>();
      for (Long imgId : createReqDTO.getResourceIds()) {
        OpinionFeedbackImageDO opinionFeedbackImageDO = new OpinionFeedbackImageDO();
        opinionFeedbackImageDO.setOpinionFeedbackId(opinionFeedbackDO.getId());
        opinionFeedbackImageDO.setImageResourseId(imgId);
        opinionFeedbackImageDOS.add(opinionFeedbackImageDO);
//         opinionFeedbackImageMapper.insert(opinionFeedbackImageDO);
      }
      opinionFeedbackImageMapper.insertBatch(opinionFeedbackImageDOS);
    }

    return result;
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateOpinionFeedback(OpinionFeedbackUpdateReqDTO updateReqDTO) {
    OpinionFeedbackDO opinionFeedbackDO = opinionFeedbackMapper.selectById(updateReqDTO.getId());
    if (opinionFeedbackDO == null) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    opinionFeedbackDO.setHandleStatus(updateReqDTO.getHandleStatus());
    opinionFeedbackDO.setContent(updateReqDTO.getContent());
    int result = opinionFeedbackMapper.updateById(opinionFeedbackDO);

    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteOpinionFeedback(Long id) {
    if (opinionFeedbackMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = opinionFeedbackMapper.deleteById(id);
    opinionFeedbackImageMapper.deleteByOpinionFeedbackId(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<OpinionFeedbackRespDTO> listOpinionFeedbacks(
      OpinionFeedbackListQueryReqDTO listQueryReqDTO) {
    List<OpinionFeedbackDO> list = opinionFeedbackMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    List<OpinionFeedbackRespDTO> opinionFeedbackRespDTOS = OpinionFeedbackConvert.INSTANCE
        .convertList(list);
    buildOpinionFeedbackRespDTO(opinionFeedbackRespDTOS);
    return opinionFeedbackRespDTOS;
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public OpinionFeedbackRespDTO getOpinionFeedbackById(Long id) {
    OpinionFeedbackDO opinionFeedbackDO = opinionFeedbackMapper.selectById(id);
    if (opinionFeedbackDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    OpinionFeedbackRespDTO opinionFeedbackRespDTO = OpinionFeedbackConvert.INSTANCE
        .convert(opinionFeedbackDO);
    List<OpinionFeedbackRespDTO> opinionFeedbackRespDTOS = new ArrayList<>();
    opinionFeedbackRespDTOS.add(opinionFeedbackRespDTO);
    buildOpinionFeedbackRespDTO(opinionFeedbackRespDTOS);
    return opinionFeedbackRespDTO;
  }

  /**
   * 分页
   *
   * @param page
   * @return
   */
  public PageResult<OpinionFeedbackRespDTO> pageOpinionFeedback(OpinionFeedbackPageReqDTO page) {
    if (null != page.getReleaseStartTime()) {
      DateTime dateTime = DateUtil.beginOfDay(page.getReleaseStartTime());
      page.setReleaseStartTime(dateTime);
    }
    if (null != page.getReleaseEndTime()) {
      DateTime dateTime = DateUtil.endOfDay(page.getReleaseEndTime());
      page.setReleaseEndTime(dateTime);
    }
    if (null != page.getEditStartTime()) {
      DateTime dateTime = DateUtil.beginOfDay(page.getEditStartTime());
      page.setEditStartTime(dateTime);
    }
    if (null != page.getEditEndTime()) {
      DateTime dateTime = DateUtil.endOfDay(page.getEditEndTime());
      page.setEditEndTime(dateTime);
    }
    IPage<OpinionFeedbackDO> opinionFeedbackPage = opinionFeedbackMapper.selectPage(page);
    PageResult<OpinionFeedbackRespDTO> pageResult = OpinionFeedbackConvert.INSTANCE
        .convertPage(opinionFeedbackPage);
    buildOpinionFeedbackRespDTO(pageResult.getList());
    return pageResult;
  }



  /**
   * 根据userId获取最后一条反馈记录
   *
   * @param listReqDTO
   * @return
   */
  public OpinionFeedbackRespDTO selectLastFeedbackByUserId(OpinionFeedbackListQueryReqDTO listReqDTO) {
    OpinionFeedbackDO opinionFeedbackDO = opinionFeedbackMapper.selectLastFeedbackByUserId(listReqDTO);
    if (opinionFeedbackDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    OpinionFeedbackRespDTO opinionFeedbackRespDTO = OpinionFeedbackConvert.INSTANCE
        .convert(opinionFeedbackDO);
    List<OpinionFeedbackRespDTO> opinionFeedbackRespDTOS = new ArrayList<>();
    opinionFeedbackRespDTOS.add(opinionFeedbackRespDTO);
    buildOpinionFeedbackRespDTO(opinionFeedbackRespDTOS);
    return opinionFeedbackRespDTO;
  }

  /**
   * 构造OpinionFeedbackRespDTO对象
   *
   * @param list
   */
  public void buildOpinionFeedbackRespDTO(List<OpinionFeedbackRespDTO> list) {
    if (CollectionUtils.isEmpty(list)) {
      return;
    }
    List<Long> ids = list.stream().map(OpinionFeedbackRespDTO::getId).collect(Collectors.toList());
    List<OpinionFeedbackImageDO> feedbackImageDOS = opinionFeedbackImageMapper
        .listByOpinionFeedbackIds(ids);
    //根据OpinionFeedbackId分组并返回ImageResourseId集合
    Map<Long, List<Long>> feedbackImageMap = feedbackImageDOS.stream().collect(
        Collectors.groupingBy(OpinionFeedbackImageDO::getOpinionFeedbackId,
            Collectors.mapping(OpinionFeedbackImageDO::getImageResourseId, Collectors.toList())));
    for (OpinionFeedbackRespDTO respDTO : list) {
      List<Long> imageIds = feedbackImageMap.get(respDTO.getId());
      if (!CollectionUtils.isEmpty(imageIds)) {
        respDTO.setImgs(imageIds);
      }
    }
  }


}
