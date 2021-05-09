package com.db.chaomaxs.companyweb.convert.delivery;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryRespDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryUpdateReqDTO;
import com.db.chaomaxs.companyweb.controller.delivery.dto.CompanyDeliveryAddDTO;
import com.db.chaomaxs.companyweb.controller.delivery.dto.CompanyDeliveryDTO;
import com.db.chaomaxs.companyweb.controller.delivery.dto.CompanyDeliveryPageDTO;
import com.db.chaomaxs.companyweb.controller.delivery.dto.CompanyDeliveryUpdateDTO;
import com.db.chaomaxs.companyweb.controller.delivery.vo.CompanyDeliveryVO;
import com.db.chaomaxs.companyweb.service.resume.bo.UserResumeInfoBO;
import com.db.chaomaxs.companyweb.service.resume.vo.UserResumeInfoVO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserResumeDetailRespDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 应用层实体对象转换企业投递表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface CompanyDeliveryConvert {

  CompanyDeliveryConvert INSTANCE = Mappers.getMapper(CompanyDeliveryConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyDeliveryCreateReqDTO convert(CompanyDeliveryAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyDeliveryUpdateReqDTO convert(CompanyDeliveryUpdateDTO updateDTO);

  @Mappings({})
  CompanyDeliveryListQueryReqDTO convert(CompanyDeliveryDTO companyDeliveryDTO);

  /**
   * BO convert VO
   *
   * @param companyDeliveryRespDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyDeliveryVO convert(CompanyDeliveryRespDTO companyDeliveryRespDTO);

  @Mappings({})
  List<CompanyDeliveryVO> convertList(List<CompanyDeliveryRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserResumeInfoBO> convert(
      TableResultResponse<CompanyDeliveryRespDTO> tableResultResponse);

  @Mappings({})
  CompanyDeliveryPageReqDTO convert(CompanyDeliveryPageDTO companyDeliveryPageDTO);

  /**
   * userResumeDetailRespDTO 转换成 UserBaseInfoVO
   * @param userResumeDetailRespDTO
   * @return
   */
  @Mappings({})
  UserResumeInfoVO convert(UserResumeDetailRespDTO userResumeDetailRespDTO);

}
