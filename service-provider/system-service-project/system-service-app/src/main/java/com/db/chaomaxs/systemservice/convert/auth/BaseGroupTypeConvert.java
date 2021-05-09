package com.db.chaomaxs.systemservice.convert.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.auth.BaseGroupTypeDO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupTypeCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupTypeRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupTypeUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * BaseGroupTypeConvert
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Mapper
public interface BaseGroupTypeConvert {

  BaseGroupTypeConvert INSTANCE = Mappers.getMapper(
      BaseGroupTypeConvert.class);

  /**
   * 将 resourceDTO 转成 resourceVO
   *
   * @param createReqDTO
   * @return
   */
  BaseGroupTypeDO convert(BaseGroupTypeCreateReqDTO createReqDTO);

  /**
   * 将更新转成DO
   *
   * @param updateReqDTO
   * @return
   */
  BaseGroupTypeDO convert(BaseGroupTypeUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<BaseGroupTypeRespDTO> convertList(List<BaseGroupTypeDO> list);

  /**
   * 对象转换
   *
   * @param baseGroupTypeDO
   * @return
   */
  BaseGroupTypeRespDTO convert(BaseGroupTypeDO baseGroupTypeDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<BaseGroupTypeRespDTO> convertPage(IPage<BaseGroupTypeDO> page);


}
