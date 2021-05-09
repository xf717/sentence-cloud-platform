package com.db.chaomaxs.systemservice.manager.notice;

import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationExtendCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationExtendListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationExtendPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationExtendRespDTO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationExtendUpdateReqDTO;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.service.notice.NoticeInformationExtendService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * NoticeInformationExtendManager
 *
 * @author xiaofeng
 * @date 2021-03-29 18:09:32
 */
@Service
@Validated
public class NoticeInformationExtendManager {

  @Autowired
  private NoticeInformationExtendService noticeInformationExtendService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveNoticeInformationExtend(NoticeInformationExtendCreateReqDTO createReqDTO) {
    return noticeInformationExtendService.saveNoticeInformationExtend(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateNoticeInformationExtend(NoticeInformationExtendUpdateReqDTO updateReqDTO) {
      return noticeInformationExtendService.updateNoticeInformationExtend(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteNoticeInformationExtend(Long id) {
    return noticeInformationExtendService.deleteNoticeInformationExtend(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<NoticeInformationExtendRespDTO> listNoticeInformationExtends(NoticeInformationExtendListQueryReqDTO listQueryReqDTO) {
    return noticeInformationExtendService.listNoticeInformationExtends(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public NoticeInformationExtendRespDTO getNoticeInformationExtendById(Long id) {
    return noticeInformationExtendService.getNoticeInformationExtendById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<NoticeInformationExtendRespDTO> pageNoticeInformationExtend(NoticeInformationExtendPageReqDTO page) {
    return noticeInformationExtendService.pageNoticeInformationExtend(page);
  }


}
