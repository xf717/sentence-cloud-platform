package com.db.chaomaxs.systemservice.service.feedback;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.convert.feedback.OpinionFeedbackImageConvert;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.feedback.OpinionFeedbackImageDO;
import com.db.chaomaxs.systemservice.dal.mysql.mapper.feedback.OpinionFeedbackImageMapper;
import com.db.chaomaxs.systemservice.enums.SystemErrorCodeConstants;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackImageCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackImageListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackImagePageReqDTO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackImageRespDTO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackImageUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * OpinionFeedbackImageService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class OpinionFeedbackImageService {

  @Autowired
  private OpinionFeedbackImageMapper opinionFeedbackImageMapper;

  /**
  * 保存数据
* @param createReqDTO
* @return
*/
  public int saveOpinionFeedbackImage(OpinionFeedbackImageCreateReqDTO createReqDTO) {
    return opinionFeedbackImageMapper.insert(OpinionFeedbackImageConvert.INSTANCE.convert(createReqDTO));
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateOpinionFeedbackImage(OpinionFeedbackImageUpdateReqDTO updateReqDTO) {
          OpinionFeedbackImageDO opinionFeedbackImageDO = opinionFeedbackImageMapper.selectById(updateReqDTO.getId());
    if (opinionFeedbackImageDO == null) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
          opinionFeedbackImageDO = OpinionFeedbackImageConvert.INSTANCE.convert(updateReqDTO);
    int result = opinionFeedbackImageMapper.updateById(opinionFeedbackImageDO);
    return result;
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteOpinionFeedbackImage(Long id) {
    if (opinionFeedbackImageMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = opinionFeedbackImageMapper.deleteById(id);
    return result;
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<OpinionFeedbackImageRespDTO> listOpinionFeedbackImages(OpinionFeedbackImageListQueryReqDTO listQueryReqDTO) {
    List<OpinionFeedbackImageDO> list = opinionFeedbackImageMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return OpinionFeedbackImageConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public OpinionFeedbackImageRespDTO getOpinionFeedbackImageById(Long id) {
          OpinionFeedbackImageDO opinionFeedbackImageDO = opinionFeedbackImageMapper.selectById(id);
    if (opinionFeedbackImageDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return OpinionFeedbackImageConvert.INSTANCE.convert(opinionFeedbackImageDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<OpinionFeedbackImageRespDTO> pageOpinionFeedbackImage(OpinionFeedbackImagePageReqDTO page) {
    IPage<OpinionFeedbackImageDO> opinionFeedbackImagePage = opinionFeedbackImageMapper.selectPage(page);
    return OpinionFeedbackImageConvert.INSTANCE.convertPage(opinionFeedbackImagePage);
  }


}
