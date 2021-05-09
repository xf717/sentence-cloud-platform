package com.db.chaomaxs.companyservice.convert.chat;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.chat.CompanyUserChatDO;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.chat.CompanyUserChatStatisticsDO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatRespDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatStatisticRespDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * CompanyUserChatConvert
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface CompanyUserChatConvert {

  CompanyUserChatConvert INSTANCE = Mappers.getMapper(CompanyUserChatConvert.class);

  /**
   * 将 CompanyUserChatDTO 转成 CompanyUserChatVO
   *
   * @param createReqDTO
   * @return
   */
  CompanyUserChatDO convert(CompanyUserChatCreateReqDTO createReqDTO);

  /**
   * 将更新转成DO
   *
   * @param updateReqDTO
   * @return
   */
  CompanyUserChatDO convert(CompanyUserChatUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<CompanyUserChatRespDTO> convertList(List<CompanyUserChatDO> list);

  /**
   * 对象转换
   *
   * @param companyUserChatDO
   * @return
   */
  CompanyUserChatRespDTO convert(CompanyUserChatDO companyUserChatDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<CompanyUserChatRespDTO> convertPage(IPage<CompanyUserChatDO> page);


    List<CompanyUserChatStatisticRespDTO> convertStatistic(List<CompanyUserChatStatisticsDO> companyUserChatStatisticsDOList);
}
