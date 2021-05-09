package com.github.xf717.userservice.convert.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserTrackDO;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserTrackStatisticsDO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackStatisticRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackUpdateReqDTO;
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
