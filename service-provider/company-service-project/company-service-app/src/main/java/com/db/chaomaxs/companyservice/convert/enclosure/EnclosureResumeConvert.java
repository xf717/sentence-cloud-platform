package com.db.chaomaxs.companyservice.convert.enclosure;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.enclosure.EnclosureResumeDO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeRespDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * EnclosureResumeConvert
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface EnclosureResumeConvert {

  EnclosureResumeConvert INSTANCE = Mappers.getMapper(EnclosureResumeConvert.class);

  /**
   * 将 EnclosureResumeDTO 转成 EnclosureResumeVO
   *
   * @param createReqDTO
   * @return
   */
  EnclosureResumeDO convert(EnclosureResumeCreateReqDTO createReqDTO);

  /**
   * 将更新转成DO
   *
   * @param updateReqDTO
   * @return
   */
  EnclosureResumeDO convert(EnclosureResumeUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<EnclosureResumeRespDTO> convertList(List<EnclosureResumeDO> list);

  /**
   * 对象转换
   *
   * @param enclosureResumeDO
   * @return
   */
  EnclosureResumeRespDTO convert(EnclosureResumeDO enclosureResumeDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<EnclosureResumeRespDTO> convertPage(IPage<EnclosureResumeDO> page);


}
