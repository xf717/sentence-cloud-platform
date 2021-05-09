package com.db.chaomaxs.userservice.convert.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserTrackDO;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserTrackStatisticsDO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackStatisticRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserTrackConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Mapper
public interface UserTrackConvert {

        UserTrackConvert INSTANCE = Mappers.getMapper(UserTrackConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      UserTrackDO convert(UserTrackCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      UserTrackDO convert(UserTrackUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserTrackRespDTO> convertList(List<UserTrackDO> list);

  /**
   * 对象转换
   *
   * @param userTrackDO
   * @return
   */
      UserTrackRespDTO convert(UserTrackDO userTrackDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserTrackRespDTO> convertPage(IPage<UserTrackDO> page);


    List<UserTrackStatisticRespDTO> convertStatistic(List<UserTrackStatisticsDO> userTrackStatisticsDOList);
}
