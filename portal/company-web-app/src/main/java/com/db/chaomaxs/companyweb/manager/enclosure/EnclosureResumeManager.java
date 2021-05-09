package com.db.chaomaxs.companyweb.manager.enclosure;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeRespDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.facade.EnclosureResumeRpcFacade;
import com.db.chaomaxs.companyweb.controller.enclosure.dto.EnclosureResumeAddDTO;
import com.db.chaomaxs.companyweb.controller.enclosure.dto.EnclosureResumeDTO;
import com.db.chaomaxs.companyweb.controller.enclosure.dto.EnclosureResumePageDTO;
import com.db.chaomaxs.companyweb.controller.enclosure.dto.EnclosureResumeUpdateDTO;
import com.db.chaomaxs.companyweb.controller.enclosure.vo.EnclosureResumeVO;
import com.db.chaomaxs.companyweb.convert.enclosure.EnclosureResumeConvert;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * EnclosureResumeManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class EnclosureResumeManager {

  @Autowired
  private EnclosureResumeRpcFacade enclosureResumeRpcFacade;

  /**
   * 添加数据
   *
   * @param enclosureResumeCreateReqDTO 添加参数
   * @return
   */
  public int save(EnclosureResumeAddDTO enclosureResumeAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = enclosureResumeRpcFacade
        .save(EnclosureResumeConvert.INSTANCE.convert(enclosureResumeAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param enclosureResumeUpdateDTO 更新参数
   * @return
   */
  public int update(EnclosureResumeUpdateDTO enclosureResumeUpdateDTO) {
    BaseResponse baseResponse = enclosureResumeRpcFacade
        .update(EnclosureResumeConvert.INSTANCE.convert(enclosureResumeUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = enclosureResumeRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public EnclosureResumeVO getEnclosureResumeById(Long id) {
    ObjectRestResponse<EnclosureResumeRespDTO> objectRestResponse = enclosureResumeRpcFacade
        .getEnclosureResumeById(id);
    objectRestResponse.checkError();
    return EnclosureResumeConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   *
   * @param enclosureResumeDTO 查询参数
   * @return
   */
  public List<EnclosureResumeVO> listEnclosureResumes(EnclosureResumeDTO enclosureResumeDTO) {
    ObjectRestResponse<List<EnclosureResumeRespDTO>> objectRestResponse = enclosureResumeRpcFacade
        .listEnclosureResumes(EnclosureResumeConvert.INSTANCE.convert(enclosureResumeDTO));
    objectRestResponse.checkError();
    return EnclosureResumeConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  public TableResultResponse<EnclosureResumeVO> pageEnclosureResume(
      EnclosureResumePageDTO pageReqDTO) {
    TableResultResponse<EnclosureResumeRespDTO> tableResultResponse = enclosureResumeRpcFacade
        .page(EnclosureResumeConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return EnclosureResumeConvert.INSTANCE.convert(tableResultResponse);
  }


}
