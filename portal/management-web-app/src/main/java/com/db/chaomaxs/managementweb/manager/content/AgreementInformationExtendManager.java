package com.db.chaomaxs.managementweb.manager.content;

import com.db.chaomaxs.managementweb.controller.content.dto.AgreementInformationExtendAddDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.AgreementInformationExtendUpdateDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.AgreementInformationExtendDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.AgreementInformationExtendPageDTO;
import com.db.chaomaxs.managementweb.controller.content.vo.AgreementInformationExtendVO;
import com.db.chaomaxs.managementweb.convert.content.AgreementInformationExtendConvert;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationExtendRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.facade.AgreementInformationExtendRpcFacade;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * AgreementInformationExtendManager
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Service
@Validated
public class AgreementInformationExtendManager {

  @Autowired
  private AgreementInformationExtendRpcFacade agreementInformationExtendRpcFacade;

  /**
   * 添加数据
   * @param agreementInformationExtendCreateReqDTO 添加参数
   * @return
   */
  public int save(AgreementInformationExtendAddDTO agreementInformationExtendAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = agreementInformationExtendRpcFacade
        .save(AgreementInformationExtendConvert.INSTANCE.convert(agreementInformationExtendAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   * @param agreementInformationExtendUpdateDTO  更新参数
   * @return
   */
  public int update(AgreementInformationExtendUpdateDTO agreementInformationExtendUpdateDTO) {
    BaseResponse baseResponse = agreementInformationExtendRpcFacade
        .update(AgreementInformationExtendConvert.INSTANCE.convert(agreementInformationExtendUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   * @param id  id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = agreementInformationExtendRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   * @param id id
   * @return
   */
  public AgreementInformationExtendVO getAgreementInformationExtendById(Long id) {
    ObjectRestResponse<AgreementInformationExtendRespDTO> objectRestResponse = agreementInformationExtendRpcFacade.getAgreementInformationExtendById(
        id);
    objectRestResponse.checkError();
    return AgreementInformationExtendConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   * @param agreementInformationExtendDTO  查询参数
   * @return
   */
  public List<AgreementInformationExtendVO> listAgreementInformationExtends(AgreementInformationExtendDTO agreementInformationExtendDTO) {
    ObjectRestResponse<List<AgreementInformationExtendRespDTO>> objectRestResponse = agreementInformationExtendRpcFacade.listAgreementInformationExtends(
                AgreementInformationExtendConvert.INSTANCE.convert(agreementInformationExtendDTO));
    objectRestResponse.checkError();
    return AgreementInformationExtendConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   * @param pageReqDTO  分页参数
   * @return
   */
  public TableResultResponse<AgreementInformationExtendVO> pageAgreementInformationExtend(AgreementInformationExtendPageDTO pageReqDTO) {
    TableResultResponse<AgreementInformationExtendRespDTO> tableResultResponse = agreementInformationExtendRpcFacade
        .page(AgreementInformationExtendConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return AgreementInformationExtendConvert.INSTANCE.convert(tableResultResponse);
  }


}
