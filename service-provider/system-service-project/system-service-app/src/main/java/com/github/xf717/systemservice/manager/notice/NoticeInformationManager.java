package com.github.xf717.systemservice.manager.notice;

import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationCreateReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationListQueryReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationPageReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationRespDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationUpdateReqDTO;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.service.notice.NoticeInformationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * NoticeInformationManager
 *
 * @author xiaofeng
 * @date 2021-03-29 18:09:32
 */
@Service
@Validated
public class NoticeInformationManager {

  @Autowired
  private NoticeInformationService noticeInformationService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveNoticeInformation(NoticeInformationCreateReqDTO createReqDTO) {
    return noticeInformationService.saveNoticeInformation(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateNoticeInformation(NoticeInformationUpdateReqDTO updateReqDTO) {
      return noticeInformationService.updateNoticeInformation(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteNoticeInformation(Long id) {
    return noticeInformationService.deleteNoticeInformation(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<NoticeInformationRespDTO> listNoticeInformations(NoticeInformationListQueryReqDTO listQueryReqDTO) {
    return noticeInformationService.listNoticeInformations(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public NoticeInformationRespDTO getNoticeInformationById(Long id) {
    return noticeInformationService.getNoticeInformationById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<NoticeInformationRespDTO> pageNoticeInformation(NoticeInformationPageReqDTO page) {
    return noticeInformationService.pageNoticeInformation(page);
  }


}
