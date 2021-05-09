package com.db.chaomaxs.systemservice.service.notice;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.convert.notice.NoticeInformationConvert;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.notice.NoticeInformationDO;
import com.db.chaomaxs.systemservice.dal.mysql.mapper.notice.NoticeInformationMapper;
import com.db.chaomaxs.systemservice.enums.SystemErrorCodeConstants;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationRespDTO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * NoticeInformationService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class NoticeInformationService {

  @Autowired
  private NoticeInformationMapper noticeInformationMapper;

  /**
  * 保存数据
* @param createReqDTO
* @return
*/
  public int saveNoticeInformation(NoticeInformationCreateReqDTO createReqDTO) {
    return noticeInformationMapper.insert(NoticeInformationConvert.INSTANCE.convert(createReqDTO));
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateNoticeInformation(NoticeInformationUpdateReqDTO updateReqDTO) {
          NoticeInformationDO noticeInformationDO = noticeInformationMapper.selectById(updateReqDTO.getId());
    if (noticeInformationDO == null) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
          noticeInformationDO = NoticeInformationConvert.INSTANCE.convert(updateReqDTO);
    int result = noticeInformationMapper.updateById(noticeInformationDO);
    return result;
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteNoticeInformation(Long id) {
    if (noticeInformationMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = noticeInformationMapper.deleteById(id);
    return result;
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<NoticeInformationRespDTO> listNoticeInformations(NoticeInformationListQueryReqDTO listQueryReqDTO) {
    List<NoticeInformationDO> list = noticeInformationMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return NoticeInformationConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public NoticeInformationRespDTO getNoticeInformationById(Long id) {
          NoticeInformationDO noticeInformationDO = noticeInformationMapper.selectById(id);
    if (noticeInformationDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return NoticeInformationConvert.INSTANCE.convert(noticeInformationDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<NoticeInformationRespDTO> pageNoticeInformation(NoticeInformationPageReqDTO page) {
    IPage<NoticeInformationDO> noticeInformationPage = noticeInformationMapper.selectPage(page);
    return NoticeInformationConvert.INSTANCE.convertPage(noticeInformationPage);
  }


}
