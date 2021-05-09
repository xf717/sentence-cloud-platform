package com.db.chaomaxs.userservice.convert.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserIntegralRecordDO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserIntegralRecordCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserIntegralRecordRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserIntegralRecordUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserIntegralRecordConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Mapper
public interface UserIntegralRecordConvert {

        UserIntegralRecordConvert INSTANCE = Mappers.getMapper(UserIntegralRecordConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      UserIntegralRecordDO convert(UserIntegralRecordCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      UserIntegralRecordDO convert(UserIntegralRecordUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserIntegralRecordRespDTO> convertList(List<UserIntegralRecordDO> list);

  /**
   * 对象转换
   *
   * @param userIntegralRecordDO
   * @return
   */
      UserIntegralRecordRespDTO convert(UserIntegralRecordDO userIntegralRecordDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserIntegralRecordRespDTO> convertPage(IPage<UserIntegralRecordDO> page);


}
