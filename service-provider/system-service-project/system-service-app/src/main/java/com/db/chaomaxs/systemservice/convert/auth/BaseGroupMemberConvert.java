package com.db.chaomaxs.systemservice.convert.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.auth.BaseGroupMemberDO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * BaseGroupMemberConvert
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Mapper
public interface BaseGroupMemberConvert {

  BaseGroupMemberConvert INSTANCE = Mappers.getMapper(
      BaseGroupMemberConvert.class);

  /**
   * 将 resourceDTO 转成 resourceVO
   *
   * @param createReqDTO
   * @return
   */
  BaseGroupMemberDO convert(BaseGroupMemberCreateReqDTO createReqDTO);

  /**
   * 将更新转成DO
   *
   * @param updateReqDTO
   * @return
   */
  BaseGroupMemberDO convert(BaseGroupMemberUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<BaseGroupMemberRespDTO> convertList(List<BaseGroupMemberDO> list);

  /**
   * 对象转换
   *
   * @param baseGroupMemberDO
   * @return
   */
  BaseGroupMemberRespDTO convert(BaseGroupMemberDO baseGroupMemberDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<BaseGroupMemberRespDTO> convertPage(IPage<BaseGroupMemberDO> page);


}
