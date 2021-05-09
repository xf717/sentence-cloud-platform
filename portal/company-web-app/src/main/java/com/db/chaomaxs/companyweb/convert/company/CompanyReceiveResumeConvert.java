package com.db.chaomaxs.companyweb.convert.company;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatRespDTO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.CompanyUserCollectRespDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryRespDTO;
import com.db.chaomaxs.companyweb.service.resume.bo.UserResumeInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
/**
 * @author wst
 * @date 2021/5/7 14:40
 */

@Mapper
public interface CompanyReceiveResumeConvert {

  CompanyReceiveResumeConvert INSTANCE = Mappers.getMapper(CompanyReceiveResumeConvert.class);

  /**
   * 企业沟通 CompanyUserChatRespDTO 转 UserResumeInfoBO
   * @param tableResultResponse
   * @return
   */

  @Mappings({})
  TableResultResponse<UserResumeInfoBO> convertFromUserChat(
      TableResultResponse<CompanyUserChatRespDTO> tableResultResponse);

  /**
   * 企业投递 CompanyUserChatRespDTO 转 UserResumeInfoBO
   * @param tableResultResponse
   * @return
   */
  @Mappings({})
  TableResultResponse<UserResumeInfoBO> convertFromDelivery(
      TableResultResponse<CompanyDeliveryRespDTO> tableResultResponse);

  /**
   * 企业收藏 CompanyUserCollectRespDTO 转 UserResumeInfoBO
   * @param tableResultResponse
   * @return
   */
  @Mappings({})
  TableResultResponse<UserResumeInfoBO> convertFromCollect(
      TableResultResponse<CompanyUserCollectRespDTO> tableResultResponse);

}
