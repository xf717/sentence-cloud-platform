package com.db.chaomaxs.systemservice.rpc.notice;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.manager.notice.NoticeInformationManager;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationRespDTO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.notice.facade.NoticeInformationRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 18:09:32
 */
@Slf4j
@Service
public class NoticeInformationRpcImpl implements NoticeInformationRpcFacade {

  @Autowired
  private NoticeInformationManager noticeInformationManager;

  @Override
  public BaseResponse save(NoticeInformationCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    noticeInformationManager.saveNoticeInformation(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(NoticeInformationUpdateReqDTO updateReqDTO) {
      noticeInformationManager.updateNoticeInformation(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      noticeInformationManager.deleteNoticeInformation(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<NoticeInformationRespDTO> getNoticeInformationById(Long id) {
      NoticeInformationRespDTO noticeInformation = noticeInformationManager.getNoticeInformationById(id);
    return new ObjectRestResponse<>().data(noticeInformation);
  }

  @Override
  public ObjectRestResponse<List<NoticeInformationRespDTO>> listNoticeInformations(NoticeInformationListQueryReqDTO listQuery) {
    List<NoticeInformationRespDTO> list = noticeInformationManager.listNoticeInformations(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<NoticeInformationRespDTO> page(NoticeInformationPageReqDTO pageReqDTO) {
    PageResult<NoticeInformationRespDTO> pageResult = noticeInformationManager.pageNoticeInformation(pageReqDTO);
    TableResultResponse<NoticeInformationRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}
