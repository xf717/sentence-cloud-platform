package com.github.xf717.systemservice.service.content;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.convert.content.AgreementInformationExtendConvert;
import com.github.xf717.systemservice.dal.mysql.dataobject.content.AgreementInformationExtendDO;
import com.github.xf717.systemservice.dal.mysql.mapper.content.AgreementInformationExtendMapper;
import com.github.xf717.systemservice.enums.SystemErrorCodeConstants;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendPageReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * AgreementInformationExtendService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class AgreementInformationExtendService {

  @Autowired
  private AgreementInformationExtendMapper agreementInformationExtendMapper;

  /**
  * 保存数据
* @param createReqDTO
* @return
*/
  public int saveAgreementInformationExtend(AgreementInformationExtendCreateReqDTO createReqDTO) {
    return agreementInformationExtendMapper.insert(AgreementInformationExtendConvert.INSTANCE.convert(createReqDTO));
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateAgreementInformationExtend(AgreementInformationExtendUpdateReqDTO updateReqDTO) {
          AgreementInformationExtendDO agreementInformationExtendDO = agreementInformationExtendMapper.selectById(updateReqDTO.getId());
    if (agreementInformationExtendDO == null) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
          agreementInformationExtendDO = AgreementInformationExtendConvert.INSTANCE.convert(updateReqDTO);
    int result = agreementInformationExtendMapper.updateById(agreementInformationExtendDO);
    return result;
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteAgreementInformationExtend(Long id) {
    if (agreementInformationExtendMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = agreementInformationExtendMapper.deleteById(id);
    return result;
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<AgreementInformationExtendRespDTO> listAgreementInformationExtends(AgreementInformationExtendListQueryReqDTO listQueryReqDTO) {
    List<AgreementInformationExtendDO> list = agreementInformationExtendMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return AgreementInformationExtendConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public AgreementInformationExtendRespDTO getAgreementInformationExtendById(Long id) {
          AgreementInformationExtendDO agreementInformationExtendDO = agreementInformationExtendMapper.selectById(id);
    if (agreementInformationExtendDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return AgreementInformationExtendConvert.INSTANCE.convert(agreementInformationExtendDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<AgreementInformationExtendRespDTO> pageAgreementInformationExtend(AgreementInformationExtendPageReqDTO page) {
    IPage<AgreementInformationExtendDO> agreementInformationExtendPage = agreementInformationExtendMapper.selectPage(page);
    return AgreementInformationExtendConvert.INSTANCE.convertPage(agreementInformationExtendPage);
  }


}
