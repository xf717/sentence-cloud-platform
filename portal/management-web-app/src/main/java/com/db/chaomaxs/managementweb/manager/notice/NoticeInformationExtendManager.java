package com.db.chaomaxs.managementweb.manager.notice;

import com.db.chaomaxs.managementweb.controller.notice.dto.NoticeInformationExtendAddDTO;
import com.db.chaomaxs.managementweb.controller.notice.dto.NoticeInformationExtendUpdateDTO;
import com.db.chaomaxs.managementweb.controller.notice.dto.NoticeInformationExtendDTO;
import com.db.chaomaxs.managementweb.controller.notice.dto.NoticeInformationExtendPageDTO;
import com.db.chaomaxs.managementweb.controller.notice.vo.NoticeInformationExtendVO;
import com.db.chaomaxs.managementweb.convert.notice.NoticeInformationExtendConvert;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationExtendRespDTO;
import com.db.chaomaxs.systemservice.rpc.notice.facade.NoticeInformationExtendRpcFacade;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
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
  private NoticeInformationExtendRpcFacade noticeInformationExtendRpcFacade;

  /**
   * 添加数据
   * @param noticeInformationExtendCreateReqDTO 添加参数
   * @return
   */
  public int save(NoticeInformationExtendAddDTO noticeInformationExtendAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = noticeInformationExtendRpcFacade
        .save(NoticeInformationExtendConvert.INSTANCE.convert(noticeInformationExtendAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   * @param noticeInformationExtendUpdateDTO  更新参数
   * @return
   */
  public int update(NoticeInformationExtendUpdateDTO noticeInformationExtendUpdateDTO) {
    BaseResponse baseResponse = noticeInformationExtendRpcFacade
        .update(NoticeInformationExtendConvert.INSTANCE.convert(noticeInformationExtendUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   * @param id  id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = noticeInformationExtendRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   * @param id id
   * @return
   */
  public NoticeInformationExtendVO getNoticeInformationExtendById(Long id) {
    ObjectRestResponse<NoticeInformationExtendRespDTO> objectRestResponse = noticeInformationExtendRpcFacade.getNoticeInformationExtendById(
        id);
    objectRestResponse.checkError();
    return NoticeInformationExtendConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   * @param noticeInformationExtendDTO  查询参数
   * @return
   */
  public List<NoticeInformationExtendVO> listNoticeInformationExtends(NoticeInformationExtendDTO noticeInformationExtendDTO) {
    ObjectRestResponse<List<NoticeInformationExtendRespDTO>> objectRestResponse = noticeInformationExtendRpcFacade.listNoticeInformationExtends(
                NoticeInformationExtendConvert.INSTANCE.convert(noticeInformationExtendDTO));
    objectRestResponse.checkError();
    return NoticeInformationExtendConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   * @param pageReqDTO  分页参数
   * @return
   */
  public TableResultResponse<NoticeInformationExtendVO> pageNoticeInformationExtend(NoticeInformationExtendPageDTO pageReqDTO) {
    TableResultResponse<NoticeInformationExtendRespDTO> tableResultResponse = noticeInformationExtendRpcFacade
        .page(NoticeInformationExtendConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return NoticeInformationExtendConvert.INSTANCE.convert(tableResultResponse);
  }


}
