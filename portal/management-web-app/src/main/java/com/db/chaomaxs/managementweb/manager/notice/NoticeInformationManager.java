package com.db.chaomaxs.managementweb.manager.notice;

import com.db.chaomaxs.managementweb.controller.notice.dto.NoticeInformationAddDTO;
import com.db.chaomaxs.managementweb.controller.notice.dto.NoticeInformationUpdateDTO;
import com.db.chaomaxs.managementweb.controller.notice.dto.NoticeInformationDTO;
import com.db.chaomaxs.managementweb.controller.notice.dto.NoticeInformationPageDTO;
import com.db.chaomaxs.managementweb.controller.notice.vo.NoticeInformationVO;
import com.db.chaomaxs.managementweb.convert.notice.NoticeInformationConvert;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationRespDTO;
import com.db.chaomaxs.systemservice.rpc.notice.facade.NoticeInformationRpcFacade;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
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
  private NoticeInformationRpcFacade noticeInformationRpcFacade;

  /**
   * 添加数据
   * @param noticeInformationCreateReqDTO 添加参数
   * @return
   */
  public int save(NoticeInformationAddDTO noticeInformationAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = noticeInformationRpcFacade
        .save(NoticeInformationConvert.INSTANCE.convert(noticeInformationAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   * @param noticeInformationUpdateDTO  更新参数
   * @return
   */
  public int update(NoticeInformationUpdateDTO noticeInformationUpdateDTO) {
    BaseResponse baseResponse = noticeInformationRpcFacade
        .update(NoticeInformationConvert.INSTANCE.convert(noticeInformationUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   * @param id  id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = noticeInformationRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   * @param id id
   * @return
   */
  public NoticeInformationVO getNoticeInformationById(Long id) {
    ObjectRestResponse<NoticeInformationRespDTO> objectRestResponse = noticeInformationRpcFacade.getNoticeInformationById(
        id);
    objectRestResponse.checkError();
    return NoticeInformationConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   * @param noticeInformationDTO  查询参数
   * @return
   */
  public List<NoticeInformationVO> listNoticeInformations(NoticeInformationDTO noticeInformationDTO) {
    ObjectRestResponse<List<NoticeInformationRespDTO>> objectRestResponse = noticeInformationRpcFacade.listNoticeInformations(
                NoticeInformationConvert.INSTANCE.convert(noticeInformationDTO));
    objectRestResponse.checkError();
    return NoticeInformationConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   * @param pageReqDTO  分页参数
   * @return
   */
  public TableResultResponse<NoticeInformationVO> pageNoticeInformation(NoticeInformationPageDTO pageReqDTO) {
    TableResultResponse<NoticeInformationRespDTO> tableResultResponse = noticeInformationRpcFacade
        .page(NoticeInformationConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return NoticeInformationConvert.INSTANCE.convert(tableResultResponse);
  }


}
