package com.db.chaomaxs.companyservice.convert.company;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.company.GreetContentDO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * GreetContentConvert
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface GreetContentConvert {

  GreetContentConvert INSTANCE = Mappers.getMapper(GreetContentConvert.class);

  /**
   * 将 GreetContentDTO 转成 GreetContentVO
   *
   * @param createReqDTO
   * @return
   */
  GreetContentDO convert(GreetContentCreateReqDTO createReqDTO);

  /**
   * 将更新转成DO
   *
   * @param updateReqDTO
   * @return
   */
  GreetContentDO convert(GreetContentUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<GreetContentRespDTO> convertList(List<GreetContentDO> list);

  /**
   * 对象转换
   *
   * @param greetContentDO
   * @return
   */
  GreetContentRespDTO convert(GreetContentDO greetContentDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<GreetContentRespDTO> convertPage(IPage<GreetContentDO> page);


}
