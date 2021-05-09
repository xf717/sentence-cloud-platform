package com.github.xf717.systemservice.rpc.notice;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.manager.notice.NoticeInformationExtendManager;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendCreateReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendListQueryReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendPageReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendRespDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendUpdateReqDTO;
import com.github.xf717.systemservice.rpc.notice.facade.NoticeInformationExtendRpcFacade;
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
public class NoticeInformationExtendRpcImpl implements NoticeInformationExtendRpcFacade {

  @Autowired
  private NoticeInformationExtendManager noticeInformationExtendManager;

  @Override
  public BaseResponse save(NoticeInformationExtendCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    noticeInformationExtendManager.saveNoticeInformationExtend(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(NoticeInformationExtendUpdateReqDTO updateReqDTO) {
      noticeInformationExtendManager.updateNoticeInformationExtend(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      noticeInformationExtendManager.deleteNoticeInformationExtend(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<NoticeInformationExtendRespDTO> getNoticeInformationExtendById(Long id) {
      NoticeInformationExtendRespDTO noticeInformationExtend = noticeInformationExtendManager.getNoticeInformationExtendById(id);
    return new ObjectRestResponse<>().data(noticeInformationExtend);
  }

  @Override
  public ObjectRestResponse<List<NoticeInformationExtendRespDTO>> listNoticeInformationExtends(NoticeInformationExtendListQueryReqDTO listQuery) {
    List<NoticeInformationExtendRespDTO> list = noticeInformationExtendManager.listNoticeInformationExtends(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<NoticeInformationExtendRespDTO> page(NoticeInformationExtendPageReqDTO pageReqDTO) {
    PageResult<NoticeInformationExtendRespDTO> pageResult = noticeInformationExtendManager.pageNoticeInformationExtend(pageReqDTO);
    TableResultResponse<NoticeInformationExtendRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}
