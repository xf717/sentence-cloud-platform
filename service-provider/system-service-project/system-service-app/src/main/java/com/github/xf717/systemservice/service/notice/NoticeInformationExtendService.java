package com.github.xf717.systemservice.service.notice;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.convert.notice.NoticeInformationExtendConvert;
import com.github.xf717.systemservice.dal.mysql.dataobject.notice.NoticeInformationExtendDO;
import com.github.xf717.systemservice.dal.mysql.mapper.notice.NoticeInformationExtendMapper;
import com.github.xf717.systemservice.enums.SystemErrorCodeConstants;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendCreateReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendListQueryReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendPageReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendRespDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * NoticeInformationExtendService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class NoticeInformationExtendService {

  @Autowired
  private NoticeInformationExtendMapper noticeInformationExtendMapper;

  /**
  * 保存数据
* @param createReqDTO
* @return
*/
  public int saveNoticeInformationExtend(NoticeInformationExtendCreateReqDTO createReqDTO) {
    return noticeInformationExtendMapper.insert(NoticeInformationExtendConvert.INSTANCE.convert(createReqDTO));
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateNoticeInformationExtend(NoticeInformationExtendUpdateReqDTO updateReqDTO) {
          NoticeInformationExtendDO noticeInformationExtendDO = noticeInformationExtendMapper.selectById(updateReqDTO.getId());
    if (noticeInformationExtendDO == null) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
          noticeInformationExtendDO = NoticeInformationExtendConvert.INSTANCE.convert(updateReqDTO);
    int result = noticeInformationExtendMapper.updateById(noticeInformationExtendDO);
    return result;
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteNoticeInformationExtend(Long id) {
    if (noticeInformationExtendMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = noticeInformationExtendMapper.deleteById(id);
    return result;
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<NoticeInformationExtendRespDTO> listNoticeInformationExtends(NoticeInformationExtendListQueryReqDTO listQueryReqDTO) {
    List<NoticeInformationExtendDO> list = noticeInformationExtendMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return NoticeInformationExtendConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public NoticeInformationExtendRespDTO getNoticeInformationExtendById(Long id) {
          NoticeInformationExtendDO noticeInformationExtendDO = noticeInformationExtendMapper.selectById(id);
    if (noticeInformationExtendDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return NoticeInformationExtendConvert.INSTANCE.convert(noticeInformationExtendDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<NoticeInformationExtendRespDTO> pageNoticeInformationExtend(NoticeInformationExtendPageReqDTO page) {
    IPage<NoticeInformationExtendDO> noticeInformationExtendPage = noticeInformationExtendMapper.selectPage(page);
    return NoticeInformationExtendConvert.INSTANCE.convertPage(noticeInformationExtendPage);
  }


}
