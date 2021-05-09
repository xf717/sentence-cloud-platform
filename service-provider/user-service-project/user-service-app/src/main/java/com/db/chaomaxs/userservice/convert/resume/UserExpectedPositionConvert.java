package com.db.chaomaxs.userservice.convert.resume;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.resume.UserExpectedPositionDO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserExpectedPositionConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Mapper
public interface UserExpectedPositionConvert {

  UserExpectedPositionConvert INSTANCE = Mappers.getMapper(UserExpectedPositionConvert.class);

  /**
   * createReq 转换
   *
   * @param createReqDTO
   * @return
   */
  UserExpectedPositionDO convert(UserExpectedPositionCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
  UserExpectedPositionDO convert(UserExpectedPositionUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserExpectedPositionRespDTO> convertList(List<UserExpectedPositionDO> list);

  /**
   * 对象转换
   *
   * @param userExpectedPositionDO
   * @return
   */
  UserExpectedPositionRespDTO convert(UserExpectedPositionDO userExpectedPositionDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserExpectedPositionRespDTO> convertPage(IPage<UserExpectedPositionDO> page);

}
