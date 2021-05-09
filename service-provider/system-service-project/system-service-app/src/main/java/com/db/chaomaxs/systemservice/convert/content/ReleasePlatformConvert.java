package com.db.chaomaxs.systemservice.convert.content;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.content.ReleasePlatformDO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ReleasePlatformCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ReleasePlatformRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ReleasePlatformUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * ReleasePlatformConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Mapper
public interface ReleasePlatformConvert {

        ReleasePlatformConvert INSTANCE = Mappers.getMapper(ReleasePlatformConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      ReleasePlatformDO convert(ReleasePlatformCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      ReleasePlatformDO convert(ReleasePlatformUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<ReleasePlatformRespDTO> convertList(List<ReleasePlatformDO> list);

  /**
   * 对象转换
   *
   * @param releasePlatformDO
   * @return
   */
      ReleasePlatformRespDTO convert(ReleasePlatformDO releasePlatformDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<ReleasePlatformRespDTO> convertPage(IPage<ReleasePlatformDO> page);


}
