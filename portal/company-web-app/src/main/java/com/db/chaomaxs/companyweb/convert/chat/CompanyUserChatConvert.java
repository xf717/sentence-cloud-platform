package com.db.chaomaxs.companyweb.convert.chat;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatRespDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatUpdateReqDTO;
import com.db.chaomaxs.companyweb.controller.chat.dto.CompanyUserChatAddDTO;
import com.db.chaomaxs.companyweb.controller.chat.dto.CompanyUserChatDTO;
import com.db.chaomaxs.companyweb.controller.chat.dto.CompanyUserChatPageDTO;
import com.db.chaomaxs.companyweb.controller.chat.dto.CompanyUserChatUpdateDTO;
import com.db.chaomaxs.companyweb.controller.chat.vo.CompanyUserChatVO;
import com.db.chaomaxs.companyweb.service.resume.vo.UserResumeInfoVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 应用层实体对象转换企业我的沟通
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface CompanyUserChatConvert {

  CompanyUserChatConvert INSTANCE = Mappers.getMapper(CompanyUserChatConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyUserChatCreateReqDTO convert(CompanyUserChatAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyUserChatUpdateReqDTO convert(CompanyUserChatUpdateDTO updateDTO);

  @Mappings({})
  CompanyUserChatListQueryReqDTO convert(CompanyUserChatDTO companyUserChatDTO);

  /**
   * BO convert VO
   *
   * @param companyUserChatRespDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyUserChatVO convert(CompanyUserChatRespDTO companyUserChatRespDTO);

  @Mappings({})
  List<CompanyUserChatVO> convertList(List<CompanyUserChatRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserResumeInfoVO> convert(
      TableResultResponse<CompanyUserChatRespDTO> tableResultResponse);

  @Mappings({})
  CompanyUserChatPageReqDTO convert(CompanyUserChatPageDTO companyUserChatPageDTO);

}
