package com.db.chaomaxs.systemservice.service.content;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.convert.content.AgreementInformationConvert;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.content.AgreementInformationDO;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.content.AgreementInformationExtendDO;
import com.db.chaomaxs.systemservice.dal.mysql.mapper.content.AgreementInformationExtendMapper;
import com.db.chaomaxs.systemservice.dal.mysql.mapper.content.AgreementInformationMapper;
import com.db.chaomaxs.systemservice.enums.SystemErrorCodeConstants;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * AgreementInformationService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class AgreementInformationService {

  @Autowired
  private AgreementInformationMapper agreementInformationMapper;
  @Autowired
  private AgreementInformationExtendMapper agreementInformationExtendMapper;

  /**
  * 保存数据
* @param createReqDTO
* @return
*/
  public int saveAgreementInformation(AgreementInformationCreateReqDTO createReqDTO) {
    return agreementInformationMapper.insert(AgreementInformationConvert.INSTANCE.convert(createReqDTO));
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateAgreementInformation(AgreementInformationUpdateReqDTO updateReqDTO) {
          AgreementInformationDO agreementInformationDO = agreementInformationMapper.selectById(updateReqDTO.getId());
    if (agreementInformationDO == null) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
          agreementInformationDO = AgreementInformationConvert.INSTANCE.convert(updateReqDTO);
    int result = agreementInformationMapper.updateById(agreementInformationDO);
    return result;
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteAgreementInformation(Long id) {
    if (agreementInformationMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = agreementInformationMapper.deleteById(id);
    return result;
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<AgreementInformationRespDTO> listAgreementInformations(AgreementInformationListQueryReqDTO listQueryReqDTO) {
    List<AgreementInformationDO> list = agreementInformationMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return AgreementInformationConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public AgreementInformationRespDTO getAgreementInformationById(Long id) {
          AgreementInformationDO agreementInformationDO = agreementInformationMapper.selectById(id);
    if (agreementInformationDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return AgreementInformationConvert.INSTANCE.convert(agreementInformationDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<AgreementInformationRespDTO> pageAgreementInformation(AgreementInformationPageReqDTO page) {
    IPage<AgreementInformationDO> agreementInformationPage = agreementInformationMapper.selectPage(page);
    return AgreementInformationConvert.INSTANCE.convertPage(agreementInformationPage);
  }


  /**
   * 根据code获取对象
   *
   * @param code
   * @return
   */
  public AgreementInformationRespDTO getAgreementInformationByCode(String code) {
    AgreementInformationDO agreementInformationDO = agreementInformationMapper.selectByCode(code);
    if (agreementInformationDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    AgreementInformationRespDTO agreementInformationRespDTO = AgreementInformationConvert.INSTANCE
        .convert(agreementInformationDO);
    AgreementInformationExtendDO agreementInformationExtendDO = agreementInformationExtendMapper
        .selectByAgreemenInfoId(agreementInformationDO.getId());
    if (null != agreementInformationExtendDO) {
      agreementInformationRespDTO.setContent(agreementInformationExtendDO.getContent());
    }
    return agreementInformationRespDTO;
  }


}
